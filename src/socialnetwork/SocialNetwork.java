package socialnetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SocialNetwork {

	//class variables
	private String name; 
	private static int userId;
	private static int groupId;
	private ArrayList<User> users;
	private GroupComposite groupRoot;
	private int activeUserId;
	private static SocialNetwork _instance;


	//constructor
	public SocialNetwork(String name)
	{
		this.name=name;
		userId = 0;
		groupId = 0;
		users = new ArrayList<User>();
		groupRoot = new GroupComposite(0, -999, "Groups");
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
		String input="";

		u.setUserId(userId);
		try{
			System.out.print("\nYour name and surname: ");
			u.setName(bufferRead.readLine());

			System.out.print("E-mail: ");
			input=bufferRead.readLine();
			
			if(input.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))
			{				
				u.setEmail(input);
			}else{
				throw new IOException("Please enter valid email!");
			}
	
			System.out.print("Password: ");
			input=bufferRead.readLine();
			
			if(input.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})"))
			{			
				u.setPass(input);
			}else{
				throw new IOException("Please enter valid password!");
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
			return -1;
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
			System.out.print("\nE-mail: ");
			email=bufferRead.readLine();
			
			System.out.print("Password ");
			pass=bufferRead.readLine();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid input!");
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

		System.out.println("\nName & Surname: ");
		String name="";
		try {
			name = bufferRead.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid input!");
		}

		User activeUser = findUserById(activeUserId);

		String[] parts = name.toUpperCase().split(" ");

		//önce arkadaşlar arasında aranıyor
		for (User u : activeUser.getFriends()) {
			boolean match = true;
			if (u.isVisible()) {
				for (String s : parts) {
					if (!u.getName().toUpperCase().contains(s)) {
						match = false;
					}
				}
				if (match) {
					searchResult.add(u);
				}
			}
		}

		//daha sonra tüm sosyal ağ aranıyor
		for (User u : users) {
			boolean match = true;
			if (!activeUser.isFriend(u.getUserId()) && u.isVisible()) {
				for (String s : parts) {
					if (!u.getName().toUpperCase().contains(s)) {
						match = false;
					}
				}
				if (match) {
					searchResult.add(u);
				}
			}
		}

		if (!searchResult.isEmpty()) {
			//sonuçlar listeleniyor
			int i = 1;
			String dep;
			for (User u : searchResult) {
				dep="";

				// arkadaşı olanlar belirtilsin, ortak ilgiler ve gruplar yazsın
				ArrayList<String> commonInterests = new ArrayList<String>();

				for(String sAct : findUserById(activeUserId).getInterests())
				{
					String[] interests = sAct.toUpperCase().split(" ");
					for(String s : u.getInterests() )
					{
						for (String interest : interests) {
							if (s.toUpperCase().contains(interest)){
								commonInterests.add(interest);}
						}// ortak gruplar ve arkadaşlar
					}
				}
				for(Dependent d : activeUser.getDependents())
				{
					if(d.getId()==u.getUserId()) {
						dep=d.getDependency();
						break;
					}
				}

				System.out.println(i + ". " + u.getName() + dep +" - " + commonInterests.toString());
				i++;
			}

			System.out.println(i + ". Cancel");

			System.out.println("\nPlease choose a person you want to interact:");
			int choice=0;
			try {
				choice = Integer.parseInt(bufferRead.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid input!");
			}


			if(choice<i && choice>0)
			{	
				//arkadaşı ise bilgilerini yazdırıyor
				int otherId = searchResult.get(choice-1).getUserId();
				User otherUser = searchResult.get(choice-1);
				if(activeUser.isFriend(otherId))
				{
					System.out.println(otherUser.toString()+"\n\n\n\n");
					System.out.println("\n1.Unfriend \n"+
									   "2.Back");
								//"3.Send a Message");
					int c=0;
					try {
						 c = Integer.parseInt(bufferRead.readLine());
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(c==1)
					{
						if(activeUser.isDependent(otherId))
						{
							activeUser.deleteDependent(otherId);
							activeUser.deleteFriend(otherUser);
						}
						activeUser.deleteFriend(otherUser);
					}
					
					
				}
				//değil ise ekleyebilme seçeneği aktif hale getiriliyor
				else
				{
					System.out.println("\n" + otherUser.getName()
							+ " is not your friend.Do you want to add as a friend him/her?(yes/no) :");
					try {

						if(bufferRead.readLine().equals("yes"))
						{
							activeUser.addFriend(otherUser);
							//gecici cozum!!!
							otherUser.addFriend(activeUser);

							System.out.println("\nDo you want to add this person as a dependent?(yes/no) ["+searchResult.get(choice-1).getName()+"]");
							try {
								if(bufferRead.readLine().equals("yes"))
								{
									System.out.println("as a father press 'f'\n" +
											"as a mother press 'm'\n" +
											"as a son press 's'\n" +
											"as a daughter press 'd'\n" +
											"as a sister/brother press 'b'\n" +
											"as a aunt press 'a'\n" +
											"as a uncle press 'u'\n" +
											"as a wife press 'w'\n" +
											"as a husband press 'h'\n");
									Dependent d = new Dependent(otherId,bufferRead.readLine().charAt(0));
									activeUser.addDependent(d);
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.out.println("Invalid input!");
							}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Invalid input!");
					}

				}
			}

		} else {
			System.out.println("User not found");
		}

	}

	public void share(){
		//file name error

		int choseType=0;
		do{
			System.out.println("\nWhich type of file do you like to post on your wall?\n"
							  +"1.Text\n"
							  +"2.Link\n"
							  +"3.Media\n"
							  +"4.Back");

			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

			try {
				choseType = Integer.parseInt(bufferRead.readLine());
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid input!");
			}
			
			String typeOfFile = "";
			switch (choseType){
			case 1: typeOfFile="text";break;
			case 2: typeOfFile="link";break;
			case 3: typeOfFile="media";break;

			}
			
			if(choseType!=4)
			{
				System.out.print("\nType your file name:");
				String fileName="";
				try {
					fileName = bufferRead.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid input!");
				}

				SharableFactory factory = new SharableFactory();

				Command c = new ShareCommand(findUserById(activeUserId).getWall(), factory.createShaObj(fileName, typeOfFile));
				c.run();

			}

		}while(choseType!=4);
	}

	public User findUserById(int id) {
		for (User u : users) {
			if (u.getUserId() == id)
				return u;
		}

		return null;
	}


	public void interests() {
		// TODO Auto-generated method stub

		int index=1;
		for(String i : findUserById(activeUserId).getInterests())
		{
			System.out.println(index+". "+i);
			index++;
		}
		int choice = 0;
		do{
			System.out.println("\n1.Add new interests\n"+					
							   "2.Delete old one\n"+
					           "3.Back");
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

			try {
				choice = Integer.parseInt(bufferRead.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid input!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid input!");
			}

			switch(choice){
				case 1:
					System.out.println("\nType your new interest");
					String interest="";
					try {
						interest = bufferRead.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Invalid input!");
					}
					
					findUserById(activeUserId).addInterest(interest);
					break;
					
				case 2:
					System.out.println("\nEnter index of interest that you want to delete:");
					int input = 0;
					try {
						input = Integer.parseInt(bufferRead.readLine());
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						System.out.println("Invalid input!");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Invalid input!");
					}
					
					findUserById(activeUserId).deleteInterest(input-1);
					break;
					
			}
			
		}while(choice!=3);
		
	}
	
	public void groups() {
		
		System.out.println("\nGroups that I joined:");
		groupRoot.listUserGroups(activeUserId); //kullanicinin katildigi gruplar listeleniyor
		
		int choice = 0;
		do{
			System.out.println("\n1.Create new group\n"+					
							   "2.Search groups\n"+
							   "3.Back");
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

			try {
				choice = Integer.parseInt(bufferRead.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid input!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid input!");
			}

			switch(choice){
				case 1: //yeni grup ekleme
					System.out.println("\nType your group name");
					String name="";
					try {
						name = bufferRead.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Invalid input!");
					}
	
					groupId++;
					//grubun suanda alt grubu olmadigi icin leaf olarak yaratildi
					//grubu kuran kisi grubun yöneticisi olarak ataniyor
					GroupLeaf group = new GroupLeaf(groupId, activeUserId, name);
					addGroup(group); //sosyal agdaki gruplarin icine ekleniyor
	
					break;
	
				case 2: //grup arama
					System.out.println("\nGroup name:");
					String groupName="";
					try {
						groupName = bufferRead.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Invalid input!");
					}
	
					//gruplari arayan metot
					ArrayList<GroupComponent> result = groupRoot.searchGroup(groupName);
					int index = 0;
					for (GroupComponent c : result) {
						index++;
						System.out.println(index + ". " + c.getName());
					}
	
					if (!result.isEmpty()) {
						System.out.println("\nEnter index of group that you want to choose:");
						int input = 0;
						try {
							input = Integer.parseInt(bufferRead.readLine());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Invalid input!");
						}
		
						GroupComponent selectedGroup = result.get(input-1);
		
						boolean admin = false;
						boolean alreadyJoined = false;
						if (selectedGroup.getAdminId() == activeUserId) { //aktif kullanici grubun kurucusu ise
							admin = true;
							System.out.println("\n1.Delete the group\n"+
											   "2.Add subgroup\n"+
											   "3.Back");
						} else {
							if (selectedGroup.searchMember(activeUserId)) { //aktif kullanici bu gruba daha onceden katilmis ise
								alreadyJoined = true;
								System.out.println("\n1.Leave from group\n"+
												   "2.Add subgroup\n"+
										   		   "3.Back");
							} else {
								System.out.println("\n1.Join the group\n"+
												   "2.Add subgroup\n"+
								   		   		   "3.Back");
							}
						}
						
						try {
							input = Integer.parseInt(bufferRead.readLine());
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							System.out.println("Invalid input!");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Invalid input!");
						}
						
						switch (input) { //secilen grupla hangi islemin yapilacagi belirleniyor
							case 1: //grubu silme, gruba katilma, gruptan cikma
								if (admin) {
									removeGroup(selectedGroup);							
								} else if (alreadyJoined) {
									selectedGroup.removeMember(activeUserId);
								} else {
									selectedGroup.addMember(activeUserId);
								}
								break;
								
							case 2: //alt grup ekleme
								System.out.println("\nGroup name:");
								groupName="";
								try {
									groupName = bufferRead.readLine();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
												
								//alt grup eklenecegi icin daha onceden leaf olarak eklenen grup composite yapiliyor
								GroupComposite cloned = selectedGroup.convertToComposite();
								
								//leaf olan eski grup siliniyor
								removeGroup(selectedGroup);
								
								//composite olan yeni gruba alt grubu ekleniyor
								cloned.addGroup(new GroupLeaf(groupId, activeUserId, selectedGroup.getName() + " -> " + groupName));
								
								//yeni grup alt grubuyla beraber sosyal aga ekleniyor
								addGroup(cloned);
								
								break;

							default:
								break;
						}
					} else {
						System.out.println("Group not found");
					}
					
				default:
					break;
			}
			
		}while(choice!=3);

	}

	public void addGroup(GroupComponent c) {
		//c.addMember(activeUserId);
		groupRoot.addGroup(c);
	}

	public void removeGroup(GroupComponent c) {
		groupRoot.removeGroup(c);
	}

	public void displayAllGroups() {
		groupRoot.displayGroup();
	}

	public void displayGroupMembers(GroupComponent c) {
		c.displayGroupMembers();
	}

	public void viewProfile() {
		// TODO Auto-generated method stub
		System.out.println(findUserById(activeUserId).toString());
	}

}
