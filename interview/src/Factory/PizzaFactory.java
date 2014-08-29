package Factory;

class CheesePizza implements Pizza{
	public void bake() {
		
	}
	public void orderPizza() {
		
	}
}
public class PizzaFactory {
	public Pizza getPizzaType(String type) {
			Pizza pizza = null;
			if(type.equals("cheese")) {
				pizza = new CheesePizza();
			}
			return pizza;
	}
}
