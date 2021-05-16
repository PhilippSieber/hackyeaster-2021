# solution
- decompile, e.g. with APKTool
- find raw resource *raw.raw* containing cipher string
- find string *pattern*: `[a-z][0-9]{4}`
- understand logic:
   - PIN entry
   - check PIN against pattern
   - decrypt raw.raw using `Crypto` class
- write Brute-Forcer which checks all values possible (26*10^4)
- PIN: `g0717`