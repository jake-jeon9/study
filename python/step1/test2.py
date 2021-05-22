
t1 = (1, 2, 'a', 'b')
print(t1)
print(t1[1])
print(t1[0:2])

a = 'asdawdadsa'
print(len(a))

k = 36
dic = {'name': 'jake', 'age': k}
dic['job'] = 'helper'
print(dic)

dic2 = {'name': 'korea', 'age':  15}
print(dic['name'])

key = {1: 'jake', 2: 'jeon', 3: 'seonghwan'}
print(key.values())
print(key.keys())
print(key.items())

for k in key.keys():
    print(k)

for k, v in key.items():
    print("키는 : "+str(k))
    print("벨류는 : "+v)

print(key[1])

print(4 in key)
