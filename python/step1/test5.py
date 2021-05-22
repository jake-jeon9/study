# if문
money = 2000
card = 1

pokect = ['money', 'card', 'cellphone']

if 'money' not in pokect:
    pass
elif card:
    print('택시타기1')
else:
    print('걸어가기')


score = 70
if score >= 60:
    message = 'success'
else:
    message = 'failure'

message2 = "success" if score >= 60 else "failure"
# 삼항 연산자와 같은거임
print(message)
print(message2)
