## Tizen Devlab 

#### Tizen.Net 과 Cross Platform TV Application 개발

###### Devlab이란 삼성전자 글로벌 개발자 실습 프로그램

1. Tizen.Net CrossPlatform 개발소개
2. Cross Platform VideoPlayer 개발 - LibraryPage
3. Cross Platform VideoPlayer 개발 - PlayerPage



### 1. Tizen.Net CrossPlatform 개발소개

> #### Tizen.Net Cross Platform Application
>
> 1.  TizenStudio + C# 
> 2.  Xamarin Android + Xamarin IOS + .Net Core = Xamarin.Forms
>    - 안드로이드, IOS, 리눅스 등 운영체제에 상관없이 개발을 가능하게 함
> 3.  View -> ViewModel -> Model = MVVM 패턴
>
> ![mvvm-chart](C:\Users\Hee\Desktop\Lite\mvvm-chart.png)
>
> ![ic416621](C:\Users\Hee\Desktop\Lite\ic416621.png)



### 2. Cross Platform VideoPlayer 개발 - LibraryPage

- http://tizenappschool.org/tutorial/95/contents/3 참고해서 만들기 !

> ##### 1] Introduction
>
> 1. VideoPlayerLite 앱구조![2](C:\Users\Hee\Desktop\Lite\2.PNG)

> #####2] Library Page View 
>
> 1. Library Page 개요 ![4](C:\Users\Hee\Desktop\Lite\4.PNG)
>
>    ![5](C:\Users\Hee\Desktop\Lite\5.PNG)

