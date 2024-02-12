package org.messaging.kafkaproxylayer.connector;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;
import org.messaging.kafkaproxylayer.sink.CustomSinkTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomSinkConnector extends SinkConnector {
    private Map<String, String> configProps;
    @Override
    public void start(Map<String, String> props) {
        configProps = props;
    }

    @Override
    public Class<? extends Task> taskClass() {
        return CustomSinkTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        final List<Map<String, String>> configs = new ArrayList<>(maxTasks);
        for (int i = 0; i < maxTasks; ++i) {
            configs.add(configProps);
        }
        return configs;
    }

    @Override
    public void stop() {

    }

    @Override
    public ConfigDef config() {
        return new ConfigDef();
    }

    @Override
    public String version() {
        return this.getClass().getPackage().getImplementationVersion();
    }
}
