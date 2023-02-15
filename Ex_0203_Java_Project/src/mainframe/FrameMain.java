package mainframe;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import classapp.Application;
import menu_frame.LoginFrame;
import menu_information.UserInfomation;

public class FrameMain extends Frame {
	
	UserInfomation use = new UserInfomation();
	UserLoad ul = new UserLoad();
	//LoginFrame lf =new LoginFrame();
	Application app = new Application();
	String str = "";
	

	String[] depart = { "인문학부 - 국문학과", "인문학부 - 철학과", "인문학부 - 사학과", "자연과학부 - 물리학과 ", "자연과학부 - 화학과 ", "자연과학부 - 수학과 ",
			"사회과학부 - 경영학과", "사회과학부 - 경제학과", "사회과학부 - 법학과", "공학부 - 전기전자공학과", "공학부 - 컴퓨터공학과", "공학부 - 정보통신공학과" };

//	String[][] students = { { "인문학부 - 국문학과", "1학년", "홍길동", "학부생", "2023002011" },
//			{ "인문학부 - 국문학과", "2학년", "박민수", "학부생", "2022002021" }, { "인문학부 - 국문학과", "3학년", "김병헌", "학부생", "2019002603" },
//			{ "인문학부 - 국문학과", "2학년", "노민우", "학부생", "2023002604" }, { "인문학부 - 철학과", "1학년", "김민하", "학부생", "2023001605" },
//			{ "인문학부 - 철학과", "2학년", "이수근", "학부생", "2021001701" }, { "인문학부 - 사학과", "2학년", "김성철", "학부생", "2022003702" },
//			{ "인문학부 - 사학과", "4학년", "이성진", "학부생", "2011003703" }, { "자연과학부 - 물리학과", "1학년", "김하민", "학부생", "2023011704" },
//			{ "자연과학부 - 물리학과", "1학년", "노우민", "학부생", "2023011705" }, { "자연과학부 - 화학과", "2학년", "박민철", "학부생", "2022012801" },
//			{ "자연과학부 - 화학과", "2학년", "김연하", "학부생", "2022012802" }, { "자연과학부 - 수학과", "4학년", "김하연", "학부생", "2019013803" },
//			{ "자연과학부 - 수학과", "1학년", "노우근", "학부생", "2023013804" }, { "사회과학부 - 경제학과", "4학년", "이서희", "학부생", "2019021805" }, 
//			{ "사회과학부 - 경영학과", "4학년", "채민석", "학부생", "2015021805" }, { "사회과학부 - 경영학과", "1학년", "김수아", "학부생", "2023022805" },
//			{ "사회과학부 - 경제학과", "3학년", "이서아", "학부생", "2020022805" }, { "사회과학부 - 법학과", "4학년", "류하린", "학부생", "2019023805" },
//			{ "사회과학부 - 법학과", "3학년", "안진영", "학부생", "2020023805" }, { "공학부 - 전기전자공학과", "1학년", "남궁유진", "학부생", "2023031805" },
//			{ "공학부 - 전기전자공학과", "4학년", "손동희", "학부생", "2016031805" }, { "공학부 - 컴퓨터공학과", "3학년", "제갈민수", "학부생", "2020032805" },
//			{ "공학부 - 컴퓨터공학과", "1학년", "정하윤", "학부생", "2023032805" }, { "공학부 - 정보통신공학과", "3학년", "이준", "학부생", "2020033805" },
//			{ "공학부 - 정보통신공학과", "3학년", "이지안", "학부생", "2019033805" }};
	
	ArrayList<String>[] student_info ;
	
	UserInfomation ui = new UserInfomation();

	MenuBar mb = new MenuBar();

	Menu homeMenu = new Menu("HOME");
	Menu controlMenu = new Menu("성적정보");

	// JLabel titleLabel = new JLabel("Select Student Type");
	// boolean a = false;

	Choice choice = new Choice();
	// JComboBox<String> cb = new JComboBox<String>();

	JTree tree;
	DefaultMutableTreeNode root;

	DefaultTreeModel treeModel;

	JTable table;
	JScrollPane sp;
	
