<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
  <script src="../scripts/jquery-1.8.3.js"></script>
<LINK rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<script>
    $(function(){
        $.post("getAllType",null,function (data) {
            for (var i = 0; i <data.length ; i++) {
                var option = $("<option value="+data[i].id+">"+data[i].name+"</option>");
                $("#type_id").append(option);
            }
            $("#type_id").val(${condition.tid})
        },"json");

        $.post("getAllDistrict",null,function (data) {
            for (var i = 0; i <data.length ; i++) {
                var option = $("<option value="+data[i].id+">"+data[i].name+"</option>");
                $("#district_id").append(option);
            }
            $("#district_id").val(${condition.did});
            changeStreet();
        },"json");

        $("#district_id").change(function () {
            changeStreet();
        });
    });

    function  changeStreet() {
        var did = $("#district_id").val();
        $("#street_id>option:gt(0)").remove();
        $.post("getAllStreet",{"did":did},function (data) {
            for (var i = 0; i <data.length ; i++) {
                var option = $("<option value="+data[i].id+">"+data[i].name+"</option>");
                $("#street_id").append(option)
            }
            $("#street_id").val(${condition.sid})
        },"json");
    }
    
    function goPage(num) {
        $("#setPage").val(num);
        $("#sform").submit();
    }
</script>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id=sform method=post action=selectHouse>
    <LI class=bold>房屋信息</LI>
    <input type="hidden" name="setPage" id="setPage" value="1">
    标题：<INPUT class=text type=text name=title value="${condition.title}">
    区域:
        <SELECT id=district_id name=did>
          <OPTION selected value="">不限</OPTION>
        </SELECT>
    街道:
        <SELECT id=street_id name=sid>
          <OPTION selected value="">不限</OPTION>
        </SELECT>
    房型:
        <SELECT name=tid id=type_id>
          <OPTION selected value="">不限</OPTION>
        </SELECT>
    价格:
      <input type="text" name="startPrice" value="${condition.startPrice}"> -
      <input type="text" name="endPrice" value="${condition.endPrice}">
      <input type="submit" name=search value="搜索">
</FORM></DL></DIV>
<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>
  <c:forEach items="${houses.list}" var="h">
    <TR>
      <TD class=house-thumb><span><A href="details.htm" target="_blank">
        <img src="http://localhost:80/${h.path}" width="100" height="75" alt="">
      </a></span></TD>
      <TD>
        <DL>
          <DT><A href="details.htm" target="_blank">${h.title}</A></DT>
          <DD>${h.dname}${h.sname},${h.floorage}平米<BR>联系方式:${h.contact}</DD></DL></TD>
      <TD class=house-type>${h.tname}</TD>
      <TD class=house-price><SPAN>${h.price}</SPAN>元/月</TD></TR>
  </c:forEach>
  <TR>无租房信息</TR></TBODY></TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="javascript:goPage(1)">首页</A></LI>
  <LI><A href="javascript:goPage(${houses.prePage == 0?1:houses.prePage})">上一页</A></LI>
  <LI><A href="javascript:goPage(${houses.prePage == 0?houses.prePage:houses.nextPage})">下一页</A></LI>
  <LI><A href="javascript:goPage(${houses.pages})">末页</A></LI></UL><SPAN
class=total>${houses.pageNum}/${houses.pages}页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
