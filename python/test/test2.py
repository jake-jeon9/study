from animal import dog  # 애니멀 패키지에서 덕이라는 모듈을 가져와
from animal import cat  # 애니멀 패키지에서 캣이라는 모듈을 가져와

from animal import *  # 애니멀 패키지가 갖고 있는 모듈을 다 가져와

d = dog.Dog()
d.hi()

c = Cat()
c.hi()


k = "python"
k[0].replace("p", "P")
print(k)
