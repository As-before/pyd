package com.jnzyjsxy.common;

import java.sql.ResultSet;

import javax.sound.midi.VoiceStatus;
import javax.swing.JOptionPane;

import org.omg.CORBA.PUBLIC_MEMBER;
/*
 * �й���Ա��Ϣ���ݿ��������
 */
public class PersonBean {
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
	String field8;
	String field9;
	String field10;
	
	String colname;//����
	String colvalue1;//��ֵ1
	String colvalue2;//��ֵ2
	
	/*
	 * �����Ϣ
	 */
	public void add(String f1,String f2,String f3,String f4,String f5,
			String f6,String f7,String f8,String f9,String f10) {
		//�������ݿ���� ִ�����ݿ�����ķ��� �������ݿ� ִ��sql���
		Database DB=new Database();
		//������ӽ��洫������ֵ ������Ա����
		this.field1=f1;
		this.field2=f2;
		this.field3=f3;
		this.field4=f4;
		this.field5=f5;
		this.field6=f6;
		this.field7=f7;
		this.field8=f8;
		this.field9=f9;
		this.field10=f10;
		//�жϴ�������ֵ�Ƿ�Ϊ�� ���Ϊ�վ���ʾ��ʾ���
		if (field2==null || field2.equals("")) {
			JOptionPane.showMessageDialog(null, "��������Ա����", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field3==null||field3.equals("")) {
			JOptionPane.showMessageDialog(null,"�������Ա�","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field4==null||field4.equals("")) {
			JOptionPane.showMessageDialog(null,"�������������","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field5==null||field5.equals("")) {
			JOptionPane.showMessageDialog(null,"����������","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field6==null||field6.equals("")) {
			JOptionPane.showMessageDialog(null,"�������ַ","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field7==null||field7.equals("")) {
			JOptionPane.showMessageDialog(null,"�����벿��","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field8==null||field8.equals("")) {
			JOptionPane.showMessageDialog(null,"������н��","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		//���������ַ���
		//����sql�ַ���ʱ��ע���ַ��ͣ������õ��������������int,float���ö����
		//���ݹ������������ַ��ͣ� 
		//Ϊ�˲���int���ݣ���������ת��-Integer.parseInt(field1) 
		//�ڴ�PersonID��DeptID��Ϊint���ͣ�SqlaryΪfloat���ͣ������ϲ�ͬ 
		else {
			sql="insert into Person(PersonID,Name,Sex,Birth,Nat,Address,DeptID,Salary,Assess,Other) values("+Integer.parseInt(field1)+ ",'"+field2+"','"+field3+"','"+field4+"','"+field5+"','"+field6+"',"+Integer.parseInt(field7)+","+Float.parseFloat(field8)+",'"+field9+"','"+field10+"')";
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
	public void modify(String f1,String f2,String f3,String f4,String f5,
			String f6,String f7,String f8,String f9,String f10) {
		Database DB=new Database();
		this.field1=f1;
		this.field2=f2;
		this.field3=f3;
		this.field4=f4;
		this.field5=f5;
		this.field6=f6;
		this.field7=f7;
		this.field8=f8;
		this.field9=f9;
		this.field10=f10;
		if (field2==null || field2.equals("")) {
			JOptionPane.showMessageDialog(null, "��������Ա����", "����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field3==null||field3.equals("")) {
			JOptionPane.showMessageDialog(null,"�������Ա�","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field4==null||field4.equals("")) {
			JOptionPane.showMessageDialog(null,"�������������","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field5==null||field5.equals("")) {
			JOptionPane.showMessageDialog(null,"����������","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field6==null||field6.equals("")) {
			JOptionPane.showMessageDialog(null,"�������ַ","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field7==null||field7.equals("")) {
			JOptionPane.showMessageDialog(null,"�����벿��","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field8==null||field8.equals("")) {
			JOptionPane.showMessageDialog(null,"������н��","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		//���������ַ���
		//����sql�ַ���ʱ��ע���ַ��ͣ������õ��������������int,float���ö����
		//���ݹ������������ַ��ͣ� 
		//Ϊ�˲���int���ݣ���������ת��-Integer.parseInt(field1) 
		//�ڴ�PersonID��DeptID��Ϊint���ͣ�SqlaryΪfloat���ͣ������ϲ�ͬ 
		else {
			sql="update Person set Name ='"+field2+"',Sex ='"+field3      +"',Birth ='"+field4+"',Nat ='"+field5      +"',Address='"+field6 +"',DeptID =" +Integer.parseInt(field7)      +",Salary ="+Float.parseFloat(field8) +",Assess ='"+field9      +"',Other ='"+field10       +"'  where PersonID="+Integer.parseInt(field1); 
			System.out.println(sql);	
			//�����ݿ�����
			try {
				DB.openConn();
				//ִ��sql���
				DB.executeUpdate(sql);
				//��ʾ��Ϣ
				JOptionPane.showMessageDialog(null, "��ɹ��޸�һ���µļ�¼��");
			} catch (Exception e) {
				// TODO: handle exception
				//�����쳣 ��������ʾ
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "����ʧ�� ","����", JOptionPane.ERROR_MESSAGE);
			}
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
		sql="delete from Person where PersonID="+Integer.parseInt(field1);
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
	 * ����PersonID��ѯ��Ա��Ϣ��������Ա��Ϣ����ֵ��ɵ��ַ�����
	 */
	public String[] search(String f1) {
		Database DB=new Database();
		this.field1=f1;
		//�����ַ������� ���ڼ�¼��ѯ������
		String[] s =new String[10];
		sql="select * from Person where PersonID="+field1;
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
				s[0]=rs.getString("PersonID");
				s[1]=rs.getString("Name");
				s[2]=rs.getString("Sex");
				s[3]=rs.getString("Birth");
				s[4]=rs.getString("Nat");
				s[5]=rs.getString("Address");
				s[6]=rs.getString("DeptID");
				s[7]=rs.getString("Salary");
				s[8]=rs.getString("Assess");
				s[9]=rs.getString("Other");
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
	 * ����PersonID��ѯ��Ա���ˣ�������Ա��Ϣ����ֵ��ɵ��ַ�����
	 */
	public String searchAssess(String f1) {
		Database DB=new Database();
		this.field1=f1;
		//�����ַ������� ���ڼ�¼��ѯ������
		String s=null;
		sql="select Assess from Person where PersonID="+field1;
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
				s=rs.getString("Assess");
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
	 * ����PersonID��ѯ��Ա���ˣ�������Ա��Ϣ����ֵ��ɵ��ַ�����
	 */
	public String searchS(String f1) {
		Database DB=new Database();
		this.field1=f1;
		//�����ַ������� ���ڼ�¼��ѯ������
		String s=null;
		sql="select Salary from Person where PersonID="+field1;
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
				s=rs.getString("Salary");
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
		 * ��Ա��Ϣ�ۺϲ�ѯ
		 * ��PersonID��Dept���ѯ����Where DeptID=Person.DeptID���ű����ȵļ�¼
		 */
	public String[][] searchAllForNode() {
		//��ʼ�����ݿ�
		Database DB=new Database();
		//������ά���� �洢���ҵ��ķ���������¼�Ŀ���ֵ
		//���ڷ��������ļ�¼�����ж��У�������Ҫ��ά����
		String[][] sn =null;
		int row=0;//�洢����
		int i=0;//ѭ������
		//�������ϲ�ѯ��� ��ѯ����where DeptID=Person.DeptID
		//��Person��Dept���ѯWhere Dept.DeptID=Person.DeptID ������ָ���ֶ�
		sql="select PersonID,Name,Sex,Dept.DeptID as DeptID,B_Dept,S_Dept, Salary,Assess  from  Dept,Person  where Dept.DeptID=Person.DeptID  order by PersonID";   
		try {
			DB.openConn();
			// TODO: handle exception
			//ִ�в�ѯ
			rs=DB.executeQuery(sql);
			//rs.last()--����¼ָ���ƶ�������¼�ϣ��÷�������Ϊboolean
			//���ָ��λ����Чλ,�򷵻�true;���������в������κ���,�򷵻�false
			//�����rs���м�¼
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
				//���������һ������ ����true ִ��ѭ��
				//���û��ִ��re.previons()��� ��ִ��rs.next��������һ���¼���Թ��ˡ�
				while (rs.next()) {
					sn[i][0]=rs.getString("PersonID");
					sn[i][1]=rs.getString("Name");
					sn[i][2]=rs.getString("Sex");
					//һ������-�������ţ��洢��sn[i][3]Ԫ����
					sn[i][3]=rs.getString("B_Dept")+"-"+rs.getString("s_Dept");
					sn[i][4]=rs.getString("Salary");
					sn[i][5]=rs.getString("Assess");
					i++;
				}
				
			}
		}catch (Exception e) {

		}finally{
			DB.closeStmt();
			DB.closeConn();
		}
		return sn;
	}
	/*
	 * ��ѯ����ID
	 * 
	 */
public String[] searchAllID() {
	//��ʼ�����ݿ�
	Database DB=new Database();
	//������ά���� �洢���ҵ��ķ���������¼�Ŀ���ֵ
	//���ڷ��������ļ�¼�����ж��У�������Ҫ��ά����
	String[] sn =null;
	int row=0;//�洢����
	int i=0;//ѭ������
	//�������ϲ�ѯ��� ��ѯ����where DeptID=Person.DeptID
	//��Person��Dept���ѯWhere Dept.DeptID=Person.DeptID ������ָ���ֶ�
	sql="select * from Person order by PersonID";
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
					sn[i]=rs.getString("PersonID");
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
	/*
	 * �޸�Person���� ָ���û��Ĳ�����Ϣ�����޸�Person���е�DeptID�ֶ�ֵ
	 */
	public void updateDept(String f1,String f7) {
		Database DB=new Database();
		this.field1=f1;//PersonID
		this.field7=f7;//Dept �����ֶ�
		//HistrinBean histrinBean=new HistrinBean();
		//histrinBean.add("��Ա����", f3, f4, f5, f6, f7);
		sql="update Person set DeptID =" +Float.parseFloat(field7)+" where PersonID ="+Integer.parseInt(field1);
		try {
			DB.openConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "���Ÿ��ĳɹ�");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "����ʧ��", "ʧ��",JOptionPane.ERROR_MESSAGE);
		}
	}
	/*
	 * �޸�Person���� ָ���û���н����Ϣ�����޸�Person���е�DeptID�ֶ�ֵ
	 */
	public void updateDept1(String f1,String f8) {
		Database DB=new Database();
		this.field1=f1;//PersonID
		this.field8=f8;//salary н���ֶ�
		sql="update Person set Salary =" +Float.parseFloat(field8)+" where PersonID ="+Integer.parseInt(field1);
		try {
			DB.openConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "���ʸ��ĳɹ�");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "����ʧ��", "ʧ��",JOptionPane.ERROR_MESSAGE);
		}
	}
	/*
	 * �޸�Person����ָ��������Ϣ ���޸�Person����Assess�ֶ�ֵ
	 */
	public void updateAssess(String f1,String f9) {
	Database DB=new Database();
	this.field1=f1;
	this.field9=f9;//�����ֶ�
	sql="update Person set Assess = '"+field9 +"' where PersonID ="+Integer.parseInt(field1);
	try{
		DB.openConn();
		DB.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "��Ա���˳ɹ�");
	}catch(Exception e){
		System.out.println(e);
		JOptionPane.showMessageDialog(null, "����ʧ��", "ʧ��",
				JOptionPane.ERROR_MESSAGE);
	}
	}

		

	/*
	 * ��Person���ѯ���е���Ա��Ϣ DeptID����ʾ��������
	 */
	public String[][] searchAll() {
		Database DB=new Database();
		//�����ά����
		String[][] sn=null;
		int row=0;//����
		int i=0;//ѭ������
		//��ѯsql�ַ���
		sql="select * from Person order by PersonID";
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
						sn[i][0]=rs.getString("PersonID");
						sn[i][1]=rs.getString("Name");
						sn[i][2]=rs.getString("Birth");
						sn[i][3]=rs.getString("Nat");
						sn[i][4]=rs.getString("Address");
						//�������Ų�����DeptBean�Ķ���
						DeptBean dBean=new DeptBean();
						sn[i][5]=dBean.getDepstr(rs.getString("DeptID"));
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
	
	//н��
	public String[][] searchS() {
		Database DB=new Database();
		//�����ά����
		String[][] sn=null;
		int row=0;//����
		int i=0;//ѭ������
		//��ѯsql�ַ���
		sql="select * from Person order by PersonID";
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
						sn[i][0]=rs.getString("PersonID");
						sn[i][1]=rs.getString("Name");
						sn[i][2]=rs.getString("Birth");
						sn[i][3]=rs.getString("Nat");
						sn[i][4]=rs.getString("Address");
						//�������Ų�����DeptBean�Ķ���
						//DeptBean dBean=new DeptBean();
						sn[i][5]=rs.getString("Salary");
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
	//����
		public String[][] searchA() {
			Database DB=new Database();
			//�����ά����
			String[][] sn=null;
			int row=0;//����
			int i=0;//ѭ������
			//��ѯsql�ַ���
			sql="select * from Person order by PersonID";
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
							sn[i][0]=rs.getString("PersonID");
							sn[i][1]=rs.getString("Name");
							sn[i][2]=rs.getString("Birth");
							sn[i][3]=rs.getString("Nat");
							sn[i][4]=rs.getString("Address");
							//�������Ų�����DeptBean�Ķ���
							//DeptBean dBean=new DeptBean();
							sn[i][5]=rs.getString("Assess");
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
	 * ����µ�Personֵ
	 */
	public int getId() {
		Database DB=new Database();
		int ID=1;
		//��ѯsql����Person���ȡPersonID�е����ֵ
		sql="select max(PersonID) from Person";
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
	 * ���DeptID
	 */
	public String getDeptId(String f1) {
		Database DB=new Database();
		//���ݴ��ݹ�����PersonID ������Ա����ţ���DeptID
		sql="select DeptID from Person where PersonID = "+f1;
		String deptid=null;
		try {
			DB.openConn();
			rs=DB.executeQuery(sql);
			if (rs.next()) {
				deptid=rs.getString("DeptID");
			}else {
				deptid="";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return deptid;
	} 
	/*
	 * ����PersonID����Ա������
	 */
	public String getName(String f1) {
		Database DB=new Database();
		sql="select Name from Person where PersonID ="+f1;
		String name=null;
		try {
			DB.openConn();
			rs=DB.executeQuery(sql);
			if (rs.next()) {
				name =rs.getString("Name");
			}
			else {
				name="";
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return name;
	}
	/*
	 * ��perSon���в�������PersonID Name�ֶ� �洢��s������ ����
	 */
	public String[] getAllId() {
		String[] s=null;
		int row=0;
		int i=0;
		Database DB=new Database();
		sql="select PersonID,Name from Person order by PersonID";
		try {
			DB.openConn();
			rs=DB.executeQuery(sql);
			if (rs.last()) {
				row=rs.getRow();
			}
			if (row==0) {
				s=null;
			}else {
				s=new String[row];
				rs.first();
				rs.previous();
				while (rs.next()) {
				s[i]=rs.getString(1)+"-"+rs.getShort(2);
				i++;
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	}
	}
