package com.lucky.example.infrastructure.database.po;

import lombok.Data;

/**
 * @author zhourj
 * @date 2020/8/26 17:05
 */
@Data
public class GoodsPo {
	/**
	 * ID
	 */
	public String id;
	/**
	 * 商品名称
	 */
	public String name;
	/**
	 * 商品规格
	 */
	public String sku;
	/**
	 * 库存
	 */
	public Integer inventory;
}
