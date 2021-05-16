#!/usr/bin/python3

# Instead of the usual hex order, bunny uses musical hex.
# Which means, it's not 0123456789abcdef but 0123456789cdefab
#
# So a becomes c etc:
# a -> c
# b -> d
# c -> e
# d -> f
# e -> a
# f -> b


def garble_hash(my_hash):
	my_hash = my_hash.lower()
	my_hash = my_hash.replace("a", "C")
	my_hash = my_hash.replace("b", "D")
	my_hash = my_hash.replace("c", "E")
	my_hash = my_hash.replace("d", "F")
	my_hash = my_hash.replace("e", "A")
	my_hash = my_hash.replace("f", "B")

	return(my_hash.lower())

def ungarble_hash(my_hash):
	my_hash = my_hash.lower()
	my_hash = my_hash.replace("c", "A")
	my_hash = my_hash.replace("d", "B")
	my_hash = my_hash.replace("e", "C")
	my_hash = my_hash.replace("f", "D")
	my_hash = my_hash.replace("a", "E")
	my_hash = my_hash.replace("b", "F")
	return(my_hash.lower())


orig_hashes = ["cae2f9fa51459f2ff38f92dc472c3275c8d6e393", "aac840307d8c2a58f5bbbfa41e6d8049d304e50f", "f19d3fd5251ae76e221048fd0d445cf39ed576d0"]

for my_hash in orig_hashes:
	print(f"{my_hash}\n{garble_hash(my_hash)}\n")

print("And back")

for my_hash in orig_hashes:
	print(f"{garble_hash(my_hash)}\n{ungarble_hash(garble_hash(my_hash))}\n")


"""
cae2f9fa51459f2ff38f92dc472c3275c8d6e393	sha1	ilovemum
aac840307d8c2a58f5bbbfa41e6d8049d304e50f	sha1	sincerely
f19d3fd5251ae76e221048fd0d445cf39ed576d0	sha1	hunnybunny

garbled
eca2b9bc51459b2bb38b92fe472e3275e8f6a393
cce840307f8e2c58b5dddbc41a6f8049f304a50b
b19f3bf5251ca76a221048bf0f445eb39af576f0

hunnybunny loves music! Can you figure out what else he loves?


"""

