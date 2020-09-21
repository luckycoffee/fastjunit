package com.lucky.ut.effective.data.category;

import com.lucky.ut.effective.utils.RandomUtils;

/**
 * @author zhourj
 * @date 2020/9/18 10:58
 */
public class FloatProvider implements Provider<Float> {
	private Integer startRange;
	private Integer endRange;

	public FloatProvider(Integer ... params){
		if(params.length >= 2){
			startRange = params[0];
			endRange = params[1];
		}else if(params.length==1){
			startRange = params[0];
			endRange = providerConfig.intRange()[1];
		}else {
			startRange = providerConfig.intRange()[0];
			endRange = providerConfig.intRange()[1];
		}
	}
	@Override
	public Float generate() {
		return RandomUtils.nextFloat(startRange, endRange);
	}
}
