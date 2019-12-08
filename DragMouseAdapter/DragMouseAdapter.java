package DragMouseAdapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
//import javax.swing.JComponent;
import javax.swing.TransferHandler;
/***
 * 
 * @author MayankASU
 * date create - 10/14/2019
 * date modified - 10/14/2019
 */
public class DragMouseAdapter extends MouseAdapter {
	public void mouseDragged(MouseEvent e) {
		JButton button = (JButton)e.getSource();
		TransferHandler handler	 = button.getTransferHandler();
		handler.exportAsDrag(button, e, TransferHandler.COPY);
	}
}
