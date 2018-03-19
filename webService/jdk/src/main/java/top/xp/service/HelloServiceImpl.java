package top.xp.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloServiceImpl implements HelloService {
    @WebMethod
    @Override
    public void sayHello() {
        System.out.println("hi!");
    }
    @WebMethod
    @Override
    public void say(String name) {
        System.out.println("hi,"+name);
    }
}
