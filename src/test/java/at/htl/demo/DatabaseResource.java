package at.htl.demo;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Collections;
import java.util.Map;

public class DatabaseResource implements QuarkusTestResourceLifecycleManager {

    private static final PostgreSQLContainer<?> DATABASE = new PostgreSQLContainer<>("postgres:10.5")
            .withDatabaseName("test_db")
            .withUsername("test")
            .withPassword("test");

    @Override
    public Map<String, String> start() {
        DATABASE.start();

        return Collections.singletonMap("quarkus.datasource.jdbc.url", DATABASE.getJdbcUrl());
    }

    @Override
    public void stop() {
        DATABASE.stop();
    }
}
