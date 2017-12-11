# 2일차 복습
# 2. 로또 번호 추천 사이트를 만든다.
#  - get '/' {} : '로또 추천'라는 버튼을 만들고 -> '/lotto'
# - get '/lotto' {} : 로또 번호를 추천하는데, 매번 추천된 번호를 lotto.txt 파일에 저장을 한다.

require 'sinatra'
require 'uri'

get '/' do
  erb :index
end

get '/lotto' do
  numbers = (1..45).to_a
  @lot = numbers.sample(6).sort

  File.open("log.txt", "a+") do |f|
    f.write("#{@lot}" + "\n")
  end
  erb :lotto
end
