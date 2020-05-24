/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Redencionmillas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Redencionmillas_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Usuario;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class RedencionmillasFacade extends AbstractFacade<Redencionmillas> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RedencionmillasFacade() {
        super(Redencionmillas.class);
    }

    public boolean isUsuarioRedimeEmpty(Redencionmillas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Redencionmillas> redencionmillas = cq.from(Redencionmillas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(redencionmillas, entity), cb.isNotNull(redencionmillas.get(Redencionmillas_.usuarioRedime)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findUsuarioRedime(Redencionmillas entity) {
        return this.getMergedEntity(entity).getUsuarioRedime();
    }
    
}
