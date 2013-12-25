package socialnetwork;

import java.util.ArrayList;

public abstract class GroupComponent {
	
	protected int id;
	protected String name;
	
	public GroupComponent(int id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	public abstract void addGroup(GroupComponent c);
	public abstract void removeGroup(GroupComponent c);
	public abstract ArrayList<GroupComponent> searchGroup(String name);
	public abstract void displayGroup();
	public abstract void displayGroupMembers();
	public abstract void addMember(User u);
	public abstract void removeMember(User u);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
