// 1. open API 정보 요청하기
var get_request = require("request");
var temperatureCondition = 0;

var fetch_options = {
  url: 'http://apis.skplanetx.com/weather/current/hourly?version=1&lat=37.5012113&lon=127.0299232&city=서울&county=강남구&village=역삼동',
  headers: {
      'x-skpop-userId': 'klpoik',
      'Accept': 'application/json',
      'Accept-Language': 'ko_KR',
      'appKey': 
  }
}
// 2. 날씨 정보 송신(json)
function fetch_callback(error, response, body){ //날씨 정보 송신(JSON)
  if(!error && response.statusCode == 200){ // 에러가 아니면서 코드정보가 200일떄
    var info = JSON.parse(body); //string 개체를 json object로 변환
    var weather = info.weather.hourly; //open API 날씨 정보 연결
    var timeRelease = weather[0].timeRelease; // open API에서 얻어온 날씨 측정 시간
    var sky_name = weather[0].sky.name; //날씨 상태
    var temperature = weather[0].temperature.tc; //현재 기온

    //콘솔창에 정보 출력
    console.log(sky_name);
    console.log(temperature);
    console.log(timeRelease);

    // 3. 날씨 정보 전달
    var post_request = require("request");
    var dateFormat = require('dateFormat');

    var newDate = new Date(timeRelease);
    var newDateFormat = dateFormat(new Date, "yyyy/mm/dd h시");
    console.log(newDateFormat);

    if(temperature > temperatureCondition || temperature < temperatureCondition) {
      post_request({
        url: 'https://maker.ifttt.com/trigger/weather_info_push/with/key/10WNrSs6hE9PXpm2tla84',
        method: 'POST',
        json: {
          "value1" : newDateFormat,
          "value2" : temperature,
          "value3" : sky_name
        }
      }, function(error, response, body){
          if (error){
            console.log(error);
          }
          else {
            console.log(response.statusCode, body);
          }
      });
    }
  }
}

// 4. 날씨 정보 조회 시간 설정
function startWeatherObserving(){
  var isTriggered = false;

  function triggerGetRequest(){
    get_request(fetch_options, fetch_callback);
  }

  function callEveryHour(){
    if(isTriggered == false){
      triggerGetRequest();
      isTriggered = true;
    }
    setInterval(triggerGetRequest, 1000 * 60 * 60);
  }

  var nextDate = new Date();
  var d = nextDate;

  if(nextDate.getMinutes() === 0){
    callEveryHour();
  }
  else if(nextDate.getMinutes() < 5){
    nextDate.setHours(d.getHours());
    nextDate.setMinutes(5);
    nexDate.setSeconds(0);

    var difference = nextDate - new Date();
    setTimeout(callEveryHour, difference);
  }
  else{
    nextDate.setHours(d.getHours() + 1);
    nextDate.setMinutes(5);
    nextDate.setSeconds(0);

    var difference = nextDate - new Date();
    setTimeout(callEveryHour, difference);
  }
}

startWeatherObserving();
