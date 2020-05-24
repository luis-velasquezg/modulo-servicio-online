package controller;

import entities.Redencionmillas;
import facade.RedencionmillasFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "redencionmillasController")
@ViewScoped
public class RedencionmillasController extends AbstractController<Redencionmillas> {

    @Inject
    private UsuarioController usuarioRedimeController;

    public RedencionmillasController() {
        // Inform the Abstract parent controller of the concrete Redencionmillas Entity
        super(Redencionmillas.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        usuarioRedimeController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUsuarioRedime(ActionEvent event) {
        Redencionmillas selected = this.getSelected();
        if (selected != null && usuarioRedimeController.getSelected() == null) {
            usuarioRedimeController.setSelected(selected.getUsuarioRedime());
        }
    }

}
