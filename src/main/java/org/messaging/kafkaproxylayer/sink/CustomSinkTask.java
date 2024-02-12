package org.messaging.kafkaproxylayer.sink;

import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.messaging.kafkaproxylayer.rest.SyncRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CustomSinkTask extends SinkTask {
    @Autowired
    private SyncRestClient syncRestClient;

    public String version() {
        return null;
    }

    @Override
    public void start(Map<String, String> map) {

    }

    @Override
    public void put(Collection<SinkRecord> collection) {
        AtomicInteger a = new AtomicInteger(0);
        collection.stream().forEach(record ->
        {
            if(a.get()%2==0) {
                syncRestClient.postMessage(record.value().toString());
            }
            a.incrementAndGet();
        });

    }

    @Override
    public void stop() {

    }
}
