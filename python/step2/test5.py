# 매주 1회 작성해야 하는 보고서가 있다. 폼은 아래와 같다

# - X 차 주간보고 -
# 부서 :
# 이름 :
# 업무요약 :

# 1주차 부터 50주차까지 보고서 파일을 만드는 프로그램을 작성하시오

# 조건 : 파일명은 1주차.txt , 2주차.txt. 와 같이 만든다


for i in range(1, 51):
    text = """
    - {} 주차 주간보고 -
    부서 : {}
    이름 : {}
    업무 요약 : {}
    """.format(i, "글로벌팀", "전성환", str(i)+"주 실적임")
    with open(str(i)+"주차.txt", 'w', encoding="utf8") as file:
        file.write(text)
