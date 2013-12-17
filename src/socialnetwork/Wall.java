package socialnetwork;

import java.util.ArrayList;

//Receiver class
public class Wall {
	
	private ArrayList<SharableObject> shares;
	
	public Wall()
	{
		shares = new ArrayList<SharableObject>();	
	}
	
	public ArrayList<SharableObject> getShares() {
		return shares;
	}

	public void setShares(ArrayList<SharableObject> shares) {
		this.shares = shares;
	}

	public void share(SharableObject so)
	{
		shares.add(so);
	}
	
	public String toString()
	{
		String list="";
		
		for(SharableObject o : shares )
			list+=o.getData()+"\n";
		
		return list;
	}
}
