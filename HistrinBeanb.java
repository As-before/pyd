package com.jnzyjsxy.common;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class HistrinBeanb {
	//�����ַ������ڴ洢sql�ַ���
		String sql;
		//�������
		ResultSet rs=null;
		//�����ַ������� �洢�Ӳ������洫��������Ա��Ϣ
		String field1;
		String field2;
		String field3;
		String field4;
		String field5;
		String field6;
		String field7;
		
		public void add(String f2,String f3,String f4,String f5,
				String f6,String f7){
			//�������ݿ���� ִ�����ݿ�����ķ��� �������ݿ� ִ��sql���
			Database DB=new Database();
			//������ӽ��洫������ֵ ������Ա����
			//this.field1=f1;
			this.field2=f2;
			this.field3=f3;
			this.field4=f4;
			this.field5=f5;
			this.field6=f6;
			this.field7=f7;
			//�жϴ�������ֵ�Ƿ�Ϊ�� ���Ϊ�վ���ʾ��ʾ���
			if (field2==null || field2.equals("")) {
				JOptionPane.showMessageDialog(null, "������FromAcc", "����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (field3==null||field3.equals("")) {
				JOptionPane.showMessageDialog(null,"������OldInfo","����",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (field4==null||field4.equals("")) {
				JOptionPane.showMessageDialog(null,"������NewInfo","����",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (field5==null||field5.equals("")) {
				JOptionPane.showMessageDialog(null,"������ChgTime","����",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (field6==null||field6.equals("")) {
				JOptionPane.showMessageDialog(null,"������RegDate","����",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (field7==null||field7.equals("")) {
				JOptionPane.showMessageDialog(null,"������PersonID","����",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			//���������ַ���
			//����sql�ַ���ʱ��ע���ַ��ͣ������õ��������������int,float���ö����
			//���ݹ������������ַ��ͣ� 
			//Ϊ�˲���int���ݣ���������ת��-Integer.parseInt(field1)
			else {
				sql="insert into Histrjnb(JourNo,FromAcc,OldInfo,NewInfo,ChgTime,RegDate,PersonID) values("+getId()+ ",'"+field2+"','"+field3+"','"+field4+"',"+Integer.parseInt(field5)+",'"+field6+"',"+Integer.parseInt(field7)+")";
				System.out.println(sql);	
				//�����ݿ�����
				try {
					DB.openConn();
					//ִ��sql���
					DB.executeUpdate(sql);
					//��ʾ��Ϣ
					JOptionPane.showMessageDialog(null, "��¼�ɹ�");
				} catch (Exception e) {
					// TODO: handle exception
					//�����쳣 ��������ʾ
					System.out.println(e);
					JOptionPane.showMessageDialog(null, "��¼ʧ�� ","����", JOptionPane.ERROR_MESSAGE);
				}
					//�ر�����������Ӷ���
					finally{
						DB.closeStmt();
						DB.closeConn();
					}
				}
		}
			/*
			 * ����JourNo
			 * ��������Ա��Ϣ����ֵ��ɵ��ַ�����
			 */
			public String[] search(String f1) {
				Database DB=new Database();
				this.field1=f1;
				//�����ַ������� ���ڼ�¼��ѯ������
				String[] s =new String[6];
				sql="select * from Histrjnb where JourNo="+field1;
				try{
					DB.openConn();//�������ݿ�
					//ִ�в�ѯ����ѯ�������rs��rsΪ�����
					rs=DB.executeQuery(sql);
					//���rs.nextΪtrue
					if (rs.next()) {
						//��ȡָ����ֵ
						//˵����PersonID'DeptId salary������String����
						//���ڴ˼򻯴�����ȡ��ֵ�����ַ�������ֵ���ַ�����Ԫ��
						//����ͳһ���᷵��ֵ
						s[0]=rs.getString("JourNo");
						s[1]=rs.getString("FromAcc");
						s[2]=rs.getString("OldInfo");
						s[3]=rs.getString("NewInfo");
						s[4]=rs.getString("ChgTime");
						s[5]=rs.getString("RegDate");
						s[6]=rs.getString("PersonID");
					}else {
						s=null;
					}
				}catch(Exception e){
					
				}finally {
						DB.closeStmt();
						DB.closeConn();
					}
				return s;
				}
			/*
			 * ����PersonID
			 * ��������Ա��Ϣ����ֵ��ɵ��ַ�����
			 */
			public String[] searchPI(String f7) {
				Database DB=new Database();
				this.field1=f7;
				//�����ַ������� ���ڼ�¼��ѯ������
				String[] s =new String[6];
				sql="select * from Histrjnb where PersonID="+field7;
				try{
					DB.openConn();//�������ݿ�
					//ִ�в�ѯ����ѯ�������rs��rsΪ�����
					rs=DB.executeQuery(sql);
					//���rs.nextΪtrue
					if (rs.next()) {
						//��ȡָ����ֵ
						//˵����PersonID'DeptId salary������String����
						//���ڴ˼򻯴�����ȡ��ֵ�����ַ�������ֵ���ַ�����Ԫ��
						//����ͳһ���᷵��ֵ
						s[0]=rs.getString("JourNo");
						s[1]=rs.getString("FromAcc");
						s[2]=rs.getString("OldInfo");
						s[3]=rs.getString("NewInfo");
						s[4]=rs.getString("ChgTime");
						s[5]=rs.getString("RegDate");
						s[6]=rs.getString("PersonID");
					}else {
						s=null;
					}
				}catch(Exception e){
					
				}finally {
						DB.closeStmt();
						DB.closeConn();
					}
				return s;
				}
			public boolean isRows(String ID) {
				// TODO Auto-generated method stub
				Database DB=new Database();
				this.field7=ID;
				//�����ַ������� ���ڼ�¼��ѯ������
				//String[] s =new String[6];
				sql="select * from Histrjnb where PersonID="+field7;
				try{
					DB.openConn();//�������ݿ�
					//ִ�в�ѯ����ѯ�������rs��rsΪ�����
					rs=DB.executeQuery(sql);
					//���rs.nextΪtrue
					if (rs.next()) {
						//��ȡָ����ֵ
						//˵����PersonID'DeptId salary������String����
						//���ڴ˼򻯴�����ȡ��ֵ�����ַ�������ֵ���ַ�����Ԫ��
						//����ͳһ���᷵��ֵ
						//s[0]=rs.getString("JourNo");
						//s[1]=rs.getString("FromAcc");
						//s[2]=rs.getString("OldInfo");
						//s[3]=rs.getString("NewInfo");
						//s[4]=rs.getString("ChgTime");
						//s[5]=rs.getString("RegDate");
						//s[6]=rs.getString("PersonID");
						return false;
					}else {
						//s=null;
						return true;
					}
				}catch(Exception e){
					
				}finally {
						DB.closeStmt();
						DB.closeConn();
					}
				return true;
				
			
}
			public int getId() {
				Database DB=new Database();
				int ID=1;
				//��ѯsql����Person���ȡPersonID�е����ֵ
				sql="select max(JourNo) from Histrjnb";
				try {
					DB.openConn();
					rs=DB.executeQuery(sql);
					if (rs.next()) {
						ID=rs.getInt(1)+1;
					}else {
						ID=1;
					}
				} catch (Exception e) {
					// TODO: handle exception
					
				}
				finally {
					DB.closeStmt();
					DB.closeConn();
				}
				return ID;
			}
			public String[][] searchAll() {
				Database DB=new Database();
				//�����ά����
				String[][] sn=null;
				int row=0;//����
				int i=0;//ѭ������
				//��ѯsql�ַ���
				sql="select * from Histrjnb order by JourNo";
				try {
					DB.openConn();
					rs=DB.executeQuery(sql);
						if (rs.last()) {
							row=rs.getRow();//��ȡ�����rs�м�¼����������
						}
						//���row==0˵��rsû�м�¼ ��û�в鵽���������ļ�¼
						if (row==0) {
							//��ʼ����ά����1��6�� ÿ��Ԫ��Ϊ�հ��ַ�
							sn=new String[1][6];
							sn[0][0]="";
							sn[0][1]="";
							sn[0][2]="";
							sn[0][3]="";
							sn[0][4]="";
							sn[0][5]="";
						}
						//����rs������0
						else {
							//��������row ��ʼ����ά����sn
							sn=new String[row][6];
							//��rsָ����һ������
							rs.first();
							//��ָ���ƶ�����һ�� ������һ������¼ָ�뵽��һ������
							//ִ������������ ��¼ָ���ƶ���rs��ͷ����
							//ִ�и������������Ǳ������еļ�¼��������rs.next()����
							rs.previous();
							while (rs.next()) {
								sn[i][0]=rs.getString("JourNo");
								sn[i][1]=rs.getString("OldInfo");
								sn[i][2]=rs.getString("NewInfo");
								sn[i][3]=rs.getString("ChgTime");
								sn[i][4]=rs.getString("RegDate");
								//�������Ų�����DeptBean�Ķ���
								//DeptBean dBean=new DeptBean();
								sn[i][5]=rs.getString("PersonID");
								i++;			
							} 
						}
				}catch (Exception e) {
					// TODO: handle exception
				}finally {
					DB.closeStmt();
					DB.closeConn();
				}
				return sn;	
			}
			
			//������ʷ��ѯ
			public String[][] searchF() {
				Database DB=new Database();
				//�����ά����
				String[][] sn=null;
				int row=0;//����
				int i=0;//ѭ������
				//��ѯsql�ַ���
				sql="select * from Histrjnb order by JourNo";
				try {
					DB.openConn();
					rs=DB.executeQuery(sql);
						if (rs.last()) {
							row=rs.getRow();//��ȡ�����rs�м�¼����������
						}
						//���row==0˵��rsû�м�¼ ��û�в鵽���������ļ�¼
						if (row==0) {
							//��ʼ����ά����1��6�� ÿ��Ԫ��Ϊ�հ��ַ�
							sn=new String[1][6];
							sn[0][0]="";
							sn[0][1]="";
							sn[0][2]="";
							sn[0][3]="";
							sn[0][4]="";
							sn[0][5]="";
						}
						//����rs������0
						else {
							//��������row ��ʼ����ά����sn
							sn=new String[row][6];
							//��rsָ����һ������
							rs.first();
							//��ָ���ƶ�����һ�� ������һ������¼ָ�뵽��һ������
							//ִ������������ ��¼ָ���ƶ���rs��ͷ����
							//ִ�и������������Ǳ������еļ�¼��������rs.next()����
							
							rs.previous();
							//if (rs.getString("FromAcc")=="��Ա����") {
							while (rs.next()) {
									
									sn[i][0]=rs.getString("JourNo");
									sn[i][1]=rs.getString("OldInfo");
									sn[i][2]=rs.getString("NewInfo");
									sn[i][3]=rs.getString("ChgTime");
									sn[i][4]=rs.getString("RegDate");
									sn[i][5]=rs.getString("PersonID");
									i++;	
								//}
								//sn[i][0]=rs.getString("JourNo");
								//sn[i][1]=rs.getString("OldInfo");
								//sn[i][2]=rs.getString("NewInfo");
								//sn[i][3]=rs.getString("ChgTime");
								//sn[i][4]=rs.getString("RegDate");
								//�������Ų�����DeptBean�Ķ���
								//DeptBean dBean=new DeptBean();
								//sn[i][5]=rs.getString("PersonID");
								//i++;		
									
							} 
						}
				}catch (Exception e) {
					// TODO: handle exception
				}finally {
					DB.closeStmt();
					DB.closeConn();
				}
				return sn;	
			}
}

		

