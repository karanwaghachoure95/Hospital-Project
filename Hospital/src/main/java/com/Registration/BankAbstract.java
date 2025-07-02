package com.Registration;

public abstract class BankAbstract implements Bank{
	   @Override
	  public  void printDatail(String accountNum,double balance){//jab abtract class mein interface ki method ko ovveride karte vakt public lagana jaruri hai nahi lagaoke tho error degha.S

	   }

	   @Override
	   public  void otpCheck(String accountNum,String password) {
		   
	   }
}
