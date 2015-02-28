/**
 * 
 */
package com.iparty.util;

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
}
