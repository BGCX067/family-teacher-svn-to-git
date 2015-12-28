package com.familyedu.net;

/**
 * 结果类
 *
 */
public class ResultObject {
	
	/**true:表示正确码false:表示错误的错误码*/
	public boolean result = false;

	/**如果result为true, 则obj表示正确返回结果的对象，否则表示错误码的描述，类型为String*/
	public Object obj = "";
}
