package View;

import java.awt.event.ActionEvent;
import java.util.EventListener;

public interface NavigationListener extends EventListener {

    /**
     * Invoked when an action occurs.
     */
    public void onBackButtonClicked(ActionEvent e);

}