## 멋쟁이사자처럼 프로젝트 실습교육 2일차

#### 오늘 실습은 Atom, Git Bash를 통해서 !



#### 1.  Linux Git Bash 명령어

- **Git Bash는 윈도우를 리눅스 커맨드로 리눅스처럼 쓸 수 있게 해주는 프로그램 !**

>**ls** : 폴더 및 파일 목록을 보여줌
>
>**cd 폴더명** : 폴더명으로 이동 (~표시는 홈 디렉토리를 칭한다.)
>
>- 홈 디렉토리로 이동하고 싶으면 cd ~ (홈으로 !)
>- 최상위 디렉토리로 이동하고 싶으면 cd / 
>- cd .. 상위폴더로 이동
>
>**pwd** : 절대경로 ! (가장 최상위 폴더부터 지금 폴더까지의 전체 경로 !)
>
>**mkdir 폴더명** : 폴더 생성

#### 2.  리눅스 환경 만들기

> 1.  https://www.vagrantup.com/ 접속 후 다운로드 !
> 2.  https://www.virtualbox.org/wiki/Downloads (Virtualbox 다운로드)

#### 3. Life hacking 복습!

> #### 1. scraping
>
> ```ruby
> require 'httparty'
> require 'nokogiri'
>
> # HTTParty.get 원하는 정보가 있는 주소로 요청 보냄
> # Nokogiri::HTML() 해당 문서를 검색하기 쉽게 바꾸기
> # .css('selector 경로') 원하는 정보만 뽑아옴 !
> url = "http://www.naver.com"
>
> response = HTTParty.get(url)
>
> #puts response
> html = Nokogiri::HTML(response.body)
>
> phone = html.css('#main_pack > div.shopping_item2.shopping_item2_v2.section.shop_new._shopping_groupmodel.matrix > div.evalu_con._evalu_con > ul > li:nth-child(1) > dl:nth-child(1) > dd.price > em')
>
> puts phone.text
> ```
>
>  
>
> #### 궁극의 스크래핑 Selenuim ! 이것을 사용하면 못 긁어오는 자료가 없다 ! 



### 4. Work hacking !

>#### 1. 파일 생성하기
>
>```ruby
>File.open("text.txt", "w") do |f|
>  f.write("Hack your life!")
>end
>```
>
>결과값 : 
>
>해당 폴더에 text.txt 파일이 생성 됨 !
>
> 
>
>#### 2. 여러개 파일 생성
>
>```ruby
># .txt 20개를 만든다.
># 몇번째 파일 + list
># 1list.txt > 내용물 : 1번째 파일입니다.
># 2list.txt > 내용물 : 2번째 파일입니다.
># 3list.txt
>20.times do |timer|
>  File.open((timer + 1).to_s + "list.txt", "w") do |f|
>    f.write((timer + 1).to_s + "번째 파일입니다.")
>  end
>end
>#concatenation : 합체코드
>```
>
>**String 조작방법 2가지**
>
>concatenation : 합체 "" + ""
>
>interpolation : 수술 "()" 안에 뭔가를 집어넣음
>
>
>
>**interpolation 사용법**
>
>```ruby
>age = 26
>
>puts "내 나이는 #{age}"
>```
>
> #### 여러개 파일 생성코드를 interpolation을 사용해서 바꾸기
>
>```ruby
>20.times do |timer|
>  File.open("#{timer + 1}list.txt", "w") do |f|
>    f.write("#{timer + 1}번째 파일입니다.")
>  end
>end
>#interpolation : 수술코드
>```
>
> 
>
>#### 3. 파일이름 바꾸기
>
>루비는 폴더에 대한 정보는 Dir에 저장됨
>
>1. 해당폴더로 들어간다
>2. 폴더안에서 파일들을 하나씩 돈다
>3. 파일 이름을 바꾼다.
>
>```Ruby
>Dir.pwd #절대경로 확인
>Dir.chdir ('src') #폴더 변경
>Dir.entries(Dir.pwd) #폴더안에 있는 내용물들을 보여줌
>
>#폴더 안에 있는 내용물 출력 확인
>list = Dir.entries(Dir.pwd)
>puts list.class
>#list는 배열로 생성된다 !
># list.each do |file|
>#   puts file
># end
>#[".", "..", "1list.txt", "2list.txt" ..., "20list.txt"]요소가 있는 22크기의 배열이 생성됨.
>
>#폴더 이름 바꾸기
>list = Dir.entries(Dir.pwd).reject {|name| name[0] == "."}
>#name[0]이 . 일때 '.'이 들어간 파일들을 제외됨
># File.rename("원래 파일명", "바꿀 파일명")
>list.each do |f|
>  File.rename(f, "2017" + f)
>end
>```



