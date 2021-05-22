# 표중 체중구하기

# 공식
# 남자 : 키(m) X 키(m) X 22
# 여자 : 키(m) X 키(m) X 21

# 조건 1 : 표중 체중은 별도의 함수 내에서 계산
#   함수명 : std_weight / 전달값 : 키, 성별
# 조건 2 : 표중 체중은 소수점 둘재짜리까지만 표시


def std_weight(height, gender):
    data = 0
    if gender == "남자":
        data = height * height * 22
    else:
        data = pow(height) * 21

    return data


height = 175
data = round(std_weight(height, "남자") / 10000, 2)

print("키 {} 남자의 표중 체중은 {} 입니다.".format(height, data))
