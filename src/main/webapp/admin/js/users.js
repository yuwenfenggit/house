$(function(){  //加载事件
    //显示数据
    $('#dg').datagrid({
        title:"用户信息",
        url:'getUsersByPage',
        toolbar:"#tb",
        pagination:true,
        pageSize:5,
        pageList:[5,10,15,20],
        columns:[[
            {field:'id',title:'编号',width:100},
            {field:'name',title:'姓名',width:100},
            {field:'telephone',title:'电话',width:100},
            {field:'age',title:'年龄',width:100},
            {field:'del',title:'操作',width:200,
                formatter: function(value,row,index){
                    return "<a href='javascript:delUsers("+row.id+")'>删除</a> | <a href='#'>修改</a>";
                }
            }
        ]]
    });

});

function search() {
    var name = $("#name").val();
    var tel = $("#tel").val();
    $("#dg").datagrid("load",{"name":name,"tel":tel});
}


function delUsers(id) {
    $.messager.confirm('删除用户', '真的要删除吗?',function (r) {
        if (r){
            $.post("delUsers",{"id":id},function (data) {
                if (data.result==1){
                    $("#dg").datagrid('reload'); //刷新
                }else{
                    $.messager.alert('提示信息','删除失败!','error');
                }
            },"json");
        }
    });
}