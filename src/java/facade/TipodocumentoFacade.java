/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Tipodocumento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Tipodocumento_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Persona;
import java.util.List;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class TipodocumentoFacade extends AbstractFacade<Tipodocumento> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipodocumentoFacade() {
        super(Tipodocumento.class);
    }

    public boolean isPersonaListEmpty(Tipodocumento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tipodocumento> tipodocumento = cq.from(Tipodocumento.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipodocumento, entity), cb.isNotEmpty(tipodocumento.get(Tipodocumento_.personaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Persona> findPersonaList(Tipodocumento entity) {
        Tipodocumento mergedEntity = this.getMergedEntity(entity);
        List<Persona> personaList = mergedEntity.getPersonaList();
        personaList.size();
        return personaList;
    }
    
}
