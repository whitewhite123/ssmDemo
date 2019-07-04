package com.msj.service;

import com.msj.entity.ClaimVoucher;
import com.msj.entity.ClaimVoucherItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ClaimVoucherService {
    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);
    List<ClaimVoucher> findSelf(String createSn);
    List<ClaimVoucher> findForDeal(String createSn);
}
