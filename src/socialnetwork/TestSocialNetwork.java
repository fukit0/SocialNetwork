package socialnetwork;

public class TestSocialNetwork {
	
	public void populateNetwork(){
		
		SocialNetwork sc = SocialNetwork.getSocialNetwork("foi"); //singleton test
		
		User furkan = new User(1, "furkan tanriverdi","furkan@ege.edu","qwE123");
		User onur = new User(2, "onur cem senel","onur@ege.edu","asD456");
		User yasin = new User(3, "yasin bozbay","yasin@ege.edu","zxC789");
		User omer = new User(4, "ömer faruk alaca","ömer@ege.edu","rtY123");
		User ahmet = new User(5, "amat cahat","amat@ege.edu","fgH456");
		User taner = new User(6, "taner aydogan","tanerer@ege.edu","vbn789");
		
		GroupComponent tenisSeverler = new GroupLeaf(1, 1, "tenis severler");
		sc.addGroup(tenisSeverler);
		tenisSeverler.addMember(6);
		
		GroupComponent girisimciler = new GroupLeaf(2, 4, "girişimciler");
		sc.addGroup(girisimciler);
		girisimciler.addMember(2);
		girisimciler.addMember(3);	
		
		furkan.addFriend(yasin);
		yasin.addFriend(furkan);
		
		furkan.addFriend(onur);
		onur.addFriend(furkan);
		
		furkan.addFriend(taner);
		taner.addFriend(furkan);
		
		furkan.addDependent(new Dependent(3,'b'));
		furkan.addInterest("tennis");
		furkan.addInterest("snowboard");
		furkan.addInterest("fifa");
			
		onur.addFriend(furkan);
		furkan.addFriend(onur);
		
		onur.addFriend(omer);
		omer.addFriend(onur);
			
		omer.addFriend(ahmet);
		ahmet.addFriend(omer);
		
		omer.addFriend(taner);
		taner.addFriend(omer);
		
		omer.addInterest("fifa");
		
		ahmet.addInterest("fifa");
		
		taner.addInterest("tennis");
		taner.addInterest("fifa");
		
		sc.getUsers().add(furkan);
		sc.getUsers().add(onur);
		sc.getUsers().add(yasin);
		sc.getUsers().add(omer);
		sc.getUsers().add(ahmet);
		sc.getUsers().add(taner);
		
		SharableFactory factory = new SharableFactory();
		
		Command c = new ShareCommand(furkan.getWall(), factory.createShaObj("today is zaman", "text"));
		c.run();
		
		c = new ShareCommand(yasin.getWall(), factory.createShaObj("magic break \n iletisim", "text"));
		c.run();
		
		c = new ShareCommand(onur.getWall(), factory.createShaObj("kerem kusmezer: bit.ly/3487df", "link"));
		c.run();

	}
	
}


