package ren.shuaibing.sql;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureWebTestClient
class FishApiTest {

    @Autowired WebTestClient webClient;

    @Test
    @Order(2)
    void fishList() {
        webClient.get().uri("/fish/list").exchange().expectStatus().isOk()
                //.expectBody(String.class).isEqualTo("Hello World")
        ;

    }

    @Test
    @Order(1)
    void fishAdd() {
    }
}