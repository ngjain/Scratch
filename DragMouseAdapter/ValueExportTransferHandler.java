package DragMouseAdapter;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

import UI.DragAndDropPanel;
/***
 * 
 * @author MayankASU
 * date create - 10/15/2019
 * date modified - 11/15/2019
 */
@SuppressWarnings("serial")
public class ValueExportTransferHandler extends TransferHandler{

        public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
        private String value;
        private DragAndDropPanel dragPanel;

        public ValueExportTransferHandler(String value, DragAndDropPanel dragPanel) {
            this.value = value;
            this.dragPanel = dragPanel;
        }

        public String getValue() {
            return value;
        }

        @Override
        public int getSourceActions(JComponent c) {
            return DnDConstants.ACTION_COPY_OR_MOVE;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            Transferable t = new StringSelection(getValue());
            return t;
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            super.exportDone(source, data, action);
            // Decide what to do after the drop has been accepted
            String eqn = dragPanel.text.getText();
            dragPanel.calculate(eqn);
        }

    }

