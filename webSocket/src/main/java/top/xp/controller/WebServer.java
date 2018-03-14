package top.xp.controller;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/webSocket/test")
public class WebServer {
    private boolean isRunning = false;
//      【onopen】websocket建立连接完成并进行发送消息
//    【onclose】websocket连接被关闭或无法建立连接
//    【onmessage】websocket收到数据，发送数据对应socket.send方法
//    【onerror】websocket发生错误

    @OnOpen
    public void open(Session session) {
        isRunning = true;
        System.out.println("open: " + session.getId());
        final RemoteEndpoint.Basic basic = session.getBasicRemote();
        new Thread(new Runnable() {
            public void run() {
                if (isRunning) {
                    try {
                        Thread.sleep(5000);
                        if (session.isOpen()) {
                            System.out.println("后台：发送消息");
                            basic.sendText("来自后台的消息");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException, InterruptedException {
//        message是页面中onopen中的ws.send("发送数据");
//        System.out.println("message: " + session.getId());
//        System.out.println("Received: " + message);
        //接受浏览器页面发送来的信息
        System.out.println("页面："+message);
    }

    @OnClose
    public void close(Session session) {
        isRunning = false;
        System.out.println("close: " + session.getId());
    }

    @OnError
    public void error(Session session, Throwable throwable) {
        System.out.println("error: " + session.getId());
        System.out.println(throwable.getMessage());
    }
}
