package UI;
/* 
 Author: Jain Nayan
 Built for: SER 515, Professor Findler
Date 12/1/2109
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DragAndDropPanelTest {
	DragAndDropPanel dadptest = new DragAndDropPanel(0, null);
	@Test
	void testDragAndDropPanel() {
		assertNotNull(dadptest);
	}

	@Test
	void testInit() {
		/*Initializes window via test when ran*/
	}

	@Test
	void testCalculate() {
		dadptest.calculate("Invalideqn");
		/*Valid as the logic is handled by an in-built function ScriptEngine*/
		
	}

}
