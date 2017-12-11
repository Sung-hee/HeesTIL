## 멋쟁이사자처럼 프로젝트 실습 3일차

### 실습환경은 Atom !



### 1. 시작은 2일차 복습 !

> #### Sinatra 베이스의 앱 만들기
>
> ##### 1. fake 검색사이트
>
> - . bing.com 모사한 사이트를 만든다.
> - get '/' {} : 사용자의 입력을 받아 bing 검색을 해주는 <form>을 만든다
>
> ```ruby
> # 2일차 복습
> # fake 검색사이트
> # . bing.com 모사한 사이트를 만든다.
> # get '/' {} : 사용자의 입력을 받아 bing 검색을 해주는 <form>을 만든다
>
> require 'sinatra'
>
> get '/' do
>   erb :index
> end
> ```
>
> - index.erb 만들기
>
> ```erb
> <html>
>   <head>
>     <meta charset="utf-8">
>     <title>Fake Bing search</title>
>   </head>
>   <body>
>     <h1>Bing search</h1>
>     <form action="https://www.bing.com/search">
>       Bing 검색 : <input type="text" name="q">
>       <input type="submit" value="검색">
>     </form>
>   </body>
> </html>
> ```
>
>  
>
> ##### 2. 로또 번호 추천 사이트 만들기
>
> - get '/' {} : '로또 추천'라는 버튼을 만들고 -> '/lotto'
> - get '/lotto' {} : 로또 번호를 추천하는데, 매번 추천된 번호를 lotto.txt 파일에 저장을 한다.
> - app.rb 만들기
>
> ```ruby
> # 2일차 복습
> # 2. 로또 번호 추천 사이트를 만든다.
> #  - get '/' {} : '로또 추천'라는 버튼을 만들고 -> '/lotto'
> # - get '/lotto' {} : 로또 번호를 추천하는데, 매번 추천된 번호를 lotto.txt 파일에 저장을 한다.
>
> require 'sinatra'
> require 'uri'
>
> get '/' do
>   erb :index
> end
>
> get '/lotto' do
>   numbers = (1..45).to_a
>   @lot = numbers.sample(6).sort
>
>   File.open("log.txt", "a+") do |f|
>     f.write("#{@lot}" + "\n")
>   end
>   erb :lotto
> end
> ```
>
> - index.erb 만들기
>
> ```erb
> <html>
>   <head>
>     <meta charset="utf-8">
>     <title>로또 번호 추천 사이트</title>
>   </head>
>   <body>
>     <h1>로또 번호 추천</h1>
>     <form action="/lotto">
>       <!-- <input type="button" value="로또번호추천"> -->
>       <input type="submit" value="로또번호추천">
>     </form>
>   </body>
> </html>
> ```
>
> - lotto.erb 만들기
>
> ```erb
> <html>
>   <head>
>     <meta charset="utf-8">
>     <title>로또 번호 추천</title>
>   </head>
>   <body>
>     <h1>이번 주 로또 번호 추천<h1>
>     <p><%= @lot %></p>
>   </body>
> </html>
> ```



### 2. 웹 서비스 개발을 위한 2가지 원칙

> 1.  브라우저는 크롬이다 ! 크롬을 써라 !
> 2.  검색은 구글이다 ! 구박사를 써라 ! (네이버는 검색엔진이 아니다.)
>
> ```html
> <!--iframe은 동영상 링크 거는 법!-->
>     <iframe width="560" height="315" src="https://www.youtube.com/embed/zQTGx09BKgA" frameborder="0" gesture="media" allow="encrypted-media" allowfullscreen></iframe>
> ```



### 3. 오늘의 목표 CRUD

