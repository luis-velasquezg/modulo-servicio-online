/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Tipoclase;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Tipoclase_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Tiquetevuelo;
import java.util.List;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class TipoclaseFacade extends AbstractFacade<Tipoclase> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoclaseFacade() {
        super(Tipoclase.class);
    }

    public boolean isTiquetevueloListEmpty(Tipoclase entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tipoclase> tipoclase = cq.from(Tipoclase.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoclase, entity), cb.isNotEmpty(tipoclase.get(Tipoclase_.tiquetevueloList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Tiquetevuelo> findTiquetevueloList(Tipoclase entity) {
        Tipoclase mergedEntity = this.getMergedEntity(entity);
        List<Tiquetevuelo> tiquetevueloList = mergedEntity.getTiquetevueloList();
        tiquetevueloList.size();
        return tiquetevueloList;
    }
    
}
