package socialnetwork;

public class TestSocialNetwork {
	
	public void populateNetwork(){
		
		SocialNetwork sc = new SocialNetwork("foi");
		User u1 = new User(1, "furkan tanriverdi","furkan@ege.edu","qwE123");
		User u2 = new User(2, "onur cem senel","onur@ege.edu","asD456");
		User u3 = new User(3, "yasin bozbay","yasin@ege.edu","zxC789");
		User u4 = new User(4, "ömer faruk alaca","ömer@ege.edu","rtY123");
		User u5 = new User(5, "amat cahat","amat@ege.edu","fgH456");
		User u6 = new User(6, "taner aydogan","tanerer@ege.edu","vbn789");
		
		
		
		u1.addFriend(u3);
		u1.addFriend(u2);
		u1.addFriend(u6);
		u1.addDependent(new Dependent(3,'b'));
		u1.addInterest("tennis");
		u1.addInterest("snowboard");
		u1.addInterest("fifa");
		
		
		u2.addFriend(u1);
		u2.addFriend(u4);
		
		
		
		sc.getUsers().add(u1);
		sc.getUsers().add(u2);
		sc.getUsers().add(u3);
		
		SharableFactory factory = new SharableFactory();
		
		Command c = new ShareCommand(u1.getWall(), factory.createShaObj("deneme", "text"));
		c.run();

	}
	
}


