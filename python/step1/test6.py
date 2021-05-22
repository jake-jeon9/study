
# while문

treeHit = 0
while treeHit < 10:
    treeHit = treeHit+1
    print("나무를 %d번 찍었습니다" % treeHit)
    if treeHit == 10:
        print('나무가 넘어갔습니다')

coffee = 10
money = 30000
while money > 0:
    coffee = coffee - 1
    money = money - 2000
    print("커피 한잔 나왔다. 잔여 커피는 %d 잔" % coffee)
    if not coffee:
        print("커피가 없습니다. 잔돈은 %d원입니다" % money)
        break


a = 0
while a < 10:
    a = a + 1
    if a % 2 == 0:
        continue
    print(a)

test_list = ['one', 'two', 'three']
for i in test_list:
    print(i)

a = [(1, 2), (3, 4,), (5, 6)]
for (first, last) in a:
    print(first + last)

marks = [90, 25, 67, 45, 80]
number = 0
for mark in marks:
    number = number+1
    if mark >= 60:
        print("%d번 학생은 합격입니다." % number)
    else:
        print("%d번 학생은 불합격입니다." % number)

number = 0
for mark in marks:
    number = number + 1
    if mark < 60:
        continue
    print("%d번 학생 합격입니다." % number)

sum = 0
for i in range(1, 11):
    sum = sum + i
print(sum)

for i in range(2, 10):
    for j in range(1, 10):
        print(i*j, end=" ")
    print('')


a = [1, 2, 3, 4, 5, 6]
result = [num * 3 for num in a if num % 2 == 0]

result = []
for num in a:
    if num % 2 == 0:
        result.append(num*3)

resultk = [x*y for x in range(2, 10) for y in range(1, 10)]
print(resultk)

resultk = []
for x in range(2, 10):
    for y in range(1, 10):
        resultk.append(x*y)
