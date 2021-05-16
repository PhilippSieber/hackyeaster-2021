FROM openjdk:11-jdk-slim

RUN mkdir /seasons
COPY app.jar /seasons/app.jar
COPY flag.txt /seasons/flag.txt
COPY start.sh /seasons/start.sh
RUN chmod 755 /seasons/start.sh
RUN chmod -R 755 /seasons
RUN groupadd -r seasons && useradd -r -g seasons seasons
USER seasons

EXPOSE 8080
ENTRYPOINT [ "/seasons/start.sh" ]