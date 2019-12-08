package UI;
/* 
 Author: Jain Nayan
 Built for: SER 515, Professor Findler
Date 12/1/2109
*/
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

class mainPageTest {

	@Test
	void testMain() {
		/*main*/
	}

	@Test
	void testCheckStudent() {
		/*Database connection*/
	}

	@Test
	void testCheckTeacher() {
		/*Database Connection*/
	}

	@Test
	void testMainPage() {
		mainPage mainpagetest = new mainPage();
		assertNotNull(mainpagetest);
		JTextField username = (JTextField)TestUtils.getChildNamed(mainpagetest, "mainpage");
		assertNotNull(username);
	}

}
