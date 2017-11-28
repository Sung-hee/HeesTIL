//네이버 TTS(Text to Speech) 패키지 웹 요청 용
var request = require('request');

//카카오톡 파싱용 패키지
var bodyParser = require('body-parser');

//웹 패키지
var express = require('express');
var app = express();

//네이버 KEYㄴ
var client_id = "ID";//'4Bs3G19BPpNVKr2Wop1X';
var client_passkey = "KEY";//'fDdbQQMqh9';

var api_url = 'https://openapi.naver.com/v1/language/translate';

//parse apllication/json
app.use(bodyParser.json());
//parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: true }));

//초기 상태 get '시작', 버튼으로 시작
app.get('/keyboard', function(req, res){
  const menu = {
    "type": 'buttons',
    "buttons": ["시작"]
  };

  res.set({
    'content-type': 'application/json'
  }).send(JSON.stringify(menu));
});

//카톡 메세지 처리
app.post('/message', function (req, res) {
  const _obj = {
    user_key: req.body.user_key,
    type: req.body.type,
    content: req.body.content
  }
  //카톡으로  받은 메세지
  console.log(_obj.content);

  /// 네이버 번역기 전송할 데이터 만들기
  var options = {
     url: api_url,
    //한국어(source : ko) > 영어 (target : en ), 카톡에서 받은 메시지(text)
     form: {'source':'ko', 'target':'en', 'text':req.body.content},
     headers: {'X-Naver-Client-Id':client_id, 'X-Naver-Client-Secret': client_passkey}
  };
  //네이버로 번역하기 위해 전송(post)
  request.post(options, function (error, response, body){
    //번역이 성공 시
    if(!error && response.statusCode == 200){
      //json 파싱
      var objBody = JSON.parse(response.body);
      //번역된 메세지
      console.log(objBody.message.result.translatedText);

      //카톡으로 번역된 메세지를 전송하기 위한 메세지
      let message = {
        "message": {
          "text": objBody.message.result.translatedText
        },
      };

      //카톡에 메세지 전송
      res.set({
        'content-type': 'application/json'
      }).send(JSON.stringify(message));
    }
    else {
      //네이버에서 메세지 에러 발생
      res.status(response.statusCode).end();
      console.log('error = ' + response.statusCode);

      let message = {
        "message": {
          "text": response.statusCode
        },
      };

      //카톡에 메세지 전송 에러 메세지
      res.set({
        'content-type': 'application/json'
      }).send(JSON.stringify(message));
    }
  });
});
app.listen(process.env.PORT || 3000, process.env.IP || "0.0.0.0", function() {

});
