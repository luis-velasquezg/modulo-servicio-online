package controller;

import entities.Aeropuertos;
import entities.Vuelo;
import java.util.List;
import facade.AeropuertosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "aeropuertosController")
@ViewScoped
public class AeropuertosController extends AbstractController<Aeropuertos> {

    @Inject
    private CiudadController ciudadController;

    // Flags to indicate if child collections are empty
    private boolean isVueloListEmpty;

    public AeropuertosController() {
        // Inform the Abstract parent controller of the concrete Aeropuertos Entity
        super(Aeropuertos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        ciudadController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsVueloListEmpty();
    }

    /**
     * Sets the "selected" attribute of the Ciudad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCiudad(ActionEvent event) {
        Aeropuertos selected = this.getSelected();
        if (selected != null && ciudadController.getSelected() == null) {
            ciudadController.setSelected(selected.getCiudad());
        }
    }

    public boolean getIsVueloListEmpty() {
        return this.isVueloListEmpty;
    }

    private void setIsVueloListEmpty() {
        Aeropuertos selected = this.getSelected();
        if (selected != null) {
            AeropuertosFacade ejbFacade = (AeropuertosFacade) this.getFacade();
            this.isVueloListEmpty = ejbFacade.isVueloListEmpty(selected);
        } else {
            this.isVueloListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Vuelo entities that are
     * retrieved from Aeropuertos and returns the navigation outcome.
     *
     * @return navigation outcome for Vuelo page
     */
    public String navigateVueloList() {
        Aeropuertos selected = this.getSelected();
        if (selected != null) {
            AeropuertosFacade ejbFacade = (AeropuertosFacade) this.getFacade();
            List<Vuelo> selectedVueloList = ejbFacade.findVueloList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Vuelo_items", selectedVueloList);
        }
        return "/app/vuelo/index";
    }

}
