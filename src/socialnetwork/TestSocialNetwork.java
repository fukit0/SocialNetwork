package socialnetwork;

public class TestSocialNetwork {
	
	public void populateNetwork(){
		
		SocialNetwork sc = SocialNetwork.getSocialNetwork("foi"); //singleton test
		
		User furkan = new User(101, "furkan tanriverdi","furkan@ege.edu","qwE123");
		User onur = new User(102, "onur cem senel","onur@ege.edu","asD456");
		User yasin = new User(103, "yasin bozbay","yasin@ege.edu","zxC789");
		User omer = new User(104, "ömer faruk alaca","omer@ege.edu","rtY123");
		User ahmet = new User(105, "amat cahat","amat@ege.edu","fgH456");
		User taner = new User(106, "taner aydogan","tanerer@ege.edu","vbN789");
		
		GroupComponent tenisSeverler = new GroupLeaf(101, 101, "tenis severler");
		tenisSeverler.addMember(106);
		sc.addGroup(tenisSeverler);
		
		GroupComponent girisimciler = new GroupLeaf(102, 104, "giriþimciler");
		girisimciler.addMember(102);
		girisimciler.addMember(103);
		sc.addGroup(girisimciler);
		
		furkan.addFriend(yasin);
		yasin.addFriend(furkan);
		
		furkan.addFriend(onur);
		onur.addFriend(furkan);
		
		furkan.addFriend(taner);
		taner.addFriend(furkan);
		
		onur.addFriend(omer);
		omer.addFriend(onur);
			
		omer.addFriend(ahmet);
		ahmet.addFriend(omer);
		
		omer.addFriend(taner);
		taner.addFriend(omer);
		
		furkan.addDependent(new Dependent(103,'b'));
		furkan.addInterest("tennis");
		furkan.addInterest("snowboard");
		furkan.addInterest("fifa");
				
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
		
		c = new ShareCommand(girisimciler.getWall(), factory.createShaObj(onur.getName() + " - etkinlik: 07.01.2014 Ege Üniversitesi", "text"));
		c.run();

	}
	
}


