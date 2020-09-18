package com.lucky.ut.effective.data.category;

import com.lucky.ut.effective.data.ProviderConfig;

/**
 * @author zhourj
 * @date 2020/9/18 11:02
 */
public interface Provider<T> {
	ProviderConfig providerConfig = new ProviderConfig();
	/**
	 * 生成数据
	 * @return
	 */
	T generate();
}