	JLabel login = new JLabel();

	
	//String user[] = {ui.getMajorName(), ui.getName(), ui.getId()};

	String columName[] = { "학과", "학년", "성명", "구분", "학번" };
	String[][] select;
	int cnt = 0;

	public FrameMain() {
		
	
		String path = "userCharacter\\";
		File f = new File(path);
		student_info = new ArrayList[f.list().length];
		for (int i = 0; i < f.list().length; i++) {
			student_info[i] = new ArrayList<String>();
		}
		
		String temp_str = "";
		for(int i = 0; i<f.list().length; i++) {
			String str = f.list()[i].toString().substring(0, 10);
			temp_str = str;
			ul.sysLoader(str);
			student_info[i].add(ul.user.getMajorName().toString());
			student_info[i].add(ul.user.getGrade().toString());
			student_info[i].add(ul.user.getName().toString());
			student_info[i].add("학부생");
			student_info[i].add(ul.user.getId().toString());
			
			//System.out.println(student_info[i]);
		}
		
		String [][] student = new String [f.list().length][columName.length];
		for(int i = 0; i<f.list().length; i++) {
			for(int j = 0; j<columName.length; j++) {
				student[i][j] = student_info[i].get(j);
			}
		}
		
		//System.out.println(LoginFrame.id_str);
		ul.sysLoader(LoginFrame.id_str);
	login.setText("<html>" + ul.user.getName() + "(" + ul.user.getId() + ") 님" +"<br/> 신분 : 학부생 <br/> 소속 : " + ul.user.getMajorName());
	login.setBounds(35, 390, 160, 160);
		
	
		
		
		setTitle("학생관리프로그램");
		mb.add(homeMenu);
		mb.add(controlMenu);
		


		choice.add("국문학과");
		choice.add("철학과");
		choice.add("사학과");
		choice.add("물리학과");
		choice.add("화학과");
		choice.add("수학과");
		choice.add("경영학과");
		choice.add("경제학과");
		choice.add("법학과");
		choice.add("전기전자공학과");
		choice.add("컴퓨터공학과");
		choice.add("정보통신공학과");
		
		
		choice.setBounds(20, 330, 160, 20);
		choice.setVisible(true);

		root = new DefaultMutableTreeNode("학과");

		tree = new JTree(root);

		tree.setBounds(10, 110, 160, 140);

		for (int i = 0; i < depart.length; i++) {

			DefaultMutableTreeNode node = new DefaultMutableTreeNode(depart[i]);
			root.add(node);
			treeModel = (DefaultTreeModel) tree.getModel();
			treeModel.setRoot(root);
		} // for
		
		controlMenu.addActionListener(new MenuClickListener(homeMenu, controlMenu));
		
//	     controlMenu.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				System.out.println("click");
//				Grade2 g2 = new Grade2("성적");
//				g2.setDesign();
//				g2.actionPerformed(e);
//				
//			}
//		});

		table = new JTable(student, columName) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		sp = new JScrollPane(table);
		sp.setBounds(200, 68, 750, 400);
		add(sp);

		choice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				remove(sp);

				cnt = 0;
				int plus = 0;

				String obj = (String) arg0.getItem();
				for (int i = 0; i < student.length; i++) {
					// System.out.println(students[i][0]);

					if (obj.equals(student[i][0])) {
						cnt++;
					}
				}

				select = new String[cnt][columName.length];

				for (int i = 0; i < student.length; i++) {
					if (obj.equals(student[i][0])) {

						for (int j = 0; j < columName.length; j++) {
							select[plus][j] = student[i][j];

						}
						plus++;
					}
				}

				table = new JTable(select, columName) {
					@Override
					public boolean isCellEditable(int row, int column) {
						// TODO Auto-generated method stub
						return false;
					}
				};
				sp = new JScrollPane(table);
				sp.setBounds(200, 68, 750, 400);
				add(sp);

			}
		});
		add(choice);
		add(tree);
		setMenuBar(mb);
		add(login);
		// add(titleLabel);
		// add(gsCheck);
		// add(usCheck);

		setSize(1000, 500);
		setVisible(true);
		
		
		//System.out.println(students.length);

		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();
			};

		});
	}

	
}