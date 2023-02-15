package mainframe;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import classapp.Application;
import menu_information.SaveUserInfo;
import menu_information.UserInfomation;

public class UserLoad {
	
	
	UserInfomation user;
	
	public void sysLoader(String id) {


		String path = "userCharacter\\";
		File f = new File(path);
	
		
		
		//System.out.println(f.list()[1]);

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		if (f.exists()) {

			try {
				fis = new FileInputStream(path + "/" + id + ".info");
				ois = new ObjectInputStream(fis);
				user = (UserInfomation) ois.readObject();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					ois.close();
					fis.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			
		}


	}


}
