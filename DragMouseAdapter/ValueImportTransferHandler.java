package DragMouseAdapter;

import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

//import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.TransferHandler;
/***
 * 
 * @author hzhan193, MayankASU
 * date create - 10/15/2019
 * date modified - 10/15/2019
 */
@SuppressWarnings("serial")
public class ValueImportTransferHandler extends TransferHandler{
	
	public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
	
	public ValueImportTransferHandler() {
		}
	
	@Override
    public boolean canImport(TransferHandler.TransferSupport support) {
        return support.isDataFlavorSupported(SUPPORTED_DATE_FLAVOR);
    }
	
	 @Override
     public boolean importData(TransferHandler.TransferSupport support) {
         boolean accept = false;
         if (canImport(support)) {
             try {
                 Transferable t = support.getTransferable();
                 Object value = t.getTransferData(SUPPORTED_DATE_FLAVOR);
                 if (value instanceof String) {
                     Component component = support.getComponent();
                     if (component instanceof JLabel) {
                         ((JLabel) component).setText(value.toString());
                         accept = true;
                     }
                 }
             } catch (Exception exp) {
                 exp.printStackTrace();
             }
         }
         return accept;
     }
 }

