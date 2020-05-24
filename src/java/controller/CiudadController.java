package controller;

import entities.Ciudad;
import entities.Persona;
import entities.Aeropuertos;
import entities.Vuelo;
import entities.Vuelo;
import java.util.List;
import facade.CiudadFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ciudadController")
@ViewScoped
public class CiudadController extends AbstractController<Ciudad> {

    @Inject
    private DepartamentoController departamentoController;

    // Flags to indicate if child collections are empty
    private boolean isPersonaListEmpty;
    private boolean isAeropuertosListEmpty;
    private boolean isVueloListEmpty;
    private boolean isVueloList1Empty;

    public CiudadController() {
        // Inform the Abstract parent controller of the concrete Ciudad Entity
        super(Ciudad.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        departamentoController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsPersonaListEmpty();
        this.setIsAeropuertosListEmpty();
        this.setIsVueloListEmpty();
        this.setIsVueloList1Empty();
    }

    public boolean getIsPersonaListEmpty() {
        return this.isPersonaListEmpty;
    }

    private void setIsPersonaListEmpty() {
        Ciudad selected = this.getSelected();
        if (selected != null) {
            CiudadFacade ejbFacade = (CiudadFacade) this.getFacade();
            this.isPersonaListEmpty = ejbFacade.isPersonaListEmpty(selected);
        } else {
            this.isPersonaListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Persona entities that are
     * retrieved from Ciudad and returns the navigation outcome.
     *
     * @return navigation outcome for Persona page
     */
    public String navigatePersonaList() {
        Ciudad selected = this.getSelected();
        if (selected != null) {
            CiudadFacade ejbFacade = (CiudadFacade) this.getFacade();
            List<Persona> selectedPersonaList = ejbFacade.findPersonaList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Persona_items", selectedPersonaList);
        }
        return "/app/persona/index";
    }

    public boolean getIsAeropuertosListEmpty() {
        return this.isAeropuertosListEmpty;
    }

    private void setIsAeropuertosListEmpty() {
        Ciudad selected = this.getSelected();
        if (selected != null) {
            CiudadFacade ejbFacade = (CiudadFacade) this.getFacade();
            this.isAeropuertosListEmpty = ejbFacade.isAeropuertosListEmpty(selected);
        } else {
            this.isAeropuertosListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Aeropuertos entities that
     * are retrieved from Ciudad and returns the navigation outcome.
     *
     * @return navigation outcome for Aeropuertos page
     */
    public String navigateAeropuertosList() {
        Ciudad selected = this.getSelected();
        if (selected != null) {
            CiudadFacade ejbFacade = (CiudadFacade) this.getFacade();
            List<Aeropuertos> selectedAeropuertosList = ejbFacade.findAeropuertosList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Aeropuertos_items", selectedAeropuertosList);
        }
        return "/app/aeropuertos/index";
    }

    /**
     * Sets the "selected" attribute of the Departamento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDepartamento(ActionEvent event) {
        Ciudad selected = this.getSelected();
        if (selected != null && departamentoController.getSelected() == null) {
            departamentoController.setSelected(selected.getDepartamento());
        }
    }

    public boolean getIsVueloListEmpty() {
        return this.isVueloListEmpty;
    }

    private void setIsVueloListEmpty() {
        Ciudad selected = this.getSelected();
        if (selected != null) {
            CiudadFacade ejbFacade = (CiudadFacade) this.getFacade();
            this.isVueloListEmpty = ejbFacade.isVueloListEmpty(selected);
        } else {
            this.isVueloListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Vuelo entities that are
     * retrieved from Ciudad and returns the navigation outcome.
     *
     * @return navigation outcome for Vuelo page
     */
    public String navigateVueloList() {
        Ciudad selected = this.getSelected();
        if (selected != null) {
            CiudadFacade ejbFacade = (CiudadFacade) this.getFacade();
            List<Vuelo> selectedVueloList = ejbFacade.findVueloList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Vuelo_items", selectedVueloList);
        }
        return "/app/vuelo/index";
    }

    public boolean getIsVueloList1Empty() {
        return this.isVueloList1Empty;
    }

    private void setIsVueloList1Empty() {
        Ciudad selected = this.getSelected();
        if (selected != null) {
            CiudadFacade ejbFacade = (CiudadFacade) this.getFacade();
            this.isVueloList1Empty = ejbFacade.isVueloList1Empty(selected);
        } else {
            this.isVueloList1Empty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Vuelo entities that are
     * retrieved from Ciudad and returns the navigation outcome.
     *
     * @return navigation outcome for Vuelo page
     */
    public String navigateVueloList1() {
        Ciudad selected = this.getSelected();
        if (selected != null) {
            CiudadFacade ejbFacade = (CiudadFacade) this.getFacade();
            List<Vuelo> selectedVueloList1 = ejbFacade.findVueloList1(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Vuelo_items", selectedVueloList1);
        }
        return "/app/vuelo/index";
    }

}
