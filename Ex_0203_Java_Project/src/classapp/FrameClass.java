package classapp;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.NumberFormatter;

import mainframe.UserLoad;
import menu_frame.LoginFrame;
import menu_information.UserInfomation;



public class FrameClass {

	static int cnt = 0;
	static int count = 0;
	static String res[][];
	static JTable jtable;
	static JScrollPane sp = new JScrollPane(jtable);
	static String[][] complete = new String[0][];
	static int credit = 0;
	static Application app = new Application();
	static ArrayList<String>[] list;
	
	
	public FrameClass() {
		

		// 수강신청 메인화면
		Frame fc = new Frame("수강신청시스템");
		fc.setBounds(500, 200, 800, 540);
		fc.setLayout(null);

		// Frame 안의 각 객체들 자리잡기
		
		Button login = new Button("조회");
		login.setBounds(25, 50, 70, 40);
		login.setEnabled(true);

		
		
		Label info = new Label();
		info.setBounds(100, 50, 590, 40);
		
		Label search = new Label("강의시간표 검색");
		search.setBounds(50, 110, 100, 30);

		Button ask = new Button("신청");
		ask.setBounds(715, 160, 50, 150);
		ask.setEnabled(false);

		Button cancel = new Button("신청취소");
		cancel.setBounds(715, 330, 50, 150);
		cancel.setEnabled(true);
		cancel.setVisible(false);
		
		Button save = new Button("저장");
		save.setBounds(700, 50, 70, 40);
		save.setEnabled(false);
//		
//		ImageIcon logo = new ImageIcon("logo.png");
//		JLabel back = new JLabel(logo);
//		back.setBounds(0, 0, 800, 700);
//		
		
		

		// 강의시간표 학부, 과 choice
		Choice studies = new Choice();
		studies.setBounds(170, 110, 0, 0);
		studies.add("전체");
		studies.add("인문학부");
		studies.add("자연과학부");
		studies.add("사회과학부");
		studies.add("공학부");

		// 강의목록 설정
		String header[] = { "학부", "개설전공", "교과목명", "학점", "수강인원", "담당교수", "요일 및 교시" };
		String contents[][] = { { "인문학부", "철학과", "고대철학사", "3", "40", "이창우", "화 1~3" },
				{ "인문학부", "철학과", "중세철학사", "3", "60", "박승찬", "목 4~6" },
				{ "인문학부", "철학과", "현대인식론", "3", "50", "마이클샌델", "수 1~3" },
				{ "인문학부", "국문학과", "언어학개론", "3", "40", "김민서", "금 1~3" },
				{ "인문학부", "국문학과", "문학개론", "3", "60", "안용희", "목 2~4" },
				{ "인문학부", "국문학과", "문학과 윤리", "2", "50", "안용희", "월 4~5" },
				{ "인문학부", "사학과", "한국사학입문", "3", "40", "정연태", "월 2~4" },
				{ "인문학부", "사학과", "한국사기초사료읽기", "3", "60", "채웅석", "수 1~3" },
				{ "인문학부", "사학과", "한국고대사", "2", "50", "기경량", "금 4~5" },
				{ "자연과학부", "물리학과", "양자역학", "3", "40", "조향현", "화 4~6" },
				{ "자연과학부", "물리학과", "물리학실험", "3", "40", "서경진", "수 4~6" },
				{ "자연과학부", "물리학과", "전자기학", "3", "40", "김시은", "목 1~3" },
				{ "자연과학부", "화학과", "생화학실험", "3", "40", "이서희", "월 2~4" },
				{ "자연과학부", "화학과", "유기화학", "3", "60", "이성진", "화 2~4" },
				{ "자연과학부", "화학과", "무기화학", "3", "50", "한동훈", "금 1~3" },
				{ "자연과학부", "수학과", "일반수학", "3", "40", "박민준", "월 5~7" },
				{ "자연과학부", "수학과", "선형대수학", "3", "60", "채민석", "화 3~5" },
				{ "자연과학부", "수학과", "해석학개론", "2", "50", "안진영", "목 1~2" },
				{ "사회과학부", "경영학과", "경영학원론", "3", "80", "김희경", "월 6~8" },
				{ "사회과학부", "경영학과", "재무관리", "3", "80", "이상의", "화 2~4" },
				{ "사회과학부", "경영학과", "마케팅", "2", "80", "박성준", "금 6~7" },
				{ "사회과학부", "경제학과", "경제학개론", "3", "80", "애덤스미스", "목 1~3" },
				{ "사회과학부", "경제학과", "미시경제학", "3", "80", "문시열", "화 2~4" },
				{ "사회과학부", "경제학과", "거시경제학", "3", "80", "양준석", "금 4~6" },
				{ "사회과학부", "법학과", "법학개론", "3", "60", "정연태", "금 6~8" },
				{ "사회과학부", "법학과", "헌법총론", "3", "60", "채웅석", "수 6~8" },
				{ "사회과학부", "법학과", "형법총론", "3", "60", "기경량", "목 4~6" },
				{ "공학부", "전기전자공학과", "전력전자", "3", "30", "손동희", "화 4~6" },
				{ "공학부", "전기전자공학과", "플라즈마", "2", "40", "문준", "수 4~6" },
				{ "공학부", "전기전자공학과", "회로이론", "3", "40", "김건훈", "목 1~3" },
				{ "공학부", "컴퓨터공학과", "운영체제", "3", "40", "김진", "화 6~8" },
				{ "공학부", "컴퓨터공학과", "컴퓨터구조", "3", "40", "남궁유진", "목 6~8" },
				{ "공학부", "컴퓨터공학과", "알고리즘분석", "3", "40", "조이안", "금 2~4" },
				{ "공학부", "정보통신공학과", "정보통신공학개론", "3", "40", "장다은", "월 5~7" },
				{ "공학부", "정보통신공학과", "데이터통신", "2", "60", "한지훈", "화 3~4" },
				{ "공학부", "정보통신공학과", "이동통신공학", "3", "50", "김지은", "목 1~3" } };

		// 신청현황 label
		Label credit_now = new Label("총 0 학점 신청되었습니다");
		credit_now.setBounds(620, 110, 170, 30);
		

		// 학부 선택했을 때, 학부에 해당하는 과 choice목록 띄우기
		Choice major = new Choice();
		major.setBounds(310, 110, 120, 50);
		studies.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String str = (String) e.getItem();
				if (str.equals("인문학부")) {
					major.removeAll();
					major.add("철학과");
					major.add("국문학과");
					major.add("사학과");
				} else if (str.equals("자연과학부")) {
					major.removeAll();
					major.add("물리학과");
					major.add("화학과");
					major.add("수학과");
				} else if (str.equals("사회과학부")) {
					major.removeAll();
					major.add("경영학과");
					major.add("경제학과");
					major.add("법학과");
				} else if (str.equals("공학부")) {
					major.removeAll();
					major.add("전기전자공학과");
					major.add("컴퓨터공학과");
					major.add("정보통신공학과");
				} else if (str.equals("전체")) {
					major.removeAll();
				}

			}

		});

		// 전공 choice했을 때, 해당 전공의 강의가 뜨도록
		cnt = 36;
		res = new String[cnt][header.length];
		jtable = new JTable(res, header) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		sp = new JScrollPane(jtable);
		sp.setBounds(25, 160, 690, 150);
		for (int i = 0; i < contents.length; i++) {

			for (int j = 0; j < contents[i].length; j++) {
				res[i][j] = contents[i][j];

			}

		}
		fc.add(sp);

		studies.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// fc.add(sp);

				fc.remove(sp);

				cnt = 0;
				String str = (String) e.getItem();
				for (int i = 0; i < contents.length; i++) {
					if (contents[i][0].equals(str)) {
						cnt++;
					}
				}
				if (str.equals("전체")) {
					cnt = 36;
				}

				res = new String[cnt][header.length];
				jtable = new JTable(res, header) {
					@Override
					public boolean isCellEditable(int row, int column) {
						// TODO Auto-generated method stub
						return false;
					}
				};
				sp = new JScrollPane(jtable);
				sp.setBounds(25, 160, 690, 150);

				// sp.setEnabled(true);

				if (str.equals("전체")) {

					for (int i = 0; i < contents.length; i++) {

						for (int j = 0; j < contents[i].length; j++) {
							res[i][j] = contents[i][j];

						}

					}
					fc.add(sp);
				}

				int num = 0;
				for (int i = 0; i < contents.length; i++) {
					if (contents[i][0].equals(str)) {
						// fc.remove(sp);

						for (int j = 0; j < contents[i].length; j++) {
							res[num][j] = contents[i][j];

						}
						num++;

					}
				}
				fc.add(sp);

			}
		});
		major.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				fc.remove(sp);

				cnt = 0;
				String str = (String) e.getItem();
				for (int i = 0; i < contents.length; i++) {
					if (contents[i][1].equals(str)) {
						cnt++;
					}
				}
				res = new String[cnt][header.length];
				jtable = new JTable(res, header) {
					@Override
					public boolean isCellEditable(int row, int column) {
						// TODO Auto-generated method stub
						return false;
					}
				};
				sp = new JScrollPane(jtable);
				sp.setBounds(25, 160, 690, 150);
				// sp.setEnabled(true);
				int num = 0;
				for (int i = 0; i < contents.length; i++) {

					if (contents[i][1].equals(str)) {
						for (int j = 0; j < contents[i].length; j++) {
							res[num][j] = contents[i][j];

						}
						num++;
					}
				}
				fc.add(sp);
				fc.add(credit_now);

			}
		});

		// 수강신청 신청 버튼 클릭했을 때

		complete = new String[8][header.length];
		JTable table = new JTable(complete, header);
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(25, 330, 690, 153);
		list = new ArrayList[complete.length];
		for (int i = 0; i < complete.length; i++) {
			list[i] = new ArrayList<String>();
		}

		// 로그인버튼을 눌렀을 경우
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fc.add(cancel);
				
				info.setText(LoginFrame.id_str + " 님 로그인되었습니다.");
				
				SystemLoad sl = new SystemLoad();
				app = sl.sysLoader(LoginFrame.id_str);
				//list = app.getList();
				//System.out.println(app.getCredit());
				//System.out.println(list[0].get(2));
				if(app == null) {
					app = new Application();
					app.setId(LoginFrame.id_str);
				}else {
					credit = app.getCredit();
					//complete = app.getComplete();
					list = app.getList();
					count = app.getCount();
					for (int i = 0; i < list.length; i++) {
						
						for (int j = 0; j < list[i].size(); j++) {
							
							complete[i][j] = list[i].get(j);

						}
					}
					credit_now.setText("총 "+credit+" 학점 신청되었습니다");
					cancel.setVisible(true);
					//cancel.setEnabled(true);
					fc.add(jsp);
					
				
				}
				
				ask.setEnabled(true);
				
			}
		});
		//정보 load
		
