## 멋쟁이사자처럼 프로젝트 실습 4일차

#### 실습환경은 Atom, vagrant에서 !



### 1. 오늘도 시작은 어제 복습으로

>#### 1.  Blog 만들기
>
>- app.rb 일부분 !
>
>```ruby
>#Simle Blog
>
># # 1. new
>#      - get '/' => erb :index,
>#      - <form>을 통해 제목(title), 내용(content) 입력
>#
># # 2. Create
>#     - get 'write' => erb :write,
>#     - File.open을 통해 내용 쓰기
>#
># # 3. Read
>#     - get 'show' => erb :show
>#     - File.open을 통해 모든 블로그 내용 읽기
>
>get '/write' do
>  @title = params["title"]
>  @content = params["content"]
>
>  File.open("blog.txt", "a") do |f|
>    f.write("#{@title}, #{@content}" + "\n")
>  end
>
>  erb :write
>end
>
>get '/show' do
>  @blog_list = []
>
>  File.open("blog.txt", "r") do |f|
>    f.each_line do |line|
>      # line의 한줄 한줄을 q_list 넣겠다.
>      @blog_list << line
>      # 결과값 -> ["질문 테스트", "두번째 질문 테스트"]
>    end
>  end
>
>  erb :show
>end
>```
>
>- show.erb 일부분 !
>
>```erb
><html>
>  <head>
>    <meta charset="utf-8">
>    <title>Simle Blog</title>
>  <body>
>    <h1>블로그 목록보기</h1>
>    <% @blog_list.each do |e| %>
>      <p><%= e %></p>
>    <% end %>
>    <a href="/">홈으로</a>
>  </body>
>  </head>
></html>
>```
>
> 
>
>#### 2. ORM(객체 관계 매핑) 이란 ? (Object-Relational Mappings)
>
>**(ruby에서 대표적인건 datamapper)**
>
>ORM이라는 것을 단순하게 표현해보자면 객체와 관계와의 설정? 정도일까? 그럼 여기서 말하는 객체라는 것은 우리가 흔히 말하는 OOP(Object-Oriented Programming)의 그 객체를 이야기 하는 것 이라면, 과연 관계라는 것이 의미하는 것은 무엇일까? 뭐 지극히 기초적인 이야기지만 우리(개발자)가 흔히 사용하고 있는 관계형 데이터베이스를 의미한다.
>
>#### 결론 ! 코드를 통해서 데이터베이스를 조작하는 것 ! SQL을 사용하지 않고 !



###2. 오늘은 CRUD 완성하기 

> **datamapper(ORM)을 이용해 데이터베이스를 조작하면서 실습 진행!**
>
> **그리고 vagrant를 통해서 리눅스 환경에서 실습 진행할꺼임 !**
>
> ```ubuntu
> ruby app.rb -o 0.0.0.0
>
> 여기선 app.rb를 진행하기 위해선 뒤에 -o 0.0.0.0을 붙여줘야 함!
> ```
>
> 또는 
>
> ``` truby
> #이 코드는 app.rb에서 !
> set :bind, '0.0.0.0' 
> #이 코드를 입력하면 커맨드창에서 -o 0.0.0.0 을 입력안해도 됨 !
> ```
>
> #### 1. Datamapper 설치하기
>
> ```ubuntu
> gem install data_mapper 
> gem install dm-sqlite-adapter
>
> 이 두개를 설치하자 !
> ```
>
> 
>
> #### 2. 데이터베이스를 조작해서 '진짜!' blog 만들기
>
> - app.erb 코드 !
>
> ```ruby
> # 먼저 cmd창에서 gem install thin 설치하자 
> # thin이 경량 서버이며 더 좋음 !
>
> require 'rubygems'
> require 'sinatra'
> require 'data_mapper' # metagem, requires common plugins too.
>
> # 이 코드를 입력하면 커맨드창에서 -o 0.0.0.0 을 입력안해도 됨 !
> set :bind, '0.0.0.0'
>
> # need install dm-sqlite-adapter
> DataMapper::setup(:default, "sqlite3://#{Dir.pwd}/blog.db")
>
> class Post
>   include DataMapper::Resource
>   property :id, Serial
>   property :title, String
>   property :body, Text
>   property :created_at, DateTime
> end
>
> # Perform basic sanity checks and initialize all relationships
> # Call this when you've defined all your models
> DataMapper.finalize
>
> # automatically create the post table
> Post.auto_upgrade!
>
> get '/' do
>
>   # 가지고 있는 Post를 보여줌
>   @posts = Post.all.reverse
>
>   # reverse이용해서 최신글이 맨 위에 올라오도록 만들자.
>
>   erb :index
> end
>
> get '/create' do
>
>   # DB에 저장하기 위해서 create에 저장 폼을 만듬
>   Post.create(
>     :title => params["title"],
>     :body => params["content"]
>   )
>
>   # 홈 페이지로 보내기
>   redirect to '/'
> end
>
> ```
>
> - index.erb 일부분 !
>
> ```erb
> <!--Post에 저장된 title, body 을 출력해주는 코드-->
>     <% @posts.each do |post|%>
>       <p>제목 : <%= post.title %></p>
>       <p>내용 : <%= post.body %></p>
>     <% end %>
> ```



