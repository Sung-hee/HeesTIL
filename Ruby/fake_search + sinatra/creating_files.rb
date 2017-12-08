# File.open("text.txt", "w") do |f|
#   f.write("Hack your life!")
# end

#반복, int, String 합치기
# 5.times do |n|
#   puts (n + 1).to_s + "list"
# end

# .txt 20개를 만든다.
# 몇번째 파일 + list
# 1list.txt > 내용물 : 1번째 파일입니다.
# 2list.txt > 내용물 : 2번째 파일입니다.
# 3list.txt
# 20.times do |timer|
#   File.open((timer + 1).to_s + "list.txt", "w") do |f|
#     f.write((timer + 1).to_s + "번째 파일입니다.")
#   end
# end

# String 조작방법 2가지
# concatenation : 합체 "" + ""
# interpolation : 수술 "()" 안에 뭔가를 집어넣음

#interpolation 사용법
# age = 26
# puts "내 나이는 #{age}"

Dir.chdir ('src')
puts Dir.pwd

20.times do |timer|
  File.open("#{timer + 1}list.txt", "w") do |f|
    f.write("#{timer + 1}번째 파일입니다.")
  end
end
