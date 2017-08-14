package com.jnzyjsxy.common;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class HistrinBeank {
	//定义字符串用于存储sql字符串
		String sql;
		//结果集类
		ResultSet rs=null;
		//声明字符串变量 存储从操作界面传过来的人员信息
		String field1;
		String field2;
		String field3;
		String field4;
		String field5;
		String field6;
		String field7;
		
		public void add(String f2,String f3,String f4,String f5,
				String f6,String f7){
			//创建数据库对象 执行数据库里面的方法 链接数据库 执行sql语句
			Database DB=new Database();
			//将从添加界面传过来的值 付给成员变量
			//this.field1=f1;
			this.field2=f2;
			this.field3=f3;
			this.field4=f4;
			this.field5=f5;
			this.field6=f6;
			this.field7=f7;
			//判断穿过来的值是否为空 如果为空就显示提示语句
			if (field2==null || field2.equals("")) {
				JOptionPane.showMessageDialog(null, "请输入FromAcc", "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (field3==null||field3.equals("")) {
				JOptionPane.showMessageDialog(null,"请输入OldInfo","错误",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (field4==null||field4.equals("")) {
				JOptionPane.showMessageDialog(null,"请输入NewInfo","错误",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (field5==null||field5.equals("")) {
				JOptionPane.showMessageDialog(null,"请输入ChgTime","错误",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (field6==null||field6.equals("")) {
				JOptionPane.showMessageDialog(null,"请输入RegDate","错误",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (field7==null||field7.equals("")) {
				JOptionPane.showMessageDialog(null,"请输入PersonID","错误",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			//构建插入字符串
			//构建sql字符串时，注意字符型，两侧用单引号做定界符，int,float不用定界符
			//传递过来的数据是字符型， 
			//为了插入int数据，进行类型转换-Integer.parseInt(field1)
			else {
				sql="insert into Histrjnk(JourNo,FromAcc,OldInfo,NewInfo,ChgTime,RegDate,PersonID) values("+getId()+ ",'"+field2+"','"+field3+"','"+field4+"',"+Integer.parseInt(field5)+",'"+field6+"',"+Integer.parseInt(field7)+")";
				System.out.println(sql);	
				//打开数据库连接
				try {
					DB.openConn();
					//执行sql语句
					DB.executeUpdate(sql);
					//提示信息
					JOptionPane.showMessageDialog(null, "纪录成功");
				} catch (Exception e) {
					// TODO: handle exception
					//出现异常 ，给出提示
					System.out.println(e);
					JOptionPane.showMessageDialog(null, "记录失败 ","错误！", JOptionPane.ERROR_MESSAGE);
				}
					//关闭语句对象和链接对象
					finally{
						DB.closeStmt();
						DB.closeConn();
					}
				}
		}
			/*
			 * 根据JourNo
			 * ，返回人员信息各列值组成的字符数组
			 */
			public String[] search(String f1) {
				Database DB=new Database();
				this.field1=f1;
				//创建字符串数组 用于记录查询的数据
				String[] s =new String[6];
				sql="select * from Histrjnk where JourNo="+field1;
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
			 * 根据PersonID
			 * ，返回人员信息各列值组成的字符数组
			 */
			public String[] searchPI(String f7) {
				Database DB=new Database();
				this.field1=f7;
				//创建字符串数组 用于记录查询的数据
				String[] s =new String[6];
				sql="select * from Histrjnk where PersonID="+field7;
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
				//创建字符串数组 用于记录查询的数据
				//String[] s =new String[6];
				sql="select * from Histrjnk where PersonID="+field7;
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
				//查询sql，从Person表获取PersonID列的最大值
				sql="select max(JourNo) from Histrjnk";
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
				//定义二维数组
				String[][] sn=null;
				int row=0;//行数
				int i=0;//循环变量
				//查询sql字符串
				sql="select * from Histrjnk order by JourNo";
				try {
					DB.openConn();
					rs=DB.executeQuery(sql);
						if (rs.last()) {
							row=rs.getRow();//获取结果集rs中记录数，即行数
						}
						//如果row==0说明rs没有记录 既没有查到符号条件的记录
						if (row==0) {
							//初始化二维数组1行6列 每个元素为空白字符
							sn=new String[1][6];
							sn[0][0]="";
							sn[0][1]="";
							sn[0][2]="";
							sn[0][3]="";
							sn[0][4]="";
							sn[0][5]="";
						}
						//否则rs不等于0
						else {
							//根据行数row 初始化二维数组sn
							sn=new String[row][6];
							//让rs指到第一条数据
							rs.first();
							//将指针移动到上一行 由于上一条语句记录指针到第一条数据
							//执行完这条语句后 记录指针移动的rs的头部分
							//执行该条语句的作用是保障所有的记录都能满足rs.next()条件
							rs.previous();
							while (rs.next()) {
								sn[i][0]=rs.getString("JourNo");
								sn[i][1]=rs.getString("OldInfo");
								sn[i][2]=rs.getString("NewInfo");
								sn[i][3]=rs.getString("ChgTime");
								sn[i][4]=rs.getString("RegDate");
								//创建部门操作类DeptBean的对象
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
			
			//部门历史查询
			public String[][] searchF() {
				Database DB=new Database();
				//定义二维数组
				String[][] sn=null;
				int row=0;//行数
				int i=0;//循环变量
				//查询sql字符串
				sql="select * from Histrjnk order by JourNo";
				try {
					DB.openConn();
					rs=DB.executeQuery(sql);
						if (rs.last()) {
							row=rs.getRow();//获取结果集rs中记录数，即行数
						}
						//如果row==0说明rs没有记录 既没有查到符号条件的记录
						if (row==0) {
							//初始化二维数组1行6列 每个元素为空白字符
							sn=new String[1][6];
							sn[0][0]="";
							sn[0][1]="";
							sn[0][2]="";
							sn[0][3]="";
							sn[0][4]="";
							sn[0][5]="";
						}
						//否则rs不等于0
						else {
							//根据行数row 初始化二维数组sn
							sn=new String[row][6];
							//让rs指到第一条数据
							rs.first();
							//将指针移动到上一行 由于上一条语句记录指针到第一条数据
							//执行完这条语句后 记录指针移动的rs的头部分
							//执行该条语句的作用是保障所有的记录都能满足rs.next()条件
							
							rs.previous();
							//if (rs.getString("FromAcc")=="人员调动") {
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
								//创建部门操作类DeptBean的对象
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

		