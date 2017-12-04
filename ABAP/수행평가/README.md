### SAPUI5 User Experience Development]

․ SCARR(항공사 정보) 테이블의 데이터를 읽어들이는 SAP Gateway를 생성한다.
․ GET_ENTITYSET 메소드를 이용하여 조건에 맞는 데이터를 읽어들이는 로직을 구성한다.



### [ABAP Workbench Fundamentals]

․ 아래 Layout을 참조로 하여 새로운 Transparent 테이블을 생성한다.
․ 테이블 용도는 학생 주소록이다.
․ 아래 XX는 학생 여러분이 각자 부여받은 번호이다
․ 아래 필드중 AREA는 탐색도움말이 나오도록 생성한다.
․ AREA (A:역삼동, B:방배동, C:길동, D:혜화동, E:목동)
․ TIME STAMP는 학생 본인이 생성한 Structure를 사용한다.
․ ------------------ Table Name ZTSTUXX -----------------------
․ MANDT TYPE MANDT, <- PK로 설정
․ STUNO TYPE ZENOXX = 학생번호 (NUMC 4 자리) : 데이터 엘리먼트 생성 <- PK로 설정
․ STUNAME TYPE ZENAMEXX = 학생이름 (CHAR 50 자리) : 데이터 엘리먼트 생성
․ CITY TYPE AD_CITY1 = 도시
․ AREA TYPE ZEAREAXX = 동네 (CHAR 20 자리) : 탐색도움말 설치
․ ADDR TYPE ADDRGP_KK
․ (TIME STAMP) <- 생성일자, 생성자, 생성시간 정보필드를 Include structure로 추가한다.



### [ABAP Report & Database Update]

․ 전표헤더 테이블인 BKPF 테이블을 조회하는 프로그램을 개발한다
․ 조회조건은 회사코드(BUKRS), 회계연도(GJAHR), 전표유형(BLART)이다
․ 초기값은 아래와 같다
․ 회사코드(필수) : 1100, 회계연도(필수) : 당해년도, 전표유형 : ‘DA’
․ 출력필드는 BUKRS, BELNR, GJAHR, BLART, BUDAT, BKTXT
․ 모든 로직은 FORM Soubroutine 에 구현한다
․ 결과 화면은 Write 로 출력한다.



### [ABAP Workbench Concepts]

․ 스텐다드 ALV 클래스를 이용하여 데이터를 화면에 출력하는 기능을 개발한다.
․ Local class event를 설치하여 전표번호를 더블클릭 하면 티코드 FB03 화면으로 이동 하도록 한다.
․ 전표헤더 인 BKPF 테이블을 조회하여 조건에 맞는 데이터를 ALV 화면으로 출력한다.
․ 조회조건은 회사코드(BUKRS), 회계연도(GJAHR), 전표유형(BLART)이다
․ 초기값은 아래와 같다
․ 회사코드(필수) : 1100, 회계연도(필수) : 당해년도, 전표유형 : ‘DA’
․ 출력필드는 BUKRS, BELNR, GJAHR, BLART, BUDAT, BKTXT 
․ 모든 로직은 FORM Soubroutine 에 구현한다