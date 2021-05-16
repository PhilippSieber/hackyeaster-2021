#
# abcdefghijklmnop
#
# edcba
# f
# ghijk
#     l
#  ponm   
#
# efg - dhp - cio - bjn - aklm
#

plain = "he2021{dont_fall_into_the_snake_pit!}"
map = [4,3,2,1,0,0,0,1,2,3,4,4]
columns = ["" for x in range(5)]

for i in range(len(plain)):
    columns[map[i%len(map)]] += plain[i]

print(''.join(columns))