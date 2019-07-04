package com.msj.service.impl;

import com.msj.dao.ClaimVoucherItemDao;
import com.msj.entity.ClaimVoucherItem;
import com.msj.service.ClaimVoucherItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaimVoucherItemServiceImpl implements ClaimVoucherItemService{
    @Autowired
    private ClaimVoucherItemDao claimVoucherItemDao;

    public void save(ClaimVoucherItem item){
        claimVoucherItemDao.insertOne(item);
    }


}
