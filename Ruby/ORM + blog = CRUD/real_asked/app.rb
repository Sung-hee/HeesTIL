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
  property :question, Text
  property :created_at, DateTime
end

DataMapper.finalize

Post.auto_upgrade!

get '/' do
  @q_list = Post.all.reverse

  erb :index
end

get '/asked' do
  Post.create(
    :question => params["question"]
  )

  redirect to '/'
end
