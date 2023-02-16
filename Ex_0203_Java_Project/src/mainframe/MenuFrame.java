package mainframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import board.BoardList;
import classapp.FrameClass;
import mainframe.Grade2.TableEvent;
import menu_frame.LoginFrame;

public class MenuFrame extends JFrame{
	public MenuFrame () {
	
		setLayout(null);
		setBounds(750, 150, 700, 475);
		
		JButton btn1 = new JButton("공  지  사  항");
		JButton btn2 = new JButton("학  생  정  보");
		JButton btn3 = new JButton("성  적  관  리");
		JButton btn4 = new JButton("수  강  신  청");
		JButton btn5 = new JButton("오 늘 의  학 식");
		
		btn1.setBounds(520, 0, 175, 90);
		btn2.setBounds(520, 90, 175, 90);
		btn3.setBounds(520, 180, 175, 90);
		btn4.setBounds(520, 270, 175, 90);
		btn5.setBounds(520, 360, 175, 90);
		
		ImageIcon mit = new ImageIcon("KakaoTalk_20230214_120135682.jpg.png");
		
		JLabel mitt = new JLabel(mit);
		mitt.setBounds(0, 15, 500, 420);
		
		
		//btn3.setEnabled(true);
		if(LoginFrame.id_str.equals("관리자")) {
			btn3.setEnabled(true);
		}else {
			btn3.setEnabled(false);
			//System.out.println("왜 여기로?");
		}
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FrameMain fm = new FrameMain();
				
			}
		});
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameClass();
				
			}
		});
		
		btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu_frame.MenuFrame mf = new menu_frame.MenuFrame();
				
			}
		});
		
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Grade2 gr = new Grade2("성적");
				
				
				
			}
		});
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new BoardList("공지사항");
				
			}
		});
		
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		
	
		add(mitt);
		setResizable(false);
		setVisible(true);
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();
			};

		});
	}


	
}
