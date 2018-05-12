package projlabController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainController.getInstance().switchToMain();
    }
}
