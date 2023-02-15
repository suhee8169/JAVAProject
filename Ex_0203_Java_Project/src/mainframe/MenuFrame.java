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

public class MenuFrame extends JFrame{
	public MenuFrame () {
	
		setLayout(null);
		setBounds(750, 150, 700, 470);
		
		JButton btn1 = new JButton("공  지  사  항");
		JButton btn2 = new JButton("학  생  정  보");
		JButton btn3 = new JButton("성  적  관  리");
		JButton btn4 = new JButton("수  강  신  청");
		JButton btn5 = new JButton("오 늘 의  학 식");
		
		btn1.setBounds(520, 0, 160, 85);
		btn2.setBounds(520, 85, 160, 85);
		btn3.setBounds(520, 170, 160, 85);
		btn4.setBounds(520, 255, 160, 85);
		btn5.setBounds(520, 340, 160, 85);
		
		ImageIcon mit = new ImageIcon("KakaoTalk_20230214_120135682.jpg.png");
		
		JLabel mitt = new JLabel(mit);
		mitt.setBounds(0, 0, 500, 420);
		
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
