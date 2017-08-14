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
static //������������ֶ���
GridBagLayout girdBag=new GridBagLayout();
//���������Լ�������
GridBagConstraints girdBagCon;
Image icon;
public login(){
super("��½����");
//lblTitle=new Label("�����������û���Ϣ:");
lblName=new Label("�û���:");
txtName=new TextField(15);
txtName.setFont(new Font("Dialog", 0, 15));
lblPassword=new Label("����:");
txtPassword=new TextField(15);
txtPassword.setFont(new Font("Dialog", 0, 15));
txtPassword.setEchoChar('*');
btnSubmit=new Button("�ύ");
btnReset=new Button("����");
//lblName.setText("�û���");


lblName.setFont(new Font("Dialog", 0, 16));
girdBagCon=new GridBagConstraints();
girdBagCon.gridx=0;
girdBagCon.gridy=1;
//�ⲿ��� 4������ top,left,bottom,right
//���ⲿ���
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
//�ⲿ��� 4������ top,left,bottom,right
//���ⲿ���
girdBagCon.insets=new Insets(0, 15, 10, 1);
girdBag.setConstraints(lblPassword, girdBagCon);
this.add(lblPassword);

girdBagCon=new GridBagConstraints();
girdBagCon.gridx=1;
girdBagCon.gridy=2;
girdBagCon.insets=new Insets(0, 1, 10, 15);
girdBag.setConstraints(txtPassword, girdBagCon);
this.add(txtPassword);

//addInfo.setText("����");
btnSubmit.setFont(new Font("Dialog", 0, 16));
girdBagCon=new GridBagConstraints();
girdBagCon.gridx=0;
girdBagCon.gridy=3;
girdBagCon.gridwidth=2;
girdBagCon.gridheight=1;
//�ⲿ��� 4������ top,left,bottom,right
//���ⲿ���
girdBagCon.insets=new Insets(10, 10, 10, 90);
girdBag.setConstraints(btnSubmit, girdBagCon);
this.add(btnSubmit);



//clearInfo.setText("���");
btnReset.setFont(new Font("Dialog", 0, 16));
girdBagCon=new GridBagConstraints();
girdBagCon.gridx=1;
girdBagCon.gridy=3;
girdBagCon.gridwidth=2;
girdBagCon.gridheight=1;
//�ⲿ��� 4������ top,left,bottom,right
//���ⲿ���
girdBagCon.insets=new Insets(10, 10, 10, -30);
girdBag.setConstraints(btnReset, girdBagCon);
this.add(btnReset);


icon=getImage("icon.png");
//���ô���ͼ��
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
if(s.equals("����")){
clear();
}else if(s.equals("�ύ")){
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
if(n.equals("����") && paw.equals("2500918234")){
	
JOptionPane.showMessageDialog(this,"�Ϸ��û�����ӭ���뱾ϵͳ");
this.setVisible(false);
	HrP hrP=new HrP();
	
	}else{
		JOptionPane.showMessageDialog(this, "�Ƿ��û�����ֹ���뱾ϵͳ");
		System.exit(0);
	}
}

//ͼ����
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
		//UIManager--���������
		//������ó���ʹ�õĲ���ƽ̨�����
		//���������ĸ�ƽ̨���У���ʾ�Ĵ��ڣ��Ի������ĸ�ƽ̨�����
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		login ttf=new login();
		ttf.setSize(300,200);
		//��ȡ��Ļ��С
				Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
				//��ȡ��ǰ��Ŀ�Ĵ����С
				Dimension frameSize=ttf.getSize();
				//�����Ŀ�����>��Ļ�ߣ�����Ļ��������Ŀ�����
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
	//����������������Ŀ




}



}