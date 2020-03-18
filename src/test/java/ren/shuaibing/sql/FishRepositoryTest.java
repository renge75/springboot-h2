package ren.shuaibing.sql;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * 注解：@TestMethodOrder(MethodOrderer.OrderAnnotation.class)启动测试顺序控制
 * 于order连用
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FishRepositoryTest {

    @Autowired
    FishRepository fishRepository;

    @Test
    @Order(1)
    public void saveTest(){
        Fish fish = new Fish();
        fish.setName("叉尾鱼");
        fish.setHabit("冷水");
        fishRepository.save(fish);
    }

    @Test
    @Order(4)
    public void deleteTest() {
        Fish fish = new Fish();
        fish.setName("叉尾鱼");
        fish.setHabit("冷水");
        fishRepository.delete(fish);
    }


    @Test
    @Order(3)
    public void updateTest() {
        Fish fish = new Fish();
        fish.setName("叉尾鱼");
        fish.setHabit("冷水");
        fishRepository.save(fish);
    }

    @Test
    @Order(2)
    public void findByIdTest() {

        Optional<Fish> byId = fishRepository.findById(1L);
        Assertions.assertNotNull(byId.get());
    }


}