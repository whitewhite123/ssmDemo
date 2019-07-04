package com.msj.dao;

import com.msj.entity.ClaimVoucher;

import java.util.List;

public interface ClaimVoucherDao {
    void insertOne(ClaimVoucher claimVoucher);
    List<ClaimVoucher> selectSelf(String createSn);
    List<ClaimVoucher> selectForDeal(String createSn);
}
