package MVC;

public class Controller {
	Model model;
	View view;
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
}
