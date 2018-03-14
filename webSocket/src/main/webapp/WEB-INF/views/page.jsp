<%--
  Created by IntelliJ IDEA.
  User: Xie xuepei
  Date: 2018-3-13
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<h1>接受信息的页面</h1>

<script type="text/javascript">

        if ("WebSocket" in window) {
            alert("您的浏览器支持 WebSocket!");

            // 打开一个 web socket
            var ws = new WebSocket("ws://localhost:8080/webSocket/test");

            ws.onmessage = function (evt) {
                var received_msg = evt.data;
                alert("数据已接收..."+received_msg);
            };

            ws.onclose = function () {
                // 关闭 websocket
                alert("连接已关闭...");
            };
        }

        else {
            // 浏览器不支持 WebSocket
            alert("您的浏览器不支持 WebSocket!");
        }

</script>

</html>