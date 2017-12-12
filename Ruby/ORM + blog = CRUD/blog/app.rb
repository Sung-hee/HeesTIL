#Simle Blog

# # 1. new
#      - get '/' => erb :index,
#      - <form>을 통해 제목(title), 내용(content) 입력
#
# # 2. Create
#     - get 'write' => erb :write,
#     - File.open을 통해 내용 쓰기
#
# # 3. Read
#     - get 'show' => erb :show
#     - File.open을 통해 모든 블로그 내용 읽기

require 'sinatra'

get '/' do
  erb :index
end

get '/write' do
  @title = params["title"]
  @content = params["content"]

  File.open("blog.txt", "a") do |f|
    f.write("title : #{@title}, contents : #{@content}" + "\n")
  end

  erb :write
end

get '/show' do
  @blog_list = []

  File.open("blog.txt", "r") do |f|
    f.each_line do |line|
      # line의 한줄 한줄을 q_list 넣겠다.
      @blog_list << line
      # 결과값 -> ["질문 테스트", "두번째 질문 테스트"]
    end
  end

  erb :show
end
