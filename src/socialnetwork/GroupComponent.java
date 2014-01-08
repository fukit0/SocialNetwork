package socialnetwork;

import java.util.ArrayList;

public abstract class GroupComponent {
	
	protected int id;
	protected int adminId;
	protected String name;
	private Wall wall;
	
	public GroupComponent(int id, int adminId, String name) {
		this.setId(id);
		this.setAdminId(adminId);
		this.setName(name);
		wall = new Wall();
	}
	
	public abstract void addGroup(GroupComponent c);
	public abstract void removeGroup(GroupComponent c);
	public abstract void removeSubGroups();
	public abstract ArrayList<GroupComponent> searchGroup(String name);
	public abstract void displayGroup();
	public abstract void displayGroupMembers();
	public abstract ArrayList<GroupComponent> getUserGroups(int userId);
	public abstract boolean searchMember(int userId);
	public abstract void addMember(int userId);
	public abstract void removeMember(int userId);
	public abstract GroupComposite convertToComposite();

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

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public Wall getWall() {
		return wall;
	}

	public void setWall(Wall wall) {
		this.wall = wall;
	}

}