### 5. Sinatra / '오늘 뭐먹지?' 웹 만들기 

- 경량 웹 프레임워크 !
- Sinatra는 최소한의 노력으로 루비 기반 웹 애플리케이션을 신속하게 만들 수 있게 해 줌

>1. 설치하기 (install gem)
>
>```command with ruby
>gem install sinatra
>```
>
>2. 간단한 웹 페이지 만들기 
>
>```ruby
>#Dinner App 페이지 만들기
>require 'sinatra'
>
>#요청이 들어왔을 때 기본 웹 페이지
>get '/' do
>  "
>  <html>
>    <head>
>      <title>Dinner app</title>
>    </head>
>    <body>
>      <h1>This is Dinner App</h1>
>      <p>Dinner Recommendation</p>
>      <a href='/me'>About me</a>
>    </body>
>  </html>
>  "
>end
>
>get '/me' do
>  "
>  <html>
>    <head>
>      <title>Dinner app</title>
>    </head>
>    <body>
>      <h1>My name is Hee</h1>
>      <p>Sung hee</p>
>    </body>
>  </html>
>  "
>end
>```
>
> 
>
>### Html에 ruby코드 작성 방법
>
>**1]. ERB 소개**
>
>ERB는 루비의 내장 템플릿 엔진으로 텍스트의 종류에 상관없이, 루비 코드의 값을 포함하는 문서를 만들 수 있다. 템플릿은 문서내에 변수 뿐만 아니라 흐름제어를 위한 루비코드와 함께 사용함으로써, 다양한 문서 형식에 대응할 수 있다.
>
>ERB는 주로 웹문서를 만들기 위해서 사용한다. 이외에도 XML 문서, RSS 피드, 소스코드 기타 구조화된 텍스트파일을 만들기 위해서 사용한다. 특히 ERB는 표준 형식을 지니는 반복된 패턴을 포함한 문서를 만들 때 특히 유용하다. 웹문서는 이러한 동일한 패턴을 가지는 대표적인 표준 문서다.
>
>ERB의 장점이라면 루비나 rake에서 직접 호출 할 수 있는 표준 라이브러리 형태로 제공된다는 점이다. ERB를 사용하기 위해서 다른 어떤 소프트웨어 설치가 필요없다
>
>**2]. 사용방법**
>
>- dinner 폴더 안에 views라는 폴더를 만들어야 된다 !
>
>  **단, 폴더 이름은 views 라고만 해야함 ! / 확장자는 .erb**
>
>  ```erb
>  <h1>추천 저녁은 !</h1>
>  <p><%= @choice%></p>
>  <img src='<%= @url[@choice]%>'>
>  ```
>
>- 그리고 Ruby에서는 변수 앞에 **'@'** 를 붙여줘야함 !
>
>  (완성코드는 dinner에서 확인)
>
>  ```ruby
>  # 그냥 사용할 때
>  # choice = menu.sample
>
>    #erb 사용시
>    @choice = menu.sample
>    
>    #해쉬를 이용한 이미지 추가
>    # url = {
>    #   "참치회" => 'http://cfile25.uf.tistory.com/image/195FE2364DC91F601C866C',
>    #   "초밥" => 'http://kstatic.inven.co.kr/upload/2017/07/30/bbs/i16002780677.png',
>    #   "스테이크" => 'http://cfile30.uf.tistory.com/image/2363F8505288327718E758',
>    #   "한우" => 'http://cphoto.asiae.co.kr/listimglink/6/200909210812311440377A_1.jpg'
>    # }
>
>    #erb 사용시
>    @url = {
>      "참치회" => 'http://cfile25.uf.tistory.com/image/195FE2364DC91F601C866C',
>      "초밥" => 'http://kstatic.inven.co.kr/upload/2017/07/30/bbs/i16002780677.png',
>      "스테이크" => 'http://cfile30.uf.tistory.com/image/2363F8505288327718E758',
>      "한우" => 'http://cphoto.asiae.co.kr/listimglink/6/200909210812311440377A_1.jpg'
>    }
>
>    #erb에 넘기는 방법
>    erb :dinner
>  ```



### 6. 복습 겸 fake_Search 만들기

