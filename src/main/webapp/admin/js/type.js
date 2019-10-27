$(function(){  //加载事件
    //显示数据
    $('#dg').datagrid({
        title:"类型信息",
        url:'getTypeByPage',
        toolbar:"#tb",
        pagination:true,
        pageSize:5,
        pageList:[5,10,15,20],
        columns:[[
            {field:'opt',checkbox:"true"},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'类型名称',width:100},
            {field:'del',title:'操作',width:100,
                formatter: function(value,row,index){
                    return "<a href='javascript:delType("+row.id+")'>删除</a>";
                }
            }
        ]]
    });

});

function add(){
    $("#AddDialog").dialog("setTitle","添加类型");
    $("#AddDialog").dialog("open");
}



function CloseDialog(id){
    $("#"+id).dialog("close");
}

function SaveDialog(){
    $("#addFrom").form('submit',{
        url:"addType",
        success:function(data){
            data=$.parseJSON(data);
            if(data.result==1){
                $("#dg").datagrid('reload');
                $("#AddDialog").dialog("close");
            }else{
                $.messager.alert('提示信息','添加失败!','error');
            }
        }
    });
}

function upd() {
    var datagrid = $("#dg").datagrid('getSelections');
    if (datagrid.length == 1){
        var bh = datagrid[0].id;
        $.post("getType",{"id":bh},function (data) {
            $("#upFrom").form('load',data);
        },"json");
        $("#upDialog").dialog("setTitle","修改类型");
        $("#upDialog").dialog("open");
    }else {
        $.messager.alert('提示信息','你没有选中行或者选中多行','warning');
    }
}



function updateDialog() {
    $("#upFrom").form('submit',{
        url:"upType",
        success:function(data) {
            data=$.parseJSON(data);
            if (data.result == 1){
                $("#dg").datagrid('reload');
                $("#upDialog").dialog("close");
            } else {
                $.messager.alert('提示信息','修改失败!','error');
            }
        }
    })
}

function del() {
    var SelectRows = $("#dg").datagrid('getSelections');
    if(SelectRows.length==0){
        $.messager.alert('提示信息', '你还没有选择删除项',"info");
    }else
    {
        $.messager.confirm('删除类型', '真的想删除吗?', function(r){
            if (r) {
                //拼接删除的字符串
                var ids = "";
                for (var i = 0; i < SelectRows.length; i++) {
                    ids = ids + SelectRows[i].id + ",";
                }
                ids = ids.substring(0, ids.length - 1);
                $.post("delMoreType",{"ids":ids},function(data){
                    if(data.result==1){
                        $("#dg").datagrid('reload'); //刷新
                    }else{
                        $.messager.alert('提示信息','删除失败!','error');
                    }
                },"json");

            }
        });
    }

}

function delType(id){
    //确认提示框
    $.messager.confirm('删除类型', '真的要删除吗?', function(r){
        if (r){
            //删除
            $.post("delType",{"id":id},function(data){
                if(data.result==1){
                    $("#dg").datagrid('reload'); //刷新
                }else{
                    $.messager.alert('提示信息','删除失败!','error');
                }
            },"json");
        }
    });
}