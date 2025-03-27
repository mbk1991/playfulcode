#!/bin/bash

echo $1

for i in $(seq 1 65535)
do

    if tcping $1 $i 2>&1 | grep -q "open"; then
        echo "port $i is open"
    fi



done
