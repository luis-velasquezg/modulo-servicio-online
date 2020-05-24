/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Ciudad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Ciudad_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Persona;
import entities.Aeropuertos;
import entities.Departamento;
import entities.Vuelo;
import entities.Vuelo;
import java.util.List;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiudadFacade() {
        super(Ciudad.class);
    }

    public boolean isPersonaListEmpty(Ciudad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ciudad, entity), cb.isNotEmpty(ciudad.get(Ciudad_.personaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Persona> findPersonaList(Ciudad entity) {
        Ciudad mergedEntity = this.getMergedEntity(entity);
        List<Persona> personaList = mergedEntity.getPersonaList();
        personaList.size();
        return personaList;
    }

    public boolean isAeropuertosListEmpty(Ciudad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ciudad, entity), cb.isNotEmpty(ciudad.get(Ciudad_.aeropuertosList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Aeropuertos> findAeropuertosList(Ciudad entity) {
        Ciudad mergedEntity = this.getMergedEntity(entity);
        List<Aeropuertos> aeropuertosList = mergedEntity.getAeropuertosList();
        aeropuertosList.size();
        return aeropuertosList;
    }

    public boolean isDepartamentoEmpty(Ciudad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ciudad, entity), cb.isNotNull(ciudad.get(Ciudad_.departamento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Departamento findDepartamento(Ciudad entity) {
        return this.getMergedEntity(entity).getDepartamento();
    }

    public boolean isVueloListEmpty(Ciudad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ciudad, entity), cb.isNotEmpty(ciudad.get(Ciudad_.vueloList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Vuelo> findVueloList(Ciudad entity) {
        Ciudad mergedEntity = this.getMergedEntity(entity);
        List<Vuelo> vueloList = mergedEntity.getVueloList();
        vueloList.size();
        return vueloList;
    }

    public boolean isVueloList1Empty(Ciudad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ciudad, entity), cb.isNotEmpty(ciudad.get(Ciudad_.vueloList1)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Vuelo> findVueloList1(Ciudad entity) {
        Ciudad mergedEntity = this.getMergedEntity(entity);
        List<Vuelo> vueloList1 = mergedEntity.getVueloList1();
        vueloList1.size();
        return vueloList1;
    }
    
}
