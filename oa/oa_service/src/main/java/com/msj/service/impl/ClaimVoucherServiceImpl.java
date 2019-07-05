package com.msj.service.impl;

import com.msj.dao.ClaimVoucherDao;
import com.msj.dao.ClaimVoucherItemDao;
import com.msj.dao.DealRecordDao;
import com.msj.entity.ClaimVoucher;
import com.msj.entity.ClaimVoucherItem;
import com.msj.entity.DealRecord;
import com.msj.global.Contant;
import com.msj.service.ClaimVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClaimVoucherServiceImpl implements ClaimVoucherService{
    @Autowired
    private ClaimVoucherDao claimVoucherDao;
    @Autowired
    private ClaimVoucherItemDao claimVoucherItemDao;
    @Autowired
    private DealRecordDao dealRecordDao;

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

    public List<ClaimVoucher> findForDeal(String createSn) {
        return claimVoucherDao.selectForDeal(createSn);
    }

    public ClaimVoucher findclaimVoucher(Integer id) {
        return claimVoucherDao.selectclaimVoucher(id);
    }

    public List<ClaimVoucherItem> findItems(Integer cid) {
        return claimVoucherItemDao.selectItems(cid);
    }

    public List<DealRecord> findRecords(Integer id) {
        return dealRecordDao.selectRecord(id);
    }
}
