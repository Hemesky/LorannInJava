package view;

import controller.IOrderPerformer;
import model.IMobile;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IViewFacade {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);
    
    void OpenGateMAJ();
    void PowerSpawn(IMobile power);
    void setOrderPerformer(IOrderPerformer orderPerfomer);
    
    
}
