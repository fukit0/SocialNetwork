package socialnetwork;

import java.util.ArrayList;

public class GroupLeaf extends GroupComponent {

	private int admin;
	private ArrayList<User> groupMembers;
	
	public GroupLeaf(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
		groupMembers = new ArrayList<User>();
	}

	@Override
	public void addGroup(GroupComponent c) {
		// TODO Auto-generated method stub
		System.out.println("Cannot add to a leaf");
	}

	@Override
	public void removeGroup(GroupComponent c) {
		// TODO Auto-generated method stub
		System.out.println("Cannot remove from a leaf");
	}

	@Override
	public void displayGroup() {
		// TODO Auto-generated method stub
		System.out.println(getName());
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
		
		return result;
		
	}

}
