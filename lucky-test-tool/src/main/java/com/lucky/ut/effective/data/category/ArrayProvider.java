package com.lucky.ut.effective.data.category;

import com.lucky.ut.effective.data.ProviderConfig;
import com.lucky.ut.effective.utils.RandomUtils;
import org.testng.collections.Lists;

import java.lang.reflect.Array;

/**
 * @author zhourj
 * @date 2020/9/18 13:52
 */
public class ArrayProvider<T>{
	Class<T> clazz;
	ProviderConfig providerConfig;
	public ArrayProvider(Class<T> clazz){
		this.clazz = clazz;
		providerConfig = new ProviderConfig();
	}

	public Object generate() {
		int size = RandomUtils.nextSize(providerConfig.sizeRange()[0], providerConfig.sizeRange()[1]);
		String className = clazz.getName().replaceAll("\\[L","").replaceAll(";","");
		Object result = null;
		try {
			result = Array.newInstance(Class.forName(className), size);

			Lists.newArrayList();
			for (int index = 0; index < size; index++) {
				Array.set(result, index, new ObjectProvider<>(Class.forName(className)).generate());
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}
}
