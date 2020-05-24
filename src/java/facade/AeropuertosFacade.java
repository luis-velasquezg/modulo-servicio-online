/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Aeropuertos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Aeropuertos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Ciudad;
import entities.Vuelo;
import java.util.List;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class AeropuertosFacade extends AbstractFacade<Aeropuertos> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AeropuertosFacade() {
        super(Aeropuertos.class);
    }

    public boolean isCiudadEmpty(Aeropuertos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Aeropuertos> aeropuertos = cq.from(Aeropuertos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(aeropuertos, entity), cb.isNotNull(aeropuertos.get(Aeropuertos_.ciudad)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ciudad findCiudad(Aeropuertos entity) {
        return this.getMergedEntity(entity).getCiudad();
    }

    public boolean isVueloListEmpty(Aeropuertos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Aeropuertos> aeropuertos = cq.from(Aeropuertos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(aeropuertos, entity), cb.isNotEmpty(aeropuertos.get(Aeropuertos_.vueloList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Vuelo> findVueloList(Aeropuertos entity) {
        Aeropuertos mergedEntity = this.getMergedEntity(entity);
        List<Vuelo> vueloList = mergedEntity.getVueloList();
        vueloList.size();
        return vueloList;
    }
    
}
