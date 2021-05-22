import re
p = re.compile('(blue|white|red)')
print(p.sub('color', 'blue socks and red'))


s = '<html><head><title>Title</title>'
print(re.match('<.*>', s).group())  # greedy
print(re.match('<.*?>', s).group())  # non-greedy
