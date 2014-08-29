package MVC;

public class Application {
	public static void main(String[] args) {
		
	}
	public static void runApp() {
		Model model = new Model();
		View view = new View(model);
//		Controller controller = new Controller(model, view);
	}
}
