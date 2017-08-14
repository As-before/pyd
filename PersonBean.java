package com.jnzyjsxy.common;

import java.sql.ResultSet;

import javax.sound.midi.VoiceStatus;
import javax.swing.JOptionPane;

import org.omg.CORBA.PUBLIC_MEMBER;
/*
 * 有关人员信息数据库操作的类
 */
public class PersonBean {
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
	String field8;
	String field9;
	String field10;
	
	String colname;//列名
	String colvalue1;//列值1
	String colvalue2;//列值2
	
	/*
	 * 添加信息
	 */
	public void add(String f1,String f2,String f3,String f4,String f5,
			String f6,String f7,String f8,String f9,String f10) {
		//创建数据库对象 执行数据库里面的方法 链接数据库 执行sql语句
		Database DB=new Database();
		//将从添加界面传过来的值 付给成员变量
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
		//判断穿过来的值是否为空 如果为空就显示提示语句
		if (field2==null || field2.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入人员姓名", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field3==null||field3.equals("")) {
			JOptionPane.showMessageDialog(null,"请输入性别","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field4==null||field4.equals("")) {
			JOptionPane.showMessageDialog(null,"请输入出生年月","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field5==null||field5.equals("")) {
			JOptionPane.showMessageDialog(null,"请输入民族","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field6==null||field6.equals("")) {
			JOptionPane.showMessageDialog(null,"请输入地址","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field7==null||field7.equals("")) {
			JOptionPane.showMessageDialog(null,"请输入部门","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field8==null||field8.equals("")) {
			JOptionPane.showMessageDialog(null,"请输入薪酬","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		//构建插入字符串
		//构建sql字符串时，注意字符型，两侧用单引号做定界符，int,float不用定界符
		//传递过来的数据是字符型， 
		//为了插入int数据，进行类型转换-Integer.parseInt(field1) 
		//在此PersonID，DeptID均为int类型，Sqlary为float类型，与书上不同 
		else {
			sql="insert into Person(PersonID,Name,Sex,Birth,Nat,Address,DeptID,Salary,Assess,Other) values("+Integer.parseInt(field1)+ ",'"+field2+"','"+field3+"','"+field4+"','"+field5+"','"+field6+"',"+Integer.parseInt(field7)+","+Float.parseFloat(field8)+",'"+field9+"','"+field10+"')";
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
			JOptionPane.showMessageDialog(null, "请输入人员姓名", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field3==null||field3.equals("")) {
			JOptionPane.showMessageDialog(null,"请输入性别","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field4==null||field4.equals("")) {
			JOptionPane.showMessageDialog(null,"请输入出生年月","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field5==null||field5.equals("")) {
			JOptionPane.showMessageDialog(null,"请输入民族","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field6==null||field6.equals("")) {
			JOptionPane.showMessageDialog(null,"请输入地址","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field7==null||field7.equals("")) {
			JOptionPane.showMessageDialog(null,"请输入部门","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if (field8==null||field8.equals("")) {
			JOptionPane.showMessageDialog(null,"请输入薪酬","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		//构建插入字符串
		//构建sql字符串时，注意字符型，两侧用单引号做定界符，int,float不用定界符
		//传递过来的数据是字符型， 
		//为了插入int数据，进行类型转换-Integer.parseInt(field1) 
		//在此PersonID，DeptID均为int类型，Sqlary为float类型，与书上不同 
		else {
			sql="update Person set Name ='"+field2+"',Sex ='"+field3      +"',Birth ='"+field4+"',Nat ='"+field5      +"',Address='"+field6 +"',DeptID =" +Integer.parseInt(field7)      +",Salary ="+Float.parseFloat(field8) +",Assess ='"+field9      +"',Other ='"+field10       +"'  where PersonID="+Integer.parseInt(field1); 
			System.out.println(sql);	
			//打开数据库连接
			try {
				DB.openConn();
				//执行sql语句
				DB.executeUpdate(sql);
				//提示信息
				JOptionPane.showMessageDialog(null, "你成功修改一条新的纪录！");
			} catch (Exception e) {
				// TODO: handle exception
				//出现异常 ，给出提示
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "保存失败 ","错误！", JOptionPane.ERROR_MESSAGE);
			}
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
		sql="delete from Person where PersonID="+Integer.parseInt(field1);
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
	 * 根据PersonID查询人员信息，返回人员信息各列值组成的字符数组
	 */
	public String[] search(String f1) {
		Database DB=new Database();
		this.field1=f1;
		//创建字符串数组 用于记录查询的数据
		String[] s =new String[10];
		sql="select * from Person where PersonID="+field1;
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
	 * 根据PersonID查询人员考核，返回人员信息各列值组成的字符数组
	 */
	public String searchAssess(String f1) {
		Database DB=new Database();
		this.field1=f1;
		//创建字符串数组 用于记录查询的数据
		String s=null;
		sql="select Assess from Person where PersonID="+field1;
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
	 * 根据PersonID查询人员考核，返回人员信息各列值组成的字符数组
	 */
	public String searchS(String f1) {
		Database DB=new Database();
		this.field1=f1;
		//创建字符串数组 用于记录查询的数据
		String s=null;
		sql="select Salary from Person where PersonID="+field1;
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
		 * 人员信息综合查询
		 * 从PersonID和Dept表查询所有Where DeptID=Person.DeptID部门编号相等的记录
		 */
	public String[][] searchAllForNode() {
		//初始化数据库
		Database DB=new Database();
		//创建二维数组 存储查找到的符号条件记录的咯列值
		//由于符合条件的记录可能有多行，所以需要二维数组
		String[][] sn =null;
		int row=0;//存储行数
		int i=0;//循环变量
		//构建联合查询语句 查询条件where DeptID=Person.DeptID
		//从Person，Dept表查询Where Dept.DeptID=Person.DeptID 条件的指定字段
		sql="select PersonID,Name,Sex,Dept.DeptID as DeptID,B_Dept,S_Dept, Salary,Assess  from  Dept,Person  where Dept.DeptID=Person.DeptID  order by PersonID";   
		try {
			DB.openConn();
			// TODO: handle exception
			//执行查询
			rs=DB.executeQuery(sql);
			//rs.last()--将记录指针移动到最后记录上，该方法类型为boolean
			//如果指针位于有效位,则返回true;如果结果集中不存在任何行,则返回false
			//即如果rs中有记录
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
				//结果集下移一条数据 返回true 执行循环
				//如果没有执行re.previons()语句 在执行rs.next（），第一天记录就略过了。
				while (rs.next()) {
					sn[i][0]=rs.getString("PersonID");
					sn[i][1]=rs.getString("Name");
					sn[i][2]=rs.getString("Sex");
					//一级部门-二级部门，存储到sn[i][3]元素中
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
	 * 查询所有ID
	 * 
	 */
public String[] searchAllID() {
	//初始化数据库
	Database DB=new Database();
	//创建二维数组 存储查找到的符号条件记录的咯列值
	//由于符合条件的记录可能有多行，所以需要二维数组
	String[] sn =null;
	int row=0;//存储行数
	int i=0;//循环变量
	//构建联合查询语句 查询条件where DeptID=Person.DeptID
	//从Person，Dept表查询Where Dept.DeptID=Person.DeptID 条件的指定字段
	sql="select * from Person order by PersonID";
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
	 * 修改Person表中 指定用户的部门信息，即修改Person表中的DeptID字段值
	 */
	public void updateDept(String f1,String f7) {
		Database DB=new Database();
		this.field1=f1;//PersonID
		this.field7=f7;//Dept 部门字段
		//HistrinBean histrinBean=new HistrinBean();
		//histrinBean.add("人员调动", f3, f4, f5, f6, f7);
		sql="update Person set DeptID =" +Float.parseFloat(field7)+" where PersonID ="+Integer.parseInt(field1);
		try {
			DB.openConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "部门更改成功");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "更新失败", "失败",JOptionPane.ERROR_MESSAGE);
		}
	}
	/*
	 * 修改Person表中 指定用户的薪资信息，即修改Person表中的DeptID字段值
	 */
	public void updateDept1(String f1,String f8) {
		Database DB=new Database();
		this.field1=f1;//PersonID
		this.field8=f8;//salary 薪资字段
		sql="update Person set Salary =" +Float.parseFloat(field8)+" where PersonID ="+Integer.parseInt(field1);
		try {
			DB.openConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "劳资更改成功");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "更新失败", "失败",JOptionPane.ERROR_MESSAGE);
		}
	}
	/*
	 * 修改Person表中指定考核信息 即修改Person表中Assess字段值
	 */
	public void updateAssess(String f1,String f9) {
	Database DB=new Database();
	this.field1=f1;
	this.field9=f9;//考核字段
	sql="update Person set Assess = '"+field9 +"' where PersonID ="+Integer.parseInt(field1);
	try{
		DB.openConn();
		DB.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "人员考核成功");
	}catch(Exception e){
		System.out.println(e);
		JOptionPane.showMessageDialog(null, "更新失败", "失败",
				JOptionPane.ERROR_MESSAGE);
	}
	}

		

	/*
	 * 从Person表查询所有的人员信息 DeptID列显示部门名称
	 */
	public String[][] searchAll() {
		Database DB=new Database();
		//定义二维数组
		String[][] sn=null;
		int row=0;//行数
		int i=0;//循环变量
		//查询sql字符串
		sql="select * from Person order by PersonID";
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
						sn[i][0]=rs.getString("PersonID");
						sn[i][1]=rs.getString("Name");
						sn[i][2]=rs.getString("Birth");
						sn[i][3]=rs.getString("Nat");
						sn[i][4]=rs.getString("Address");
						//创建部门操作类DeptBean的对象
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
	
	//薪资
	public String[][] searchS() {
		Database DB=new Database();
		//定义二维数组
		String[][] sn=null;
		int row=0;//行数
		int i=0;//循环变量
		//查询sql字符串
		sql="select * from Person order by PersonID";
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
						sn[i][0]=rs.getString("PersonID");
						sn[i][1]=rs.getString("Name");
						sn[i][2]=rs.getString("Birth");
						sn[i][3]=rs.getString("Nat");
						sn[i][4]=rs.getString("Address");
						//创建部门操作类DeptBean的对象
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
	//考核
		public String[][] searchA() {
			Database DB=new Database();
			//定义二维数组
			String[][] sn=null;
			int row=0;//行数
			int i=0;//循环变量
			//查询sql字符串
			sql="select * from Person order by PersonID";
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
							sn[i][0]=rs.getString("PersonID");
							sn[i][1]=rs.getString("Name");
							sn[i][2]=rs.getString("Birth");
							sn[i][3]=rs.getString("Nat");
							sn[i][4]=rs.getString("Address");
							//创建部门操作类DeptBean的对象
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
	 * 获得新的Person值
	 */
	public int getId() {
		Database DB=new Database();
		int ID=1;
		//查询sql，从Person表获取PersonID列的最大值
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
	 * 获得DeptID
	 */
	public String getDeptId(String f1) {
		Database DB=new Database();
		//根据传递过来的PersonID 即根据员工编号，查DeptID
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
	 * 根据PersonID查找员工姓名
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
	 * 从perSon表中查找所有PersonID Name字段 存储在s数组中 返回
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
