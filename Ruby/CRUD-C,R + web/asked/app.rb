require 'sinatra'

get '/' do
  # 질문을 담기 위한 배열 선언
  @q_list = []

  # 파일 읽기
  # Asked 처럼 메인화면에서 질문을 읽기 위한 코드
  File.open("question.txt", "r") do |f|
    f.each_line do |line|
      # line의 한줄 한줄을 q_list 넣겠다.
      @q_list << line
      # 결과값 -> ["질문 테스트", "두번째 질문 테스트"]
    end
  end

  erb :index
end

get '/ask' do
  # 질문 저장하기
  @question = params["question"]
  @q_id = params["id"]

  # 질문 로깅하기
  File.open("question.txt", "a") do |f|
    f.write("#{@question}, #{@q_id}" + "\n")
  end

  erb :ask
end