> ##### 3]  Application Model
>
> 1. App Model 개요![7](C:\Users\Hee\Desktop\Lite\7.PNG)
>
> 2.  MediaItem 데이터 모델 구현![11](C:\Users\Hee\Desktop\Lite\11.PNG)
>
> 3. IMediaContentAPIs Interface 정의![8](C:\Users\Hee\Desktop\Lite\8.PNG)
>
> 4. MediaContentPort (플랫폼 별) 구현![9](C:\Users\Hee\Desktop\Lite\9.PNG)
>
> 5. DependencyService 등록 및 MediaItemProvider 구현![10](C:\Users\Hee\Desktop\Lite\10.PNG)
>
>    - **<DependencyService 란?>**
>
>      Xamarin.Forms의 **DependencyService**는 공용 코드에서 플랫폼 종속된 기능들을 불러올 수 있게 해줍니다.
>
>      이를 통해서 Xamarin.Forms 앱들은 각 플랫폼의 네이티브 앱들이 할 수 있는 모든 것들을 할 수 있게 됩니다. 
>
>
>      DepencyService를 사용하기 위해서는 아래와 같은 과정이 필요합니다. 
>
>      - **Interface** – Shared 코드 내 인터페이스에서 필요한 기능들을 정의
>      - **Implementation Per Platform** – 각 플랫폼에서 해당 인터페이스를 구현하는 클래스들을 추가
>      - **Registration** – 구현된 각 클래스는 메타데이터 속성을 통해 DependencyService에 등록되어야함. 이는 DependencyService가 구현된 클래스를 찾을 수 있게 해주며 런타임 시 인터페이스에 맞게 클래스를 제공
>      - **Call to DependencyService** – Shared 코드는 인터페이스 구현을 위하여 DependencyService를 요청
>
> ​      
>
>      \* 더 자세한 정보는 아래 링크에서 확인 가능
>
>      [Introduction to DependencyService](https://developer.xamarin.com/guides/xamarin-forms/application-fundamentals/dependency-service/introduction/)
>
>      ![12](C:\Users\Hee\Desktop\Lite\12.PNG)



> ##### 4] LibraryPage ViewModel
>
> 1.  LibraryPage ViewModel 개요![13](C:\Users\Hee\Desktop\Lite\13.PNG)
>
>    ![14](C:\Users\Hee\Desktop\Lite\14.PNG)
>
> 2. ViewModelBase Class 구현![15](C:\Users\Hee\Desktop\Lite\15.PNG)
>
> 3. LibraryPageViewModel 구현
>
> 4. View / ViewModel 간 Binding 설정
>
> 5. Emulator 내 비디오 파일 추가 및 LibaryPage 최종확인
>
>    - 기본 Emulator에는 비디오 파일이 포함되어 있지 않기 때문에 본 강의의 앱을 제대로 보려면 비디오 파일을 추가해야 함.![P20171122_155814063_35CC1D00-FBCF-4301-A87F-AD0F31C84B18 (1)](C:\Users\Hee\Desktop\Lite\P20171122_155814063_35CC1D00-FBCF-4301-A87F-AD0F31C84B18 (1).JPG)
>
>      (핸드폰 애뮬레이터 실행 결과)
>
>      ![16](C:\Users\Hee\Desktop\Lite\16.PNG)
>
>      (TV 애뮬레이터 실행결과)



> 
>
> ##### 5] ItemView View
>
> 1. ItemView 개요![17](C:\Users\Hee\Desktop\Lite\17.PNG)
>
>    ![18](C:\Users\Hee\Desktop\Lite\18.PNG)
>
> 2. ItemView View 구현

> ##### 6] ItemView ViewModel 
>
> 1. ItemView ViewModel 개요![19](C:\Users\Hee\Desktop\Lite\19.PNG)
>
> 2. ItemView ViewModel 구현
>
> 3. View / ViewModel 간 Binding 설정
>
> 4. Tizen Privileg 추가 및 ItemView 최종확인![P20171122_161913407_BCCF6647-C032-420C-BD5B-9079D7BF01F9](C:\Users\Hee\Desktop\Lite\P20171122_161913407_BCCF6647-C032-420C-BD5B-9079D7BF01F9.JPG)
>
>    (핸드폰으로 실행 결과)
>
>    ![20](C:\Users\Hee\Desktop\Lite\20.PNG)
>
>    (애뮬레이터 실행 결과)



### 3. Cross Platform VideoPlayer 개발 - PlayerPage

- http://tizenappschool.org/tutorial/97/contents/3 참고

> ##### 1] Introduction
>
> 1. VideoPlayerLite 소개![21](C:\Users\Hee\Desktop\Lite\21.PNG)



> ##### 2] Implementing PlayerPage
>
> 1. PlayerPage 구현![22](C:\Users\Hee\Desktop\Lite\22.PNG)
>
>    ![23](C:\Users\Hee\Desktop\Lite\23.PNG)
>
>    ![24](C:\Users\Hee\Desktop\Lite\24.PNG)
>
>     (여기까지 실행 결과)
>
> 2.  mediaItemProvider 수정![25](C:\Users\Hee\Desktop\Lite\25.PNG)
>
> 3.  ItemViewModel 수정![26](C:\Users\Hee\Desktop\Lite\26.PNG)
>
>    ![27](C:\Users\Hee\Desktop\Lite\27.PNG)
>
> 4.  PlayerPageViewModel 생성![28](C:\Users\Hee\Desktop\Lite\28.PNG)
>
> 5.  View / ViewModel 간 Binding 설정
>
>    - PlayerPageViewModel과 PlayerPage를 바인딩하면 선택된 비디오의 타이틀, 전체 시간을 볼 수 있고, 이전, 다음 비디오로 바꿔 볼 수 있습니다.



> ##### 3] Implementing MediaRendering View
>
> 1.  MediaRenderingView 생성![29](C:\Users\Hee\Desktop\Lite\29.PNG)
>
> 2.  CustomRenderer 소개
>
>    ![30](C:\Users\Hee\Desktop\Lite\30.PNG)
>
>    ![31](C:\Users\Hee\Desktop\Lite\31.PNG)
>
>    ![32](C:\Users\Hee\Desktop\Lite\32.PNG)
>
> 3.  CustomRenderer 생성![33](C:\Users\Hee\Desktop\Lite\33.PNG)
>
> 4.  Tizen Player에 대한 이해
>
>    - Tizen Player에는 **비디오 재생을 위한 몇가지 상태가 정의**되어 있습니다.
>
>      아래를 통해 그 부분을 간략하게 알아보도록 하겠습니다.![34](C:\Users\Hee\Desktop\Lite\34.PNG)
>
>    - 위에서 볼 수 있듯 비디오 재생을 하기 위해선 대략 아래와 같은 과정이 필요합니다.
>
>      먼저 **Dispaly**를 현재 **Control**, 즉 **MediaView**로 지정하고,
>
>      현재 **Element**, **MediaRenderingView**의 **VideoPath **프로퍼티를 통해 재생할 비디오를 지정합니다.
>
>      **PrepareAsync**를 이용하여 재생할 준비가 끝나면 재생이 가능해 집니다
>
> 5. CustomRenderer 구현![35](C:\Users\Hee\Desktop\Lite\35.PNG)
>
>    - **PlayerPage**, **MediaRenderingView**에서 변경된 프로퍼티들을 상대 **View**에게 알려주기 위해서
>
>      위의 그림과 같이 **PlayerPageViewModel**를 통해 바인딩합니다.
>
>       
>
>      **PlayerPage**에서 **PauseButton**을 눌렀을 때의 상황을 토대로 자세히 알아보도록 하겠습니다.
>
>    ![36](C:\Users\Hee\Desktop\Lite\36.PNG)
>
>    **PlayerPage**에서 **PauseButton**을 누르게 되면 **PlayerPage**의 **PlayerStatus**는 **Paused**로 바뀌게 될 것이고,
>
>    이와 비인딩되어 있는 **PlayerPageViewModel**의 **CurrentStatus**도 **Paused**로 바뀌게 될 것입니다.
>
>    마찬가지로 **MediaRenderingView**의 **CurrentStatus**도 **Paused**로 변경이 되고,
>
>    최종적으로 **MediaRenderingView**의 **OnElementPropertyChanged**내에서 **Player.Pause()**로 **재생이 일시정지**됩니다.
>
>     
>
>    다른 예를 통해 더 알아보도록 하겠습니다.![img](http://tizenappschool.org/resource-tutorials/97/11-2.png)
>
>    반대로 **Player**의 현재 재생 시간을 **Timer**를 통해 **MediaRenderingView**의 **PlayPosition**을 업데이트하면,
>
>    이와 바인딩 되어있는 **PlayerPageViewModel**의 **CurrentPosition**이 바뀌게 되고,
>
>    마찬가지로 **PlayerPage**의 **ItemPosition **Label의 **Text가 갱신**됩니다.
>
>     
>
>    위와 같은 방법으로 **CustomRender**와 이와 관련된 **View**, **ViewModel**들을 구현, 수정해보도록 하겠습니다.
>
>    - 어플리케이션을 실행하여 선택한 비디오가 재생되는지 확인합니다.![img](http://tizenappschool.org/resource-tutorials/85/13.png)
>
> 6.  뒤로가기 처리 버튼

> ##### 1] Implementing PlayerButton
>
> 1. PlayerButton 생성 !![img](http://tizenappschool.org/resource-tutorials/85/15.png)
> 2.  끝 !![img](http://tizenappschool.org/resource-tutorials/85/16.png)