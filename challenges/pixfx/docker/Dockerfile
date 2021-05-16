FROM openjdk:11-jdk-slim

RUN mkdir /pixfx
COPY app.jar /pixfx/app.jar
COPY start.sh /pixfx/start.sh
RUN chmod 755 /pixfx/start.sh
RUN chmod -R 755 /pixfx
RUN groupadd -r pixfx && useradd -r -g pixfx pixfx
USER pixfx

EXPOSE 8080
ENTRYPOINT [ "/pixfx/start.sh" ]