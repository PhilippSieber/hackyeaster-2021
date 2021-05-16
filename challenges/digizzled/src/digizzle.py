import re
pattern = re.compile("^he2021\{([dlsz134]){9}\}$")

def hizzle(s):
	s1 = 13
	s2 = 37
	for n in range(len(s)):
		s1 = (s1 + ord(s[n])) % 65521
		s2 = (s1 * s2) % 65521
	return (s2 << 16) | s1

def smizzle(a,b):
	return format(a,'x') + format(b,'x')

print("-------------------------------------")
print("      o                  o           ")
print("      | o      o         |           ")
print("    o-O   o--o   o-o o-o | o-o o-o   ")
print("   |  | | |  | |  /   /  | |-' |     ")
print("    o-o | o--O | o-o o-o o o-o o     ")
print("             |                       ")
print("         o--o                        ")
print("-------------------------------------")
s = input('enter flag:')
if (pattern.match(s)):
	print("digizzling...")
	a = hizzle(s)
	b = hizzle(s[::-1])
	print(smizzle(a,b))
else:
	print('wrong format!')
