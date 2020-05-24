/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Vuelo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Vuelo_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Tiquetevuelo;
import entities.Aeropuertos;
import entities.Avion;
import entities.Ciudad;
import entities.Ciudad;
import java.util.List;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class VueloFacade extends AbstractFacade<Vuelo> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VueloFacade() {
        super(Vuelo.class);
    }

    public boolean isTiquetevueloListEmpty(Vuelo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Vuelo> vuelo = cq.from(Vuelo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(vuelo, entity), cb.isNotEmpty(vuelo.get(Vuelo_.tiquetevueloList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Tiquetevuelo> findTiquetevueloList(Vuelo entity) {
        Vuelo mergedEntity = this.getMergedEntity(entity);
        List<Tiquetevuelo> tiquetevueloList = mergedEntity.getTiquetevueloList();
        tiquetevueloList.size();
        return tiquetevueloList;
    }

    public boolean isAeropuertoEmpty(Vuelo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Vuelo> vuelo = cq.from(Vuelo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(vuelo, entity), cb.isNotNull(vuelo.get(Vuelo_.aeropuerto)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Aeropuertos findAeropuerto(Vuelo entity) {
        return this.getMergedEntity(entity).getAeropuerto();
    }

    public boolean isAvionEmpty(Vuelo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Vuelo> vuelo = cq.from(Vuelo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(vuelo, entity), cb.isNotNull(vuelo.get(Vuelo_.avion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Avion findAvion(Vuelo entity) {
        return this.getMergedEntity(entity).getAvion();
    }

    public boolean isCiudadDestinoEmpty(Vuelo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Vuelo> vuelo = cq.from(Vuelo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(vuelo, entity), cb.isNotNull(vuelo.get(Vuelo_.ciudadDestino)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ciudad findCiudadDestino(Vuelo entity) {
        return this.getMergedEntity(entity).getCiudadDestino();
    }

    public boolean isCiudadOrigenEmpty(Vuelo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Vuelo> vuelo = cq.from(Vuelo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(vuelo, entity), cb.isNotNull(vuelo.get(Vuelo_.ciudadOrigen)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ciudad findCiudadOrigen(Vuelo entity) {
        return this.getMergedEntity(entity).getCiudadOrigen();
    }
    
}