### 여기서 잠깐 !!

#### 3. 근데 왜 Ruby 인가?

>1. High-level : 사람 말 같고
>
>2. Interpreted : 편하고(안 귀찮고)
>
>3. **Object-oriented : 상식적이고**
>
>   - 객체지향프로그래밍언어
>
>   - **사물이 중심이된**
>
>   - **세상을 있는 그대로 프로그래밍 언어로 표현하고 싶다**
>
>     > - Object + Predicate
>     >
>     >   **-> '무엇이' + '무엇하다' = 주어 + 동사 = Subject + Verb **
>     >
>     >   **-> Object. method()** = 저장된 자료. 조작방법()
>
>4. Easy to use : 쉽다
>
> 
>
>#### 번외] irb에서 놀아보기
>
> ```ubuntu
>irb(main):003:0> str
>=> "hello"
>irb(main):005:0> str.capitalize
>=> "Hello"
>irb(main):006:0> str
>=> "hello"
>irb(main):007:0> str.capitalize!
>=> "Hello"
>irb(main):008:0> str
>=> "Hello"
>irb(main):009:0> str.swapcase
>=> "hELLO"
>irb(main):010:0> str.length
>=> 5
>irb(main):012:0> str.gsub("e", "a")
>=> "Hallo"
>irb(main):013:0> str.gsub("H", "s")
>=> "sello"
>irb(main):014:0> str
>=> "Hello"
>irb(main):005:0> 2.4.integer?
>=> false
>irb(main):009:0> 24.real?
>=> true
>irb(main):010:0> numbers = [24, 3, 2, 9, -9, 10]
>=> [24, 3, 2, 9, -9, 10]
>irb(main):012:0> numbers.sort
>=> [-9, 2, 3, 9, 10, 24]
>irb(main):013:0> numbers.count
>=> 6
>irb(main):014:0> numbers.sample
>=> 10
>irb(main):015:0> numbers.sample(3)
>=> [10, 24, -9]
>irb(main):016:0> numbers.max
>=> 24
>irb(main):018:0> numbers.min
>=> -9
>irb(main):019:0> numbers.delete(3)
>=> 3
>irb(main):020:0> numbers
>=> [24, 2, 9, -9, 10]
>irb(main):022:0> numbers << 200
>=> [24, 2, 9, -9, 10, 200]
>irb(main):023:0> numbers.send(:<<, 500)
>=> [24, 2, 9, -9, 10, 200, 500]
>irb(main):024:0> ^C
>irb(main):024:0> 10 + 10
>=> 20
>irb(main):025:0> 10.send(:+, 10)
>=> 20
> ```
>
>  #### pry에서 놀아보기 (irb와 같은 명령어)
>
>```ubuntu
>gem install pry 
>
>pry는 irb와 같은 기능을 하는 프로그램 ? 명령어 임 ! 
>하지만 하이라이트 기능이 있어서 cmd 화면에서 보기가 편함!
>
>[1] pry(main)> require './app.rb'
>=> true
>[2] pry(main)> Post.create(
>[2] pry(main)*   :title => "title test",
>[2] pry(main)*   :body => "body test",
>[2] pry(main)* )
>[4] pry(main)> Post.first
>=> #<Post @id=1 @title="날아온 제목" @body=<not loaded> @created_at=#<DateTime: 2017-12-12T02:22:09+00:00 ((2458100j,8529s,0n),+0s,2299161j)>>
>[5] pry(main)> Post.last
>=> #<Post @id=8 @title="title test" @body=<not loaded> @created_at=#<DateTime: 2017-12-12T05:26:07+00:00 ((2458100j,19567s,0n),+0s,2299161j)>>
>[6] pry(main)> Post.last.title
>=> "title test"
>[7] pry(main)> Post.last.body
>=> "body test"
>[8] pry(main)> Post.first.body
>=> "날아온 내용"
>[9] pry(main)> Post.first.id
>=> 1
>[10] pry(main)> Post.first.title
>=> "날아온 제목"
>[12] pry(main)> Post.create(
>[12] pry(main)*   :title => "제목테스트 해본다",
>[12] pry(main)*   :body => "내용도 테스트 해본다."
>[12] pry(main)* )
>=> #<Post @id=9 @title="제목테스트 해본다" @body="내용도 테스트 해본다." @created_at=#<DateTime: 2017-12-12T05:32:43+00:00 ((2458100j,19963s,101786194n),+0s,2299161j)>>
>[13] pry(main)> Post.last.title
>=> "제목테스트 해본다"
>[14] pry(main)> Post.last.body
>=> "내용도 테스트 해본다."
>[15] pry(main)> Post.last.id
>=> 9
> @posts = Post.all
>=> [#<Post @id=1 @title="날아온 제목" @body=<not loaded> @created_at=#<DateTime: 2017-12-12T02:22:09+00:00 ((2458100j,8529s,0n),+0s,2299161j)>>, #<Post @id=2 @title="날아온 제목" @body=<not loaded> @created_at=#<DateTime: 2017-12-12T02:24:15+00:00 ((2458100j,8655s,0n),+0s,2299161j)>>, #<Post @id=3 @title="진짜로" @body=<not loaded> @created_at=#<DateTime: 2017-12-12T02:28:33+00:00 ((2458100j,8913s,0n),+0s,2299161j)>>, #<Post @id=4 @title="진짜로" @body=<not loaded> @created_at=#<DateTime: 2017-12-12T02:28:40+00:00 ((2458100j,8920s,0n),+0s,2299161j)>>, #<Post @id=5 @title="진짜로" @body=<not loaded> @created_at=#<DateTime: 2017-12-12T02:28:42+00:00 ((2458100j,8922s,0n),+0s,2299161j)>>, #<Post @id=6 @title="진짜로" @body=<not loaded> @created_at=#<DateTime: 2017-12-12T02:30:00+00:00 ((2458100j,9000s,0n),+0s,2299161j)>>, #<Post @id=7 @title="오오오" @body=<not loaded> @created_at=#<DateTime: 2017-12-12T02:31:36+00:00 ((2458100j,9096s,0n),+0s,2299161j)>>, #<Post @id=8 @title="title test" @body=<not loaded> @created_at=#<DateTime: 2017-12-12T05:26:07+00:00 ((2458100j,19567s,0n),+0s,2299161j)>>, #<Post @id=9 @title="제목테스트 해본다" @body=<not loaded> @created_at=#<DateTime: 2017-12-12T05:32:43+00:00 ((2458100j,19963s,0n),+0s,2299161j)>>]
>] pry(main)> @posts[0]
>=> #<Post @id=1 @title="날아온 제목" @body="날아온 내용" @created_at=#<DateTime: 2017-12-12T02:22:09+00:00 ((2458100j,8529s,0n),+0s,2299161j)>>
>[10] pry(main)> @posts[5]
>=> #<Post @id=6 @title="진짜로" @body="왜 안변해" @created_at=#<DateTime: 2017-12-12T02:30:00+00:00 ((2458100j,9000s,0n),+0s,2299161j)>>
>```
>
>#### 위에와 같이 DB를 가지고 노는게 ORM임 !
>
>
>
>#### 1. palindrome 만들기
>
>```ruby
>def is_palindrome?(str)
>  # str이 palindrome인지 아닌지
>  # 원래 자신과 거꾸로 뒤집은 자신은 항상 같다
>  str == str.reverse
>end
>
>puts is_palindrome?("asdsa")
>puts is_palindrome?("asdfg")
>```
>
>



