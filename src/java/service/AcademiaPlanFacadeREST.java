/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.AcademiaPlan;
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
@Path("entities.academiaplan")
public class AcademiaPlanFacadeREST extends AbstractFacade<AcademiaPlan> {
    @PersistenceContext(unitName = "pruebasRESTPU")
    private EntityManager em;

    public AcademiaPlanFacadeREST() {
        super(AcademiaPlan.class);
    }

    @POST
    @Override
    @Consumes({ "application/json"})
    public void create(AcademiaPlan entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({ "application/json"})
    public void edit(AcademiaPlan entity) {
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
    public AcademiaPlan find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ "application/json"})
    public List<AcademiaPlan> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ "application/json"})
    public List<AcademiaPlan> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
