require 'httparty'
require 'nokogiri'

url = "http://webtoon.daum.net/ranking"

response = HTTParty.get(url)

html = Nokogiri::HTML(response)
ranking = html.css('#serialRanking > ol.list_ranking.list_ranking1 > li.rank_top > a > em')

puts ranking.text
