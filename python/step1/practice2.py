# 3과 5의 배수의 합구하기

num = int(input("1000미만의 자연수 입력 : "))

while num < 0 or num > 1000:
    print("범위 내에서 값을 입력하세요.")
    num = int(input("1000미만의 자연수 입력 : "))

k = 1
s1 = {}
numlist = []
while k < num:
    if k % 3 == 0:
        numlist.append(k)
        # s1.update(3*k)
    elif k % 5 == 0:
        # s1.update(5*k)
        numlist.append(k)

    k += 1

numlist = set(numlist)
print(sum(numlist))
print("----------")

result = 0
for n in range(1, num):
    if n % 3 == 0 or n % 5 == 0:
        result += n
print(result)
