package controller;

import entities.Tipotarjeta;
import entities.Tiquetevuelo;
import java.util.List;
import facade.TipotarjetaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipotarjetaController")
@ViewScoped
public class TipotarjetaController extends AbstractController<Tipotarjeta> {

    // Flags to indicate if child collections are empty
    private boolean isTiquetevueloListEmpty;

    public TipotarjetaController() {
        // Inform the Abstract parent controller of the concrete Tipotarjeta Entity
        super(Tipotarjeta.class);
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
        Tipotarjeta selected = this.getSelected();
        if (selected != null) {
            TipotarjetaFacade ejbFacade = (TipotarjetaFacade) this.getFacade();
            this.isTiquetevueloListEmpty = ejbFacade.isTiquetevueloListEmpty(selected);
        } else {
            this.isTiquetevueloListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Tiquetevuelo entities
     * that are retrieved from Tipotarjeta and returns the navigation outcome.
     *
     * @return navigation outcome for Tiquetevuelo page
     */
    public String navigateTiquetevueloList() {
        Tipotarjeta selected = this.getSelected();
        if (selected != null) {
            TipotarjetaFacade ejbFacade = (TipotarjetaFacade) this.getFacade();
            List<Tiquetevuelo> selectedTiquetevueloList = ejbFacade.findTiquetevueloList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tiquetevuelo_items", selectedTiquetevueloList);
        }
        return "/app/tiquetevuelo/index";
    }

}
