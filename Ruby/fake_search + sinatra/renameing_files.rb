Dir.chdir('src')

puts Dir.pwd

list = Dir.entries(Dir.pwd).reject {|name| name[0] == "."}
#name[0]이 . 일때 '.'이 들어간 파일들을 제외됨


# File.rename("원래 파일명", "바꿀 파일명")
# File.rename("1list.txt", "sap1list.txt")
# 20.times do |n|
#   File.rename("#{n + 1}list.txt", "sap#{n + 1}list.txt")
# end

list.each do |f|
  File.rename(f, "2017" + f)
end

# puts list.length
#폴더안에 있는 내용물들을 보여줌
# list.each do |file|
#   puts file
# end

#[".", "..", "1list.txt", "2list.txt" ..., "20list.txt"]요소가 있는 22크기의 배열이 생성됨.
