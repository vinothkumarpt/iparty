/**
 * 
 */
package com.iparty.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Vinothkumar P T
 *
 */
public class IPartyUtil {
	
  /*This method was created to log the event method enters*/	
  public static String getMethodEnterMessage(String className, String methodName){
		 return className+IPartyConstants.DOT+methodName+IPartyConstants.STR_METHOD_STARTS;
  } 
  
  /*This method was created to log method exits*/	
  public static String getMethodExitMessage(String className, String methodName){
		 return className+IPartyConstants.DOT+methodName+IPartyConstants.STR_METHOD_ENDS;
  }
  
  public static Boolean isNull(Object obj){
	  if(obj != null){
		  return false;
	  }
	  else{
		  return true;
	  }
  }
  
  public static Boolean isNotNull(Object obj){
	  return !isNull(obj);
  }
  
/*  public static String club(Object... obj){
	 StringBuffer buff = new StringBuffer(); 
	  
	 for(Object object: obj){
		 buff.append(object);
		 buff.append(IPartyConstants.STR_SPACE) ;
	 }
	  
	 return buff.toString().trim();
  }*/
  
  public static Timestamp timeStampNow(){
	  return new Timestamp(new Date().getTime());
  }

}
