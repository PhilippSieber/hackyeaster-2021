# solution
- reverse engineer the python disassembly
- brute-force
  - pattern: ^he2021\{([dlsz134]){9}\}$
  - 7^9 = 40 mio possibilities
  - calculate hash until output matches
  - similar to adler32 hash
    - different start values
    - multiplication instead of addition
    - applied for string and reversed string
    - hex values concatenated
- solver.py

# generation
python3 -m dis digizzler.py 
