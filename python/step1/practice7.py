import re

p = re.compile('[a-z]+')

m = p.finditer('life is too short')

for k in m:
    print(k)
