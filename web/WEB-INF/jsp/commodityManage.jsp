<%--
  Created by IntelliJ IDEA.
  User: cdewse
  Date: 17-5-16
  Time: 下午7:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ex" uri="http://www.cdewse.com/tags" %>
<html>
<head>
    <title>商品管理界面</title>
    <script src="/js/jquery-3.2.0.min.js"></script>
    <script>
        function upLoad(obj){ //图片预览以及ajax异步上传
            var preView = $('#preView')[0];
            var image = obj.files[0];
            var fileReader = new FileReader();
            //js的ajax异步请求的关键
            var request = new XMLHttpRequest();
            fileReader.readAsDataURL(image);
            //设置ajax回调函数
            request.onreadystatechange = callback;
            //文件上传完成时执行
            fileReader.onload = function(e) { //小写
                preView.src = e.target.result;
                //post方法，第二个表示url地址，第三个表示同步还是异步，true异步
                request.open("post","uploadAction",true);
                //post方法要自己写请求头
                request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                //发送数据
                request.send("image="+e.target.result+"&imageName="+obj.value);
            };
            //定义回调函数
            function callback() {
                //判断对象的状态是交互完成
                if (request.readyState == 4){
                    //判断http的交互是否成功
                    if (request.status == 200){
                        //获取服务器端返回的数据
                        //获取服务器端输出的纯文本数据
                        var responseText = request.responseText;
                        var picture = $('#picture')[0];
                        picture.value = responseText;
                    }
                }
            }
        }

    </script>
</head>
<body>
    <%--<form>--%>
        <%--<table>--%>
            <%--<ex:ListCommodity/>--%>
        <%--</table>--%>
    <%--</form>--%>
    <form action="addCommodity.action">
        <table>
            <tr>
                <td><label><span>商品名称</span></label></td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td><label><span>品牌</span></label></td>
                <td><input type="text" name="brand" required></td>
            </tr>
            <tr>
                <td><label><span>进价</span></label></td>
                <td><input type="text" name="inputPrice" required
                pattern="^\d+(.\d+)\d*$"></td>
            </tr>
            <tr>
                <td><label><span>售价</span></label></td>
                <td><input type="text" name="outputPrice" required
                           pattern="^\d+(.\d+)\d*$"></td>
            </tr>
            <tr>
                <td><label><span>质量</span></label></td>
                <td><input type="text" name="quality" required
                           pattern="^\d+(.\d+)\d*$"></td>
            </tr>
            <tr>
                <td><label><span>货存</span></label></td>
                <td><input type="number" name="amount" required></td>
            </tr>
            <tr>
                <td><label><span>类型</span></label></td>
                <td><input type="number" name="type" required></td>
            </tr>
            <tr>
                <td><label><span>图片</span></label></td>
                <td><input type="file" name="imgSelect" accept=".jpg,.png" onchange="upLoad(this)"></td>
                <td><input type="hidden" id="picture" name="picture" value=""></td>
            </tr>
            <tr>
                <td></td>
                <td><span style="height: 30px;width: 80px;"><img id="preView" src=""></span></td>
            </tr>
            <tr>
                <td><input type="submit"></td>
            </tr>
        </table>
    </form>
</body>
</html>
