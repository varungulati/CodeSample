package MVC;

import javax.swing.JFrame;

public class View extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Model model;
	public View(Model model) {
		this.model = model;
	}
}
