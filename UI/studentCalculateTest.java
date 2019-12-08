package UI;
/* 
 Author: Jain Nayan
 Built for: SER 515, Professor Findler
Date 12/1/2109
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class studentCalculateTest {

	@Test
	void testStudentCalculate() {
		studentCalculate sctest = new studentCalculate(0);
		assertNotNull(sctest);
	}

}
