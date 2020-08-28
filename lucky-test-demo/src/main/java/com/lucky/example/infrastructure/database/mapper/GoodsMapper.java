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
     * 新增应用流水线
     *
     * @param goodsPo
     */
    void insert(GoodsPo goodsPo);


    /**
     * 根据id查询
     *
     * @param pipelineId
     * @return
     */
    GoodsPo queryById(Long pipelineId);

}
