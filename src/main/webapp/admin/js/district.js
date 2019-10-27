$(function(){  //加载事件
    //显示数据
    $('#dg').datagrid({
        title:"区域信息",
        url:'getDistrictByPage',
        toolbar:"#tb",
        pagination:true,
        pageSize:5,
        pageList:[5,10,15,20],
        columns:[[
            {field:'opt',checkbox:"true"},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'区域名称',width:100},
            {field:'del',title:'操作',width:200,
                formatter: function(value,row,index){
                    return "<a href='javascript:delDistrict("+row.id+")'>删除</a> | <a href='javascript:selDistrict("+row.id+")'>显示街道信息</a>";
                }
            }
        ]]
    });

});

function add(){
    $("#AddDialog").dialog("setTitle","添加区域");
    $("#AddDialog").dialog("open");
}



function CloseDialog(id){
    $("#"+id).dialog("close");
}

function SaveDialog(){
    $("#addFrom").form('submit',{
        url:"addDistrit",
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
        $.post("getDistrit",{"id":bh},function (data) {
            $("#upFrom").form('load',data);
        },"json");
        $("#upDialog").dialog("setTitle","修改区域");
        $("#upDialog").dialog("open");
    }else {
        $.messager.alert('提示信息','你没有选中行或者选中多行','warning');
    }
}



function updateDialog() {
    $("#upFrom").form('submit',{
        url:"upDistrit",
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
        $.messager.confirm('删除区域', '真的想删除吗?', function(r){
            if (r) {
                //拼接删除的字符串
                var ids = "";
                for (var i = 0; i < SelectRows.length; i++) {
                    ids = ids + SelectRows[i].id + ",";
                }
                ids = ids.substring(0, ids.length - 1);
                $.post("delMoreDistrit",{"ids":ids},function(data){
                    if(data==1){
                        $("#dg").datagrid('reload'); //刷新
                    }else{
                        $.messager.alert('提示信息','删除失败!','error');
                    }
                },"json");

            }
        });
    }
}

function delDistrict(id){
    //确认提示框
    $.messager.confirm('删除区域', '真的要删除吗?', function(r){
        if (r){
            //删除
            $.post("delDistrit",{"id":id},function(data){
                if(data==1){
                    $("#dg").datagrid('reload'); //刷新
                }else{
                    $.messager.alert('提示信息','删除失败!','error');
                }
            },"json");
        }
    });
}


function selDistrict(id) {
    $('#dg1').datagrid({
        title:"街道信息",
        url:'getStreetByPage?id='+id,
        pagination:true,
        pageSize:5,
        pageList:[5,10,15,20],
        columns:[[
            {field:'id',title:'编号',width:100},
            {field:'name',title:'街道名称',width:100},
        ]]
    });
}