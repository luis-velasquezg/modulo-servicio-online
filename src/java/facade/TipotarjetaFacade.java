/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Tipotarjeta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Tipotarjeta_;
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
public class TipotarjetaFacade extends AbstractFacade<Tipotarjeta> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipotarjetaFacade() {
        super(Tipotarjeta.class);
    }

    public boolean isTiquetevueloListEmpty(Tipotarjeta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tipotarjeta> tipotarjeta = cq.from(Tipotarjeta.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipotarjeta, entity), cb.isNotEmpty(tipotarjeta.get(Tipotarjeta_.tiquetevueloList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Tiquetevuelo> findTiquetevueloList(Tipotarjeta entity) {
        Tipotarjeta mergedEntity = this.getMergedEntity(entity);
        List<Tiquetevuelo> tiquetevueloList = mergedEntity.getTiquetevueloList();
        tiquetevueloList.size();
        return tiquetevueloList;
    }
    
}
