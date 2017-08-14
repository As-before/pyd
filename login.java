package com.jnzyjsxy.test;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
public class login extends Frame implements ActionListener {
TextField txtName;
TextField txtPassword;
Label lblTitle,lblName,lblPassword;
Button btnSubmit;
Button btnReset;

JButton clearInfo=new JButton();
static //创建网格包布局对象
GridBagLayout girdBag=new GridBagLayout();
//创建网格包约束类变量
GridBagConstraints girdBagCon;
Image icon;
public login(){
super("登陆界面");
//lblTitle=new Label("请输入您的用户信息:");
lblName=new Label("用户名:");
txtName=new TextField(15);
txtName.setFont(new Font("Dialog", 0, 15));
lblPassword=new Label("密码:");
txtPassword=new TextField(15);
txtPassword.setFont(new Font("Dialog", 0, 15));
txtPassword.setEchoChar('*');
btnSubmit=new Button("提交");
btnReset=new Button("重置");
//lblName.setText("用户名");


lblName.setFont(new Font("Dialog", 0, 16));
girdBagCon=new GridBagConstraints();
girdBagCon.gridx=0;
girdBagCon.gridy=1;
//外部填充 4个参数 top,left,bottom,right
//既外部间距
girdBagCon.insets=new Insets(0, 10, 10, 1);
girdBag.setConstraints(lblName, girdBagCon);
this.add(lblName);

girdBagCon=new GridBagConstraints();
girdBagCon.gridx=1;
girdBagCon.gridy=1;
girdBagCon.insets=new Insets(0, 1, 10, 15);
girdBag.setConstraints(txtName, girdBagCon);
this.add(txtName);

//lblPassword.setText("");
lblPassword.setFont(new Font("Dialog", 0, 16));
girdBagCon=new GridBagConstraints();
girdBagCon.gridx=0;
girdBagCon.gridy=2;
//外部填充 4个参数 top,left,bottom,right
//既外部间距
girdBagCon.insets=new Insets(0, 15, 10, 1);
girdBag.setConstraints(lblPassword, girdBagCon);
this.add(lblPassword);

girdBagCon=new GridBagConstraints();
girdBagCon.gridx=1;
girdBagCon.gridy=2;
girdBagCon.insets=new Insets(0, 1, 10, 15);
girdBag.setConstraints(txtPassword, girdBagCon);
this.add(txtPassword);

//addInfo.setText("增加");
btnSubmit.setFont(new Font("Dialog", 0, 16));
girdBagCon=new GridBagConstraints();
girdBagCon.gridx=0;
girdBagCon.gridy=3;
girdBagCon.gridwidth=2;
girdBagCon.gridheight=1;
//外部填充 4个参数 top,left,bottom,right
//既外部间距
girdBagCon.insets=new Insets(10, 10, 10, 90);
girdBag.setConstraints(btnSubmit, girdBagCon);
this.add(btnSubmit);



//clearInfo.setText("清空");
btnReset.setFont(new Font("Dialog", 0, 16));
girdBagCon=new GridBagConstraints();
girdBagCon.gridx=1;
girdBagCon.gridy=3;
girdBagCon.gridwidth=2;
girdBagCon.gridheight=1;
//外部填充 4个参数 top,left,bottom,right
//既外部间距
girdBagCon.insets=new Insets(10, 10, 10, -30);
girdBag.setConstraints(btnReset, girdBagCon);
this.add(btnReset);


icon=getImage("icon.png");
//设置窗体图标
this.setIconImage(icon);


this.btnSubmit.addActionListener(this);
this.btnReset.addActionListener(this);
addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e) {
System.exit(0);
}
});
}
 
public void actionPerformed(ActionEvent e){
String s=e.getActionCommand();
if(s.equals("重置")){
clear();
}else if(s.equals("提交")){
submit();
}else if(e.getSource()==txtName){
txtPassword.requestFocus();
}else if(e.getSource()==txtPassword){
submit();
}
}
public void clear(){
txtName.setText("");
txtPassword.setText("");
txtName.requestFocus();
	}
public void submit(){
String n=txtName.getText();
String paw=txtPassword.getText();
if(n.equals("庞玉栋") && paw.equals("2500918234")){
	
JOptionPane.showMessageDialog(this,"合法用户，欢迎进入本系统");
this.setVisible(false);
	HrP hrP=new HrP();
	
	}else{
		JOptionPane.showMessageDialog(this, "非法用户，禁止进入本系统");
		System.exit(0);
	}
}

//图像定义
Image getImage(String filename) {
	URLClassLoader urlLoader=(URLClassLoader) this.getClass().getClassLoader(); 
	URL  url=null;   
	Image image=null;
	url=urlLoader.findResource(filename); 
	image=Toolkit.getDefaultToolkit().getImage(url); 
	MediaTracker mediaTracker=new MediaTracker(this); 
	 try { 
		 mediaTracker.addImage(image, 0); 
		 mediaTracker.waitForID(0); 
	 }catch (InterruptedException _ex){
		 image=null;
	 }
	 if (mediaTracker.isErrorID(0)) {
		 image=null;
	 }
	 return image;
}

public static void main(String[] args) {
	try {
		//UIManager--界面管理类
		//外观设置成所使用的操作平台的外观
		//即程序在哪个平台运行，显示的窗口，对话框将是哪个平台的外观
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		login ttf=new login();
		ttf.setSize(300,200);
		//获取屏幕大小
				Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
				//获取当前项目的窗体大小
				Dimension frameSize=ttf.getSize();
				//如果项目窗体高>屏幕高，用屏幕高设置项目窗体高
				if (frameSize.height>screenSize.height) {
					frameSize.height=screenSize.height;
				}
				if (frameSize.width>screenSize.width) {
					frameSize.width=screenSize.width;
				}
		ttf.setLocation((screenSize.width-frameSize.width)/2,
				(screenSize.height-frameSize.height)/2);;
		ttf.setLayout(girdBag);
		 ttf.setResizable(false);
		ttf.setVisible(true);
		
		
	
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	//创建主类对象测试项目




}



}