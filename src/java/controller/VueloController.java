package controller;

import entities.Vuelo;
import entities.Tiquetevuelo;
import java.util.List;
import facade.VueloFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "vueloController")
@ViewScoped
public class VueloController extends AbstractController<Vuelo> {

    @Inject
    private AeropuertosController aeropuertoController;
    @Inject
    private AvionController avionController;
    @Inject
    private CiudadController ciudadDestinoController;
    @Inject
    private CiudadController ciudadOrigenController;

    // Flags to indicate if child collections are empty
    private boolean isTiquetevueloListEmpty;

    public VueloController() {
        // Inform the Abstract parent controller of the concrete Vuelo Entity
        super(Vuelo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        aeropuertoController.setSelected(null);
        avionController.setSelected(null);
        ciudadDestinoController.setSelected(null);
        ciudadOrigenController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsTiquetevueloListEmpty();
    }

    public boolean getIsTiquetevueloListEmpty() {
        return this.isTiquetevueloListEmpty;
    }

    private void setIsTiquetevueloListEmpty() {
        Vuelo selected = this.getSelected();
        if (selected != null) {
            VueloFacade ejbFacade = (VueloFacade) this.getFacade();
            this.isTiquetevueloListEmpty = ejbFacade.isTiquetevueloListEmpty(selected);
        } else {
            this.isTiquetevueloListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Tiquetevuelo entities
     * that are retrieved from Vuelo and returns the navigation outcome.
     *
     * @return navigation outcome for Tiquetevuelo page
     */
    public String navigateTiquetevueloList() {
        Vuelo selected = this.getSelected();
        if (selected != null) {
            VueloFacade ejbFacade = (VueloFacade) this.getFacade();
            List<Tiquetevuelo> selectedTiquetevueloList = ejbFacade.findTiquetevueloList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tiquetevuelo_items", selectedTiquetevueloList);
        }
        return "/app/tiquetevuelo/index";
    }

    /**
     * Sets the "selected" attribute of the Aeropuertos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAeropuerto(ActionEvent event) {
        Vuelo selected = this.getSelected();
        if (selected != null && aeropuertoController.getSelected() == null) {
            aeropuertoController.setSelected(selected.getAeropuerto());
        }
    }

    /**
     * Sets the "selected" attribute of the Avion controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAvion(ActionEvent event) {
        Vuelo selected = this.getSelected();
        if (selected != null && avionController.getSelected() == null) {
            avionController.setSelected(selected.getAvion());
        }
    }

    /**
     * Sets the "selected" attribute of the Ciudad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCiudadDestino(ActionEvent event) {
        Vuelo selected = this.getSelected();
        if (selected != null && ciudadDestinoController.getSelected() == null) {
            ciudadDestinoController.setSelected(selected.getCiudadDestino());
        }
    }

    /**
     * Sets the "selected" attribute of the Ciudad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCiudadOrigen(ActionEvent event) {
        Vuelo selected = this.getSelected();
        if (selected != null && ciudadOrigenController.getSelected() == null) {
            ciudadOrigenController.setSelected(selected.getCiudadOrigen());
        }
    }

}
