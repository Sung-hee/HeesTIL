# list = ["hello", "hi"]
list = Array.new
#
# list[0] = "hello"
# list[1] = "hi"

count = {}
# count = Hash.new(0)
#디폴트값 생성자로 만든다.
count["1key"] += 1
count["2key"] += 1
count["3key"] += 1

puts count

count {"1hour" => 0, "2hour" => 0, "3hour" => 0}
