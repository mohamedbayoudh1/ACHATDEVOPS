FROM openjdk:11-jre-slim

WORKDIR /app

EXPOSE 8082


RUN apt-get update && apt-get install -y \
  curl \
  ca-certificates \
  && rm -rf /var/lib/apt/lists/*

ENV JAR_URL=http://192.168.43.223:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar

RUN curl -o achat-1.0.jar ${JAR_URL}

ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
