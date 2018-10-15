package com.datahub.tests;


import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Test;

import com.datahub.commons.utils.CharsetUtil;
import com.datahub.commons.utils.MD5Util;

public class TestCases {
    
	@Test
    public void test01() throws Exception {
		Charset code = CharsetUtil.getUTF8();
		Assert.assertEquals("UTF-8", code.name());
    }
	
	@Test
    public void test02() {
		System.out.println(MD5Util.encode("admin123"));
	}

}
