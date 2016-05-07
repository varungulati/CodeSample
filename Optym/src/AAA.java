interface Burger {
	public void cook();
}
class American implements Burger {
	public void cook() {
		System.out.println("American burger");
	}
}
class Italian implements Burger {	
	public void cook() {
		System.out.println("Italian burger");
	}
}

