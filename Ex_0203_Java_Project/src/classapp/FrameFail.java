package classapp;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameFail extends JFrame{
	
	JLabel draft;
	JButton btn;
	
	public FrameFail() {
		setBounds(700, 400, 400, 200);
		setLayout(null);

		draft = new JLabel("! 신청 가능 학점(15학점)을 초과하였습니다 !");
		draft.setBounds(70, 50, 300, 30);
		
		btn = new JButton("확인");
		btn.setBounds(170, 100, 60, 30);
		

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		
		add(btn);
		add(draft);
		
		
		// 윈도우 표시
		setVisible(true);
		setResizable(false);
		setAlwaysOnTop(true);
		
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {

				dispose(); // 열려있는 모든 프레임을 종료
			};

		});
	}

	
	
}