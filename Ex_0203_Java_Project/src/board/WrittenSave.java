package board;

import java.awt.Color;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class WrittenSave {


	public WrittenSave(File file, JTable userTable) {

		
		
		System.out.println(userTable.getValueAt(userTable.getSelectedRow(), 1).toString());
		
		Frame bf = new Frame();
		bf.setBounds(10, 10, 900, 600);
		bf.setLayout(null);

		JLabel tt = new JLabel("Á¦¸ñ:");
		tt.setBounds(50, 60, 30, 30);

		TextField title = new TextField();
		title.setBounds(90, 60, 750, 30);

		TextArea writ = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		writ.setBounds(50, 100, 790, 450);

		FileReader fr1 = null;
		BufferedReader br1 = null;
		outer : for (int i = 0; i < file.list().length; i++) {
				String str = file.list()[i].substring(0, file.list()[i].length()-4);
				if (str.equals(userTable.getValueAt(userTable.getSelectedRow(), 1).toString())) {

					try {
						fr1 = new FileReader(file + "/" + userTable.getValueAt(userTable.getSelectedRow(), 1).toString() + ".txt" );
						br1 = new BufferedReader(fr1);

						String line = "";
						String total_line = "";
						
						title.setText(str);
						
						while ((line = br1.readLine()) != null) {
							total_line = total_line + line + "\n";
						}
						writ.setText(total_line);

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							br1.close();
							fr1.close();
							break outer;
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}

				}

		} // outer for

		bf.setBackground(Color.LIGHT_GRAY);

		bf.add(tt);
		bf.add(title);
		bf.add(writ);

		bf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				bf.dispose();
			};
		});

		bf.setVisible(true);
		bf.setResizable(false);

	}

}
