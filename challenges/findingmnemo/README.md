# solution
- find out that first four digits are the prefix of the sha256 hash
- find out that the word from the hash, is the next word (empty string for the last word)
  ```
  adapt craft
  bind rescue
  bless reason
  blind small
  civil metal
  craft magnet
  garage napkin
  good bless
  half civil
  hip hotel
  home garage
  hotel lonely
  lonely blind
  magnet ring
  metal good
  mushroom hip
  napkin sunset
  reason shift
  rescue mushroom
  ring (empty string)
  shift home
  small adapt
  sunset tongue
  tongue blind
  ```
- reorder words: `half civil metal good bless reason shift home garage napkin sunset tongue bind rescue mushroom hip hotel lonely blind small adapt craft magnet ring`
- recover **entropy** (not seed!)
  - e.g. using [https://iancoleman.io/bip39/](https://iancoleman.io/bip39/)
    - check *show entropy details*
  - `6865323032317b663173685f725f667231656e64735f6e30745f66303064217d`
- convert from hex -> flag

# generation
- generate mnemonics for flag (flag in hex == entropy)
  - `python mnemonic.py`
  - `6865323032317b663173685f725f667231656e64735f6e30745f66303064217d`
  - `half civil metal good bless reason shift home garage napkin sunset tongue bind rescue mushroom hip hotel lonely blind small adapt craft magnet ring`
- to lines
  ```
  half
  civil
  metal
  good
  bless
  reason
  shift
  home
  garage
  napkin
  sunset
  tongue
  bind
  rescue
  mushroom
  hip
  hotel
  lonely
  blind
  small
  adapt
  craft
  magnet
  ring
  ```

- add **first four** hex digits of the sha256 hash of **next** word (for the last word, hash of empty string)
- sort
  ```
  adapt    3555
  bind     824e
  bless    8fcf
  blind    81db
  civil    03ec
  craft    ed05
  garage   9db4
  good     d2ba
  half     1272 
  hip      8d53
  home     21b7
  hotel    1cb0
  lonely   e5b8
  magnet   16b9
  metal    770e
  mushroom dd80
  napkin   0829
  reason   ecd3
  rescue   5ef2
  ring     e3b0
  shift    4ea1
  small    f1f6
  sunset   b271
  tongue   f08d
  ``` 