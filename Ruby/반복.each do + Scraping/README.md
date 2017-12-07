## 멋쟁이사자 프로젝트 실습교육 1일차

### 실습은 chatbot.likelion.io 



#### 1] Ruby의 문법

- 저장

- 조건

- 반복

  ​

>#### 1.  무엇을 저장하는가 ?
>
>1. Numeric 
>   - 현실세계에 존재하는 모든 글자
>2. String
>   - 따옴표로 둘러싼 글자 or 숫자
>3. Boolean
>   - true or false



#### 2] Ruby 출력

1. print
   - 개행 x
2. puts
   - 개행 o
3. p
   - 유니코드 출력

> Ruby의 출력에서 괄호를 안넣어도 출력이 가능함 !
>
> ex ) print(date) = print date 
>
> ```ruby
> date = "03월 26일"
> age = 26.5
>
> puts date
> puts age
>
> print date
> print age
> puts
>
> p date
> p age
>
> puts
> puts date.class
> puts age.class
> ```
>
> 결과 값
>
> 03월 26일 
> 26.5 
> 03월 26일26.5 
> "03\uC6D4 26\uC77C" 
> 26.5
>
> String 
> Float



> ####2. 어떻게 저장하는가. 
>
> 1.  변수 
>
>    - 저장된 값을 변경 할 수 있는 박스
>    - 숫자, 글자, 참거짓을 담을 수 있다.
>
> 2.  배열
>
>    - 박스가 순서대로 여러 개가 붙어있다.
>
> 3.  해쉬
>
>    - 견출지 붙인 박스들의 묶음
>
>    ```ruby
>     x dust = {"영등포구" => 58, "강남구" => 40}
>     puts dust["영등포구"]
>    ```
>
>    결과 값
>
>    58



#### 3] Ruby 챗봇

> #### 1. 점심메뉴 챗봇
>
> ```ruby
> # 1. 먹고 싶은 메뉴를 모아서 담아 놓는다.
> # 2. 그 중에서 랜덤으로 하나를 뽑아서 다른 상자에 저장한다.
> # 3. 상자에 저장된 값을 출력한다.
>
> # 1. 점심 메뉴들을 배열에 넣는다.
> # 2. 그 배열에서 임의의 값을 하나 뽑는다.
> # 3. 출력한다.
>
> menu = ["명동칼국수", "삼다족발", "강남목장", "뽕사부", "김밥카페", "화이트폭스", "마구로젠"]
> choice = menu.sample
> puts choice
>
> #puts ["명동칼국수", "삼다족발", "강남목장", "뽕사부", "김밥카페", "화이트폭스", "마구로젠"].sample
> #이렇게 한줄로도 가능함 ! 
> ```
>
> 결과 값
>
> 강남목장 
>
>   
>
> #### 2. 미세먼지 챗봇
>
> 
>
> #### 미세먼지 데이터는 어떻게 받을까?
>
> 1.  API 란?
>    - 응용 프로그램에서 사용할 수 있도록, 운영체제나 프로그래밍 언어가 제공하는 기능을 제어할 수 있게 만든 인터페이스를 뜻한다.
>
>
>
>  ```ruby
> # 주소는 건들지마세요.
> # 요청 건수 제한이 있으니 조심히 ㅜ^ㅜ
> require 'httparty'
> url = 'http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?stationName=%EC%98%81%EB%93%B1%ED%8F%AC%EA%B5%AC&dataTerm=MONTH&numOfRows=100&ServiceKey=sfE57qPQ5x1eAXU41ftcyXYJZK5eKEONTGzz%2FdCe069VtqGX4UwcpLZbJhXSayA%2FtauuMhXPXttKeoxuafYWPQ%3D%3D'
> response = HTTParty.get(url)
> dust = response.first[1]["body"]["items"]["item"][1]["pm10Value"]
> puts ("미세먼지 농도는 "+ dust)
>
> # 미세먼지 상태 출력
> dust = dust.to_i 
> # String -> integer로 변환
> if (dust > 150)
>   puts "매우나쁨"
> elsif (dust > 80)
>   puts "나쁨"
> elsif (dust > 30)
>   puts "보통"
> else
>   puts "좋음"
> end
>  ```
>
> 
>
> #### 3. 로또번호 추천
>
> ```ruby
> # 1. 1~45 담긴 통을 만든다.
> # 2. 그 중에서 6개 숫자를 뽑는다.
> # 3. 그걸 출력한다.
>
> numbers = (1..45).to_a      #=> [1, 2, 3, 4, 5 ..... 43, 44, 45]
> puts numbers.sample(6).sort #=> 정렬
>
> # puts (1..45).to_a.sample(6).sort #=> 원라인 코드!
> ```
>
> 



#### 4] Ruby 반복문

>1. while 
>
>2. 반복. times do end 
>
>   ```ruby
>   #n = 0
>
>   #while (n < 3)
>   #  puts "안녕하세요"
>   #  n = n + 1
>   #end
>     
>   5.times do
>     puts "안녕하세요"
>   end
>   ```
>
>   결과 값
>
>   안녕하세요 
>   안녕하세요 
>   안녕하세요 
>   안녕하세요 
>   안녕하세요
>
>3. for
>
>4. 반복. each do
>
>   ```ruby
>   names = ["정유미", "아이유", "수지"]
>   names.each do |n|
>     puts n
>   end
>   ```
>
>   결과 값
>
>   정유미 
>   아이유 
>   수지



#### 5] Gem 이란? 

>gem은 보통 [rake](https://rubygems.org/gems/rake) 프로그램에서 테스트 자동화, 코드 생성, 다른 작업을 수행하는데 사용하는 `Rakefile`을 가지고 있습니다.
>
>1.  launchy 설치하기
>
>```command with ruby
>gem install launchy
>```
>
>2.  검색어 저장 후 웹브라우저 자동 실행 
>
>```ruby
>require 'launchy'
>
>url = "http://www.naver.com"
>search = "https://search.naver.com/search.naver?query="
>keywords = ["bitcoin", "kospi", "kosdaq", "nasdaq"]
>
>keywords.each do |n|
>  Launchy.open(search + n)  
>end
>```
>
>3. 스크래핑
>
>- httparty 설치하기
>
>```command with ruby
>gem install httparty
>```
>
>- nokogiri 란 HTML 상에서 특정한 정보를 쉽게 찾아주는 역할을 한다.
>
>```command with ruby
>gem install nokogiri
>```
>
>- 스크래핑 소스코드
>
>```ruby
># 스크래핑 
># 1. 원하는 정보가 있는 사이트로 요청을 보내, 응답을 저장한다
># 2. 정보를 출력하여 확인한다.
>
>require 'httparty'
>require 'nokogiri'
>#어떤 html 문서를 검색하기 좋게 이쁘게 만들어주며 간단한 명령어로 그것을 검색하게 해준다.
>
>url = "http://finance.naver.com/sise/"
>
>response = HTTParty.get(url)
>
>html = Nokogiri::HTML(response.body)
>kospi = html.css('#KOSPI_now')
>
>puts kospi.text
># .text는 텍스트만 출력
>```
>
>



