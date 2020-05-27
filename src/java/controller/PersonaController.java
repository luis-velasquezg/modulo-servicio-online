package controller;

import dao.LoginDAO;
import dao.PersonaDAO;
import entities.Persona;
import entities.Tipodocumento;
import entities.Usuarioxpersona;
import java.util.List;
import facade.PersonaFacade;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "personaController")
@ViewScoped
public class PersonaController extends AbstractController<Persona> {

    private final static DateFormat FORMATO_ORIGINAL = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
    // private final static DateFormat FORMATO_FINAL = new SimpleDateFormat("yyyy-MM-dd");
    
    @Inject
    private CiudadController ciudadController;
    @Inject
    private TipodocumentoController tipoDocumentoController;

    private String pwd;
    private String msg;
    private String user;

    private String nombres;
    private String apellidos;
    private Tipodocumento tipoDocumento;
    private String numeroDocumento;
    private String email;
    private String telefono;
    private String fechaNacimiento;
   

    // Flags to indicate if child collections are empty
    private boolean isUsuarioxpersonaListEmpty;

    public PersonaController() {
        // Inform the Abstract parent controller of the concrete Persona Entity
        super(Persona.class);
    }

    public void registrar() throws ParseException {
        LoginDAO.registrar(user, pwd);
//        
//        Date fechaNacimientoParseada = DATE_PARSE.parse(fechaNacimiento);
//        Date fechaNacimientoFormateada = DATE_FORMAT.format(fechaNacimientoParseada);
        
//        String date = "Thu May 14 16:32:00 COT 2020";
//        SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
//                Locale.ENGLISH);

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
           
//        Date parsedDate = DATE_PARSE.parse(date);
//        String formattedDate = DATE_FORMAT.format(parsedDate);
//        Date finalParsedDate = DATE_FORMAT.parse(formattedDate);
        
        Date fechaNacimientoFormatoOriginal = FORMATO_ORIGINAL.parse(fechaNacimiento);
//        String fechaNacimientoFormatoFinal = FORMATO_FINAL.format(fechaNacimientoFormatoOriginal);
//        Date dateFinal = FORMATO_FINAL.parse(fechaNacimientoFormatoFinal);
        
        System.out.println("Fecha de Nacimiento: " + this.fechaNacimiento);
        System.out.println("fechaNacimientoFormatoOriginal: " + fechaNacimientoFormatoOriginal);
//        System.out.println("fechaNacimientoFormatoFinal: " + fechaNacimientoFormatoFinal);
//        System.out.println("dateFinal: " + dateFinal);
        
//        SimpleDateFormat print = new SimpleDateFormat("MMM d, yyyy HH:mm:ss");
//        System.out.println("SimpleDateFormat print: " + print.format(parsedDate));
               
        
        Persona personaNueva = new Persona();
        personaNueva.setNombres(nombres);
        personaNueva.setApellidos(apellidos);
        personaNueva.setTipoDocumento(tipoDocumento);
        personaNueva.setNumeroDocumento(numeroDocumento);
        personaNueva.setEmail(email);
        personaNueva.setTelefono(telefono);
        personaNueva.setFechaNacimiento(fechaNacimientoFormatoOriginal);
        // PersonaDAO.registrar(personaNueva, fechaNacimientoFormatoFinal);
        PersonaDAO.registrar(personaNueva);

    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        ciudadController.setSelected(null);
        tipoDocumentoController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsUsuarioxpersonaListEmpty();
    }

    /**
     * Sets the "selected" attribute of the Ciudad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCiudad(ActionEvent event) {
        Persona selected = this.getSelected();
        if (selected != null && ciudadController.getSelected() == null) {
            ciudadController.setSelected(selected.getCiudad());
        }
    }

    /**
     * Sets the "selected" attribute of the Tipodocumento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoDocumento(ActionEvent event) {
        Persona selected = this.getSelected();
        if (selected != null && tipoDocumentoController.getSelected() == null) {
            tipoDocumentoController.setSelected(selected.getTipoDocumento());
        }
    }

    public boolean getIsUsuarioxpersonaListEmpty() {
        return this.isUsuarioxpersonaListEmpty;
    }

    private void setIsUsuarioxpersonaListEmpty() {
        Persona selected = this.getSelected();
        if (selected != null) {
            PersonaFacade ejbFacade = (PersonaFacade) this.getFacade();
            this.isUsuarioxpersonaListEmpty = ejbFacade.isUsuarioxpersonaListEmpty(selected);
        } else {
            this.isUsuarioxpersonaListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Usuarioxpersona entities
     * that are retrieved from Persona and returns the navigation outcome.
     *
     * @return navigation outcome for Usuarioxpersona page
     */
    public String navigateUsuarioxpersonaList() {
        Persona selected = this.getSelected();
        if (selected != null) {
            PersonaFacade ejbFacade = (PersonaFacade) this.getFacade();
            List<Usuarioxpersona> selectedUsuarioxpersonaList = ejbFacade.findUsuarioxpersonaList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuarioxpersona_items", selectedUsuarioxpersonaList);
        }
        return "/app/usuarioxpersona/index";
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public CiudadController getCiudadController() {
        return ciudadController;
    }

    public void setCiudadController(CiudadController ciudadController) {
        this.ciudadController = ciudadController;
    }

    public TipodocumentoController getTipoDocumentoController() {
        return tipoDocumentoController;
    }

    public void setTipoDocumentoController(TipodocumentoController tipoDocumentoController) {
        this.tipoDocumentoController = tipoDocumentoController;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Tipodocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Tipodocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isIsUsuarioxpersonaListEmpty() {
        return isUsuarioxpersonaListEmpty;
    }

    public void setIsUsuarioxpersonaListEmpty(boolean isUsuarioxpersonaListEmpty) {
        this.isUsuarioxpersonaListEmpty = isUsuarioxpersonaListEmpty;
    }

}
