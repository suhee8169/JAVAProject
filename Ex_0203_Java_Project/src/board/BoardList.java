package board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class BoardList extends JFrame implements MouseListener{

	JTextField searchWindow;
	JButton searchbtn;
	JButton writebtn;
	JTable userTable;
	JScrollPane lists;
	JPanel listPanel;

	public BoardList(String title) {
		//super(title);


		setBounds(100, 100, 1280, 720);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);


		File file = new File("board" + "/");
		
		String columnName[] = {"No","제목","작성글"};
		
		/*
		String data[][] = {
				{"1","2022년 기말고사 관련 공지","관리자"},
				{"2","2022년도 졸업식 안내","관리자"},
				{"3","2023년 신입생 모집 안내","관리자"}
		};
		*/

		String[][] data2 = new String[(int)file.list().length][3]; 
		
		System.out.println(file.list().length);
		
		for(int i = 0; i<data2.length; i++) {
			System.out.println(file.list()[i]);			
			data2[i][0] = "" + (i+1);
			data2[i][1] = file.list()[i].substring(0, file.list()[i].length()-4);
			data2[i][2] = "관리자";
			
		}
		
		
	         
		JTable userTable = new JTable(data2, columnName){
			public boolean isCellEditable(int i, int c){
	          return false;
	         }};
		JScrollPane lists = new JScrollPane(userTable);
		lists.setBounds(30, 50, 1180, 510);
		
		JLabel lbno = new JLabel("No");
		lbno.setBounds(115, 20, 170, 30);
		JLabel lbtitle = new JLabel("제목");
		lbtitle.setBounds(600, 20, 800, 30);
		JLabel lbwt = new JLabel("글쓴이");
		lbwt.setBounds(1100, 20, 200, 30);
		
		
		
//		String path = "board\\save.txt";


//		try {
//			FileReader fr = new FileReader(path);
//			BufferedReader br = new BufferedReader(fr);
//
//			String ss = "";
//			String[] lines = null;
//
//			try {
//				fr = new FileReader(path);
//				br = new BufferedReader(fr);
//				
//				int cnt = 0;
//				lines = new String[5];
//				while( (ss  = br.readLine()) != null) {
//
//					lines[cnt++] = ss;
//	
//				}
//
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		
//		}


		listPanel = new JPanel();
		listPanel.setLayout(new BorderLayout());
		listPanel.add(userTable, BorderLayout.CENTER);

		userTable.setBounds(35, 55, 1170, 500);
		userTable.setRowHeight(30);// 행높이

		//열 너비 설정
		TableColumn column;
		column = userTable.getColumnModel().getColumn(0);
		column.setPreferredWidth(170);
		column = userTable.getColumnModel().getColumn(1);
		column.setPreferredWidth(800);
		column = userTable.getColumnModel().getColumn(2);
		column.setPreferredWidth(200);
		



		// 검색창
		searchWindow = new JTextField();
		searchWindow.setBounds(450, 620, 250, 30);

		// 검색버튼
		searchbtn = new JButton("검색");
		searchbtn.setBounds(700, 620, 70, 30);

		//검색실시
		searchbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String val = searchWindow.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(userTable.getModel());
				userTable.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});

		// 글쓰기버튼
		writebtn = new JButton("글쓰기");
		writebtn.setBounds(1125, 570, 80, 30);
		writebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Written();
				dispose();
			}

		});


		// 테이블 더블클릭 이벤트
		userTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					new WrittenSave(file,userTable);
				}


			}
		});

		// frame에 추가

		add(lbno);
		add(lbtitle);
		add(lbwt);
		add(userTable);
		add(lists);
		add(searchWindow);
		add(searchbtn);
		add(writebtn);


		// x 클릭시 종료
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();

			};

		});

		setVisible(true);

		// 프레임사이즈 변경 불가
		setResizable(false);

	}// 생성자

	// BoardList 오버라이드
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
