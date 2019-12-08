package UI;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

class teacherInputTest  {
	teacherInput teacherinputtest = new teacherInput();
	
	@Test
	void testConstructor() {
		assertNotNull(teacherinputtest);
	}
	

	@Test
	void testGetTotalQA() {
		/*Database access*/
	}

	@Test
	void testTeacherInput() {
		 JTextField input = (JTextField)TestUtils.getChildNamed(teacherinputtest, "AnswerText");       
		 assertNull(input);
	}


}
