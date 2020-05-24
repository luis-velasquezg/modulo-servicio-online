package controller;

import entities.Temporada;
import entities.Tiquetevuelo;
import java.util.List;
import facade.TemporadaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "temporadaController")
@ViewScoped
public class TemporadaController extends AbstractController<Temporada> {

    // Flags to indicate if child collections are empty
    private boolean isTiquetevueloListEmpty;

    public TemporadaController() {
        // Inform the Abstract parent controller of the concrete Temporada Entity
        super(Temporada.class);
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
        Temporada selected = this.getSelected();
        if (selected != null) {
            TemporadaFacade ejbFacade = (TemporadaFacade) this.getFacade();
            this.isTiquetevueloListEmpty = ejbFacade.isTiquetevueloListEmpty(selected);
        } else {
            this.isTiquetevueloListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Tiquetevuelo entities
     * that are retrieved from Temporada and returns the navigation outcome.
     *
     * @return navigation outcome for Tiquetevuelo page
     */
    public String navigateTiquetevueloList() {
        Temporada selected = this.getSelected();
        if (selected != null) {
            TemporadaFacade ejbFacade = (TemporadaFacade) this.getFacade();
            List<Tiquetevuelo> selectedTiquetevueloList = ejbFacade.findTiquetevueloList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tiquetevuelo_items", selectedTiquetevueloList);
        }
        return "/app/tiquetevuelo/index";
    }

}
