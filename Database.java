package com.jnzyjsxy.common;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
	/*
	 * ���ݿ�������
	 */
public class Database {
	//������Ա�������ڴ洢���ݿ����ӵ��ַ�������
	//statement�ӿ� ����ִ�о�̬sql��� �������������ɵĽ��
	private Statement stmt=null;
	//�������
	ResultSet rs=null;
	//������
	private Connection conn=null;
	String sql;//�洢sql���
	//mysql���������ַ���
	//"jdbc:mysql://localhost:3306/db_hrms"
	//���ݿ�����db_hrms
	//�����ݿ����ƺ�����"?characterEncoding=GBK"����������¼Ϊ���� 
	String strurl="jdbc:mysql://rm-uf6160p8x17k64esho.mysql.rds.aliyuncs.com:3306/db_hrms?characterEncoding=GBK";//������ַ
	String username="root";//�û���
	String password="Pp12138793";//����
	//���췽��
	public Database(){
	}
	/*
	 * �����ݿ�����
	 */
	public void openConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			//DriverManager.getConnection����������������ӷ���
			//�������ݿ����Ӷ����������� ��ʼ��conn
			conn=(Connection) DriverManager.getConnection(strurl, username, password); 
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("OpenConn:"+e.getMessage()); 
		}
	}
	/*
	 * ִ��sql��ѯ��� ���ؽ����rs
	 */
	public ResultSet executeQuery(String sql) {
		//����stmt rs ����ʹ�� ��������Ϊ��
		stmt=null;
		rs=null;
		try {
			//���Ӷ���ִ��createStatment���� ����������
			//TYPE_SCROLL_INSENSITIVE��������������˼ ������-����-������
			//�ó�����ʾ������ϼ�¼ָ��������ƶ��������ݿ��¼�ı�ʱ�������������   
			//CONCUR_READ_ONLY��������������˼  ͬ��-ֻ�� 
			//�ó�����ʾ�������ý�����������ݿ��еı� 
			stmt=(Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
			//ͨ��stml��executeQuery���� ִ��sql��ѯ��ȡ�����
			rs=stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("executeQuery"+e.getMessage());
		}
		return rs;
		
	}
	/*
	 * ִ��sql��� ������ɾ�Ĳ�
	 */
	public void executeUpdate(String sql) {
		stmt=null;
		rs=null;
		System.out.println(sql);//�۲��sql���
		try {
			stmt=(Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate(sql);
			//ͨ��conn��commit���� �ύ����
			conn.commit();//�޸Ľ�� д�����ݿ�
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exceptionUpdate"+e.getMessage());
		}
	}
	public void closeStmt() {
		try {
			stmt.close();//�ر�ִ�����stmt����
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("closeStmt"+e.getMessage());
		}
	}
	/*
	 * �ر����ݿ�����
	 */
	public void closeConn() {
		try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("closeConn"+e.getMessage());
		}
	}
	/*
	 * ת������
	 */
	public static String toGBK(String str) {
		try {
			if (str==null) {
				str="";
			}else {
				//�����������ַ�ת����byte ���ս������±���
				str=new String(str.getBytes("iso-8859-1"),"GBK");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return str;
	}
}

