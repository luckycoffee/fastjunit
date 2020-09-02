package com.lucky.example.database;

import com.lucky.example.infrastructure.database.mapper.GoodsMapper;
import com.lucky.example.infrastructure.database.po.GoodsPo;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.context.jdbc.Sql;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author zhourj
 * @date 2020/8/26 17:12
 */
@Profile("junit-test")
@Component
@Sql({"classpath:sql/goods.sql"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoodsMapperTest extends BaseMockDatabase{
	@Resource
	GoodsMapper goodsMapper;


	GoodsPo goodsPo;

	@Before
	public void init() {
		goodsPo = new GoodsPo();
		goodsPo.setId(UUID.randomUUID().toString().replaceAll("-",""));
		goodsPo.setInventory(100);
		goodsPo.setName("apple");
		goodsPo.setSku(UUID.randomUUID().toString());
	}

	@Test
	public void insert() {
		goodsMapper.insert(goodsPo);

		GoodsPo result = goodsMapper.selectOne(goodsPo.getId());

		Assertions.assertThat(result)
				.hasFieldOrPropertyWithValue("id", goodsPo.getId())
				.hasFieldOrPropertyWithValue("name", goodsPo.getName())
				.hasFieldOrPropertyWithValue("sku", goodsPo.getSku())
				.hasFieldOrPropertyWithValue("inventory", goodsPo.getInventory());
	}
}
