package at.htl.demo;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.GenericContainer;

import java.util.Map;

public class DatabaseGenericResource implements QuarkusTestResourceLifecycleManager {

    private static final GenericContainer<?> DATABASE = new GenericContainer<>("postgres:10.5")
            .withExposedPorts(5432)
            .withEnv("POSTGRES_DB", "test_db")
            .withEnv("POSTGRES_USER", "test")
            .withEnv("POSTGRES_PASSWORD", "password");

    @Override
    public Map<String, String> start() {
        DATABASE.start();

        String jdbcUrl = "jdbc:postgresql://" + DATABASE.getHost() + ":" + DATABASE.getMappedPort(5432) + "/test_db";
        return Map.of(
                "quarkus.datasource.password", "password",
                "quarkus.datasource.jdbc.url", jdbcUrl
        );
    }

    @Override
    public void stop() {
        DATABASE.stop();
    }
}
