package com.lucky.example.infrastructure.database.mapper;

import com.lucky.example.infrastructure.database.po.GoodsPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: zhourj
 * @description: com.lucky.uap.pipeline.mapper
 * @date:2020/5/15
 **/
@Mapper
public interface GoodsMapper {

    /**
     * 新增商品
     *
     * @param goodsPo
     */
    void insert(GoodsPo goodsPo);

    GoodsPo selectOne(String id);

}
