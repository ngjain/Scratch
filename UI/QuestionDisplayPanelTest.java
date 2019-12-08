package UI;
/* 
 Author: Jain Nayan
 Built for: SER 515, Professor Findler
Date 12/1/2109
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuestionDisplayPanelTest {
	QuestionDisplayPanel qdp = new QuestionDisplayPanel(null, null);

	@Test
	void Constructor() {
		assertNotNull(qdp);

	}
	@Test
	void testQuestionDisplayPanel() {
		/*Test out of scope*/
	}

	@Test
	void testSortbyColumn() {
		Object[][] arr = {
	            {1, 2, 3},
	            {10}
	        };;
		QuestionDisplayPanel.sortbyColumn(arr, 1);
		
	}

}