> **오늘은 C, R 까지만 !**
>
> **CRUD**는 대부분의 [컴퓨터](https://ko.wikipedia.org/wiki/%EC%BB%B4%ED%93%A8%ED%84%B0) [소프트웨어](https://ko.wikipedia.org/wiki/%EC%86%8C%ED%94%84%ED%8A%B8%EC%9B%A8%EC%96%B4)가 가지는 기본적인 데이터 처리 기능인 Create(생성), Read(읽기), Update(갱신), Delete(삭제)를 묶어서 일컫는 말이다. 사용자 인터페이스가 갖추어야 할 기능(정보의 참조/검색/갱신)을 가리키는 용어로서도 사용된다.
>
>  각 문자는 다음과 같이 표준 SQL문으로 대응 가능하다.
>
> | 이름                 | 조작        | SQL    |
> | ------------------ | --------- | ------ |
> | Create             | 생성        | INSERT |
> | Read(또는 Retrieve)  | 읽기(또는 인출) | SELECT |
> | Update             | 갱신        | UPDATE |
> | Delete(또는 Destroy) | 삭제(또는 파괴) | DELETE |
>
>  
>
> **ORM(객체 관계 매핑) 이란** ? (Object-Relational Mappings)
>
> ORM이라는 것을 단순하게 표현해보자면 객체와 관계와의 설정? 정도일까? 그럼 여기서 말하는 객체라는 것은 우리가 흔히 말하는 OOP(Object-Oriented Programming)의 그 객체를 이야기 하는 것 이라면, 과연 관계라는 것이 의미하는 것은 무엇일까? 뭐 지극히 기초적인 이야기지만 우리(개발자)가 흔히 사용하고 있는 관계형 데이터베이스를 의미한다.
>
> #### 결론 ! 코드를 통해서 데이터베이스를 조작하는 것 ! SQL을 사용하지 않고 ! 
>
>  
>
> #### list = [] 와 list = Array.new 의 차이 / Hash.new 와 hash {} 의 차이
>
> ```ruby
> list = []
> list = Array.new
>
> puts list.class
> # 결과값은 Array
>
> count = Hash.new(0)
> # 디폴트값 생성자로 만든다.
> # 이건 {"1key"=>0}으로 구성이 됨! 즉 초기값은 0 !
> count["1key"] += 1
> count["2key"] += 1
> count["3key"] += 1
>
> puts count
> # 결과값 {"1key"=>1, "2key"=>1, "3key"=>1}
>
> But ! 
> count = {}
> # 이건 {"1key"=>nil}로 구성이 됨
> count["1key"] += 1
> count["2key"] += 1
> count["3key"] += 1
>
> puts count
> # 결과값 hash.rb:10:in `<main>': undefined method `+' for nil:NilClass (NoMethodError)
> # 초기값이 nil이기 때문에 에러가 남.
> ```
>
>  
>
> #### hash 루프 돌리기
>
> ```ruby
> phone_number = ["01012345678", "01023456789", "01022222222"]
> phone_book = {
>   "이강호" => "01012345678",
>   "강동주" => "01023456789",
>   "김탁희" => "01022222222"
> }
>
> phone_book.each do |key, value|
>   #키만 출력
>   puts key
>   #값만 출력
>   puts value
> end
> ```
>
> 
>
> #### 1. 투표앱 만들기
>
> - **CRUD 에서 C, R 이용**
>
>  **1] app.rb 코드 일부 !**
>
> ```ruby
> # 랜딩페이지 만들기
> # 투표앱 [C,R Create, Read]
> #
> # 1. 사람 이름, 투표한 것
> # - action = '/vote'
> # 2. vote.csv 누가 어떻게 투표했는지 저장시켜 나감
> # - 'vote.csv'에 결과를 쓴다.
> # 3.'/result'
> # - 'vote.csv'에 있는 결과물을 보여준다.
>
> # 투표 참여시 화면
> get '/vote' do
>   @name = params["name"]
>   @vote = params["vote"]
>
>   # CSV 로깅파일 만들기.
>   CSV.open("vote.csv", "a") do |csv|
>     csv << [@name, @vote]
>   end
>
>   erb :vote
> end
>
> # 투표 결과 화면
> get '/result' do
>   @list = Array.new
>   # @list = [] 와 동일한 코드임.
>
>   # @count = {} 와 동일한 코드임.
>   @count = Hash.new(0)
>
>   CSV.foreach("vote.csv") do |row|
>     @list << row
>     # [[name, vote],[name2, vote2]] 저장
>     
>     # 해쉬를 이용하여 카운트하기
>     # 특정시간 +1 로 투표 인원을 구한다 !
>     if row[1] == "1"
>       @count["1hour"] += 1
>     elsif row[1] == "2"
>       @count["2hour"] += 1
>     elsif row[1] == "3"
>       @count["3hour"] += 1
>     end
>   end
>
>   erb :result
> end
> # 전체코드는 voting에서 확인 !
> ```
>
>  **2] result.erb 코드 일부!**
>
> ```erb
> <html>
>   <head>
>     <meta charset="utf-8">
>     <title>Voting</title>
>   <body>
>     <h1>투표 결과</h1>
>       <% @list.each do |row| %>
>         <p><%= row[0] %>님은 <%= row[1] %>에 투표하셨습니다.</p>
>       <% end %>
>     <h1>---------------------------------------------------</h1>
>     <h1>투표결과</h1>
>     
>     <!--해쉬를 이용한 투표결과  -->
>     <!--해쉬를 이용해서 특정시간에 투표자를 +1를 하여 인원 수를 센다-->
>       <p>1시간에 투표한 사람 : <%=@count["1hour"]%></p>
>       <p>2시간에 투표한 사람 : <%=@count["2hour"]%></p>
>       <p>3시간에 투표한 사람 : <%=@count["3hour"]%></p>
>   </body>
>   </head>
> </html>
> ```
>
>  
>
> #### 2. Asked 만들기
>
>  **1] app.rb 코드 일부 !** 
>
> ```ruby
> require 'sinatra'
>
> get '/' do
>   # 질문을 담기 위한 배열 선언
>   @q_list = []
>
>   # 파일 읽기
>   # Asked 처럼 메인화면에서 질문을 읽기 위한 코드
>   File.open("question.txt", "r") do |f|
>     f.each_line do |line|
>       # line의 한줄 한줄을 q_list 넣겠다.
>       @q_list << line
>       # 결과값 -> ["질문 테스트", "두번째 질문 테스트"]
>     end
>   end
>
>   erb :index
> end
> ```
>
>  **2] index.erb 코드 일부 !**
>
> ```erb
> <html>
>   <head>
>     <meta charset="utf-8">
>     <title>Asked</title>
>   <body>
>     <h1>질문해주세요</h1>
>     <form action="/ask">
>       <select name ="id">
>         <option value="anonym">익명</option>
>         <option value="my_id">아이디</option>
>       </select>
>       질문하기 : <input type="text" name="question" placeholder="질문을 입력해주세요.">
>       <input type="submit" value="등록">
>     </form>
>     <h3>-------------------------------------------------------------------------</h3>
>     <h1>질문 목록</h1>
>     <% @q_list.each do |e| %>
>       <p><%= e %></p>
>     <% end %>
>   </body>
>   </head>
> </html>
> ```
>
>  
>
> #### 3. Word frequency counter 앱 만들기 (단어의 빈도 사용량을 계산)
>
>  **1] wf.rb**
>
> ```ruby
> text = "A Tale of Two Cities (1859) is a novel by Charles Dickens, set in London and Paris before and during the French Revolution. The novel tells the story of the French Doctor Manette, his 18-year-long imprisonment in the Bastille in Paris and his release to life in London with his daughter Lucie, whom he had never met; Lucie's marriage and the collision between her beloved husband and the people who caused her father's imprisonment; and Monsieur and Madame Defarge, sellers of wine in a poor suburb of Paris. The story is set against the conditions that led up to the French Revolution and the Reign of Terror."
>
> # 1. text -> 단어별 끊긴 배열을 하나 만든다. (split)
> # 2. words = ["It", "was", "the", "best", "of" ....] 각각 돌면서
> # 3. wf = Hash.new(0) 특정 단어가 있으면 +1 없으면 0
> # - {"it" => 3, "was" => 2, ...}
> # 4. Hash를 돌면서 각각의 요소(단어)가 몇 번 나왔는지 출력한다.
>
> text_array = text.downcase.split(" ")
>
> wf = Hash.new(0)
>
> text_array.each do |word|
>
>   if(word.include?("."))
>     word[0..word.length - 1]
>   elsif (word.include?(","))
>     word[0..word.length - 1]
>   end
>
>   wf[word] += 1
> end
>
> values = []
> wf.each do |word, freq|
>   puts "#{word} : #{freq}"
>
>   values << freq
> end
>
> puts "The most frequent word: #{values.max}"
> # puts "The most frequent word: #{wf.values.max}" -> 한줄로도 가능하다 !
> # puts wf.keys key만 출력
> # puts wf.values value만 출력
> ```
>
> 



### 4. Vagrant 설치하기

># vagrant
>
>vagrant를 설치해 봅시다.
>
>## version
>
>- VirtualBox : 5.1.30
>- vagrant_1.9.5
>- git for windows
>
>## setting
>
>```
># 기존 설정파일에 있습니다.
>
>Vagrant.configure("2") do |config|
>  config.vm.box = "ubuntu/xenial64"
>  config.vm.network "forwarded_port", guest: 3000, host: 3000 
>end
>```
>
>- Ruby on Rails 설치 - Go Rails 따라서 GoGo
>
>- Ruby on Rails 서버 실행
>
>  ```
>  rails s -b 0.0.0.0
>  ```
>
>## 가이드
>
>```
>1. windows에서 폴더하나를 만든다.
>2. 폴더에 들어가서 vagrant init ubuntu/xenial64
>	-> Vagrantfile 생성
>	-> port, host:3000, guest:3000 수정
>3. vagrant up
>4. vagrant ssh
>5. 가상머신 접속 상태에서 cd /vagrant
>	-> 공유폴더로 접속 가능
>6. 기본 프로그램 설치
>	- gorails.com ->guides -> setup ruby on rails
>	- 필수 프로그램 : 진짜 많음
>
>** gem install bundler 까지
>```





