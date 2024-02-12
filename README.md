https://docs.confluent.io/kafka-connectors/http/current/overview.html#http-sink-multiple-tasks

https://docs.confluent.io/platform/current/connect/devguide.html

https://github.com/microsoft/kafka-connect-cosmosdb/blob/dev/src/main/java/com/azure/cosmos/kafka/connect/CosmosDBConfig.java

cp target/kafka-proxy-layer-0.0.1-SNAPSHOT-jar-with-dependencies.jar /Users/y0g02z5/confluent-7.6.0/share/confluent-hub-components

confluent local services connect connector load CustomSink --config custom-sink.json