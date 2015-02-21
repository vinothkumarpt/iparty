package com.iparty.services.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iparty.services.dao.entity.PartyUserEntity;
import com.iparty.util.IPartyConstants;


/**
 * @author vinothkumar pt
 *
 */
@Path("/service")
public class IPartyServiceImpl implements IPartyService{
	private String CLASS_NAME = "IPartyServiceImpl";
	
/*	@Autowired
	IPartyService ipartyService;*/
	//Please maintain the opearation path names here
	private String IPARTY_OPERATION_1_GET_ADMIN_ID = "/newAdminId";
	private String IPARTY_OPERATION_2_GET_PARTY_ID = "/newPartyId";
	private String IPARTY_OPERATION_3_USER_REGISTRATION = "/userRegist";
  
	public static ApplicationContext getApplicationContext(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				IPartyConstants.IPARTY_SERVICE_SPRING_XML_CONTEXT_PATH);
		return context;
	}

  /* It returns a new admin user id from the DB sequence ADMIN_ID_SEQ*/
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/newAdminId")
  public Integer getNewAdminId() {
	IPartyService ipartyService = (IPartyService)getApplicationContext()
			.getBean(IPartyConstants.IPARTY_SERVICE_SPRING_BEAN_ID);
    return ipartyService.getNewAdminId();
  }

  /* It returns a new party id from the DB sequence PARTY_ID_SEQ*/
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/newPartyId")
  public Integer getNewPartyId() {
	// TODO Auto-generated method stub
	IPartyService ipartyService = (IPartyService)getApplicationContext()
				.getBean(IPartyConstants.IPARTY_SERVICE_SPRING_BEAN_ID);
	return ipartyService.getNewPartyId();
  }

  /* It saves party users in the PARTY_USER table*/
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/userRegist")
  public String registerPartyUser(PartyUserEntity partyUserEntity[]) {
	// TODO Auto-generated method stub
	IPartyService ipartyService = (IPartyService)getApplicationContext()
				.getBean(IPartyConstants.IPARTY_SERVICE_SPRING_BEAN_ID);
	return ipartyService.registerPartyUser(partyUserEntity);  
  }  

}