//		SystemLoad sl = new SystemLoad();
//		app = sl.sysLoader(getId.getText());
//		if(app == null) {
//			app = new Application();
//			app.setId(getId.getText());
//		}else {
//			credit = app.getCredit();
//			complete = app.getComplete();
//		}
		

		ask.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = jtable.getSelectedRow();
				boolean run = true;
				TableModel model = jtable.getModel();
				char[] a = new char[3];
				char[] b = new char[3];
		
				
				for (int i = 0; i < complete.length; i++) {
					if (model.getValueAt(row, 2).equals(complete[i][2])) {
						FrameOverlap fo = new FrameOverlap();
						fo.overlap.setText("! [" + model.getValueAt(row, 2) + "]은(는) \n 이미 신청하셨습니다 !");
						count--;
						run = false;
						break ;
					}
				}
				
			
				if(run) {
				tt: for (int i = 0; i < count; i++) {
					int plus = 0;
					for (int j = 0; j < Integer.parseInt(complete[i][3]); j++) {
						
						a[j] = (char) (complete[i][6].charAt(2) + plus);
						plus++;
					}
					plus = 0;
					
					for (int j = 0; j < Integer.parseInt((String) model.getValueAt(row, 3)); j++) {
						
						b[j] = (char) (((String) model.getValueAt(row, 6)).charAt(2) + plus);
						plus++;
					}
					if (complete[i][6].charAt(0) == ((String) model.getValueAt(row, 6)).charAt(0)) {

						for (int q = 0; q < a.length; q++) {
							for (int k = 0; k < b.length; k++) {
								if (a[q] == b[k]) {
									FrameTime ft = new FrameTime();
									count--;
									run = false;
									break tt;
								}
							}//inner
						}//outer

					}
				}//tt
				}


				if(run) {
				for (int j = 0; j < model.getColumnCount(); j++) {
					Object obj = model.getValueAt(row, j);
					complete[count][j] = (String) obj;
				}
				credit += Integer.parseInt(complete[count][3]);

				if (credit >= 16) {
					credit -= Integer.parseInt(complete[count][3]);
					credit_now.setText("총 " + credit + "학점 신청되었습니다");
					FrameFail ff = new FrameFail();
					for(int i = 0; i<header.length; i++) {
						complete[count][i] = null;
					}
					
					count--;
				} else {

					credit_now.setText("총 " + credit + "학점 신청되었습니다");
					FrameSuccess fs = new FrameSuccess();

					fs.success.setText(complete[count][2] + " 수강신청 성공");

				}
				}//run if

				fc.add(jsp);
				cancel.setEnabled(true);
				cancel.setVisible(true);

				for (int j = 0; j < header.length; j++) {
					if (count >= complete.length) {
						break;
					}else {
						list[count].add(complete[count][j]);
						if(list[count].size() > header.length) {
							for(int i = header.length; i<list[count].size(); i++ ) {
								list[count].remove(i);
							}
						}
					}
				}
				count++;
				//cancel.setEnabled(true);
				save.setEnabled(true);
