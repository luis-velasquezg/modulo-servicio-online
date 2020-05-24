/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Tiquetevuelo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Tiquetevuelo_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Tipoclase;
import entities.Temporada;
import entities.Tipotarjeta;
import entities.Usuario;
import entities.Vuelo;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class TiquetevueloFacade extends AbstractFacade<Tiquetevuelo> {

    @PersistenceContext(unitName = "Modulo_Servicios_OnlinePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiquetevueloFacade() {
        super(Tiquetevuelo.class);
    }

    public boolean isClaseEmpty(Tiquetevuelo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tiquetevuelo> tiquetevuelo = cq.from(Tiquetevuelo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tiquetevuelo, entity), cb.isNotNull(tiquetevuelo.get(Tiquetevuelo_.clase)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Tipoclase findClase(Tiquetevuelo entity) {
        return this.getMergedEntity(entity).getClase();
    }

    public boolean isTemporadaEmpty(Tiquetevuelo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tiquetevuelo> tiquetevuelo = cq.from(Tiquetevuelo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tiquetevuelo, entity), cb.isNotNull(tiquetevuelo.get(Tiquetevuelo_.temporada)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Temporada findTemporada(Tiquetevuelo entity) {
        return this.getMergedEntity(entity).getTemporada();
    }

    public boolean isTipoTarjetaEmpty(Tiquetevuelo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tiquetevuelo> tiquetevuelo = cq.from(Tiquetevuelo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tiquetevuelo, entity), cb.isNotNull(tiquetevuelo.get(Tiquetevuelo_.tipoTarjeta)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Tipotarjeta findTipoTarjeta(Tiquetevuelo entity) {
        return this.getMergedEntity(entity).getTipoTarjeta();
    }

    public boolean isUsuarioTiketEmpty(Tiquetevuelo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tiquetevuelo> tiquetevuelo = cq.from(Tiquetevuelo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tiquetevuelo, entity), cb.isNotNull(tiquetevuelo.get(Tiquetevuelo_.usuarioTiket)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findUsuarioTiket(Tiquetevuelo entity) {
        return this.getMergedEntity(entity).getUsuarioTiket();
    }

    public boolean isVueloEmpty(Tiquetevuelo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tiquetevuelo> tiquetevuelo = cq.from(Tiquetevuelo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tiquetevuelo, entity), cb.isNotNull(tiquetevuelo.get(Tiquetevuelo_.vuelo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Vuelo findVuelo(Tiquetevuelo entity) {
        return this.getMergedEntity(entity).getVuelo();
    }
    
}
