FROM  panubo/sshd:1.3.0

COPY setup.sh /etc/entrypoint.d/
RUN chmod +x /etc/entrypoint.d/setup.sh

COPY motd /etc/motd

RUN mkdir -p /home/inky/images/...
RUN mkdir -p /home/inky/text

COPY files/egg.png /home/inky/images/.../...
COPY files/images/* /home/inky/images/
COPY files/text/* /home/inky/text/
COPY files/notes.txt /home/inky/

EXPOSE 22
