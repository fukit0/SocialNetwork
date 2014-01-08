package socialnetwork;

public class TestSocialNetwork {
	
	public void populateNetwork(){
		
		SocialNetwork sc = SocialNetwork.getSocialNetwork("foi"); //singleton test
		
		User furkan = new User(101, "Furkan Tanriverdi", "furkan@ege.edu", "qwE123");
		User onur = new User(102, "Onur Cem Senel", "onur@ege.edu", "asD456");
		User yasin = new User(103, "Yasin Bozbay", "yasin@ege.edu", "zxC789");
		User omer = new User(104, "Omer Faruk Alaca", "omer@ege.edu", "rtY123");
		User ahmet = new User(105, "Ahmet Cahit Yasa", "ahmet@ege.edu", "fgH456");
		User taner = new User(106, "Taner Aydogan", "taner@ege.edu", "vbN789");
		
		GroupComponent tenisSeverler = new GroupLeaf(101, 101, "Tenis Severler");
		tenisSeverler.addMember(106);
		sc.addGroup(tenisSeverler);
		
		GroupComponent girisimciler = new GroupComposite(102, 104, "Girisimciler");
		girisimciler.addGroup(new GroupLeaf(103, 102, "Girisimciler -> Ege Universitesi Girisimcilik Toplulugu"));
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
		furkan.addInterest("Tennis");
		furkan.addInterest("Snowboard");
		furkan.addInterest("Fifa");
				
		omer.addInterest("Fifa");
		
		ahmet.addInterest("Fifa");
		
		taner.addInterest("Tennis");
		taner.addInterest("Fifa");
		
		sc.getUsers().add(furkan);
		sc.getUsers().add(onur);
		sc.getUsers().add(yasin);
		sc.getUsers().add(omer);
		sc.getUsers().add(ahmet);
		sc.getUsers().add(taner);
		
		SharableFactory factory = new SharableFactory();
		
		Command c = new ShareCommand(furkan.getWall(), factory.createShaObj("Today is Zaman", "text"));
		c.run();
		
		c = new ShareCommand(yasin.getWall(), factory.createShaObj("Magic Break \n Iletisim: 0123 456 78 90", "text"));
		c.run();
		
		c = new ShareCommand(onur.getWall(), factory.createShaObj("OOP ders notlari: bit.ly/3487df", "link"));
		c.run();
		
		c = new ShareCommand(girisimciler.getWall(), factory.createShaObj(onur.getName() + " - Seminer: 07.01.2014 Ege Universitesi", "text"));
		c.run();

	}
	
}


