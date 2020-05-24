package controller;

import entities.Usuario;
import entities.Redencionmillas;
import entities.Usuarioxpersona;
import entities.Tiquetevuelo;
import java.util.List;
import facade.UsuarioFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    @Inject
    private CategoriaController categoriaController;
    @Inject
    private RolController rolController;

    // Flags to indicate if child collections are empty
    private boolean isRedencionmillasListEmpty;
    private boolean isUsuarioxpersonaListEmpty;
    private boolean isTiquetevueloListEmpty;

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        categoriaController.setSelected(null);
        rolController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsRedencionmillasListEmpty();
        this.setIsUsuarioxpersonaListEmpty();
        this.setIsTiquetevueloListEmpty();
    }

    public boolean getIsRedencionmillasListEmpty() {
        return this.isRedencionmillasListEmpty;
    }

    private void setIsRedencionmillasListEmpty() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            this.isRedencionmillasListEmpty = ejbFacade.isRedencionmillasListEmpty(selected);
        } else {
            this.isRedencionmillasListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Redencionmillas entities
     * that are retrieved from Usuario and returns the navigation outcome.
     *
     * @return navigation outcome for Redencionmillas page
     */
    public String navigateRedencionmillasList() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            List<Redencionmillas> selectedRedencionmillasList = ejbFacade.findRedencionmillasList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Redencionmillas_items", selectedRedencionmillasList);
        }
        return "/app/redencionmillas/index";
    }

    public boolean getIsUsuarioxpersonaListEmpty() {
        return this.isUsuarioxpersonaListEmpty;
    }

    private void setIsUsuarioxpersonaListEmpty() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            this.isUsuarioxpersonaListEmpty = ejbFacade.isUsuarioxpersonaListEmpty(selected);
        } else {
            this.isUsuarioxpersonaListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Usuarioxpersona entities
     * that are retrieved from Usuario and returns the navigation outcome.
     *
     * @return navigation outcome for Usuarioxpersona page
     */
    public String navigateUsuarioxpersonaList() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            List<Usuarioxpersona> selectedUsuarioxpersonaList = ejbFacade.findUsuarioxpersonaList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuarioxpersona_items", selectedUsuarioxpersonaList);
        }
        return "/app/usuarioxpersona/index";
    }

    public boolean getIsTiquetevueloListEmpty() {
        return this.isTiquetevueloListEmpty;
    }

    private void setIsTiquetevueloListEmpty() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            this.isTiquetevueloListEmpty = ejbFacade.isTiquetevueloListEmpty(selected);
        } else {
            this.isTiquetevueloListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Tiquetevuelo entities
     * that are retrieved from Usuario and returns the navigation outcome.
     *
     * @return navigation outcome for Tiquetevuelo page
     */
    public String navigateTiquetevueloList() {
        Usuario selected = this.getSelected();
        if (selected != null) {
            UsuarioFacade ejbFacade = (UsuarioFacade) this.getFacade();
            List<Tiquetevuelo> selectedTiquetevueloList = ejbFacade.findTiquetevueloList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Tiquetevuelo_items", selectedTiquetevueloList);
        }
        return "/app/tiquetevuelo/index";
    }

    /**
     * Sets the "selected" attribute of the Categoria controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCategoria(ActionEvent event) {
        Usuario selected = this.getSelected();
        if (selected != null && categoriaController.getSelected() == null) {
            categoriaController.setSelected(selected.getCategoria());
        }
    }

    /**
     * Sets the "selected" attribute of the Rol controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRol(ActionEvent event) {
        Usuario selected = this.getSelected();
        if (selected != null && rolController.getSelected() == null) {
            rolController.setSelected(selected.getRol());
        }
    }

}
