package controller;

import entities.Tiquetevuelo;
import facade.TiquetevueloFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tiquetevueloController")
@ViewScoped
public class TiquetevueloController extends AbstractController<Tiquetevuelo> {

    @Inject
    private TipoclaseController claseController;
    @Inject
    private TemporadaController temporadaController;
    @Inject
    private TipotarjetaController tipoTarjetaController;
    @Inject
    private UsuarioController usuarioTiketController;
    @Inject
    private VueloController vueloController;

    public TiquetevueloController() {
        // Inform the Abstract parent controller of the concrete Tiquetevuelo Entity
        super(Tiquetevuelo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        claseController.setSelected(null);
        temporadaController.setSelected(null);
        tipoTarjetaController.setSelected(null);
        usuarioTiketController.setSelected(null);
        vueloController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Tipoclase controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareClase(ActionEvent event) {
        Tiquetevuelo selected = this.getSelected();
        if (selected != null && claseController.getSelected() == null) {
            claseController.setSelected(selected.getClase());
        }
    }

    /**
     * Sets the "selected" attribute of the Temporada controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTemporada(ActionEvent event) {
        Tiquetevuelo selected = this.getSelected();
        if (selected != null && temporadaController.getSelected() == null) {
            temporadaController.setSelected(selected.getTemporada());
        }
    }

    /**
     * Sets the "selected" attribute of the Tipotarjeta controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoTarjeta(ActionEvent event) {
        Tiquetevuelo selected = this.getSelected();
        if (selected != null && tipoTarjetaController.getSelected() == null) {
            tipoTarjetaController.setSelected(selected.getTipoTarjeta());
        }
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUsuarioTiket(ActionEvent event) {
        Tiquetevuelo selected = this.getSelected();
        if (selected != null && usuarioTiketController.getSelected() == null) {
            usuarioTiketController.setSelected(selected.getUsuarioTiket());
        }
    }

    /**
     * Sets the "selected" attribute of the Vuelo controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareVuelo(ActionEvent event) {
        Tiquetevuelo selected = this.getSelected();
        if (selected != null && vueloController.getSelected() == null) {
            vueloController.setSelected(selected.getVuelo());
        }
    }

}
