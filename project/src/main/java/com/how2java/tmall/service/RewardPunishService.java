package com.how2java.tmall.service;

import com.how2java.tmall.dao.RewardPunishDAO;
import com.how2java.tmall.pojo.RewardPunish;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RewardPunishService {
    @Autowired RewardPunishDAO rewardPunishDAO;
    @Autowired UserService userService;

    public void add(RewardPunish bean) {
        rewardPunishDAO.save(bean);
    }

    public void delete(int id) {
        rewardPunishDAO.delete(id);
    }

    public RewardPunish get(int id) {
        return rewardPunishDAO.findOne(id);
    }

    public void update(RewardPunish bean) {
        rewardPunishDAO.save(bean);
    }

    public Page4Navigator<RewardPunish> list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =rewardPunishDAO.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

}
