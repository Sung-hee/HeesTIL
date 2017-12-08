require 'sinatra'

#요청이 들어왔을 때 기본 웹 페이지
get '/' do
  send_file 'home.html'
end

#dinner 페이지
get '/dinner' do
  # 점심 추천 로직
  # 1. 배열 만들어 메뉴 넣고
  # 2. 랜덤으로 하나 뽑아 출력
  menu = ["참치회", "초밥", "스테이크", "한우"]
  # choice = menu.sample

  #erb 사용시
  @choice = menu.sample

  #해쉬를 이용한 이미지 추가
  # url = {
  #   "참치회" => 'http://cfile25.uf.tistory.com/image/195FE2364DC91F601C866C',
  #   "초밥" => 'http://kstatic.inven.co.kr/upload/2017/07/30/bbs/i16002780677.png',
  #   "스테이크" => 'http://cfile30.uf.tistory.com/image/2363F8505288327718E758',
  #   "한우" => 'http://cphoto.asiae.co.kr/listimglink/6/200909210812311440377A_1.jpg'
  # }

  #erb 사용시
  @url = {
    "참치회" => 'http://cfile25.uf.tistory.com/image/195FE2364DC91F601C866C',
    "초밥" => 'http://kstatic.inven.co.kr/upload/2017/07/30/bbs/i16002780677.png',
    "스테이크" => 'http://cfile30.uf.tistory.com/image/2363F8505288327718E758',
    "한우" => 'http://cphoto.asiae.co.kr/listimglink/6/200909210812311440377A_1.jpg'
  }

  # String으로 넘기는 방법
  # "<p>#{choice}</p>
  #  <img src='#{url[choice]}'>
  # "

  #erb에 넘기는 방법
  erb :dinner

  # 기본적인 이미지 추가 방법
  # url = ""
  # if choice == "참치회"
  #   url = 'http://cfile25.uf.tistory.com/image/195FE2364DC91F601C866C'
  # elsif choice == "초밥"
  #   url = 'http://kstatic.inven.co.kr/upload/2017/07/30/bbs/i16002780677.png'
  # elsif choice == "스테이크"
  #   url = 'http://cfile30.uf.tistory.com/image/2363F8505288327718E758'
  # elsif choice == "한우"
  #   url = 'http://cphoto.asiae.co.kr/listimglink/6/200909210812311440377A_1.jpg'
  # end
  # "<p>#{choice}</p>
  #  <img src='#{url}'>
  # "

end

#About me 페이지
get '/me' do
  send_file 'me.html'
end

#루비는 마지막 문장의 값을 항상 리턴해줌
#그니까 굳이 return 안써도 됨.
