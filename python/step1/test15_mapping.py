import re

p = re.compile(r"(\w+)\s+\d+[-]\d+[-]\d+")
m = p.search("park 010-1234-1234")
print(m.group(1))

k = re.compile(r'(\b\w+)\s+\1')
print(k.search('Paris in the the spring').group())

o = re.compile(r"(?P<name>\w+)\s+((\d+)[-]\d+[-]\d+)")
a = o.search("park 010-1234-1234")
print(a.group("name"))

b = re.compile(r'(?P<word>\b\w+)\s+(?P=word)')
print(b.search('Paris in the the spring').group())
