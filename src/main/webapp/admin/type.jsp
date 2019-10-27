<%--
  Created by IntelliJ IDEA.
  User: Y1737
  Date: 2019/10/17
  Time: 11:48
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
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/type.js">
        //加载显示区域

    </script>
</head>
<body>
<div id="tb">
    <a href="javascript:add()" class="easyui-linkbutton"
       iconCls="icon-add" plain="true">添加</a>
    <a href="javascript:upd()" class="easyui-linkbutton"
       iconCls="icon-edit" plain="true">修改</a>
    <a href="javascript:del()" class="easyui-linkbutton"
       iconCls="icon-remove" plain="true">删除</a>
</div>
<div id="AddDialog" class="easyui-dialog"
     buttons="#AddDialogButtons"
     style="width: 280px;height: 251px;padding: 10px 20px;" closed="true" data-options="modal:true">
    <form action="add" id="addFrom" name="addFrom" method="post">
        类型名称:<input type="text" name="name">
    </form>
</div>
<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog('AddDialog')"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
<div id="upDialog" class="easyui-dialog"
     buttons="#UpDialogButtons"
     style="width: 280px;height: 251px;padding: 10px 20px;" closed="true" data-options="modal:true">
    <form action="" id="upFrom" name="upFrom" method="post">
        <input type="hidden" name="id" id="id">
        类型名称:<input type="text" name="name">
    </form>
</div>
<div id="UpDialogButtons">
    <a href="javascript:updateDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">修改</a>
    <a href="javascript:CloseDialog('upDialog')"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
<div id="delDialog" class="easyui-dialog"
     buttons="#DelDialogButtons"
     style="width: 280px;height: 251px;padding: 10px 20px;" closed="true" data-options="modal:true">
    <form action="" id="delFrom" name="delFrom" method="post">
        <input type="hidden" name="id" id="did">
        <center>是否删除?</center>
    </form>
</div>
<div id="DelDialogButtons">
    <a href="javascript:delDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">删除</a>
    <a href="javascript:CloseDialog('delDialog')"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
<table id="dg">
    <tr>
        <th field="cb" checkbox="true"></th>
    </tr>
</table>
</body>
</html>
