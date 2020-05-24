package controller;

import entities.Pais;
import entities.Departamento;
import java.util.List;
import facade.PaisFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "paisController")
@ViewScoped
public class PaisController extends AbstractController<Pais> {

    // Flags to indicate if child collections are empty
    private boolean isDepartamentoListEmpty;

    public PaisController() {
        // Inform the Abstract parent controller of the concrete Pais Entity
        super(Pais.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsDepartamentoListEmpty();
    }

    public boolean getIsDepartamentoListEmpty() {
        return this.isDepartamentoListEmpty;
    }

    private void setIsDepartamentoListEmpty() {
        Pais selected = this.getSelected();
        if (selected != null) {
            PaisFacade ejbFacade = (PaisFacade) this.getFacade();
            this.isDepartamentoListEmpty = ejbFacade.isDepartamentoListEmpty(selected);
        } else {
            this.isDepartamentoListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Departamento entities
     * that are retrieved from Pais and returns the navigation outcome.
     *
     * @return navigation outcome for Departamento page
     */
    public String navigateDepartamentoList() {
        Pais selected = this.getSelected();
        if (selected != null) {
            PaisFacade ejbFacade = (PaisFacade) this.getFacade();
            List<Departamento> selectedDepartamentoList = ejbFacade.findDepartamentoList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Departamento_items", selectedDepartamentoList);
        }
        return "/app/departamento/index";
    }

}
