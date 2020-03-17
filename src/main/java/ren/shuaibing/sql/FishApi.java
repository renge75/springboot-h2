package ren.shuaibing.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FishApi {
    /**
     * 从spring容器里面拿过来用
     */
    @Autowired
    FishRepository fishRepository;

    @RequestMapping("/fish/list")
    public Iterable<Fish> fishList() {
        return fishRepository.findAll();
    }

    @RequestMapping("/fish/add")
    public String fishAdd() {
        Fish fish = new Fish();
        fish.setName("叉尾鱼");
        fish.setHabit("冷水");
        fishRepository.save(fish);
        return "保存成功";
    }
}
