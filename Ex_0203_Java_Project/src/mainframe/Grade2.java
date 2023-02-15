package mainframe;

import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Grade2 extends JFrame implements ActionListener{
    private static final int SelectColumn = 0;
    Container cp;
    JTextField tName,tIDum,tAtt,tHW,tPj,tTest;
    JButton btAdd, btDel, btGrading,btSave,btOpen;
    DefaultTableModel model;
    JTable table;
    JScrollPane sp;
    int SelectRow = -1;
    int sum;
    String a,b;
    int c;
    double avg;
    
     Grade2(String title) {
		super("성적관리");
		cp = this.getContentPane();
		cp.setBackground(Color.green);
   	 
		this.setBounds(0, 0, 800, 600);
   	this.setBackground(new Color(255,255,200)); 
   	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   	this.setDesign(); 
   	this.setVisible(true); 
	}//Grade2()
	
	public void setDesign() {
		JPanel pTop = new JPanel();
		pTop.setBorder(new TitledBorder("성적입력"));
		cp.add("North",pTop);
		
		JPanel pBottom = new JPanel();
		pBottom.setBorder(new TitledBorder(""));
		cp.add("South",pBottom);
		
		tName = new JTextField(6);
		tIDum = new JTextField(10);
		tAtt = new JTextField(3);
		tHW = new JTextField(3);
		tPj = new JTextField(3);
		tTest = new JTextField(3);
		
		pTop.add(new JLabel("이름:"));
		pTop.add(tName);
		
		pTop.add(new JLabel("학번:"));
		pTop.add(tIDum);
		
		pTop.add(new JLabel("출석:"));
		pTop.add(tAtt);
		
		pTop.add(new JLabel("과제:"));
		pTop.add(tHW);
		
		pTop.add(new JLabel("프로젝트:"));
		pTop.add(tPj);
		
		pTop.add(new JLabel("시험:"));
		pTop.add(tTest);
		
		String[] title = {"이름","학번","출석","과제","프로젝트","시험","합계","등급"};
		//Vector title = null;
		model = new DefaultTableModel(title,0);
		table = new JTable(model);
		table.addMouseListener(new TableEvent());
		table.setAutoCreateRowSorter(true);
		TableRowSorter sorter = new TableRowSorter(table.getModel());
		table.setRowSorter(sorter);
		
		sp = new JScrollPane(table);
		cp.add("Center",sp);
		btAdd = new JButton("성적 등록");
		btDel = new JButton("성적 삭제");
		btGrading = new JButton("등수 매기기");
		btSave = new JButton("파일 저장");
		btOpen = new JButton("파일 열기");
		
		pBottom.add(btAdd);
		pBottom.add(btDel);
		pBottom.add(btGrading);
		pBottom.add(btSave);
		pBottom.add(btOpen);
		
		btAdd.addActionListener(this);
		btDel.addActionListener(this);
		btGrading.addActionListener(this);
		btSave.addActionListener(this);
		btOpen.addActionListener(this);
		
	}//setDesign()
	
	class TableEvent extends MouseAdapter{
		
		public void mouseClicked(MouseEvent e) {
			SelectRow = table.getSelectedRow();
			SelectRow = table.getSelectedRow();
			tName.setText((String)table.getValueAt(SelectRow, 0));
			tIDum.setText((String)table.getValueAt(SelectRow, 1));
			tAtt.setText((String)table.getValueAt(SelectRow, 2));
			tHW.setText((String)table.getValueAt(SelectRow, 3));
			tPj.setText((String)table.getValueAt(SelectRow, 4));
			tTest.setText((String)table.getValueAt(SelectRow, 5));
		}
	}//TableEvent
	
		
		
		
	@Override
	public void actionPerformed(ActionEvent e) {
	   Object ob = e.getSource();
	   if (ob == btAdd) {
		 Vector<String> vc = new Vector<>();
		 vc.add(tName.getText());
		 vc.add(tIDum.getText());
		 vc.add(tAtt.getText());
		 vc.add(tHW.getText());
		 vc.add(tPj.getText());
		 vc.add(tTest.getText());
		 sum = Integer.parseInt(tAtt.getText()) + Integer.parseInt(tHW.getText()) + Integer.parseInt(tPj.getText()) + Integer.parseInt(tTest.getText());
		 vc.add(String.valueOf(sum));
		
		 
		 for (int i = 0; i < model.getRowCount(); i++) {
			for (int j = 1; j < model.getRowCount(); j++) {
				a = (String.valueOf(model.getValueAt(j, 6)));
				b = (String.valueOf(model.getValueAt(j+1, 6)));
				if (Integer.parseInt(a) > Integer.parseInt(b)) {
					model.setValueAt(j, j, 8);
					model.setValueAt(j+1, j+1, 8);
					
				}else if (Integer.parseInt(a) < Integer.parseInt(b)) {
					model.setValueAt(j+1, j, 8);
				}//else if
				
			}//inner
		}//outer
		 
		 if (sum >= 95) {
			vc.add("A+");
			
		}else if (sum >= 90) {
			vc.add("A");
		}else if (sum >= 85) {
			vc.add("B+");
		}else if (sum >= 80) {
			vc.add("B");
		}else if (sum >= 75) {
			vc.add("C+");
		}else if (sum >= 70) {
			vc.add("C");
		}else if (sum >= 65) {
			vc.add("D+");
		}else if (sum >= 60) {
			vc.add("D");
		}else {
			vc.add("F");
		}
		 
		
		 
		model.addRow(vc); 
		tName.setText("-----");
		tIDum.setText("-----");
		tAtt.setText("-----");
		tHW.setText("-----");
		tPj.setText("-----");
		tTest.setText("-----");
		tName.requestFocus();
		
		
		
		
	}else if (btDel == ob) {
		if (SelectRow < 0) {
			JOptionPane.showMessageDialog(this, "삭제할 행을 선택하세요", "오류", JOptionPane.WARNING_MESSAGE);
			return;
		}//if
		String msg = table.getValueAt(SelectRow, 0) + "삭제하시겠습니까?";
		int ans = JOptionPane.showConfirmDialog(this, msg, "삭제완료",JOptionPane.YES_NO_OPTION);
		if (ans == JOptionPane.YES_OPTION) {
			model.removeRow(SelectRow);
			JOptionPane.showMessageDialog(this, "삭제되었습니다.");
			SelectRow = -1;
		}//if
	}else if (ob == btGrading) {
		int[] total = new int[model.getRowCount()];
		int[] rank = new int[model.getRowCount()];
		
		for (int i = 0; i < rank.length; i++) {
			total[i] = Integer.parseInt((String)model.getValueAt(i, 6));
			rank[i] = 1;
			
		}//for
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				if (i != j) {
					if (total[i] < total[j] ) {
						rank[i]++;
						
					}
				}
			}//inner
		}//outer
		for (int i = 0; i < rank.length; i++) {
			model.setValueAt(rank[i], i, 8);
		}
	}else if (ob == btSave) {
		FileDialog dlg = new FileDialog(this,"파일저장",FileDialog.SAVE);
		dlg.setVisible(true);
		if (dlg.getFile() == null) {
			return;
		}//if
		String fileName = dlg.getDirectory() + dlg.getFile();
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter(fileName);
			fw.write(String.valueOf(model.getRowCount()) + "\n");
			fw.write(String.valueOf(model.getColumnCount()) + "\n");
			for (int i = 0; i < model.getRowCount(); i++) {
				for (int j = 0; j < model.getColumnCount(); j++) {
					String data = (String)model.getValueAt(i, j);
					fw.write(data + "\n");
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}else if (ob == btOpen) {
		FileDialog dlg = new FileDialog(this,"파일열기",FileDialog.LOAD);
		dlg.setVisible(true);
		if (dlg.getFile() == null) {
			return;
		}//if
		String fileName = dlg.getDirectory() + dlg.getFile();
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			int row = Integer.parseInt(br.readLine());
			int col = Integer.parseInt(br.readLine());
			String []str = new String[col];
			model.setRowCount(0);
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					String data = br.readLine();
					str[j] = data;
				}
				model.addRow(str);
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}catch (NumberFormatException e1) {
           e1.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
	}//else if
		
	}
	
	
}