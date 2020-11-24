package at.htl.demo.resource;

import at.htl.demo.entity.Person;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @GET
    public Response getAllPerson() {
        return Response.ok(Person.listAll()).build();
    }

    @POST
    @Transactional
    public Response createPerson(Person person) {
        person.persist();
        return Response.ok(person).build();
    }
}
