# solution
`python2.7 exploit/solverMemeory3.py`

On Windows, change slash in `getIdFromFile(filename)`
- from: `filename.replace("img/pic","").replace(".jpg","");`
- to: `filename.replace("img\pic","").replace(".jpg","");`
