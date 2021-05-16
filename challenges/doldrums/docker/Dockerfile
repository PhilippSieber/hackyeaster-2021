# docker build -t chall3 . && docker run -p 1024:1024 --rm -it challenge3

FROM ubuntu:18.04

RUN apt-get update

RUN useradd -d /home/ctf/ -m -p ctf -s /bin/bash ctf
RUN echo "ctf:ctf" | chpasswd
RUN dpkg --add-architecture i386
RUN apt-get install -y gcc-multilib

WORKDIR /home/ctf

COPY challenge3 .
COPY flag .
COPY ynetd .
COPY heading .

RUN chmod +x ynetd challenge3

RUN chown -R root:root /home/ctf

USER ctf
CMD ./ynetd ./challenge3
