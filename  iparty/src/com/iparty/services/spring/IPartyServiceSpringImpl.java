/**
 * 
 */
package com.iparty.services.spring;

import com.iparty.services.service.IPartyService;

/**
 * @author vinothkumar pt
 *
 */
public class IPartyServiceSpringImpl implements IPartyService {
	
	@Override
	public String sayPlainTextHello() {
		// TODO Auto-generated method stub
		return "from Spring";
	}
}
