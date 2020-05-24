package controller;

import entities.Avion;
import entities.Vuelo;
import java.util.List;
import facade.AvionFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "avionController")
@ViewScoped
public class AvionController extends AbstractController<Avion> {

    // Flags to indicate if child collections are empty
    private boolean isVueloListEmpty;

    public AvionController() {
        // Inform the Abstract parent controller of the concrete Avion Entity
        super(Avion.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsVueloListEmpty();
    }

    public boolean getIsVueloListEmpty() {
        return this.isVueloListEmpty;
    }

    private void setIsVueloListEmpty() {
        Avion selected = this.getSelected();
        if (selected != null) {
            AvionFacade ejbFacade = (AvionFacade) this.getFacade();
            this.isVueloListEmpty = ejbFacade.isVueloListEmpty(selected);
        } else {
            this.isVueloListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Vuelo entities that are
     * retrieved from Avion and returns the navigation outcome.
     *
     * @return navigation outcome for Vuelo page
     */
    public String navigateVueloList() {
        Avion selected = this.getSelected();
        if (selected != null) {
            AvionFacade ejbFacade = (AvionFacade) this.getFacade();
            List<Vuelo> selectedVueloList = ejbFacade.findVueloList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Vuelo_items", selectedVueloList);
        }
        return "/app/vuelo/index";
    }

}
