package com.example.CallBack;

public class Li {

	/**
	 * ִ��С���ʵ�����
	 * @param CallBack
	 * @param question
	 */
	public void excuteMessage(CallBack wang, String question) {

		System.out.println("С���ʵ�������" + question);

		//С�����������
		System.out.println("С�����������");

		//С���Ȼ�뵽��С���ʵĴ�
		String result = "2";

		//����С���еĻص����� sovle() ֪ͨ����
		wang.sovle(result);

	}


}
