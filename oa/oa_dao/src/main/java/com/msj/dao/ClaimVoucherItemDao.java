package com.msj.dao;

import com.msj.entity.ClaimVoucherItem;

import java.util.List;

public interface ClaimVoucherItemDao {
    void insertOne(ClaimVoucherItem item);
    List<ClaimVoucherItem> selectItems(Integer cid);
}
