/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Usuarioxpersona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Usuarioxpersona_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Persona;
import entities.Usuario;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class UsuarioxpersonaFacade extends AbstractFacade<Usuarioxpersona> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioxpersonaFacade() {
        super(Usuarioxpersona.class);
    }

    public boolean isPersonaEmpty(Usuarioxpersona entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuarioxpersona> usuarioxpersona = cq.from(Usuarioxpersona.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuarioxpersona, entity), cb.isNotNull(usuarioxpersona.get(Usuarioxpersona_.persona)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Persona findPersona(Usuarioxpersona entity) {
        return this.getMergedEntity(entity).getPersona();
    }

    public boolean isUsuarioEmpty(Usuarioxpersona entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuarioxpersona> usuarioxpersona = cq.from(Usuarioxpersona.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuarioxpersona, entity), cb.isNotNull(usuarioxpersona.get(Usuarioxpersona_.usuario)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findUsuario(Usuarioxpersona entity) {
        return this.getMergedEntity(entity).getUsuario();
    }
    
}
