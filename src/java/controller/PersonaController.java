package controller;

import entities.Persona;
import entities.Usuarioxpersona;
import java.util.List;
import facade.PersonaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "personaController")
@ViewScoped
public class PersonaController extends AbstractController<Persona> {

    @Inject
    private CiudadController ciudadController;
    @Inject
    private TipodocumentoController tipoDocumentoController;

    // Flags to indicate if child collections are empty
    private boolean isUsuarioxpersonaListEmpty;

    public PersonaController() {
        // Inform the Abstract parent controller of the concrete Persona Entity
        super(Persona.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        ciudadController.setSelected(null);
        tipoDocumentoController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsUsuarioxpersonaListEmpty();
    }

    /**
     * Sets the "selected" attribute of the Ciudad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCiudad(ActionEvent event) {
        Persona selected = this.getSelected();
        if (selected != null && ciudadController.getSelected() == null) {
            ciudadController.setSelected(selected.getCiudad());
        }
    }

    /**
     * Sets the "selected" attribute of the Tipodocumento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoDocumento(ActionEvent event) {
        Persona selected = this.getSelected();
        if (selected != null && tipoDocumentoController.getSelected() == null) {
            tipoDocumentoController.setSelected(selected.getTipoDocumento());
        }
    }

    public boolean getIsUsuarioxpersonaListEmpty() {
        return this.isUsuarioxpersonaListEmpty;
    }

    private void setIsUsuarioxpersonaListEmpty() {
        Persona selected = this.getSelected();
        if (selected != null) {
            PersonaFacade ejbFacade = (PersonaFacade) this.getFacade();
            this.isUsuarioxpersonaListEmpty = ejbFacade.isUsuarioxpersonaListEmpty(selected);
        } else {
            this.isUsuarioxpersonaListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Usuarioxpersona entities
     * that are retrieved from Persona and returns the navigation outcome.
     *
     * @return navigation outcome for Usuarioxpersona page
     */
    public String navigateUsuarioxpersonaList() {
        Persona selected = this.getSelected();
        if (selected != null) {
            PersonaFacade ejbFacade = (PersonaFacade) this.getFacade();
            List<Usuarioxpersona> selectedUsuarioxpersonaList = ejbFacade.findUsuarioxpersonaList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuarioxpersona_items", selectedUsuarioxpersonaList);
        }
        return "/app/usuarioxpersona/index";
    }

}
