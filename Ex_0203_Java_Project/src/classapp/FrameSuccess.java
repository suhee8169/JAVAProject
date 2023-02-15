package classapp;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class FrameSuccess extends JFrame {

	
	JLabel success;
	Label macro;
	JButton btn;
	Random rnd = new Random();
	int ran = rnd.nextInt(311)+30;
	

	public FrameSuccess() {

		setBounds(700, 400, 400, 200);
		setLayout(null);

		success = new JLabel("");
		success.setBounds(110, 30, 250, 30);
		
		macro = new Label("***매크로 방지를 위해 확인버튼의 위치가 바뀝니다***");
		macro.setBounds(50, 120, 300, 30);
		
		btn = new JButton("확인");
		btn.setBounds(ran, 80, 60, 30);
		

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
				

			}
		});

		add(success);
		add(btn);
		add(macro);
		
		
		setVisible(true);
		setResizable(false);
		setAlwaysOnTop(true);
		
		
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {

				System.exit(0); // 열려있는 모든 프레임을 종료
			};
			

		});

	}

}