package com.msj.mapper;

import com.msj.pojo.Product;
import com.msj.pojo.ProductWithBLOBs;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    ProductWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProductWithBLOBs record);

    int updateByPrimaryKey(Product record);
}