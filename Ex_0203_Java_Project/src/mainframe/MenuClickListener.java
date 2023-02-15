package mainframe;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuClickListener implements ActionListener {
	
	Menu homeMenu;
	Menu controlMenu;
	
	public MenuClickListener(Menu homeMenu, Menu controlMenu) {
		this.homeMenu = homeMenu;
		this.controlMenu = controlMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
	}

}
