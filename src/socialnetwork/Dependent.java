package socialnetwork;

public class Dependent {
	
	//class variables
	private int id;
	private String dependency;
	
	//constructor
		public Dependent(int id,String dependency)
		{
			this.id=id;
			this.dependency=dependency;
		}
		
	//getters & setters	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDependency() {
		return dependency;
	}

	public void setDependency(String dependency) {
		this.dependency = dependency;
	}

	
	

}