>1. app.rb 작성
>
>```ruby
>require 'sinatra'
>
>get '/' do
>  erb :index
>end
>
>```
>
>2.  index.erb 작성
>
>```erb
><html>
>  <head>
>    <meta charset="utf-8">
>    <title>Fake Naver</title>
>  </head>
>  <body>
>    <h1>Fake Search</h1>
>    <form action="https://search.naver.com/search.naver">
>      네이버 검색: <input type="text" name="query"><br>
>      <input type="submit" value="검색하기" >
>    </form>
>    <form action="https://search.daum.net/search">
>      다음 검색: <input type="text" name="q"><br>
>      <input type="submit" value="검색하기" >
>    </form>
>    <form action="https://www.google.co.kr/search">
>      구글 검색: <input type="text" name="q"><br>
>      <input type="submit" value="검색하기" >
>    </form>
>  </body>
></html>
>
>```



### 7. 간단한 OP.GG 만들기

>1. app.rb 작성
>
>```ruby
>require 'sinatra'
>require 'httparty'
>require 'nokogiri'
>#한글을 url에 맞춰 변형시켜줌
>require 'uri'
>#csv 로깅할때 간편함
>require 'csv'
>#로깅할때 가장 중요한 저장 일시 시간을 위해서 사용함
>require 'date'
>
>get '/' do
>  erb :index
>end
>
>get '/serach' do
># sinatra는 똑똑해서 정보들을 params에 임시적으로 저장한다
>#coding:utf-8
>  @id = params["id"]
>
>  @encode = URI.encode(@id)
>
>  # url = "http://www.op.gg/summoner/userName=#{@encode}"
>  # response = HTTParty.get(url)
>  response = HTTParty.get("http://www.op.gg/summoner/userName=#{@encode}")
>  html = Nokogiri::HTML(response.body)
>
>  @win = html.css('#SummonerLayoutContent > div.tabItem.Content.SummonerLayoutContent.summonerLayout-summary > div.SideContent > div.TierBox.Box > div.SummonerRatingMedium > div.TierRankInfo > div.TierInfo > span.WinLose > span.wins')
>  @loss = html.css('#SummonerLayoutContent > div.tabItem.Content.SummonerLayoutContent.summonerLayout-summary > div.SideContent > div.TierBox.Box > div.SummonerRatingMedium > div.TierRankInfo > div.TierInfo > span.WinLose > span.losses')
>  @rate = html.css('#SummonerLayoutContent > div.tabItem.Content.SummonerLayoutContent.summonerLayout-summary > div.SideContent > div.TierBox.Box > div.SummonerRatingMedium > div.TierRankInfo > div.TierInfo > span.WinLose > span.winratio')
>  @tier = html.css('#SummonerLayoutContent > div.tabItem.Content.SummonerLayoutContent.summonerLayout-summary > div.SideContent > div.TierBox.Box > div.SummonerRatingMedium > div.TierRankInfo > div.TierRank > span')
>
>  # 로깅하기 = 기록남기기.txt
>  # File.open("log.txt", "a+") do |f|
>  #   f.write("#{@id}, #{@tier.text}, #{@win.text}, #{@loss.text}, #{@rate.text}" + "\n")
>  #   # 아이디, 승, 패, 티어의 정보만 로깅해보자
>  # end
>
>  #로깅하기.csv
>  #csv는 엑셀로 파일이 열린다.
>  #따라서 나중에 데이터 조작하기가 편하다.
>  #로그에서 가장 중용한것은 검색 일시임 !
>  CSV.open("log.csv", "a+") do |csv|
>      csv << [@id, @tier.text, @win.text, @loss.text, @rate.text, Time.now.to_s]
>  end
>
>  erb :serach
>end
>```
>
>2.  index.erb 작성
>
>```erb
><html>
>  <head>
>    <meta charset="utf-8">
>    <title>Fake_op.gg</title>
>  </head>
>  <body>
>    <h1>Fake_롤 전적 검색</h1>
>    <form action="/serach">
>      아이디 : <input type="text" name="id">
>      <input type="submit" value="너의 전적은?!">
>    </form>
>  </body>
></html>
>
>```
>
>3. serach.erb작성
>
>```erb
><html>
>  <head>
>    <meta charset="utf-8">
>    <title>Fake_op.gg</title>
>  </head>
>  <body>
>    <h1><%= @id %>님의 슬픈 전적</h1>
>    <p><%= @win %> <%= @loss %> <%= @rate %></p>
>    <p><%= @tier %></p>
>    <p>롤 접으세요</p>
>  </body>
></html>
>
>```







