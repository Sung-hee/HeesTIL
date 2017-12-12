require 'rubygems'
require 'sinatra'
require 'data_mapper' # metagem, requires common plugins too.
require 'sinatra/reloader'

# 이 코드를 입력하면 커맨드창에서 -o 0.0.0.0 을 입력안해도 됨 !
set :bind, '0.0.0.0'

# need install dm-sqlite-adapter
DataMapper::setup(:default, "sqlite3://#{Dir.pwd}/blog.db")

class Post
  include DataMapper::Resource
  property :id, Serial
  property :title, String
  property :body, Text
  property :created_at, DateTime
end

# 유저 저장 DB
class User
  include DataMapper::Resource
  property :id, Serial
  property :email, String
  property :password, Text
  property :created_at, DateTime
end

# Perform basic sanity checks and initialize all relationships
# Call this when you've defined all your models
DataMapper.finalize

# automatically create the post table
Post.auto_upgrade!
User.auto_upgrade!

get '/' do

  # 가지고 있는 Post를 보여줌
  @posts = Post.all.reverse
  # reverse이용해서 최신글이 맨 위에 올라오도록 만들자.

  erb :index
end

get '/create' do
  # DB에 저장하기 위해서 create에 저장 폼을 만듬
  Post.create(
    :title => params["title"],
    :body => params["content"]
  )

  # 홈 페이지로 보내기
  redirect to '/'
end

get '/signup' do
  erb :signup
end

get '/register' do
  # DB에 저장하기 위해서 user 저장 폼을 만듬
  User.create(
    :email => params["email"],
    :password => params["password"]
  )

  # 홈 페이지로 보내기
  redirect to '/'
end

get '/admin' do
  # 모든 유저를 불러와
  # admin.erb에서 모든 유저의 정보를 보여준다.
  @users = User.all.reverse

  erb :admin
end
