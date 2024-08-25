FROM maven:3.3.2-openjdk-21 AS build


LABEL authors="Missael"

ENTRYPOINT ["top", "-b"]