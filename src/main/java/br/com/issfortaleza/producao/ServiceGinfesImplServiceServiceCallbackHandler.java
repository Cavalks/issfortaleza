/**
 * ServiceGinfesImplServiceServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */
package br.com.issfortaleza.producao;


/**
 *  ServiceGinfesImplServiceServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class ServiceGinfesImplServiceServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public ServiceGinfesImplServiceServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public ServiceGinfesImplServiceServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for CancelarNfse method
     * override this method for handling normal response from CancelarNfse operation
     */
    public void receiveResultCancelarNfse(
        br.com.issfortaleza.producao.ServiceGinfesImplServiceServiceStub.CancelarNfseResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from CancelarNfse operation
     */
    public void receiveErrorCancelarNfse(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for RecepcionarLoteRpsV3 method
     * override this method for handling normal response from RecepcionarLoteRpsV3 operation
     */
    public void receiveResultRecepcionarLoteRpsV3(
        br.com.issfortaleza.producao.ServiceGinfesImplServiceServiceStub.RecepcionarLoteRpsV3Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from RecepcionarLoteRpsV3 operation
     */
    public void receiveErrorRecepcionarLoteRpsV3(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for ConsultarLoteRpsV3 method
     * override this method for handling normal response from ConsultarLoteRpsV3 operation
     */
    public void receiveResultConsultarLoteRpsV3(
        br.com.issfortaleza.producao.ServiceGinfesImplServiceServiceStub.ConsultarLoteRpsV3Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from ConsultarLoteRpsV3 operation
     */
    public void receiveErrorConsultarLoteRpsV3(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for ConsultarNfsePorRpsV3 method
     * override this method for handling normal response from ConsultarNfsePorRpsV3 operation
     */
    public void receiveResultConsultarNfsePorRpsV3(
        br.com.issfortaleza.producao.ServiceGinfesImplServiceServiceStub.ConsultarNfsePorRpsV3Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from ConsultarNfsePorRpsV3 operation
     */
    public void receiveErrorConsultarNfsePorRpsV3(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for ConsultarNfseV3 method
     * override this method for handling normal response from ConsultarNfseV3 operation
     */
    public void receiveResultConsultarNfseV3(
        br.com.issfortaleza.producao.ServiceGinfesImplServiceServiceStub.ConsultarNfseV3Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from ConsultarNfseV3 operation
     */
    public void receiveErrorConsultarNfseV3(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for ConsultarSituacaoLoteRpsV3 method
     * override this method for handling normal response from ConsultarSituacaoLoteRpsV3 operation
     */
    public void receiveResultConsultarSituacaoLoteRpsV3(
        br.com.issfortaleza.producao.ServiceGinfesImplServiceServiceStub.ConsultarSituacaoLoteRpsV3Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from ConsultarSituacaoLoteRpsV3 operation
     */
    public void receiveErrorConsultarSituacaoLoteRpsV3(java.lang.Exception e) {
    }
}
