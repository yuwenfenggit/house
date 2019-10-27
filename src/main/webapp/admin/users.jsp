<%--
  Created by IntelliJ IDEA.
  User: Y1737
  Date: 2019/10/17
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <script src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/users.js">
        //加载显示区域

    </script>
</head>
<body>
<div id="tb">
    姓名:<input type="text" name="name" id="name">
    电话:<input type="text" name="tel" id="tel">
    <a href="javascript:search()" class="easyui-linkbutton"
       iconCls="icon-search" plain="true">搜索</a>
</div>
<table id="dg">
</table>
</body>
</html>
