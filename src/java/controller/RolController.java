package controller;

import entities.Rol;
import entities.Usuario;
import java.util.List;
import facade.RolFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "rolController")
@ViewScoped
public class RolController extends AbstractController<Rol> {

    // Flags to indicate if child collections are empty
    private boolean isUsuarioListEmpty;

    public RolController() {
        // Inform the Abstract parent controller of the concrete Rol Entity
        super(Rol.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsUsuarioListEmpty();
    }

    public boolean getIsUsuarioListEmpty() {
        return this.isUsuarioListEmpty;
    }

    private void setIsUsuarioListEmpty() {
        Rol selected = this.getSelected();
        if (selected != null) {
            RolFacade ejbFacade = (RolFacade) this.getFacade();
            this.isUsuarioListEmpty = ejbFacade.isUsuarioListEmpty(selected);
        } else {
            this.isUsuarioListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Usuario entities that are
     * retrieved from Rol and returns the navigation outcome.
     *
     * @return navigation outcome for Usuario page
     */
    public String navigateUsuarioList() {
        Rol selected = this.getSelected();
        if (selected != null) {
            RolFacade ejbFacade = (RolFacade) this.getFacade();
            List<Usuario> selectedUsuarioList = ejbFacade.findUsuarioList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuario_items", selectedUsuarioList);
        }
        return "/app/usuario/index";
    }

}
