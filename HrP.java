package com.jnzyjsxy.test;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;

/*
 * 人事管理运行主类
 */
public class HrP {
	//定义布尔型变量
	boolean packFame=false;
	//构造方法
	public HrP() {
		// TODO Auto-generated constructor stub
		//创建主窗体类对象
		HrMain frame=new HrMain();
		if (packFame) {
			//窗口自适应大小 使窗口正好显示里面的控件
			frame.pack();
		}else {
			//使用validate方法 会使容器再次布置其子控件
			frame.validate();
		}
		//获取屏幕大小
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		//获取当前项目的窗体大小
		Dimension frameSize=frame.getSize();
		//如果项目窗体高>屏幕高，用屏幕高设置项目窗体高
		if (frameSize.height>screenSize.height) {
			frameSize.height=screenSize.height;
		}
		if (frameSize.width>screenSize.width) {
			frameSize.width=screenSize.width;
		}
		//设置窗体起始显示位置 居中显示
		frame.setLocation((screenSize.width-frameSize.width)/2,
		(screenSize.height-frameSize.height)/2);
		//显示窗体
		frame.setVisible(true);
		try {
			//UIManager--界面管理类
			//外观设置成所使用的操作平台的外观
			//即程序在哪个平台运行，显示的窗口，对话框将是哪个平台的外观
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}