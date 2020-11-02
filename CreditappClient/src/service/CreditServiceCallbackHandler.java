
/**
 * CreditServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package service;

    /**
     *  CreditServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CreditServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CreditServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CreditServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for find method
            * override this method for handling normal response from find operation
            */
           public void receiveResultfind(
                    service.CreditServiceStub.FindResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from find operation
           */
            public void receiveErrorfind(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addClient method
            * override this method for handling normal response from addClient operation
            */
           public void receiveResultaddClient(
                    service.CreditServiceStub.AddClientResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addClient operation
           */
            public void receiveErroraddClient(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for addCredit method
            * override this method for handling normal response from addCredit operation
            */
           public void receiveResultaddCredit(
                    service.CreditServiceStub.AddCreditResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addCredit operation
           */
            public void receiveErroraddCredit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for capital method
            * override this method for handling normal response from capital operation
            */
           public void receiveResultcapital(
                    service.CreditServiceStub.CapitalResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from capital operation
           */
            public void receiveErrorcapital(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCreditsByUsername method
            * override this method for handling normal response from getCreditsByUsername operation
            */
           public void receiveResultgetCreditsByUsername(
                    service.CreditServiceStub.GetCreditsByUsernameResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCreditsByUsername operation
           */
            public void receiveErrorgetCreditsByUsername(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for annuelle method
            * override this method for handling normal response from annuelle operation
            */
           public void receiveResultannuelle(
                    service.CreditServiceStub.AnnuelleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from annuelle operation
           */
            public void receiveErrorannuelle(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for annuite method
            * override this method for handling normal response from annuite operation
            */
           public void receiveResultannuite(
                    service.CreditServiceStub.AnnuiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from annuite operation
           */
            public void receiveErrorannuite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for saveCredit method
            * override this method for handling normal response from saveCredit operation
            */
           public void receiveResultsaveCredit(
                    service.CreditServiceStub.SaveCreditResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from saveCredit operation
           */
            public void receiveErrorsaveCredit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for duree method
            * override this method for handling normal response from duree operation
            */
           public void receiveResultduree(
                    service.CreditServiceStub.DureeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from duree operation
           */
            public void receiveErrorduree(java.lang.Exception e) {
            }
                


    }
    