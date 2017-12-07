#검색어 저장 후 웹브라우저 자동 실행

require 'launchy'

url = "http://www.naver.com"
search = "https://search.naver.com/search.naver?query="
keywords = ["bitcoin", "kospi", "kosdaq", "nasdaq"]

keywords.each do |n|
  Launchy.open(search + n)
end
