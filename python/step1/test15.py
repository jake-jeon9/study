
import re
p = re.compile("^python\s\w+", re.M)
data = """python one
life is too short
python two
you need python
python three"""
print(p.findall(data))
charref = re.compile(r'& [  # ](0[0-7]+|[0-9]+|x[0-9a-fA-F]+);')
charref = re.compile(r"""
&[#]                #start of numberic entity referance
(
        0[0-7]+     #Octal from
    |   [0-9]+      #decimal from
    |   x[09a-fA-F]+  #gexadecimal from
)
;
""", re.VERBOSE)
