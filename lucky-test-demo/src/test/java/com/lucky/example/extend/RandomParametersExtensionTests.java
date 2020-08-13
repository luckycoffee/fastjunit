/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.lucky.example.extend;

import com.lucky.ut.effective.extend.RandomParametersExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.lucky.ut.effective.extend.RandomParametersExtension.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author zhourj
 * 自定义随机参数
 * @see RandomParametersExtension
 */
@ExtendWith(RandomParametersExtension.class)
class RandomParametersExtensionTests {

	@Test
	void injectsInteger(@Random int i, @Random int j) {
		assertNotEquals(i, j);
	}

	@Test
	void injectsDouble(@Random double d) {
		assertEquals(0.0, d, 1.0);
	}

}
