package controller;

import entities.Tipodocumento;
import entities.Persona;
import java.util.List;
import facade.TipodocumentoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipodocumentoController")
@ViewScoped
public class TipodocumentoController extends AbstractController<Tipodocumento> {

    // Flags to indicate if child collections are empty
    private boolean isPersonaListEmpty;

    public TipodocumentoController() {
        // Inform the Abstract parent controller of the concrete Tipodocumento Entity
        super(Tipodocumento.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsPersonaListEmpty();
    }

    public boolean getIsPersonaListEmpty() {
        return this.isPersonaListEmpty;
    }

    private void setIsPersonaListEmpty() {
        Tipodocumento selected = this.getSelected();
        if (selected != null) {
            TipodocumentoFacade ejbFacade = (TipodocumentoFacade) this.getFacade();
            this.isPersonaListEmpty = ejbFacade.isPersonaListEmpty(selected);
        } else {
            this.isPersonaListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Persona entities that are
     * retrieved from Tipodocumento and returns the navigation outcome.
     *
     * @return navigation outcome for Persona page
     */
    public String navigatePersonaList() {
        Tipodocumento selected = this.getSelected();
        if (selected != null) {
            TipodocumentoFacade ejbFacade = (TipodocumentoFacade) this.getFacade();
            List<Persona> selectedPersonaList = ejbFacade.findPersonaList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Persona_items", selectedPersonaList);
        }
        return "/app/persona/index";
    }

}
