package socialnetwork;

import static org.junit.Assert.*;

import org.junit.Test;

public class SignUpTest {

	String emailRegex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	String passRegex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";
	
	/*
	 (			# Start of group
  (?=.*\d)		#   must contains one digit from 0-9
  (?=.*[a-z])		#   must contains one lowercase characters
  (?=.*[A-Z])		#   must contains one uppercase characters
              .		#     match anything with previous condition checking
                {6,20}	#        length at least 6 characters and maximum of 20	
	  )			# End of group
	*/
	
	String email = "username@mail.ege.edu.tr";
	String password = "abC145";
	
	@Test
	public void testEMail() {
		assertTrue(email.matches(emailRegex));
	}
	
	@Test
	public void testPass() {
		assertTrue(password.matches(passRegex));
	}

}
