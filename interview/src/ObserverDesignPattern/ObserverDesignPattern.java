package ObserverDesignPattern;

public class ObserverDesignPattern {
	public static void main(String[] args) {
		PostOffice postOffice = new PostOffice();
		User user1 = new User(postOffice, "Varun");
		postOffice.notifyUsers();
		user1.subscribe();
		User user2 = new User(postOffice, "Tommy");
		user2.subscribe();
//		user2.unsubscribe();
		postOffice.notifyUsers();
	}
}
