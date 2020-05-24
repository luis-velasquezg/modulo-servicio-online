/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Categoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Categoria_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Usuario;
import java.util.List;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }

    public boolean isUsuarioListEmpty(Categoria entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Categoria> categoria = cq.from(Categoria.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(categoria, entity), cb.isNotEmpty(categoria.get(Categoria_.usuarioList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Usuario> findUsuarioList(Categoria entity) {
        Categoria mergedEntity = this.getMergedEntity(entity);
        List<Usuario> usuarioList = mergedEntity.getUsuarioList();
        usuarioList.size();
        return usuarioList;
    }
    
}
