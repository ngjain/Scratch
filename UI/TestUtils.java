/*
 * TestUtils
 Author: Jain Nayan
 Derived From: Ichiro Suzuki
 Built for: SER 515, Professor Findler
 This piece of code has been derived from 
 https://www.javaworld.com/article/2073056/automate-gui-tests-for-swing-applications.html?page=2
 It includes some test functionalities that are beyond the scope of this project.
*/
package UI;

import java.awt.*;
import javax.swing.*;

public class TestUtils {

	static int counter;

	public static Component getChildNamed(Component parent, String name) {

		if (name.equals(parent.getName())) { return parent; }

		if (parent instanceof Container) {
			Component[] children = (parent instanceof JMenu) ?
					((JMenu)parent).getMenuComponents() :
					((Container)parent).getComponents();

			for (int i = 0; i < children.length; ++i) {
				Component child = getChildNamed(children[i], name);
				if (child != null) { return child; }
			}
		}
		
		return null;
	}

	}


