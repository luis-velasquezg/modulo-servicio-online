package controller;

import entities.Departamento;
import entities.Ciudad;
import java.util.List;
import facade.DepartamentoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "departamentoController")
@ViewScoped
public class DepartamentoController extends AbstractController<Departamento> {

    @Inject
    private PaisController paisController;

    // Flags to indicate if child collections are empty
    private boolean isCiudadListEmpty;

    public DepartamentoController() {
        // Inform the Abstract parent controller of the concrete Departamento Entity
        super(Departamento.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        paisController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsCiudadListEmpty();
    }

    public boolean getIsCiudadListEmpty() {
        return this.isCiudadListEmpty;
    }

    private void setIsCiudadListEmpty() {
        Departamento selected = this.getSelected();
        if (selected != null) {
            DepartamentoFacade ejbFacade = (DepartamentoFacade) this.getFacade();
            this.isCiudadListEmpty = ejbFacade.isCiudadListEmpty(selected);
        } else {
            this.isCiudadListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Ciudad entities that are
     * retrieved from Departamento and returns the navigation outcome.
     *
     * @return navigation outcome for Ciudad page
     */
    public String navigateCiudadList() {
        Departamento selected = this.getSelected();
        if (selected != null) {
            DepartamentoFacade ejbFacade = (DepartamentoFacade) this.getFacade();
            List<Ciudad> selectedCiudadList = ejbFacade.findCiudadList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Ciudad_items", selectedCiudadList);
        }
        return "/app/ciudad/index";
    }

    /**
     * Sets the "selected" attribute of the Pais controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePais(ActionEvent event) {
        Departamento selected = this.getSelected();
        if (selected != null && paisController.getSelected() == null) {
            paisController.setSelected(selected.getPais());
        }
    }

}
