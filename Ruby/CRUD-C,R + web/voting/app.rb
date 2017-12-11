# 랜딩페이지 만들기
# 투표앱 [C,R Create, Read]
#
# 1. 사람 이름, 투표한 것
# - action = '/vote'
# 2. vote.csv 누가 어떻게 투표했는지 저장시켜 나감
# - 'vote.csv'에 결과를 쓴다.
# 3.'/result'
# - 'vote.csv'에 있는 결과물을 보여준다.

#앱 메인화면
require 'sinatra'
require 'csv'

get '/' do
  erb :index
end

#투표 참여시 화면
get '/vote' do
  @name = params["name"]
  @vote = params["vote"]

  CSV.open("vote.csv", "a") do |csv|
    csv << [@name, @vote]
  end

  erb :vote
end

#투표 결과 화면
get '/result' do
  @list = Array.new
  #@list = [] 와 동일한 코드임.

  #@count = {} 와 동일한 코드임.
  @count = Hash.new(0)

  CSV.foreach("vote.csv") do |row|
    @list << row
    #[[name, vote],[name2, vote2]] 저장
    if row[1] == "1"
      @count["1hour"] += 1
    elsif row[1] == "2"
      @count["2hour"] += 1
    elsif row[1] == "3"
      @count["3hour"] += 1
    end
  end

  erb :result
end
