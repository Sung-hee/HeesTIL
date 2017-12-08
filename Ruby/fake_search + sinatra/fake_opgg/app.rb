require 'sinatra'
require 'httparty'
require 'nokogiri'
#한글을 url에 맞춰 변형시켜줌
require 'uri'
#csv 로깅할때 간편함
require 'csv'
#로깅할때 가장 중요한 저장 일시 시간을 위해서 사용함
require 'date'

get '/' do
  erb :index
end

get '/serach' do
# sinatra는 똑똑해서 정보들을 params에 임시적으로 저장한다
#coding:utf-8
  @id = params["id"]

  @encode = URI.encode(@id)

  # url = "http://www.op.gg/summoner/userName=#{@encode}"
  # response = HTTParty.get(url)
  response = HTTParty.get("http://www.op.gg/summoner/userName=#{@encode}")
  html = Nokogiri::HTML(response.body)

  @win = html.css('#SummonerLayoutContent > div.tabItem.Content.SummonerLayoutContent.summonerLayout-summary > div.SideContent > div.TierBox.Box > div.SummonerRatingMedium > div.TierRankInfo > div.TierInfo > span.WinLose > span.wins')
  @loss = html.css('#SummonerLayoutContent > div.tabItem.Content.SummonerLayoutContent.summonerLayout-summary > div.SideContent > div.TierBox.Box > div.SummonerRatingMedium > div.TierRankInfo > div.TierInfo > span.WinLose > span.losses')
  @rate = html.css('#SummonerLayoutContent > div.tabItem.Content.SummonerLayoutContent.summonerLayout-summary > div.SideContent > div.TierBox.Box > div.SummonerRatingMedium > div.TierRankInfo > div.TierInfo > span.WinLose > span.winratio')
  @tier = html.css('#SummonerLayoutContent > div.tabItem.Content.SummonerLayoutContent.summonerLayout-summary > div.SideContent > div.TierBox.Box > div.SummonerRatingMedium > div.TierRankInfo > div.TierRank > span')

  # 로깅하기 = 기록남기기.txt
  # File.open("log.txt", "a+") do |f|
  #   f.write("#{@id}, #{@tier.text}, #{@win.text}, #{@loss.text}, #{@rate.text}" + "\n")
  #   # 아이디, 승, 패, 티어의 정보만 로깅해보자
  # end

  #로깅하기.csv
  #csv는 엑셀로 파일이 열린다.
  #따라서 나중에 데이터 조작하기가 편하다.
  #로그에서 가장 중용한것은 검색 일시임 !
  CSV.open("log.csv", "a+") do |csv|
      csv << [@id, @tier.text, @win.text, @loss.text, @rate.text, Time.now.to_s]
  end

  erb :serach
end
