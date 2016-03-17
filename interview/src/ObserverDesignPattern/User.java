package ObserverDesignPattern;

public class User implements Observer {
	Subject subject = null;
	String username;
	public User(Subject s, String name) {
		this.subject = s;
		this.username = name;
	}
	@Override
	public void subscribe() {
		// TODO Auto-generated method stub
		this.subject.register(this);
	}

	@Override
	public void unsubscribe() {
		// TODO Auto-generated method stub
		this.subject.deleteUser(this);
	}
	@Override
	public String getObserverName() {
		// TODO Auto-generated method stub
		return this.username;
	}
	
}
