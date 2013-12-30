package socialnetwork;

import java.util.ArrayList;

public abstract class GroupComponent {
	
	protected int id;
	protected int adminId;
	protected String name;
	
	public GroupComponent(int id, int adminId, String name) {
		this.setId(id);
		this.setAdminId(adminId);
		this.setName(name);
	}
	
	public abstract void addGroup(GroupComponent c);
	public abstract void removeGroup(GroupComponent c);
	public abstract ArrayList<GroupComponent> searchGroup(String name);
	public abstract void displayGroup();
	public abstract void displayGroupMembers();
	public abstract boolean searchMember(int userId);
	public abstract void addMember(int userId);
	public abstract void removeMember(int userId);

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

}
