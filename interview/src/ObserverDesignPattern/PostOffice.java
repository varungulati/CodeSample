package ObserverDesignPattern;

import java.util.ArrayList;

public class PostOffice implements Subject {
	ArrayList<Observer> observerList;
	
	public PostOffice() {
		observerList = new ArrayList<>();
	}
	@Override
	public void register(Observer o) {
		// TODO Auto-generated method stub
		observerList.add(o);
	}

	@Override
	public void notifyUsers() {
		// TODO Auto-generated method stub
		if(observerList.size() == 0) {
			System.out.println("Nothing");
		}
		for(Observer o: observerList) {
			System.out.println(o.getObserverName());
		}
	}

	@Override
	public void deleteUser(Observer o) {
		// TODO Auto-generated method stub
		observerList.remove(o);
	}

}
