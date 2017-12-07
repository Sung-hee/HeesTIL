# 주소는 건들지마세요.
# 요청 건수 제한이 있으니 조심히 ㅜ^ㅜ
require 'httparty'
url = 'http://openapi.seoul.go.kr:8088/54775266536e6564393578574d4c41/json/TimeAverageAirQuality/1/25/201710240900'
response = HTTParty.get(url)
dust = response['TimeAverageAirQuality']['row'][0]['PM10']
puts ("미세먼지 농도는 "+dust.to_s)

# 미세먼지 상태 출력
dust = dust.to_i
# String -> integer로 변환
if (dust > 150)
  puts "매우나쁨"
elsif (dust > 80)
  puts "나쁨"
elsif (dust > 30)
  puts "보통"
else
  puts "좋음"
end
