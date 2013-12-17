package socialnetwork;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SocialNetwork sc = new SocialNetwork("foi");
		User u1 = new User(-1, "furkan tanriverdi","furkan@gmail","123");
		User u2 = new User(-2, "onur cem senel","onur@gmail","456");
		User u3 = new User(-3, "yasin bozbay","yasin@gmail","789");
		
		sc.getUsers().add(u1);
		sc.getUsers().add(u2);
		sc.getUsers().add(u3);
		
		SharableFactory factory = new SharableFactory();
		
		Command c = new ShareCommand(u1.getWall(), factory.createShaObj("deneme", "text"));
		c.run();
		
		System.out.print(u1.toString());
		
		
		int choice= new MainMenu().show();
		
		int id=0;
		switch(choice){
			case 1:
				    id=sc.signUp();
					break;
			case 2:					id=sc.signIn(); 
					break;
		}
		
		if(id!=-1)
		{
			int choice2 = new UserMenu().show();
			if(choice2==1)
				sc.searchFriend();
			
		}
		
	}

	
}
