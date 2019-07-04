package com.msj.service;

import com.msj.entity.ClaimVoucher;
import com.msj.entity.ClaimVoucherItem;

import java.util.List;


public interface ClaimVoucherService {
    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);
}
