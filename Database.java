package com.jnzyjsxy.common;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
	/*
	 * 数据库连接类
	 */
public class Database {
	//创建成员变量用于存储数据库连接的字符串或结果
	//statement接口 用于执行静态sql语句 并返回它所生成的结果
	private Statement stmt=null;
	//结果集类
	ResultSet rs=null;
	//链接类
	private Connection conn=null;
	String sql;//存储sql语句
	//mysql数据连接字符串
	//"jdbc:mysql://localhost:3306/db_hrms"
	//数据库名称db_hrms
	//在数据库名称后，增加"?characterEncoding=GBK"，避免插入记录为乱码 
	String strurl="jdbc:mysql://rm-uf6160p8x17k64esho.mysql.rds.aliyuncs.com:3306/db_hrms?characterEncoding=GBK";//主机地址
	String username="root";//用户名
	String password="Pp12138793";//密码
	//构造方法
	public Database(){
	}
	/*
	 * 打开数据库连接
	 */
	public void openConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			//DriverManager.getConnection启动器管理类的连接方法
			//创建数据库连接对象三个参数 初始化conn
			conn=(Connection) DriverManager.getConnection(strurl, username, password); 
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("OpenConn:"+e.getMessage()); 
		}
	}
	/*
	 * 执行sql查询语句 返回结果集rs
	 */
	public ResultSet executeQuery(String sql) {
		//由于stmt rs 反复使用 所以先置为空
		stmt=null;
		rs=null;
		try {
			//连接对象执行createStatment方法 创建语句对象
			//TYPE_SCROLL_INSENSITIVE，常量，字面意思 ：类型-滚动-不敏感
			//该常量表示结果集合记录指针可上下移动，当数据库记录改变时，结果集不更改   
			//CONCUR_READ_ONLY，常量，字面意思  同意-只读 
			//该常量表示，不能用结果集更新数据库中的表 
			stmt=(Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
			//通过stml的executeQuery方法 执行sql查询获取结果集
			rs=stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("executeQuery"+e.getMessage());
		}
		return rs;
		
	}
	/*
	 * 执行sql语句 进行增删改查
	 */
	public void executeUpdate(String sql) {
		stmt=null;
		rs=null;
		System.out.println(sql);//观察该sql语句
		try {
			stmt=(Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate(sql);
			//通过conn的commit方法 提交事务
			conn.commit();//修改结果 写入数据库
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exceptionUpdate"+e.getMessage());
		}
	}
	public void closeStmt() {
		try {
			stmt.close();//关闭执行语句stmt对象
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("closeStmt"+e.getMessage());
		}
	}
	/*
	 * 关闭数据库连接
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
	 * 转换编码
	 */
	public static String toGBK(String str) {
		try {
			if (str==null) {
				str="";
			}else {
				//将传过来的字符转换成byte 按照进行重新编码
				str=new String(str.getBytes("iso-8859-1"),"GBK");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return str;
	}
}

