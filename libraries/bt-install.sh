#!/usr/bin/env sh

if [ "$EUID" -ne 0 ]; then
    echo "Run as root"
    exit
fi

apt install libbluetooth-dev || yum install bluez-libs-devel
