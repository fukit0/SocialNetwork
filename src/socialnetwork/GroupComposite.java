package socialnetwork;

import java.util.ArrayList;

public class GroupComposite extends GroupComponent {

	private ArrayList<GroupComponent> children;
	private ArrayList<Integer> groupMembersIds;
	
	public GroupComposite(int id, int adminId, String name) {
		super(id, adminId, name);
		// TODO Auto-generated constructor stub
		children = new ArrayList<GroupComponent>();
		groupMembersIds = new ArrayList<Integer>();
		groupMembersIds.add(adminId);
	}

	protected void setGroupMembersIds(ArrayList<Integer> groupMembersIds) {
		this.groupMembersIds = groupMembersIds;
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
		for (GroupComponent i : children) { //silinecek olan grup alt grup ise
			if (i instanceof GroupComposite) {
				i.removeGroup(c);
			}
		}
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
		
		if (id == -1) //gruplari tutan root arama sonuclarindan cikartiliyor
			match = false;
		
		if (match) {
			for (String s : parts) {
				if (!this.getName().toUpperCase().contains(s)) {
					match = false;
				}
			}
		}
		if (match) {
			result.add(this);
		}
		
		for (GroupComponent c : children) { //alt gruplar araniyor
			for (GroupComponent g : c.searchGroup(name)) {
				result.add(g);
			}
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
		
		for (GroupComponent c : children) { //alt gruplar var ise onlarda da arama yapiliyor
			for (GroupComponent g : c.getUserGroups(userId)) {
				result.add(g);
			}
		}
		
		return result;
		
	}

	@Override
	public GroupComposite convertToComposite() {
		// TODO Auto-generated method stub
		return this;
	}
	
	public boolean hasChild() {
		if (children.isEmpty())
			return false;
		else
			return true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

}
