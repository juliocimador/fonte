FROM openjdk:17

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/cadastro_spring

COPY /target/cadastro*.jar cadastro.jar

SHELL ["/bin/sh","-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar cadastro.jar --spring.profiles.active=${PROFILE}