package controller;

import entities.Usuarioxpersona;
import facade.UsuarioxpersonaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usuarioxpersonaController")
@ViewScoped
public class UsuarioxpersonaController extends AbstractController<Usuarioxpersona> {

    @Inject
    private PersonaController personaController;
    @Inject
    private UsuarioController usuarioController;

    public UsuarioxpersonaController() {
        // Inform the Abstract parent controller of the concrete Usuarioxpersona Entity
        super(Usuarioxpersona.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        personaController.setSelected(null);
        usuarioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Persona controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePersona(ActionEvent event) {
        Usuarioxpersona selected = this.getSelected();
        if (selected != null && personaController.getSelected() == null) {
            personaController.setSelected(selected.getPersona());
        }
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUsuario(ActionEvent event) {
        Usuarioxpersona selected = this.getSelected();
        if (selected != null && usuarioController.getSelected() == null) {
            usuarioController.setSelected(selected.getUsuario());
        }
    }

}
