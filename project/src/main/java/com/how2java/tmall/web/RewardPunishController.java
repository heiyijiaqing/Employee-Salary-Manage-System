package com.how2java.tmall.web;

import com.how2java.tmall.pojo.RewardPunish;
import com.how2java.tmall.service.RewardPunishService;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class RewardPunishController {
    @Autowired RewardPunishService rewardPunishService;

    //DepartmentController 修改原 list 方法，接受 start 和 size 参数。
    @GetMapping("/rewardPunishs")
    public Page4Navigator<RewardPunish> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
        start = start < 0 ? 0 : start;
        Page4Navigator<RewardPunish> page = rewardPunishService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }

    @GetMapping("/rewardPunishs/{id}")
    public RewardPunish get(@PathVariable("id") int id) throws Exception {
        RewardPunish bean=rewardPunishService.get(id);
        return bean;
    }

    @PostMapping("/rewardPunishs")
    public Object add(@RequestBody RewardPunish bean) throws Exception {
        bean.setCreateDate(new Date());
        rewardPunishService.add(bean);
        return bean;
    }

    @DeleteMapping("/rewardPunishs/{id}")
    public String delete(@PathVariable("id") int id)  throws Exception {
        rewardPunishService.delete(id);
        return null;
    }

    @PutMapping("/rewardPunishs")
    public Object update(@RequestBody RewardPunish bean) throws Exception {
        rewardPunishService.update(bean);
        return bean;
    }
}
