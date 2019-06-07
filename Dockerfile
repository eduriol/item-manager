FROM maven:3.6.1-jdk-8
VOLUME /tmp
ADD . / item-manager/
EXPOSE 8082
CMD (cd item-manager/; mvn spring-boot:run;)
