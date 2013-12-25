package socialnetwork;

import java.util.ArrayList;

public class GroupComposite extends GroupComponent {

	private int admin;
	private ArrayList<GroupComponent> children;
	private ArrayList<User> groupMembers;
	
	public GroupComposite(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
		children = new ArrayList<GroupComponent>();
		groupMembers = new ArrayList<User>();
	}

	@Override
	public void addGroup(GroupComponent c) {
		// TODO Auto-generated method stub
		children.add(c);
	}

	@Override
	public void removeGroup(GroupComponent c) {
		// TODO Auto-generated method stub
		children.remove(c);
	}

	@Override
	public void displayGroup() {
		// TODO Auto-generated method stub

		System.out.println(getName());

		for (GroupComponent c : children) {
			c.displayGroup();
		}
	}
	
	@Override
	public void displayGroupMembers() {
		// TODO Auto-generated method stub
		System.out.println(getName());
		
		for (User u : groupMembers) {
			System.out.println("\n" + u.toString());
		}
	}

	@Override
	public void addMember(User u) {
		// TODO Auto-generated method stub
		groupMembers.add(u);
	}

	@Override
	public void removeMember(User u) {
		// TODO Auto-generated method stub
		groupMembers.remove(u);
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	@Override
	public ArrayList<GroupComponent> searchGroup(String name) {
		// TODO Auto-generated method stub
		ArrayList<GroupComponent> result = new ArrayList<GroupComponent>();

		if (this.getName().contains(name)) {
			result.add(this);
		}
		
		for (GroupComponent c : children) {
			if (!c.searchGroup(name).isEmpty()) {
				result.add(c);
			}
		}
		
		return result;
	}

}
