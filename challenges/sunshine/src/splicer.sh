#!/bin/bash

F_IN="./sunshine.png"

for i in `seq 0 64 1023`; do
	convert $F_IN -crop 

	for i in `seq 0 15` ; do convert rays-$i.png -rotate $(($i*45)) rotrays-$i.jpg ; done