import base64

flag = b'Congrats, here is your flag: he2021{th4ts_m0nkey_bus1n3ss}'
b64 = str(base64.b64encode(flag), "utf-8")
riddle = ''.join([ b64[x:x+2][::-1] for x in range(0,len(b64),2) ])
print(riddle)