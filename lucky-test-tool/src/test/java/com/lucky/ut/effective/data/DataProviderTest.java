package com.lucky.ut.effective.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lucky.ut.effective.utils.JsonUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author zhourj
 * @date 2020/9/18 12:07
 */
class DataProviderTest {
	@Test
	@DisplayName("数值数据提供工具测试")
	public void NumberTest(){
		System.out.println("无参数 Integer 测试：" + DataProvider.Integer());
		System.out.println("Integer 指定范围测试：" + DataProvider.Integer(5,10));
	}

	@Test
	@DisplayName("字符数据提供工具测试")
	public void StringTest(){
		// 没个定参数，默认 32
		System.out.println("字符无参数测试：" + DataProvider.String());
		System.out.println("长度 10 的字符测试：" + DataProvider.String(10));
		System.out.println("长度 12 的字符测试：" + DataProvider.String(12));
	}

	@Test
	@DisplayName("时间数据提供工具测试")
	public void DateTest(){
		System.out.println("LocalDate：" + DataProvider.LocalDate());
		System.out.println("LocalDateTime：" + DataProvider.LocalDateTime());
	}

	@Test
	@DisplayName("对象数据提供工具测试")
	public void ObjectTest() throws JsonProcessingException {
		BeanObject beanObject = DataProvider.anyObject(BeanObject.class);
		System.out.println("anyObject：" + JsonUtils.writeJsonStr(beanObject));

		BeanObject[] beanObjectArray = DataProvider.anyArray(BeanObject.class);
		System.out.println("数组：" + JsonUtils.writeJsonStr(beanObjectArray));

		List<BeanObject> beanObjectList = DataProvider.anyList(BeanObject.class);
		System.out.println("列表：" + JsonUtils.writeJsonStr(beanObjectList));
	}
}