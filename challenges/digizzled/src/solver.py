import re
import itertools
import string

def hizzle(s):
	s1 = 13
	s2 = 37
	for n in range(len(s)):
		s1 = (s1 + ord(s[n])) % 65521
		s2 = (s1 * s2) % 65521
	return (s2 << 16) | s1

def smizzle(a,b):
	return format(a,'x') + format(b,'x')

ALPHABET = 'dlsz134'
count =0
for a,b,c,d,e,f,g,h,i in itertools.product(ALPHABET, repeat=9):
	s = 'he2021{'+a+b+c+d+e+f+g+h+i+'}'
	a = hizzle(s)
	b = hizzle(s[::-1])
	x = smizzle(a,b)
	count = count + 1
	if count % 1000000 == 0:
		print('.')
	if x == 'c5ab05ca73f205ca':
		print(s)
