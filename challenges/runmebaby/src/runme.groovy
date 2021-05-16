def a = [7,3,2] as Set
def b = [7,8,a,4,5,3,5,1,[3,0],3,4,5,5]
def s = [1,6,a,9,4,[5,3,4],8,9,1,a,3,3] + b
def cipher = $/ik934:nvr|h2>biu37~bdeg|D~/$
def sol = ""
for (i in 0..27){
  sol += (char)(cipher.charAt(i) - s.flatten()[i])
}
println "The flag is: $sol"