package com.example.CallBack;

public class Li {

	/**
	 * 执行小王问的问题
	 * @param CallBack
	 * @param question
	 */
	public void excuteMessage(CallBack wang, String question) {

		System.out.println("小王问的问题是" + question);

		//小李做别的事情
		System.out.println("小李做别的事情");

		//小李忽然想到了小王问的答案
		String result = "2";

		//调用小王中的回调方法 sovle() 通知他答案
		wang.sovle(result);

	}


}
