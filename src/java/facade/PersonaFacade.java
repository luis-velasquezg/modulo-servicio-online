/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Persona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Persona_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Ciudad;
import entities.Tipodocumento;
import entities.Usuarioxpersona;
import java.util.List;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }

    public boolean isCiudadEmpty(Persona entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Persona> persona = cq.from(Persona.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(persona, entity), cb.isNotNull(persona.get(Persona_.ciudad)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ciudad findCiudad(Persona entity) {
        return this.getMergedEntity(entity).getCiudad();
    }

    public boolean isTipoDocumentoEmpty(Persona entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Persona> persona = cq.from(Persona.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(persona, entity), cb.isNotNull(persona.get(Persona_.tipoDocumento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Tipodocumento findTipoDocumento(Persona entity) {
        return this.getMergedEntity(entity).getTipoDocumento();
    }

    public boolean isUsuarioxpersonaListEmpty(Persona entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Persona> persona = cq.from(Persona.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(persona, entity), cb.isNotEmpty(persona.get(Persona_.usuarioxpersonaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Usuarioxpersona> findUsuarioxpersonaList(Persona entity) {
        Persona mergedEntity = this.getMergedEntity(entity);
        List<Usuarioxpersona> usuarioxpersonaList = mergedEntity.getUsuarioxpersonaList();
        usuarioxpersonaList.size();
        return usuarioxpersonaList;
    }
    
}
