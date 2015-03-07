package com.iparty.services.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iparty.controllers.CommonController;
import com.iparty.services.dao.entity.PartyAdminEntity;
import com.iparty.services.dao.entity.PartyUserEntity;
import com.iparty.services.service.response.PartyUserResponse;
import com.iparty.util.IPartyConstants;
import com.iparty.util.IPartyUtil;


/**
 * @author vinothkumar pt
 *
 */
@Path("/service")
public class IPartyServiceImpl implements IPartyService{
	private final  String CLASS_NAME = "IPartyServiceImpl";
	
	private final static Logger logger = Logger.getLogger(CommonController.class);
	
/*	@Autowired
	IPartyService ipartyService;*/
	//Please maintain the opearation path names here
	private String IPARTY_OPERATION_1_GET_ADMIN_ID = "/newAdminId";
	private String IPARTY_OPERATION_2_GET_PARTY_ID = "/newPartyId";
	private String IPARTY_OPERATION_3_USER_REGISTRATION = "/userRegist";
	private String IPARTY_OPERATION_4_PARTY_TRASH = "/trash";
	private String IPARTY_OPERATION_5_ADMIN_REGISTRATION = "adminRegist";
	
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
  public PartyUserResponse registerPartyUser(PartyUserEntity partyUserEntity[]) {

	String methodName="registerPartyUser";
	logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName));  
	//Calling Spring
	IPartyService ipartyService = (IPartyService)getApplicationContext()
				.getBean(IPartyConstants.IPARTY_SERVICE_SPRING_BEAN_ID);
	
	PartyUserResponse userResponse = ipartyService.registerPartyUser(partyUserEntity);  
	logger.debug("Party User Response: "+userResponse.getAdminId()
			+IPartyConstants.STR_SPACE+ 
			userResponse.getPartyId()
			+IPartyConstants.STR_SPACE+
			userResponse.getUserCnt()+
			IPartyConstants.STR_SPACE+userResponse.getStatus());
	
	logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName));  
	
	return userResponse;
  }

  /* It deletes party details from all the tables*/
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/trash")
  public Boolean trash(
		  @QueryParam("adminId") Integer adminId, 
		  @QueryParam("partyId") Integer partyId) {
	  
	String methodName="trash";
	logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName));  
	//Calling Spring
	IPartyService ipartyService = (IPartyService)getApplicationContext()
				.getBean(IPartyConstants.IPARTY_SERVICE_SPRING_BEAN_ID);
	
	boolean isTrashed = ipartyService.trash(adminId, partyId);

	logger.debug("Is Trashed "+isTrashed);
	logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName));  	
	return isTrashed;
  }

  /* It saves admin user in the PARTY_ADMIN table*/
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/adminRegist")
  public PartyUserResponse registerAdmin(PartyAdminEntity partyAdminEntity) {
	String methodName="registerAdmin";
	
	logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName));  
	//Calling Spring
	IPartyService ipartyService = (IPartyService)getApplicationContext()
				.getBean(IPartyConstants.IPARTY_SERVICE_SPRING_BEAN_ID);
	
	PartyUserResponse userResponse = ipartyService.registerAdmin(partyAdminEntity);  
	
	logger.debug("Admin Response: "+userResponse.getAdminId()+
			IPartyConstants.STR_SPACE+userResponse.getStatus());
	
	logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName));  
	
	return userResponse; 	
  }  

}