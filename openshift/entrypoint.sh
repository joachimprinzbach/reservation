#!/bin/sh
exec java ${JAVA_OPTS} \
-Dkafka.endpoints=${KAFKA_BOOTSTRAP_ENDPOINTS} \
-Dkafka.keystore.location=${KAFKA_KEYSTORE_LOCATION} \
-Dkafka.keystore.password=${KAFKA_KEYSTORE_PASSWORD} \
-Djava.security.egd=file:/dev/./urandom \
-jar "${HOME}/app.jar" "$@"
