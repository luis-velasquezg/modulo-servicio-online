package controller;

import entities.Categoria;
import entities.Usuario;
import java.util.List;
import facade.CategoriaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "categoriaController")
@ViewScoped
public class CategoriaController extends AbstractController<Categoria> {

    // Flags to indicate if child collections are empty
    private boolean isUsuarioListEmpty;

    public CategoriaController() {
        // Inform the Abstract parent controller of the concrete Categoria Entity
        super(Categoria.class);
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
        Categoria selected = this.getSelected();
        if (selected != null) {
            CategoriaFacade ejbFacade = (CategoriaFacade) this.getFacade();
            this.isUsuarioListEmpty = ejbFacade.isUsuarioListEmpty(selected);
        } else {
            this.isUsuarioListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Usuario entities that are
     * retrieved from Categoria and returns the navigation outcome.
     *
     * @return navigation outcome for Usuario page
     */
    public String navigateUsuarioList() {
        Categoria selected = this.getSelected();
        if (selected != null) {
            CategoriaFacade ejbFacade = (CategoriaFacade) this.getFacade();
            List<Usuario> selectedUsuarioList = ejbFacade.findUsuarioList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuario_items", selectedUsuarioList);
        }
        return "/app/usuario/index";
    }

}
