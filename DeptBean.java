package com.jnzyjsxy.common;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class DeptBean {
	//定义字符串用于存储sql字符串
	String sql;
	//结果集类
	ResultSet rs=null;
	//声明字符串变量 存储从操作界面传过来的人员信息
	String field1;
	String field2;
	String field3;
	//添加信息
	public void add(String f1,String f2,String f3) {
		//创建数据库对象 执行数据库里面的方法 链接数据库 执行sql语句
		Database DB=new Database();
		//将从添加界面传过来的值 付给成员变量
		this.field1=f1;
		this.field2=f2;
		this.field3=f3;
		if (field2==null || field2.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入人员所在一级部门", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field3==null||field3.equals("")) {
			JOptionPane.showMessageDialog(null,"请输入人员所在二级部门","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		//构建插入字符串
				//构建sql字符串时，注意字符型，两侧用单引号做定界符，int,float不用定界符
				//传递过来的数据是字符型， 
				//为了插入int数据，进行类型转换-Integer.parseInt(field1) 
				//在此PersonID，DeptID均为int类型，Sqlary为float类型，与书上不同 
				else {
					sql="insert into Dept(DeptID,B_Dept,S_Dept) values("+Integer.parseInt(field1)+ ",'"+field2+"','"+field3+"')";
					System.out.println(sql);	
					//打开数据库连接
					try {
						DB.openConn();
						//执行sql语句
						DB.executeUpdate(sql);
						//提示信息
						JOptionPane.showMessageDialog(null, "你成功添加一条新的纪录");
					} catch (Exception e) {
						// TODO: handle exception
						//出现异常 ，给出提示
						System.out.println(e);
						JOptionPane.showMessageDialog(null, "保存失败 ","错误！", JOptionPane.ERROR_MESSAGE);
					}
						//关闭语句对象和链接对象
						finally{
							DB.closeStmt();
							DB.closeConn();
					}
			}
	}
	/*
	 * 修改设备信息
	 */
	public void modify(String f1,String f2,String f3){
		Database DB=new Database();
		this.field1=f1;
		this.field2=f2;
		this.field3=f3;
		if (field2==null || field2.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入人员所在一级部门", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field3==null||field3.equals("")) {
			JOptionPane.showMessageDialog(null,"请输入人员所在二级部门","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		//构建插入字符串
		//构建sql字符串时，注意字符型，两侧用单引号做定界符，int,float不用定界符
		//传递过来的数据是字符型， 
		//为了插入int数据，进行类型转换-Integer.parseInt(field1) 
		//在此PersonID，DeptID均为int类型，Sqlary为float类型，与书上不同 
		else {
			sql="insert into Dept(DeptID,B_Dept,S_Dept) values("+Integer.parseInt(field1)+ ",'"+field2+"','"+field3+"')";
			System.out.println(sql);	
			//打开数据库连接
			try {
				DB.openConn();
				//执行sql语句
				DB.executeUpdate(sql);
				//提示信息
				JOptionPane.showMessageDialog(null, "你成功修改一条新的纪录");
			} catch (Exception e) {
				// TODO: handle exception
				//出现异常 ，给出提示
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "保存失败 ","错误！", JOptionPane.ERROR_MESSAGE);
			}
				//关闭语句对象和链接对象
				finally{
					DB.closeStmt();
					DB.closeConn();
			}
		}
	}
	/*
	 * 删除信息 根据传过来的PersonId 删除信息
	 */
	public void delete(String f1) {
		//创建数据库对象
		Database DB=new Database();
		this.field1=f1;//获取传递过来的参数
		//构建删除人员的字符串
		sql="delete from Dept where DeptID="+Integer.parseInt(field1);
		try {
			DB.openConn();
			DB.executeUpdate(sql);
			System.out.println(sql);
			JOptionPane.showMessageDialog(null, "成功删除一条新的纪录");	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "删除失败", "错误", JOptionPane.ERROR_MESSAGE);
			
	}
		finally{
			DB.closeStmt();
			DB.closeConn();
		}
	}
	/*
	 * 从Dept表查询所有人员信息，DeptID列显示部门名称 
	 */
	public String[] searchAllForNode() {
		Database DB=new Database();
		//定义二维数组
		String[] sn=null;
		int row=0;//行数
		int i=0;//循环变量
		//查询sql字符串
		sql="select * from Dept order by DeptID";
		try {
			DB.openConn();
			rs=DB.executeQuery(sql);
				if (rs.last()) {
					row=rs.getRow();//获取结果集rs中记录数，即行数
				}
				//如果row==0说明rs没有记录 既没有查到符号条件的记录
				if (row==0) {
					//初始化二维数组1行6列 每个元素为空白字符
					sn=new String[2];
					sn[0]="";
					sn[0]="";
					sn[0]="";
				}
				//否则rs不等于0
				else {
					//根据行数row 初始化二维数组sn
					sn=new String[row];
					//让rs指到第一条数据
					rs.first();
					//将指针移动到上一行 由于上一条语句记录指针到第一条数据
					//执行完这条语句后 记录指针移动的rs的头部分
					//执行该条语句的作用是保障所有的记录都能满足rs.next()条件
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
		//定义二维数组
		String[][] sn=null;
		int row=0;//行数
		int i=0;//循环变量
		//查询sql字符串
		sql="select * from Dept order by DeptID";
		try {
			DB.openConn();
			rs=DB.executeQuery(sql);
				if (rs.last()) {
					row=rs.getRow();//获取结果集rs中记录数，即行数
				}
				//如果row==0说明rs没有记录 既没有查到符号条件的记录
				if (row==0) {
					//初始化二维数组1行6列 每个元素为空白字符
					sn=new String[1][2];
					sn[0][0]="";
					sn[0][1]="";
					sn[0][2]="";
				}
				//否则rs不等于0
				else {
					//根据行数row 初始化二维数组sn
					sn=new String[row][2];
					//让rs指到第一条数据
					rs.first();
					//将指针移动到上一行 由于上一条语句记录指针到第一条数据
					//执行完这条语句后 记录指针移动的rs的头部分
					//执行该条语句的作用是保障所有的记录都能满足rs.next()条件
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
	 * 获得新的Dept值
	 */
	public int getId() {
		Database DB=new Database();
		int ID=1;
		//查询sql，从Person表获取PersonID列的最大值
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
	 * 根据DeptID查询人员信息，返回人员信息各列值组成的字符数组
	 */
	public String[] search(String f1) {
		Database DB=new Database();
		this.field1=f1;
		//创建字符串数组 用于记录查询的数据
		String[] s =new String[10];
		sql="select * from Dept where DeptID="+field1;
		try{
			DB.openConn();//连接数据库
			//执行查询，查询结果付给rs，rs为结果集
			rs=DB.executeQuery(sql);
			//如果rs.next为true
			if (rs.next()) {
				//获取指定的值
				//说明：PersonID'DeptId salary均不是String类型
				//但在此简化处理，把取出值看作字符串，赋值给字符数组元素
				//方便统一待会返回值
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
	 * 根据传递过来的ID 返回一级部门—耳机部门
	 */
	public String getDepstr(String string) {
		// TODO Auto-generated method stub
		Database DB=new Database();
		this.field1=string;
		//创建字符串数组 用于记录查询的数据
		String s = null;
		sql="select * from Dept where DeptID="+field1;
		System.out.println(sql);
		try{
			DB.openConn();//连接数据库
			//执行查询，查询结果付给rs，rs为结果集
			rs=DB.executeQuery(sql);
			//如果rs.next为true
			if (rs.next()) {
				//获取指定的值
				//说明：PersonID'DeptId salary均不是String类型
				//但在此简化处理，把取出值看作字符串，赋值给字符数组元素
				//方便统一待会返回值
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
