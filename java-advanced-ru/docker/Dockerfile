FROM eclipse-temurin:20-jdk

ARG GRADLE_VERSION=8.5

RUN apt-get update && apt-get install -yq make unzip

RUN wget -q https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip \
      && unzip gradle-${GRADLE_VERSION}-bin.zip \
      && rm gradle-${GRADLE_VERSION}-bin.zip

ENV GRADLE_HOME=/opt/gradle

RUN mv gradle-${GRADLE_VERSION} ${GRADLE_HOME}

ENV PATH=$PATH:$GRADLE_HOME/bin

COPY ./app .

EXPOSE 3000

RUN gradle installDist

CMD ./build/install/simple-application/bin/simple-application
