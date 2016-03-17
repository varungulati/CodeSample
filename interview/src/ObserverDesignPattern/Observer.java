package ObserverDesignPattern;

public interface Observer {
	public void subscribe();
	public void unsubscribe();
	public String getObserverName();
}
