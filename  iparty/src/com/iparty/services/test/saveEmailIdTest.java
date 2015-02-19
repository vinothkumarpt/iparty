package com.iparty.services.test;


import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.iparty.services.dao.entity.PartyUserEntity;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;


public class saveEmailIdTest {

	public static void main(String[] args) {

	    /*ClientConfig config = new ClientConfig();

	    Client client = ClientBuilder.newClient(config);

	    WebTarget target = client.target(getBaseURI());
	    
	    PartyUserEntity partyUserEntity= new PartyUserEntity();
	    
	    partyUserEntity.setUserEmail("setrfsf");
	    partyUserEntity.setUserId(123);
	    
	    PartyUserEntity partyUserEntit2y[]= {partyUserEntity};
	    
	    target.request().header("Accept", "application/json");
	    target.request().header("Content-Type", "application/json");
	    String in = "\"person\":{\"name\":\"xyz\"}";
	    //in = "\"name\":\"xyz\"";
	    System.out.println(target.request()

	    .accept(MediaType.APPLICATION_JSON).post(Entity.entity(in, "application/json")).toString()

	  );*/



	  }

	  private static URI getBaseURI() {

	    return UriBuilder.fromUri("http://localhost:8090/iparty/rest/service/saveEmail2").build();

	  }
	 
	

}
