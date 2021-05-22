import re

p = re.compile(".+(?=:)")
m = p.search("http://google.com")
print(m.group())

k = re.compile(".*[.](?!bat$|exe$).*$", re.M)
l = k.findall("""
autoexec.exe
autoexec.bat
autoexec.jpg
""")
print(l)
