text = "A Tale of Two Cities (1859) is a novel by Charles Dickens, set in London and Paris before and during the French Revolution. The novel tells the story of the French Doctor Manette, his 18-year-long imprisonment in the Bastille in Paris and his release to life in London with his daughter Lucie, whom he had never met; Lucie's marriage and the collision between her beloved husband and the people who caused her father's imprisonment; and Monsieur and Madame Defarge, sellers of wine in a poor suburb of Paris. The story is set against the conditions that led up to the French Revolution and the Reign of Terror."

# 1. text -> 단어별 끊긴 배열을 하나 만든다. (split)
# 2. words = ["It", "was", "the", "best", "of" ....] 각각 돌면서
# 3. wf = Hash.new(0) 특정 단어가 있으면 +1 없으면 0
# - {"it" => 3, "was" => 2, ...}
# 4. Hash를 돌면서 각각의 요소(단어)가 몇 번 나왔는지 출력한다.

text_array = text.downcase.split(" ")

wf = Hash.new(0)

text_array.each do |word|

  if(word.include?("."))
    word[0..word.length - 1]
  elsif (word.include?(","))
    word[0..word.length - 1]
  end

  wf[word] += 1
end

values = []
wf.each do |word, freq|
  puts "#{word} : #{freq}"

  values << freq
end

puts "The most frequent word: #{values.max}"
# puts "The most frequent word: #{wf.values.max}" -> 한줄로도 가능하다 !
# puts wf.keys key만 출력
# puts wf.values value만 출력
