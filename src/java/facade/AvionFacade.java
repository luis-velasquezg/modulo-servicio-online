/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Avion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Avion_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Vuelo;
import java.util.List;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class AvionFacade extends AbstractFacade<Avion> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AvionFacade() {
        super(Avion.class);
    }

    public boolean isVueloListEmpty(Avion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Avion> avion = cq.from(Avion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(avion, entity), cb.isNotEmpty(avion.get(Avion_.vueloList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Vuelo> findVueloList(Avion entity) {
        Avion mergedEntity = this.getMergedEntity(entity);
        List<Vuelo> vueloList = mergedEntity.getVueloList();
        vueloList.size();
        return vueloList;
    }
    
}
