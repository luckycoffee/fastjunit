package com.lucky.ut.effective.data.category;

import com.lucky.ut.effective.utils.RandomUtils;

/**
 * @author zhourj
 * @date 2020/9/18 10:58
 */
public class IntegerProvider implements Provider<Integer> {
	private Integer startRange;
	private Integer endRange;

	public IntegerProvider(Integer ... params){
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
	public Integer generate() {
		return RandomUtils.nextInt(startRange, endRange);
	}
}
