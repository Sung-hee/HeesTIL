## 자동번역 챗봇 + 정규표현식(Regular Expression)

#### 텍스트가 한글인지 영어인지 구분하기 !

이번에는 카카오톡을 통해 텍스트가 입력이 된다면 ! 텍스트가 한글인지 영어인지 구분하여  

한글 -> 영어 / 영어 -> 한글 번역을 지원하자 !



#### 1. 정규표현식 (Regular Expression) 이란? 

>사전적인 의미로는 특정한 규칙을 가진 문자열특정한 규칙을 가진 문자열의 집합을 표현하는 데 사용하는 [형식 언어](https://ko.wikipedia.org/wiki/%ED%98%95%EC%8B%9D_%EC%96%B8%EC%96%B4)이다. 정규 표현식은 많은 [텍스트 편집기](https://ko.wikipedia.org/wiki/%ED%85%8D%EC%8A%A4%ED%8A%B8_%ED%8E%B8%EC%A7%91%EA%B8%B0)와 [프로그래밍 언어](https://ko.wikipedia.org/wiki/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EC%96%B8%EC%96%B4)에서 문자열의 검색과 치환을 위해 지원하고 있다.![img](http://www.nextree.co.kr/content/images/2016/09/jhkim-140117-RegularExpression-151-1.png)Regular Expression UML



#### 2. 한글 구분 

>```js
>var check = _obj.content
>var languageCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
>  //language가 ture이면 ko -> en 으로 번역
>  if(languageCheck.test(check)){
>    // 네이버 번역기 전송할 데이터 만들기
>    var options = {
>      url: api_url,
>      //한국어(source : ko) > 영어 (target : en ), 카톡에서 받은 메시지(text)
>      form: {'source':'ko', 'target':'en', 'text':req.body.content},
>      headers: {'X-Naver-Client-Id':client_id, 'X-Naver-Client-Secret': client_passkey}
>    };
>
>    translatepost(options);
>  }
>
>  //language가 false면 en -> ko 으로 번역
>  else {
>    var options = {
>      url: api_url,
>      //영어(source : en) > 한국어 (target : ko ), 카톡에서 받은 메시지(text)
>      form: {'source':'en', 'target':'ko', 'text':req.body.content},
>      headers: {'X-Naver-Client-Id':client_id, 'X-Naver-Client-Secret': client_passkey}
>    };
>
>    translatepost(options);
>  }
>```



