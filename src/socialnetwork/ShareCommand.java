package socialnetwork;

//ConcreteCommand class
public class ShareCommand implements Command {

	//class variables
	private Wall wall;
	private SharableObject object;
	
	//constructor
	public ShareCommand(Wall wall, SharableObject object) {
		this.wall = wall;
		this.object = object;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		wall.share(object);
		
	}

}
