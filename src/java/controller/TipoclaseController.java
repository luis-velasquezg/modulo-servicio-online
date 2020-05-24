package controller;

import entities.Tipoclase;
import entities.Tiquetevuelo;
import java.util.List;
import facade.TipoclaseFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoclaseController")
@ViewScoped
public class TipoclaseController extends AbstractController<Tipoclase> {

    // Flags to indicate if child collections are empty
    private boolean isTiquetevueloListEmpty;

    public TipoclaseController() {
        // Inform the Abstract parent controller of the concrete Tipoclase Entity
        super(Tipoclase.class);
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
        Tipoclase selected = this.getSelected();
        if (selected != null) {
            TipoclaseFacade ejbFacade = (TipoclaseFacade) this.getFacade();
            this.isTiquetevueloListEmpty = ejbFacade.isTiquetevueloListEmpty(selected);
        } else {
            this.isTiquetevueloListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Tiquetevuelo entities
     * that are retrieved from Tipoclase and returns the navigation outcome.
     *
     * @return navigation outcome for Tiquetevuelo page
     */
    public String navigateTiquetevueloList() {
        Tipoclase selected = this.getSelected();
        if (selected != null) {
            TipoclaseFacade ejbFacade = (TipoclaseFacade) this.getFacade();
            List<Tiquetevuelo> selectedTiquetevueloList = ejbFacade.findTiquetevueloList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tiquetevuelo_items", selectedTiquetevueloList);
        }
        return "/app/tiquetevuelo/index";
    }

}
