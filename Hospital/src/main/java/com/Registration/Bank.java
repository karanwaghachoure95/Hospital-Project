package com.Registration;
public interface Bank  {
  public abstract void printDatail(String accountNum,double balance);
  public abstract void otpCheck(String accountNum,String password);
}
