FROM openjdk

EXPOSE 8080

COPY ./build/libs/pokechallenge-0.0.1-SNAPSHOT.jar ./pokechallenge.jar

ENTRYPOINT java -jar pokechallenge.jar