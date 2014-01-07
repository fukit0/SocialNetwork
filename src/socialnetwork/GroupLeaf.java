package socialnetwork;

import java.util.ArrayList;

public class GroupLeaf extends GroupComponent {

	private ArrayList<Integer> groupMembersIds;
	
	public GroupLeaf(int id, int adminId, String name) {
		super(id, adminId, name);
		// TODO Auto-generated constructor stub
		groupMembersIds = new ArrayList<Integer>();
		groupMembersIds.add(adminId);
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
		
		for (int i : groupMembersIds) {
			System.out.println("\n" + i);
		}
	}

	@Override
	public void addMember(int userId) {
		// TODO Auto-generated method stub
		groupMembersIds.add(userId);
	}

	@Override
	public void removeMember(int userId) {
		// TODO Auto-generated method stub
		groupMembersIds.remove(new Integer(userId));
	}

	@Override
	public ArrayList<GroupComponent> searchGroup(String name) {
		// TODO Auto-generated method stub
		ArrayList<GroupComponent> result = new ArrayList<GroupComponent>();
		String[] parts = name.toUpperCase().split(" ");
		boolean match = true;
		
		for (String s : parts) {
			if (!this.getName().toUpperCase().contains(s)) {
				match = false;
			}
		}
		if (match) {
			result.add(this);
		}
		
		return result;
		
	}
	
	@Override
	public boolean searchMember(int userId) {
		// TODO Auto-generated method stub
		
		for (int i : groupMembersIds) {
			if (i == userId)
				return true;
		}
		
		return false;
	}

	@Override
	public ArrayList<GroupComponent> getUserGroups(int userId) {
		// TODO Auto-generated method stub
		ArrayList<GroupComponent> result = new ArrayList<GroupComponent>();
		
		for (int i : groupMembersIds) {
			if (i == userId) {
				//System.out.println(name);
				result.add(this);
				break;
			}
		}
		
		return result;
		
	}
	
	@Override
	public GroupComposite convertToComposite() { //leaf uyeleriyle birlikte composite yapiliyor
		GroupComposite composite = new GroupComposite(id, adminId, name);
		composite.setGroupMembersIds(groupMembersIds);
		
		return composite;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

}
