package com.iparty.services.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author vinothkumar pt
 *
 */
@Path("/hello")
@Component
public class IPartyServiceImpl{
	
  @Autowired
  IPartyService ipartyService;

  public void setIpartyService(IPartyService ipartyService) {
	this.ipartyService = ipartyService;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/say")
  public String sayPlainTextHello() {
    return ipartyService.sayPlainTextHello();
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("say2")
  public String sayPlainTextHello2() {
    return "Hello Jersey 2";
  }

}