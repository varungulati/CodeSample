package ObserverDesignPattern;

public interface Subject {
	public void register(Observer o);
	public void notifyUsers();
	public void deleteUser(Observer o);
}
