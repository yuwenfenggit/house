$(function(){  //加载事件
    //显示数据
    $('#dg').datagrid({
        title:"审核信息",
        url:'getIspassBypage',
        toolbar:"#tb",
        pagination:true,
        pageSize:5,
        pageList:[5,10,15,20],
        columns:[[
            {field:'opt',checkbox:"true",width:100},
            {field:'id',title:'编号',width:100},
            {field:'title',title:'标题',width:100},
            {field:'dname',title:'区域名称',width:100},
            {field:'sname',title:'街道名称',width:100},
            {field:'tname',title:'类型名称',width:100},
            {field:'floorage',title:'面积',width:100},
            {field:'price',title:'价格',width:100},
            {field:'contact',title:'电话',width:100},
            {field:'dd',title:'操作',width:100,
                formatter: function(value,row,index){
                    return "<a href='javascript:HouseIpass("+row.id+")'>取消审核</a>";
                }
            }
        ]]
    });

});


function HouseIpass(id) {
    $.post("goNoHouseIpass",{"id":id},function (data) {
        if(data.result>0){
            $('#dg').datagrid("reload");
        }else {
            $.messager.alert("提示信息","审核失败!","error")
        }
    },"json")
}