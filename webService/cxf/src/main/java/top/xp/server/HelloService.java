package top.xp.server;

import javax.jws.WebService;

/**
 * @author xiaopeng
 * @date 2018/3/16 10:42
 */
@WebService
public interface HelloService {

    void sayHello();
    String say(String name);

}
