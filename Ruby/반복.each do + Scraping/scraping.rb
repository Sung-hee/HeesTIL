# 1. 원하는 정보가 있는 사이트로 요청을 보내, 응답을 저장한다
# 2. 정보를 출력하여 확인한다.

require 'httparty'
require 'nokogiri'
#어떤 html 문서를 검색하기 좋게 이쁘게 만들어주며 간단한 명령어로 그것을 검색하게 해준다.

url = "http://finance.naver.com/sise/"

response = HTTParty.get(url)

html = Nokogiri::HTML(response.body)
kospi = html.css('#KOSPI_now')

puts kospi.text
# .text는 텍스트만 출력
