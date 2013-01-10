/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.NivelInscrito;
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
@Path("entities.nivelinscrito")
public class NivelInscritoFacadeREST extends AbstractFacade<NivelInscrito> {
    @PersistenceContext(unitName = "pruebasRESTPU")
    private EntityManager em;

    public NivelInscritoFacadeREST() {
        super(NivelInscrito.class);
    }

    @POST
    @Override
    @Consumes({ "application/json"})
    public void create(NivelInscrito entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({ "application/json"})
    public void edit(NivelInscrito entity) {
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
    public NivelInscrito find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ "application/json"})
    public List<NivelInscrito> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ "application/json"})
    public List<NivelInscrito> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
