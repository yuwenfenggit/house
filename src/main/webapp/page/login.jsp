﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0032)http://localhost:8080/HouseRent/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 用户登录</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script src="../scripts/jquery-1.8.3.js"></script>
<%--<script>--%>
    <%--$(function(){--%>
        <%--$("#but1").click(function(){--%>
            <%--$.post("sendCode",{"sendPhone":$("#input_tel").val()},function(data){--%>
                <%--if(data.result>0){--%>
                    <%--alert("发送成功");--%>
                <%--}else{--%>
                    <%--alert("短信发送失败...");--%>
                <%--}--%>
            <%--},"json");--%>
        <%--});--%>

    <%--});--%>
<%--</script>--%>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DIV class=box>
<H4>用户登录</H4>
<FORM id=user method=post name=user action=loginUser>
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD colSpan=2></TD></TR>
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD><!-- <input type="text" class="text" name="name" /> --><INPUT 
      id=user_name class=text type=text name=name> </TD></TR>
  <TR>
    <TD class=field>密　　码：</TD>
    <TD><!-- <input type="password" class="text" name="password" /> --><INPUT 
      id=user_password class=text type=password name=password> </TD></TR>
  <%--<TR>--%>
    <%--<TD class=field>手机号：</TD>--%>
    <%--<TD><INPUT id=input_tel class=text type=text name=name> <input type="button" id="but1" name="ss" value="获取验证码"> </TD></TR>--%>
  <%--<TR>--%>
  <%--<TR>--%>
    <%--<TD class=field>输入验证码：</TD>--%>
    <%--<TD><INPUT id=code class=text type=text name=code></TD></TR>--%>
  </TBODY></TABLE>
<DIV class=buttons> <INPUT name="sub" value=登陆 type=submit> <INPUT onclick='document.location="regs.jsp"' value=注册 type=button>
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
