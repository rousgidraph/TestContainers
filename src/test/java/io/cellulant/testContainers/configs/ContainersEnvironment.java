package io.cellulant.testContainers.configs;


import io.cellulant.testContainers.containers.PostgresTestContainer;
import io.cellulant.testContainers.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class ContainersEnvironment {


    @Container
    public static PostgreSQLContainer postgreSQLContainer = PostgresTestContainer.getInstance();

}
