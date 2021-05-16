# solution
- bit flipping attack
- find egg image in popular images
  - `41E5D00E5CECC3019834C99B403DE4B24933AF3087BCE219699D7E3EB178A06F7B4717A36C617760EC0AD8BFD5DF05B2`
- play around to find json structure
- play around to realize sepa effect is needed (3)
- get code for image "pony" and effect sepa
- XOR the code to change [tony"] to [egg" ]
    ```
    B76D98A98959D26F301DE2DCACCF2BCFFBBA6E824D6F678B734201B30B46B70EB2B2DF5C132EB3EF0C9DCD2F56F8DCA1
    { " i m a g e " :   " t o n y " ,   " e f f e c t " :   3}
    xor([tony"], [egg" ]) = 1508095b02
    xor (1508095b02, DCACCF2BCF) = C9A4C670CD
    B76D98A98959D26F301DE2C9A4C670CDFBBA6E824D6F678B734201B30B46B70EB2B2DF5C132EB3EF0C9DCD2F56F8DCA1
    ````
- submit code in URL for picture -> sepa image of egg -> scan

# notes
- images
  - flipper
  - chaining
  - thecat
  - wiserabbit
  - pony
  - egg (not usable)
- effects
  - 1 oil
  - 2 contour
  - 3 sepia
  - 4 chocolatize