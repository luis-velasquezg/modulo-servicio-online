/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Temporada;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Temporada_;
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
public class TemporadaFacade extends AbstractFacade<Temporada> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TemporadaFacade() {
        super(Temporada.class);
    }

    public boolean isTiquetevueloListEmpty(Temporada entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Temporada> temporada = cq.from(Temporada.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(temporada, entity), cb.isNotEmpty(temporada.get(Temporada_.tiquetevueloList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Tiquetevuelo> findTiquetevueloList(Temporada entity) {
        Temporada mergedEntity = this.getMergedEntity(entity);
        List<Tiquetevuelo> tiquetevueloList = mergedEntity.getTiquetevueloList();
        tiquetevueloList.size();
        return tiquetevueloList;
    }
    
}
