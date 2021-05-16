#!/usr/bin/env bash
set -e

# set password
echo "clyde:555-ClYdE" | chpasswd

# group password for group blinky (aaaa)
cat /etc/group | grep -v pacman > tmpgroup
cp tmpgroup /etc/group
rm tmpgroup
echo "pacman:n5a.PKmFwZ1fw:1001:" >> /etc/group

# add file
echo "msPACM4n" > /home/pacman/.\"\\\?\$\*\'N\'\*\$\?\\\"

# disable history
echo 'set +o history' >> /home/clyde/.bashrc

# disable password change
passwd -n 9999 clyde
passwd -n 9999 pacman

# make home dir readonly
chown -R root:root /home/clyde
chmod -R 755 /home/clyde
chown -R root:root /home/pacman
chmod -R 755 /home/pacman

# make some dirs readonly
chmod -R 755 /tmp
chmod -R 755 /var/tmp
chmod -R 755 /dev/shm
chmod -R 755 /dev/mqueue

# files
echo "he2021{wh4ts_y0ur_grewp_4g4in?}" > /home/clyde/.lost+found/flag.txt
chown root:pacman /home/clyde/.lost+found/flag.txt
chmod 440 /home/clyde/.lost+found/flag.txt

# remove the file
rm -f /etc/entrypoint.d/setup.sh

# remove su
rm -f /bin/su