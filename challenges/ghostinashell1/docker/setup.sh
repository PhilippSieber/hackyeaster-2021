#!/usr/bin/env bash
set -e

# set password
echo "inky:mucky_4444" | chpasswd

# disable history
echo 'set +o history' >> /home/inky/.bashrc

# disable password change
passwd -n 9999 inky

# make home dir readonly
chown -R root:root /home/inky
chmod -R 755 /home/inky

# make some dirs readonly
chmod -R 755 /tmp
chmod -R 755 /var/tmp
chmod -R 755 /dev/shm
chmod -R 755 /dev/mqueue

# remove the file
rm -f /etc/entrypoint.d/setup.sh

# find / '(' -type f -o -type d ')' '(' '(' -user  inky -perm -u=w ')' -o '(' -group inky -perm -g=w ')' -o '(' -perm -o=w ')' ')' -print