FROM  panubo/sshd:1.3.0

COPY setup.sh /etc/entrypoint.d/
RUN chmod +x /etc/entrypoint.d/setup.sh

COPY motd /etc/motd

RUN mkdir -p /home/clyde/.lost+found
RUN mkdir -p /home/pacman
COPY files/.bash_history /home/pacman
COPY files/rick.txt /home/clyde/flag\?.txt
COPY files/fail.txt /home/pacman/notes.txt

EXPOSE 22
