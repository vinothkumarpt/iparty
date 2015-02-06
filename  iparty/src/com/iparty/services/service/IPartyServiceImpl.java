package com.iparty.services.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iparty.util.IPartyConstants;


/**
 * @author vinothkumar pt
 *
 */
@Path("/hello")
public class IPartyServiceImpl{
	
/*	@Autowired
	IPartyService ipartyService;*/
  
	public static ApplicationContext getApplicationContext(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return context;
	}

	
/*  public void setIpartyService(IPartyService ipartyService) {
	this.ipartyService = ipartyService;
  }*/

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/say")
  public String sayPlainTextHello() {
	IPartyService ipartyService = (IPartyService)getApplicationContext()
			.getBean(IPartyConstants.IPARTY_SERVICE_SPRING_BEAN_ID);
    return ipartyService.sayPlainTextHello();
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("say2")
  public String sayPlainTextHello2() {
    return "Hello Jersey 2";
  }

}