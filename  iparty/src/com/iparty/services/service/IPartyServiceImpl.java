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
@Path("/service")
public class IPartyServiceImpl{
	
/*	@Autowired
	IPartyService ipartyService;*/
	//Please maintain the opearation path names here
	private String IPARTY_OPERATION_1_GET_ADMIN_ID = "/getAdminId";
  
	public static ApplicationContext getApplicationContext(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return context;
	}

  /* It returns a new admin user id from the DB sequence ADMIN_ID_SEQ*/
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getNewAdminId")
  public String getNewAdminId() {
	IPartyService ipartyService = (IPartyService)getApplicationContext()
			.getBean(IPartyConstants.IPARTY_SERVICE_SPRING_BEAN_ID);
    return ipartyService.getNewAdminId();
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("say2")
  public String sayPlainTextHello2() {
    return "Hello Jersey 2";
  }

}