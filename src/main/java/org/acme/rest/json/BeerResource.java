package org.acme.rest.json;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class BeerResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Beer> hello() throws InterruptedException {
    	BeerRepository br = new BeerRepository();
    	return br.getBeers();
    }

    @GET
    @Path("/beer/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Beer getBeer(@PathParam(value = "name") String name) {
         return BeerRepository.findByName(name);
      }    
    
    @GET
    @Path("/beer/status/{status}")
    @Produces(MediaType.APPLICATION_JSON)    
    public List<Beer> getByStatus(@PathParam(value = "status") String status) {
         return BeerRepository.findByStatus(status);
      }    
    
}