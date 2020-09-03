package com.lucky.example.database;

import com.lucky.example.infrastructure.database.mapper.GoodsMapper;
import com.lucky.example.infrastructure.database.po.GoodsPo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
public class GoodsMapperTest extends BaseMockDatabase{
	@Resource
	GoodsMapper goodsMapper;


	static GoodsPo goodsPo;

	@BeforeAll
	static void init() {
		goodsPo = new GoodsPo();
		goodsPo.setId(UUID.randomUUID().toString().replaceAll("-",""));
		goodsPo.setInventory(100);
		goodsPo.setName("apple");
		goodsPo.setSku(UUID.randomUUID().toString());
	}

	@Test
	@Order(1)
	@DisplayName("数据库单测用例 - 插入")
	public void insert(){
		goodsMapper.insert(goodsPo);
	}

	@Test
	@Order(2)
	@DisplayName("数据库单测用例 - 查询")
	public void select() {
		goodsMapper.insert(goodsPo);
		GoodsPo result = goodsMapper.selectOne(goodsPo.getId());
		Assertions.assertThat(result)
				.hasFieldOrPropertyWithValue("id", goodsPo.getId())
				.hasFieldOrPropertyWithValue("name", goodsPo.getName())
				.hasFieldOrPropertyWithValue("sku", goodsPo.getSku())
				.hasFieldOrPropertyWithValue("inventory", goodsPo.getInventory());
	}
}
