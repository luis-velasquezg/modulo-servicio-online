/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Departamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Departamento_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Ciudad;
import entities.Pais;
import java.util.List;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class DepartamentoFacade extends AbstractFacade<Departamento> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }

    public boolean isCiudadListEmpty(Departamento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Departamento> departamento = cq.from(Departamento.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(departamento, entity), cb.isNotEmpty(departamento.get(Departamento_.ciudadList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Ciudad> findCiudadList(Departamento entity) {
        Departamento mergedEntity = this.getMergedEntity(entity);
        List<Ciudad> ciudadList = mergedEntity.getCiudadList();
        ciudadList.size();
        return ciudadList;
    }

    public boolean isPaisEmpty(Departamento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Departamento> departamento = cq.from(Departamento.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(departamento, entity), cb.isNotNull(departamento.get(Departamento_.pais)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Pais findPais(Departamento entity) {
        return this.getMergedEntity(entity).getPais();
    }
    
}
