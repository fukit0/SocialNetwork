package socialnetwork;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SocialNetwork sc = SocialNetwork.getSocialNetwork("F.O.I.net");

		new TestSocialNetwork().populateNetwork();
		
		int choice;
		do{
			choice = new MainMenu().show();
			
			int id = -1;
			switch(choice){
				case 1:
					do{					    	
						id = sc.signUp();
					}while(id == -1);
					break;
				case 2:
					do{				
						id = sc.signIn();
						if (id == -1) {
							System.out.println("\nWrong e-mail or password! Press 1 to go back.");			
						}
					}while(id == -1);
					break;
				case 3: 
					System.exit(0);
					break;
			}
			
			if(id != -1 && id != -2)
			{
				int choice2;
				do
				{
					choice2 = new UserMenu().show();
					if(choice2==1)
						sc.searchFriend();
					if(choice2==2)
						sc.share(null); //kullanicinin duvarinda paylasilacagi icin null gonderiliyor
					if(choice2==3)
						sc.interests();
					if(choice2==4)
						sc.groups();
					if(choice2==5)
						sc.viewProfile();
					
				}while(choice2!=6);
			}
			
		}while(choice!=3);	
	}

}
