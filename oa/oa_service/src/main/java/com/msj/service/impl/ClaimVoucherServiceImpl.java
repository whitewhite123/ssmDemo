package com.msj.service.impl;

import com.msj.dao.ClaimVoucherDao;
import com.msj.dao.ClaimVoucherItemDao;
import com.msj.entity.ClaimVoucher;
import com.msj.entity.ClaimVoucherItem;
import com.msj.global.Contant;
import com.msj.service.ClaimVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClaimVoucherServiceImpl implements ClaimVoucherService {
    @Autowired
    private ClaimVoucherDao claimVoucherDao;
    @Autowired
    private ClaimVoucherItemDao claimVoucherItemDao;

    public void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
        claimVoucher.setCreateTime(new Date()); //创建时间
        claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
        claimVoucher.setStatus(Contant.CLAIMVOUCHER_CREATED); //状态
        //添加到claimVoucher表中
        claimVoucherDao.insertOne(claimVoucher);
        //添加到claimVoucherItem表中
        for(ClaimVoucherItem item:items){
            item.setClaimVoucherId(claimVoucher.getId());
            claimVoucherItemDao.insertOne(item);
        }
    }

    public List<ClaimVoucher> findSelf(String createSn) {
        return claimVoucherDao.selectSelf(createSn);
    }
}
