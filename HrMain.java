package com.jnzyjsxy.test;

import java.awt.AWTError;
import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
/*
 * ���¹���ϵͳ������
 */
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.jnzyjsxy.node1.Node11Panel;
import com.jnzyjsxy.node1.Node12Panel;
import com.jnzyjsxy.node1.Node13Panel;
import com.jnzyjsxy.node1.Node14Panel;
import com.jnzyjsxy.node1.Node15Panel;
import com.jnzyjsxy.node2.Node21Panel;
import com.jnzyjsxy.node2.Node22Panel;
import com.jnzyjsxy.node3.Node31Panel;
import com.jnzyjsxy.node3.Node32Panel;
import com.jnzyjsxy.node4.Node41Panel;
import com.jnzyjsxy.node4.Node42Panel;
public class HrMain extends JFrame implements TreeSelectionListener{
	private static final URLClassLoader URLClassLoader = null;
	//��ܴ�С
	Dimension faceSize=new Dimension(650, 450);
	//����ͼ��
	Image icon;
	//����JTreeĿ¼������
	JTree tree;
	//�����ݽṹ�е�ͨ�ýڵ�
	//���溬�壬Ĭ�Ͽɱ�����ڵ���
	DefaultMutableTreeNode root;//���¹���ϵͳ���ڵ�
	DefaultMutableTreeNode node1;//������Ϣ����
	DefaultMutableTreeNode node2;//��Ա����ڵ�
	DefaultMutableTreeNode node3;//��Ա���˹���
	DefaultMutableTreeNode node4;//���ʹ���
	DefaultMutableTreeNode node5;//
	DefaultMutableTreeNode leafnode;//�����ڵ�
	TreePath treePath;//�ڵ�·����
	//���������
	//JSplitPane ���ڷָ�������ֻ����������Component
	//����Componentͼ�λ��ָ�
	//����������Component�������û�����ʽ������С
	//split--���ѣ����
	public static JSplitPane splitPane;
	JPanel panel1;//������Ŀ¼��
	JPanel panel2;
	JPanel panel3;//���Ҳ���ʾѡ��ڵ��Ľ���
	//������ʾ��ӭ��Ϣ�ı�ǩ
	JLabel welcome=new JLabel();
	//����������
	JScrollPane scrollPane;
	/*
	 * ���췽��(non-Javadoc)
	 * @see java.awt.Window#pack()
	 */public HrMain() {
		// TODO Auto-generated constructor stub
		//���������¼����� mask-��ߣ�����
		//Ҫ��û��enableEvents(AWTEvent.WIDOW_EVENT_MASK);
		 //ֻҪ��addActionListener()����������Ҳ��ӵ�и÷���
		 //����Ŀͨ��ѡ��Ŀ¼��������¼�
		 enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		 //��ӿ�ܵĹر�ʱ�䴦��
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 //��������Ӧ��С ʹ������������ʾ��������пؼ�
		 this.pack();
		 //���ÿ�ܵĴ�С
		 this.setSize(faceSize);
		 //���ô���ı���
		 this.setTitle("���¹���ϵͳ");
		 //�����Զ���ķ���GetImage���� ����ȡͼ���ļ�
		icon=getImage("icon.png");
		 //���ô���ͼ��
		 this.setIconImage(icon);
		 //���ò��ܵ�������Ĵ�С
		 this.setResizable(false);
		 try {
			Init();//���ó�ʼ������
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	 /*
	  * ��ʼ������ �������˵���
	  */
	private void Init() {
		// TODO Auto-generated method stub
		//��ʼ�����νڵ�
		root=new DefaultMutableTreeNode("���¹���ϵͳ");
		node1=new DefaultMutableTreeNode("������Ϣ����");
		node2=new DefaultMutableTreeNode("��Ա��������");
		node3=new DefaultMutableTreeNode("��Ա���˹���");
		node4=new DefaultMutableTreeNode("���ʹ���");
		//��ӻ�����Ϣ����ڵ㵽��ʶ����ϵͳ���ڵ�
		root.add(node1);
		//��Ӷ����ڵ� ����ӵ�������Ϣ����һ���ڵ���
		leafnode=new DefaultMutableTreeNode("�����Ա��Ϣ");
		node1.add(leafnode);
		leafnode=new DefaultMutableTreeNode("�޸���Ա��Ϣ");
		node1.add(leafnode);
		leafnode=new DefaultMutableTreeNode("ɾ����Ա��Ϣ");
		node1.add(leafnode);
		leafnode=new DefaultMutableTreeNode("��ѯ��Ա��Ϣ");
		node1.add(leafnode);
		leafnode=new DefaultMutableTreeNode("���Ź���");
		node1.add(leafnode);
		//�����Ա�����ڵ㵽���ڵ�
		root.add(node2);
		leafnode=new DefaultMutableTreeNode("��Ա����");
		node2.add(leafnode);
		leafnode=new DefaultMutableTreeNode("������ʷ��ѯ");
		node2.add(leafnode);
		root.add(node3);
		leafnode=new DefaultMutableTreeNode("��Ա����");
		node3.add(leafnode);
		leafnode=new DefaultMutableTreeNode("������ʷ��ѯ");
		node3.add(leafnode);
		
		root.add(node4);
		leafnode=new DefaultMutableTreeNode("���ʷ������");
		node4.add(leafnode);
		leafnode=new DefaultMutableTreeNode("������ʷ��ѯ");
		node4.add(leafnode);
		
		//����Ŀ¼������ ��rootΪ���ڵ�
		tree=new JTree(root);
		//���tree��������� ���˵������ݶ�ʱ ���ֹ�����
		scrollPane=new JScrollPane(tree);
		//���ù�������С
		scrollPane.setPreferredSize(new Dimension(150, 400));
		//setselectionMode()-��������ģ��
		//TreeSelectionModel.SINGLE_TREE_SELECTION,��ѡ
		//�������ǣ�CONTIGUOUD_TREE_SELECTION ��������
		//�� DISCONTIGUONS_TREE_SELECTION ��ѡ �ɲ�����
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		//��ʼ��Panel���
		panel1=new JPanel();//������
		panel2=new JPanel();//û�õ������
		panel3=new JPanel();//�Ҳ����
		
		panel1.add(scrollPane);//��ʾĿ¼�� ��Ŀ¼���ڹ��������
		welcome.setText("��ӭʹ�����¹���ϵͳ");
		welcome.setFont(new Font("Dialog", 0, 16));
		panel3.add(welcome);//�ӵ�panel3�����
		
		//�����ָ����
		splitPane=new JSplitPane();
		//����oneTouchExpandable���Ե�ֵ Expandable--չ��ʽ
		//ҪʹJsplitPane�ڷָ������ṩһ��С��������չ��/�۵��ָ��� �����Ա���Ϊtrue
		splitPane.setOneTouchExpandable(false);
		//������������Ϊtrue
		//����ָ����ı�λ�����������ػ�
		splitPane.setContinuousLayout(true);
		//���÷ָ����Ĵ�С
		splitPane.setPreferredSize(new Dimension(150, 400));
		//���÷ָ����ķ���--ˮƽ�ָ�
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		//���÷ָ����������-panel1 ������-panel3
		splitPane.setLeftComponent(panel1);
		splitPane.setRightComponent(panel3);
		//���÷ָ����ָ�����С
		splitPane.setDividerSize(2);
		//���÷ָ�����λ��  divider--�ָ���
		//���Խ���ֵ�ֱ��趨Ϊ150��161��171���в��� �鿴Ч��
		splitPane.setDividerLocation(161);
		//���������� �ȼ�this.add(spitpane)
		this.setContentPane(splitPane);
		this.setVisible(true);
		//���Ŀ¼��ѡ���¼�����
		tree.addTreeSelectionListener(this);
		//���ùرղ�����������
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	/*
	 * Jtree�¼�����
	 * addTreeSelectionListener����Ŀ¼������ ����ʵ�ֵķ���
	 * (non-Javadoc)
	 * @see javax.swing.event.TreeSelectionListener#valueChanged(javax.swing.event.TreeSelectionEvent)
	 */
	@Override
	public void valueChanged(TreeSelectionEvent tse) {
		// TODO Auto-generated method stub
		//����Ĭ����ڵ����
		//tse--��Ŀ¼����ѡ�񴥷���ʱ��
		//tse.getPath.getLatPathComponent
		//--������Ŀ¼���Ľڵ�
		DefaultMutableTreeNode dnode=(DefaultMutableTreeNode) tse.getPath().getLastPathComponent();
		//�ڿ���̨���ѡ�еĽڵ�
		System.out.println("dnode="+dnode);
		//��ȡ�ڵ����� ת�����ַ���
		String node_str=dnode.toString();
		//���ѡ��Ľڵ�Ϊ���¹���ϵͳ
		if (node_str=="���¹���ϵͳ") {
			//���÷ָ�����Ҳ����Ϊpanel3
			//��ʾ��ӭʹ����ʶ����ϵͳ
			splitPane.setRightComponent(panel3);
		}
		else if (node_str=="������Ϣ����") {
			treePath = new TreePath(node1.getPath()); 
			if (tree.isExpanded(treePath)) {   
				 tree.collapsePath(treePath); 
			}
			else {
				tree.expandPath(treePath); 
			}
		}
		else if (node_str=="�����Ա��Ϣ") {
			Node11Panel node11Panel = new Node11Panel();
			splitPane.setRightComponent(node11Panel); 
		}
		else if (node_str=="�޸���Ա��Ϣ") {
			Node12Panel node12Panel=new Node12Panel();
			splitPane.setRightComponent(node12Panel);
		}
		else if (node_str=="ɾ����Ա��Ϣ") {
			Node13Panel node13Panel=new Node13Panel();
			splitPane.setRightComponent(node13Panel);
		}
		else if (node_str=="��ѯ��Ա��Ϣ") {
			Node14Panel node14Panel=new Node14Panel();
			splitPane.setRightComponent(node14Panel);
		}
		else if (node_str=="���Ź���") {
			Node15Panel node15Panel=new Node15Panel();
			splitPane.setRightComponent(node15Panel);
		}
		else if (node_str == "��Ա��������") {   
			 treePath = new TreePath(node2.getParent());
			 if (tree.isExpanded(treePath)) { 
				 tree.collapsePath(treePath); 
			 } else {
			     tree.expandPath(treePath);
			     }
		}
			 else if (node_str == "��Ա����") { 
				 Node21Panel node21Panel = new Node21Panel();
				 splitPane.setRightComponent(node21Panel); 
		}
			 else if (node_str == "������ʷ��ѯ") { 
				 Node22Panel node22Panel = new Node22Panel();
				 splitPane.setRightComponent(node22Panel); 
		}
			 else if (node_str == "���ʹ���") { 
				 treePath = new TreePath(node4.getParent()); 
				 if (tree.isExpanded(treePath)) {
					 tree.collapsePath(treePath); 
				 }else {
					 tree.expandPath(treePath); 
				}
			 }
			 else if (node_str == "���ʷ������") {
				 Node41Panel node41Panel = new Node41Panel(); 
				 splitPane.setRightComponent(node41Panel); 
				 
			 }
			 else if (node_str == "������ʷ��ѯ") {
				 Node42Panel node42Panel = new Node42Panel(); 
				 splitPane.setRightComponent(node42Panel); 
				 
			 }
			 else if (node_str == "��Ա���˹���") {
				 treePath = new TreePath(node3.getParent());
				 if (tree.isExpanded(treePath)) { 
					 tree.collapsePath(treePath); 
				 }else {
					 tree.expandPath(treePath); 
				}
			 }
			 else if (node_str == "��Ա����") {
				 Node31Panel node31Panel = new Node31Panel(); 
				 splitPane.setRightComponent(node31Panel); 
			 }
		else if (node_str=="������ʷ��ѯ") {
			Node32Panel node32Panel =new Node32Panel();
			splitPane.setRightComponent(node32Panel);
		}
	}
	

	/**   * ͨ���������ļ������ͼ��   */
	
	Image getImage(String filename){ 
		//URLClassLoader--���ڴ�ָ�� jar�ļ���Ŀ¼�� URL ������·�����������Դ��
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
	
}
