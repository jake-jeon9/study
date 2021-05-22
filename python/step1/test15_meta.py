import re

p = re.compile("Crow|Servo")
m = p.match("CrowHello")
k = p.match("ServoVB")
l = p.match("bkCrow")
print(m)
print(k)
print(l)


print(re.search('Life$', 'My Life'))
print(re.search('^Life$', 'Life is too'))

j = re.compile(r'\bclass\b')
print(j.search('no class at all'))
print(j.search('the dealssfied algorithm'))
print(j.search('one subclass is'))
