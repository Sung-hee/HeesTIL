require 'httparty'
require 'nokogiri'

# HTTParty.get 원하는 정보가 있는 주소로 요청 보냄
# Nokogiri::HTML() 해당 문서를 검색하기 쉽게 바꾸기
# .css('selector 경로') 원하는 정보만 뽑아옴 !
url = "http://search.naver.com/search.naver?&oquery=%EB%84%A4%EC%9D%B4%EB%B2%84+%EC%A3%BC%EC%8B%9D&tqi=TAFFpspVuFdssu4WNChsssssssK-048909"

response = HTTParty.get(url)
html = Nokogiri::HTML(response.body)
phone = html.css('#main_pack > div.nsite.section._nsiteTop > ul > li > dl > dd:nth-child(3) > b')

puts phone.text

#이거는 왜돌아가고 위에는 왜 안돌아가 !
# url = "http://finance.naver.com/sise/"
#
# response = HTTParty.get(url)
#
# html = Nokogiri::HTML(response.body)
# kospi = html.css('#KOSPI_now')
# puts kospi.text
