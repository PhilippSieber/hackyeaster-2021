# solution
- xor first bytes with ZIP file header (`504B0304`)
  -> 'xorl' -> user knows it is a zip
- xor some additional `00` to possibly get some more characters
- bruteforce the rest of the key
- key is: `xorlatan`

# creation
- Cyber Chef
- input: file -> XOR