package io.cellulant.testContainers.repositories;

import io.cellulant.testContainers.TestContainersApplication;
import io.cellulant.testContainers.configs.ContainersEnvironment;
import io.cellulant.testContainers.entities.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestContainersApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductRepositoryTest extends ContainersEnvironment {

    @Autowired
    ProductRepository underTest;

    @Test
    void existsByNameIsLike() {
        //given
        Product prod1 = new Product();
        prod1.setName("Cashews");

        Product prod2 = new Product();
        prod2.setName("Cars");
        underTest.saveAll(List.of(prod1, prod2));

        //when

        boolean cars = underTest.existsByNameIsLike("milk");

        //then

        assertThat(cars).isFalse();
    }

    @Test
    void findByNameContainsIgnoreCase() {
    }
}