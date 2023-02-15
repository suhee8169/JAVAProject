package board;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Written extends Frame {
	public Written() {
		
		Frame f = new Frame();
		f.setBounds(95, 95, 1000, 560);
		f.setLayout(null);
		f.setBackground(Color.LIGHT_GRAY);
		
		JLabel lt = new JLabel("제목:");
		lt.setBounds(60, 80, 30, 30);
		
		TextField title = new TextField();
		title.setBounds(95, 80, 850, 30);
		
		TextArea wtOut = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		wtOut.setBounds(60, 120, 890, 360);
		
		JButton wtbtn = new JButton("등록");
		wtbtn.setBounds(880, 500, 70, 30);
		
		//등록버튼 클릭시 저장
		wtbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = wtOut.getText();
				
				File file1  = new File("board\\");
				
				FileWriter fw = null;
				BufferedWriter bw = null;
				
				try {
					
					BufferedWriter bos1 = new BufferedWriter(new FileWriter(file1 + "/" + title.getText() +  ".txt"));
					bos1.write(wtOut.getText());
					bos1.close();
					dispose();
					new BoardList("공지사항");
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally {
					try {
						
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				}
				
			}
		});
		
		// 저장 버튼 감
		wtbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame wtf = new Frame();
				wtf.setBounds(400, 400, 300, 200);
				wtf.setLayout(null);
				wtf.setBackground(Color.LIGHT_GRAY);
				
				Label lb = new Label("작성이 완료되었습니다");
				lb.setBounds(90, 90, 150, 30);
								
				JButton wtfb = new JButton("확인");
				wtfb.setBounds(120, 135, 70, 30);
				
				wtf.add(lb);
				wtf.add(wtfb);
				
				// 
				wtfb.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						wtf.dispose();
						f.dispose();
					}
				});//확인버튼 미션
				
				wtf.setVisible(true);
				wtf.setResizable(false);
				
			}
		});//등록버튼 액션
		
		
		//프레임에 추가
		f.add(lt);
		f.add(title);
		f.add(wtOut);
		f.add(wtbtn);
		
		//프레임종료
		f.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				f.dispose();
			};
		});
		
		f.setVisible(true);
		f.setResizable(false);
		
	}
}
