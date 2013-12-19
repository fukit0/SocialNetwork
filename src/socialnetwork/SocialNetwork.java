package socialnetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class SocialNetwork {
	
	//class variables
	private String name; 
	private static int userId;
	private ArrayList<User> users;
	private int activeUserId;
	private static SocialNetwork _instance;
	
	
	//constructor
	public SocialNetwork(String name)
	{
		this.name=name;
		userId = 0;
		users = new ArrayList<User>();
		activeUserId=-999;
	}
	
	
	 public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<User> getUsers() {
		return users;
	}


	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public int getActiveUserId() {
		return activeUserId;
	}


	public void setActiveUserId(int activeUserId) {
		this.activeUserId = activeUserId;
	}


	public static SocialNetwork getSocialNetwork(String name)
	    {
		 	// burada daha önce yaratılmış mı bakıyoruz. yaratılmamışsa yeni yaratıp döndürüyoruz.
	          if (_instance == null)
	          {
	            _instance = new SocialNetwork(name);
	          }
	        
	      return _instance;
	    }
	
	public int signUp()
	{
		userId++;
		
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		User u = new User();
		
		u.setUserId(userId);
		try{
		System.out.print("Your name and surname: ");
		u.setName(bufferRead.readLine());
		
		System.out.print("E-mail: ");
		u.setEmail(bufferRead.readLine());
		
		System.out.print("Password: ");
		u.setPass(bufferRead.readLine());
		}catch(IOException e){
			System.out.println("Hata Oluştu!");
		}
		
		
		users.add(u);
		
		activeUserId=u.getUserId();
		return u.getUserId();
		
	}
	
	public int signIn(){
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		String email="";
		String pass="";
		
		try{
		System.out.print("E-mail: ");
		email=bufferRead.readLine();
		
		System.out.print("Password ");
		pass=bufferRead.readLine();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Hata Oluştu!");
		}
		
		
		
		/*Iterator<User> i = users.iterator();
		while(i.hasNext())
		{
			try {
				if (i.next().getEmail().equals(email) && i.next().getPass().equals(pass)) {
					activeUserId = i.next().getUserId();
					return i.next().getUserId();
				}
			} catch (NoSuchElementException e) {
				// TODO: handle exception
				return -1;
			}
		}*/
		
		for (User u : users) {
			if (u.getEmail().equals(email) && u.getPass().equals(pass)) {
				activeUserId = u.getUserId();
				return u.getUserId();
			}
		}
			
		return -1;
	}	
	
	public void searchFriend() {
		
		ArrayList<User> searchResult = new ArrayList<>();
		
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Name & Surname: ");
		String name="";
		try {
			name = bufferRead.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Hata Oluştu!");
		}
		
		User activeUser = findUserById(activeUserId);
		
		//önce arkadaşlar arasında aranıyor
		for (User u : activeUser.getFriends()) {
			if (u.isVisible() && u.getName().contains(name)) {
				searchResult.add(u);
			}
		}
		
		//daha sonra tüm sosyal ağ aranıyor
		for (User u : users) {
			if (!activeUser.isFriend(u.getUserId()) && u.isVisible() && u.getName().contains(name)) {
				searchResult.add(u);
			}
		}

		//sonuçlar listeleniyor
		int i = 1;
		for (User u : searchResult) {
			
			// arkadaşı olanlar belirtilsin, ortak ilgiler yazsın
			System.out.println(i + ". " + u.getName() + " - " + u.getInterests());
			i++;
		}
		
		System.out.println("Please choose a person you want to interact:");
		int choice=0;
		try {
			 choice = Integer.parseInt(bufferRead.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		if(activeUser.isFriend(searchResult.get(choice-1).getUserId()))
		{
		    System.out.print(searchResult.get(choice-1).toString());
		    
		}
		else
		{
			System.out.println(searchResult.get(choice-1).getName()
					+ " is not your friend.Do you want to add as a friend him/her?(yes/no) :");
			try {
				if(bufferRead.readLine().equals("yes"))
				{
					activeUser.addFriend(searchResult.get(choice-1));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	public User findUserById(int id) {
		for (User u : users) {
			if (u.getUserId() == id)
				return u;
		}
		
		return null;
	}
	
	
}
