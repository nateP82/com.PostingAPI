package com.posting.resource;

import com.posting.entity.*;
import com.posting.persistence.*;
import com.google.gson.Gson;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/servicesV2/{id: [0-9]*}/")
public class servicesV2 {
    private GenericDao<Service> comPoster = new GenericDao(Service.class);
    private Gson gson = new Gson();

    @GET
    @Produces
    public Response getRequestPlainText(@PathParam("id") int id) {
        String serviceData = comPoster.getById(id).toString();
        return Response.status(200).entity(serviceData).build();
    }
    @GET
    @Produces({"text/html"})
    public Response getRequestHtml(@PathParam("id") int id) {
        Service serviceData = comPoster.getById(id);
        String returnHtml = "<h1>Service:</h1><br><p>" + serviceData.getName() + "</p><p>" + serviceData.getDescription() + "</p>";
        return Response.status(200).entity(returnHtml).build();
    }
    @GET
    @Produces({"application/json"})
    public Response getRequestJson(@PathParam("id") int id) {
        Service serviceData = comPoster.getById(id);
        String formattedData = this.gson.toJson(serviceData);
        return Response.status(200).entity(formattedData).build();
    }/**
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public Response postRequest(MultivaluedMap<String, String> formParameters) {
        comPoster.addEntity(formParameters.get("name"),formParameters.get("description"));
    }
    @PUT
    @Consumes("application/x-www-form-urlencoded")
    public Response putRequest(MultivaluedMap<String, String> formParameters) {
        comPoster.updateEntity(formParameters.get("id"),formParameters.get("name"),formParameters.get("description"))
    }
    @DELETE
    @Consumes("application/x-www-form-urlencoded")
    public Response deleteRequest(@PathParam("id") int id, MultivaluedMap<String, String> formParameters){
        comPoster.deleteEntity(id);
    }**/
}
