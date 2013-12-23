package socialnetwork;

import java.util.ArrayList;

public class User {
	
	//class variables
	private int userId;
	private String name;
	private String email;
	private String pass;
	
	private ArrayList<User> friends;
	private ArrayList<Dependent> dependents;
	//private ArrayList<User> dependents;
	private ArrayList<String> interests;
	private boolean visible;
	private Wall wall;
	
	public User(){
		friends = new ArrayList<User>();
		dependents = new ArrayList<Dependent>();
		//dependents = new ArrayList<User>();
		interests = new ArrayList<String>();
		visible = true;
		wall = new Wall();			
	}
	
	public User(int userId, String name, String email, String pass) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.pass = pass;
		
		friends = new ArrayList<User>();
		dependents = new ArrayList<Dependent>();
		//dependents = new ArrayList<User>();
		interests = new ArrayList<String>();
		visible = true;
		wall = new Wall();				
	}
	
	public void addFriend(User u)
	{
		friends.add(u);
	}
	
	public void addDependent(Dependent d)
	{
		dependents.add(d);
	}
	
	public boolean isFriend(int id) {
		for (User u : friends) {
			if (u.getUserId() == id)
				return true;
		}
		
		return false;
	}
	
	/*public boolean isDependent(int id){
		for(User u : dependents){
			if(u.getUserId() == id)
				return true;
		}
		return false;
	}*/
	
	public boolean isDependent(int id){
		for(Dependent d : dependents){
			if(d.getId() == id)
				return true;
		}
		return false;
	}
	
	public String toString()
	{
		return (name+wall.toString()+"\n");
	}
	
	// getters & setters
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public ArrayList<User> getFriends() {
		return friends;
	}
	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}
	public ArrayList<Dependent> getDependents() {
		return dependents;
	}
	public void setDependents(ArrayList<Dependent> dependents) {
		this.dependents = dependents;
	}
	
	/*public ArrayList<User> getDependents() {
		return dependents;
	}
	public void setDependents(ArrayList<User> dependents) {
		this.dependents = dependents;
	}*/
	
	public ArrayList<String> getInterests() {
		return interests;
	}
	public void setInterests(ArrayList<String> interests) {
		this.interests = interests;
	}
	public void addInterest(String i){
		interests.add(i);
	}
	public void deleteInterest(int index){
		interests.remove(index);
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public Wall getWall() {
		return wall;
	}
	public void setWall(Wall wall) {
		this.wall = wall;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
