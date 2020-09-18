package com.lucky.ut.effective.data;

import com.lucky.ut.effective.data.category.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhourj
 * @date 2020/9/18 10:43
 * 数据提供器
 */
public class DataProvider {
	/**
	 * 一个参数代表数字范围的起点，二个参数代表了启动和终点
	 * @param params
	 * @return
	 */
	public static Integer Integer(Integer ... params){
		return new IntegerProvider(params).generate();
	}

	/**
	 * 没个定参数，默认长度 32
	 * @param params
	 * @return
	 */
	public static String String(Integer ... params){
		return new StringProvider(params).generate();
	}

	/**
	 * 日期
	 * @param params
	 * @return
	 */
	public static LocalDate LocalDate(String ... params){
		return new LocalDateProvider(params).generate();
	}

	/**
	 * 时间
	 * @param params
	 * @return
	 */
	public static LocalDateTime LocalDateTime(String ... params){
		return new LocalDateTimeProvider(params).generate();
	}

	/**
	 * 任意对象数据的自动赋值
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T anyObject(Class<T> clazz){
		return new ObjectProvider<T>(clazz).generate();
	}

	/**
	 * 任意 array 对象的自动赋值
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T[] anyArray(Class<T> clazz){
		return (T[]) new ArrayProvider(clazz).generate();
	}

	/**
	 * 任意 list 对象的自动赋值
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> anyList(Class<T> clazz){
		return  new ListProvider(clazz).generate();
	}
}
