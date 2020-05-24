/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Pais;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Pais_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Departamento;
import java.util.List;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class PaisFacade extends AbstractFacade<Pais> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisFacade() {
        super(Pais.class);
    }

    public boolean isDepartamentoListEmpty(Pais entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Pais> pais = cq.from(Pais.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(pais, entity), cb.isNotEmpty(pais.get(Pais_.departamentoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Departamento> findDepartamentoList(Pais entity) {
        Pais mergedEntity = this.getMergedEntity(entity);
        List<Departamento> departamentoList = mergedEntity.getDepartamentoList();
        departamentoList.size();
        return departamentoList;
    }
    
}
