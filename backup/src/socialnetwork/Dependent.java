package socialnetwork;

public class Dependent{
	
	//class variables
	private int id;
	private String dependency;
	
	//constructor
		public Dependent(int id,char dependency)
		{	
			this.id=id;
			
			switch(dependency){
			case 'f': 
				this.dependency=" - father"; break;
			case 'm': 
				this.dependency=" - mother"; break;
			case 's': 
				this.dependency=" - son"; break;
			case 'd': 
				this.dependency=" - daughter"; break;
			case 'b': 
				this.dependency=" - sister/brother"; break;
			case 'a': 
				this.dependency=" - aunt"; break;
			case 'u': 
				this.dependency=" - uncle"; break;
			
			
			}
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
