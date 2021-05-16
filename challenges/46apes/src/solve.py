import base64
riddle = b'2Qu93ZhJHdsMGIlhmcgUXagMWe19icmBGbnFiOoBTZwIjM7FGd0gHdfNTbuB2a5V2X1JzcuF3MzNQf=='
b64 = ''.join([ riddle[x:x+2][::-1] for x in range(0,len(riddle),2) ])
flag = str(base64.b64decode(b64))
print(flag)