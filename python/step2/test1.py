
# 규칙 1 : http:// 이부분 자르기
# 규칙2 : 처음만나는 점 이후로 제외하기
# 규칙3 : 남은 글자 중 처음 세자리 글자 갯수 /글자 갯수/ 'e'의 갯수 / ! 구성

url = "http://naver.com"
newText = url.replace("http://", "")
first = newText[:3]
second = newText[0:newText.find(".")]
therd = newText.count("e")
newpass = first+str(len(second))+str(therd)+"!"
print("{1}의 생성된 비밀번호는 {0} 입니다.".format(newpass, url))
