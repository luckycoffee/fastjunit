package com.lucky.ut.effective.data.category;

import com.lucky.ut.effective.utils.RandomUtils;

/**
 * @author zhourj
 * @date 2020/9/18 11:28
 */
public class StringProvider implements Provider<String> {
	Integer length;
	public StringProvider(Integer ... params){
		if(params.length>0){
			length = params[0];
		}else {
			length = providerConfig.stringSize();
		}
	}

	@Override
	public String generate() {
		StringBuilder sb = new StringBuilder(length);
		String[] stringSeed = providerConfig.stringSeed();
		for (int i = 0; i < length; i++) {
			sb.append(stringSeed[RandomUtils.nextInt(0, stringSeed.length)]);
		}
		return sb.toString();
	}
}
