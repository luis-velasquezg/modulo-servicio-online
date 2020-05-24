/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Usuario_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Redencionmillas;
import entities.Usuarioxpersona;
import entities.Tiquetevuelo;
import entities.Categoria;
import entities.Rol;
import java.util.List;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public boolean isRedencionmillasListEmpty(Usuario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuario, entity), cb.isNotEmpty(usuario.get(Usuario_.redencionmillasList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Redencionmillas> findRedencionmillasList(Usuario entity) {
        Usuario mergedEntity = this.getMergedEntity(entity);
        List<Redencionmillas> redencionmillasList = mergedEntity.getRedencionmillasList();
        redencionmillasList.size();
        return redencionmillasList;
    }

    public boolean isUsuarioxpersonaListEmpty(Usuario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuario, entity), cb.isNotEmpty(usuario.get(Usuario_.usuarioxpersonaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Usuarioxpersona> findUsuarioxpersonaList(Usuario entity) {
        Usuario mergedEntity = this.getMergedEntity(entity);
        List<Usuarioxpersona> usuarioxpersonaList = mergedEntity.getUsuarioxpersonaList();
        usuarioxpersonaList.size();
        return usuarioxpersonaList;
    }

    public boolean isTiquetevueloListEmpty(Usuario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuario, entity), cb.isNotEmpty(usuario.get(Usuario_.tiquetevueloList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Tiquetevuelo> findTiquetevueloList(Usuario entity) {
        Usuario mergedEntity = this.getMergedEntity(entity);
        List<Tiquetevuelo> tiquetevueloList = mergedEntity.getTiquetevueloList();
        tiquetevueloList.size();
        return tiquetevueloList;
    }

    public boolean isCategoriaEmpty(Usuario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuario, entity), cb.isNotNull(usuario.get(Usuario_.categoria)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Categoria findCategoria(Usuario entity) {
        return this.getMergedEntity(entity).getCategoria();
    }

    public boolean isRolEmpty(Usuario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuario, entity), cb.isNotNull(usuario.get(Usuario_.rol)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Rol findRol(Usuario entity) {
        return this.getMergedEntity(entity).getRol();
    }
    
}
