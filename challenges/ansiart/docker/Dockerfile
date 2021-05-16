FROM ubuntu:16.04

RUN apt update && apt install -y socat

RUN useradd -d /home/he/ -m -p he -s /bin/bash he
RUN echo "he:he" | chpasswd
WORKDIR /home/he
COPY app/script.sh .
RUN chmod 755 *

USER he

ENTRYPOINT socat TCP-LISTEN:8080,fork,reuseaddr,bind=0.0.0.0 EXEC:"./script.sh"