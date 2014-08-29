package Factory;

public class OrderPizza {
	public static void main(String args) {
		Pizza pizza = new PizzaFactory().getPizzaType("cheese");
		pizza.bake();
	}
}
