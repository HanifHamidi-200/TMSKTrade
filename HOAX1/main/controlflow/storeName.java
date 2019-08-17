package controlflow;

public class storeName {
private String _name;
	
	public storeName(String text) {
		_name = text;
	}
	
	public void setName(String text) {
		_name = text;
	}
	
	public String getName() {
		return _name;
	}
	
	public void Saying() {
		System.out.printf("Your name is %s\n", getName());
	}
}
