
package top.xp.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloServiceImpl", targetNamespace = "http://service.xp.top/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloServiceImpl {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://service.xp.top/", className = "top.xp.client.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://service.xp.top/", className = "top.xp.client.SayHelloResponse")
    @Action(input = "http://service.xp.top/HelloServiceImpl/sayHelloRequest", output = "http://service.xp.top/HelloServiceImpl/sayHelloResponse")
    public void sayHello();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "say", targetNamespace = "http://service.xp.top/", className = "top.xp.client.Say")
    @ResponseWrapper(localName = "sayResponse", targetNamespace = "http://service.xp.top/", className = "top.xp.client.SayResponse")
    @Action(input = "http://service.xp.top/HelloServiceImpl/sayRequest", output = "http://service.xp.top/HelloServiceImpl/sayResponse")
    public void say(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
