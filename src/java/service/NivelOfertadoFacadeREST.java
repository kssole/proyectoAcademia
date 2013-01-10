/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.NivelOfertado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;

/**
 *
 * @author Usuario
 */
@Stateless
@Path("entities.nivelofertado")
public class NivelOfertadoFacadeREST extends AbstractFacade<NivelOfertado> {
    @PersistenceContext(unitName = "pruebasRESTPU")
    private EntityManager em;

    public NivelOfertadoFacadeREST() {
        super(NivelOfertado.class);
    }

    @POST
    @Override
    @Consumes({ "application/json"})
    public void create(NivelOfertado entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({ "application/json"})
    public void edit(NivelOfertado entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({ "application/json"})
    public NivelOfertado find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ "application/json"})
    public List<NivelOfertado> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ "application/json"})
    public List<NivelOfertado> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @java.lang.Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
