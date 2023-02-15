package classapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;



public class SystemLoad {
	
	Application app;

	public Application sysLoader(String id) {


		String path = "sugang\\"+ id + ".sav";
		File f = new File("sugang\\");

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		if (f.exists()) {

			try {
				fis = new FileInputStream(path);
				ois = new ObjectInputStream(fis);
				app = (Application) ois.readObject();

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return app;

	}

}