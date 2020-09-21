package com.lucky.ut.effective.data.category;


import com.lucky.ut.effective.utils.RandomUtils;

/**
 * @author zhourj
 * @date 2020/9/21 10:05
 */
public class EnumProvider<T extends Enum>  implements Provider {
	Class<T> clazz;
	public EnumProvider(Class<T> clazz){
		this.clazz = clazz;
	}
	@Override
	public Object generate() {
		Enum[] enums = providerConfig.getcacheEnum(clazz.getName());
		if(enums == null){
			enums = clazz.getEnumConstants();
			providerConfig.cacheEnum(clazz.getName(),enums);
		}
		return (T)enums[RandomUtils.nextInt(0, enums.length)];
	}
}
