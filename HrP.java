package com.jnzyjsxy.test;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;

/*
 * ���¹�����������
 */
public class HrP {
	//���岼���ͱ���
	boolean packFame=false;
	//���췽��
	public HrP() {
		// TODO Auto-generated constructor stub
		//���������������
		HrMain frame=new HrMain();
		if (packFame) {
			//��������Ӧ��С ʹ����������ʾ����Ŀؼ�
			frame.pack();
		}else {
			//ʹ��validate���� ��ʹ�����ٴβ������ӿؼ�
			frame.validate();
		}
		//��ȡ��Ļ��С
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		//��ȡ��ǰ��Ŀ�Ĵ����С
		Dimension frameSize=frame.getSize();
		//�����Ŀ�����>��Ļ�ߣ�����Ļ��������Ŀ�����
		if (frameSize.height>screenSize.height) {
			frameSize.height=screenSize.height;
		}
		if (frameSize.width>screenSize.width) {
			frameSize.width=screenSize.width;
		}
		//���ô�����ʼ��ʾλ�� ������ʾ
		frame.setLocation((screenSize.width-frameSize.width)/2,
		(screenSize.height-frameSize.height)/2);
		//��ʾ����
		frame.setVisible(true);
		try {
			//UIManager--���������
			//������ó���ʹ�õĲ���ƽ̨�����
			//���������ĸ�ƽ̨���У���ʾ�Ĵ��ڣ��Ի������ĸ�ƽ̨�����
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}