//				for(int i = 0; i<8; i++) {
//					System.out.println(list[i]);
//				}

			}
		});

		// 수강취소 버튼 클릭했을 떄
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int roww = table.getSelectedRow();
				if(list[roww].size() == 0) {
					FrameBlank fb = new FrameBlank();
				}else {
					
				credit -= Integer.parseInt(complete[roww][3]);
				

				for (int i = 0; i < list[roww].size();) {
					list[roww].remove(i);

				}
				for (int i = roww; i < list.length - 1; i++) {
					list[i] = list[i + 1];
				}

				for (int i = 0; i < list.length; i++) {
					if (list[i].size() == 0) {
						for (int j = 0; j < header.length; j++) {
							complete[i][j] = null;
						}
					}
					for (int j = 0; j < list[i].size(); j++) {
						
						complete[i][j] = list[i].get(j);

					}
				}
				
				FrameCancel fca = new FrameCancel();
				

				fc.add(jsp);
				credit_now.setText("총 " + credit + "학점 신청되었습니다");
				count--;
				}//else
			}
		});
		
		
		
		//저장
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				app.setCredit(credit);
				//app.setComplete(complete);
				app.setList(list);
				app.setCount(count);
				//System.out.println(list[0].get(2));
				
				SystemSave ss = new SystemSave();
				ss.infoSave(app);
				// TODO Auto-generated method stub
				
			}
		});
		
		//System.out.println(app.getId());
		

		// fc에 컴포넌트들 추가
		
		fc.add(login);
		fc.add(info);
		fc.add(search);
		fc.add(studies);
		fc.add(major);
		fc.add(credit_now);
		fc.add(ask);
		fc.add(cancel);
		fc.add(save);
		//fc.add(back);
		
		

		// fc 기본설정
		fc.setResizable(false);
		fc.setVisible(true);

		fc.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				fc.dispose();
			};

		});
		
	}
//public static void main(String[] args) {
//	FrameClass fc = new FrameClass();
//}
}