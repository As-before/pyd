package com.jnzyjsxy.common;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class DeptBean {
	//�����ַ������ڴ洢sql�ַ���
	String sql;
	//�������
	ResultSet rs=null;
	//�����ַ������� �洢�Ӳ������洫��������Ա��Ϣ
	String field1;
	String field2;
	String field3;
	//�����Ϣ
	public void add(String f1,String f2,String f3) {
		//�������ݿ���� ִ�����ݿ�����ķ��� �������ݿ� ִ��sql���
		Database DB=new Database();
		//������ӽ��洫������ֵ ������Ա����
		this.field1=f1;
		this.field2=f2;
		this.field3=f3;
		if (field2==null || field2.equals("")) {
			JOptionPane.showMessageDialog(null, "��������Ա����һ������", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field3==null||field3.equals("")) {
			JOptionPane.showMessageDialog(null,"��������Ա���ڶ�������","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		//���������ַ���
				//����sql�ַ���ʱ��ע���ַ��ͣ������õ��������������int,float���ö����
				//���ݹ������������ַ��ͣ� 
				//Ϊ�˲���int���ݣ���������ת��-Integer.parseInt(field1) 
				//�ڴ�PersonID��DeptID��Ϊint���ͣ�SqlaryΪfloat���ͣ������ϲ�ͬ 
				else {
					sql="insert into Dept(DeptID,B_Dept,S_Dept) values("+Integer.parseInt(field1)+ ",'"+field2+"','"+field3+"')";
					System.out.println(sql);	
					//�����ݿ�����
					try {
						DB.openConn();
						//ִ��sql���
						DB.executeUpdate(sql);
						//��ʾ��Ϣ
						JOptionPane.showMessageDialog(null, "��ɹ����һ���µļ�¼");
					} catch (Exception e) {
						// TODO: handle exception
						//�����쳣 ��������ʾ
						System.out.println(e);
						JOptionPane.showMessageDialog(null, "����ʧ�� ","����", JOptionPane.ERROR_MESSAGE);
					}
						//�ر�����������Ӷ���
						finally{
							DB.closeStmt();
							DB.closeConn();
					}
			}
	}
	/*
	 * �޸��豸��Ϣ
	 */
	public void modify(String f1,String f2,String f3){
		Database DB=new Database();
		this.field1=f1;
		this.field2=f2;
		this.field3=f3;
		if (field2==null || field2.equals("")) {
			JOptionPane.showMessageDialog(null, "��������Ա����һ������", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field3==null||field3.equals("")) {
			JOptionPane.showMessageDialog(null,"��������Ա���ڶ�������","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		//���������ַ���
		//����sql�ַ���ʱ��ע���ַ��ͣ������õ��������������int,float���ö����
		//���ݹ������������ַ��ͣ� 
		//Ϊ�˲���int���ݣ���������ת��-Integer.parseInt(field1) 
		//�ڴ�PersonID��DeptID��Ϊint���ͣ�SqlaryΪfloat���ͣ������ϲ�ͬ 
		else {
			sql="insert into Dept(DeptID,B_Dept,S_Dept) values("+Integer.parseInt(field1)+ ",'"+field2+"','"+field3+"')";
			System.out.println(sql);	
			//�����ݿ�����
			try {
				DB.openConn();
				//ִ��sql���
				DB.executeUpdate(sql);
				//��ʾ��Ϣ
				JOptionPane.showMessageDialog(null, "��ɹ��޸�һ���µļ�¼");
			} catch (Exception e) {
				// TODO: handle exception
				//�����쳣 ��������ʾ
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "����ʧ�� ","����", JOptionPane.ERROR_MESSAGE);
			}
				//�ر�����������Ӷ���
				finally{
					DB.closeStmt();
					DB.closeConn();
			}
		}
	}
	/*
	 * ɾ����Ϣ ���ݴ�������PersonId ɾ����Ϣ
	 */
	public void delete(String f1) {
		//�������ݿ����
		Database DB=new Database();
		this.field1=f1;//��ȡ���ݹ����Ĳ���
		//����ɾ����Ա���ַ���
		sql="delete from Dept where DeptID="+Integer.parseInt(field1);
		try {
			DB.openConn();
			DB.executeUpdate(sql);
			System.out.println(sql);
			JOptionPane.showMessageDialog(null, "�ɹ�ɾ��һ���µļ�¼");	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "ɾ��ʧ��", "����", JOptionPane.ERROR_MESSAGE);
			
	}
		finally{
			DB.closeStmt();
			DB.closeConn();
		}
	}
	/*
	 * ��Dept���ѯ������Ա��Ϣ��DeptID����ʾ�������� 
	 */
	public String[] searchAllForNode() {
		Database DB=new Database();
		//�����ά����
		String[] sn=null;
		int row=0;//����
		int i=0;//ѭ������
		//��ѯsql�ַ���
		sql="select * from Dept order by DeptID";
		try {
			DB.openConn();
			rs=DB.executeQuery(sql);
				if (rs.last()) {
					row=rs.getRow();//��ȡ�����rs�м�¼����������
				}
				//���row==0˵��rsû�м�¼ ��û�в鵽���������ļ�¼
				if (row==0) {
					//��ʼ����ά����1��6�� ÿ��Ԫ��Ϊ�հ��ַ�
					sn=new String[2];
					sn[0]="";
					sn[0]="";
					sn[0]="";
				}
				//����rs������0
				else {
					//��������row ��ʼ����ά����sn
					sn=new String[row];
					//��rsָ����һ������
					rs.first();
					//��ָ���ƶ�����һ�� ������һ������¼ָ�뵽��һ������
					//ִ������������ ��¼ָ���ƶ���rs��ͷ����
					//ִ�и������������Ǳ������еļ�¼��������rs.next()����
					rs.previous();
					while (rs.next()) {
						//sn[i][0]=rs.getString("DeptID");
						sn[i]=rs.getString("DeptID")+"-"+rs.getString("B_Dept")+"-"+rs.getString("S_Dept");
						//sn[i]=rs.getString("S_Dept");
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
	public String[][] searchAll() {
		Database DB=new Database();
		//�����ά����
		String[][] sn=null;
		int row=0;//����
		int i=0;//ѭ������
		//��ѯsql�ַ���
		sql="select * from Dept order by DeptID";
		try {
			DB.openConn();
			rs=DB.executeQuery(sql);
				if (rs.last()) {
					row=rs.getRow();//��ȡ�����rs�м�¼����������
				}
				//���row==0˵��rsû�м�¼ ��û�в鵽���������ļ�¼
				if (row==0) {
					//��ʼ����ά����1��6�� ÿ��Ԫ��Ϊ�հ��ַ�
					sn=new String[1][2];
					sn[0][0]="";
					sn[0][1]="";
					sn[0][2]="";
				}
				//����rs������0
				else {
					//��������row ��ʼ����ά����sn
					sn=new String[row][2];
					//��rsָ����һ������
					rs.first();
					//��ָ���ƶ�����һ�� ������һ������¼ָ�뵽��һ������
					//ִ������������ ��¼ָ���ƶ���rs��ͷ����
					//ִ�и������������Ǳ������еļ�¼��������rs.next()����
					rs.previous();
					while (rs.next()) {
						sn[i][0]=rs.getString("DeptID");
						sn[i][1]=rs.getString("B_Dept");
						sn[i][2]=rs.getString("S_Dept");
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
	/*
	 * ����µ�Deptֵ
	 */
	public int getId() {
		Database DB=new Database();
		int ID=1;
		//��ѯsql����Person���ȡPersonID�е����ֵ
		sql="select max(DeptID) from Dept";
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
	/*
	 * ����DeptID��ѯ��Ա��Ϣ��������Ա��Ϣ����ֵ��ɵ��ַ�����
	 */
	public String[] search(String f1) {
		Database DB=new Database();
		this.field1=f1;
		//�����ַ������� ���ڼ�¼��ѯ������
		String[] s =new String[10];
		sql="select * from Dept where DeptID="+field1;
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
				s[0]=rs.getString("DeptID");
				s[1]=rs.getString("B_Dept");
				s[2]=rs.getString("S_Dept");
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
	 * ���ݴ��ݹ�����ID ����һ�����š���������
	 */
	public String getDepstr(String string) {
		// TODO Auto-generated method stub
		Database DB=new Database();
		this.field1=string;
		//�����ַ������� ���ڼ�¼��ѯ������
		String s = null;
		sql="select * from Dept where DeptID="+field1;
		System.out.println(sql);
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
				s=rs.getString("DeptID")+"-"+rs.getString("B_Dept")+"-"+rs.getString("S_Dept"); 	
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
	
}
