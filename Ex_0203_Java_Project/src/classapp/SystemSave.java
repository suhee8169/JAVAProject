package classapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SystemSave {
	
	public void infoSave(Application app){
		
		String path = "sugang\\"+ app.getId() + ".sav";
		File f = new File("sugang\\");
		
		if(!f.exists()) {
			f.mkdirs();
		}else {
			System.out.println("경로가 존재합니다");
		}
		
		if(f.exists()) {
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(app); //저장완료
			System.out.println("저장완료!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				oos.close();
				fos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}

	}

}