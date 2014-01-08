package socialnetwork;

public class SharableObject {

	//class variables
	private String data;
	private String type;
	
	//constructor
	public SharableObject(String data) {
		this.data = data;
	}

	//getters & setters	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
