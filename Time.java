package com.jnzyjsxy.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	public String Time() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
        //System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		return df.format(new Date());	
	}
}
