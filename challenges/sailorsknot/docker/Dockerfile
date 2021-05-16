# docker build -t chall2 . && docker run -p 1024:1024 --rm -it challenge2

FROM ubuntu:18.04

RUN apt-get update

RUN useradd -d /home/ctf/ -m -p ctf -s /bin/bash ctf
RUN echo "ctf:ctf" | chpasswd

WORKDIR /home/ctf

COPY challenge2 .
COPY flag .
COPY ynetd .

RUN chmod +x ynetd challenge2

RUN chown -R root:root /home/ctf

USER ctf
CMD ./ynetd ./challenge2
