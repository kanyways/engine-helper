<#assign title="错误码"/>

<@override name="content">
<form action="${ctx}/resp/trans" method="post" class="form width-48 pull-left" enctype="multipart/form-data">
    <div class="title">生成错误码SQL</div>
    <div class="input-group">
        <label>银行编号：</label>
        <input type="text" name="bankNo" id="bankNo" placeholder="请输入bankNo" required/>
    </div>

    <div class="input-group">
        <label>错误码文件（Excel）：</label>
        <input type="file" id="excel" name="excel" placeholder="请选择错误码文件" required/>
    </div>

    <button class="btn btn-success" data-loading-text="正在提交..."><@s.message "app.button.save"/></button>
</form>

<div class="width-48 pull-right mt-20 green">
    <div class="ele-title">使用说明：</div>
    <p>1. 下载错误码模板：<a href="${ctx}/download/错误码模板.xlsx" class="underline">错误码模板</a></p>
    <p>2. 把错误码填写到Excel中，不要修改模板结构，程序会从第二行开始读取。</p>
    <p>3. 在左边表单中上传Excel，程序会把excel转成SQL，并输出到下方空白处。</p>
</div>

<div class="clear"></div>

<div class="result">
    <pre class="hidden" id="result"><code></code></pre>
</div>
</@override>

<script>
    $(".form").submit(function () {
        var bankNo = $("#bankNo").val();
        if (!bankNo || bankNo == '') {
            alert("请输入银行编号！");
            return false;
        }

        var filename = $(this).find("input[type='file']").val();
        if (!filename || filename == '') {
            alert("请选择Excel文件");
            return false;
        }

        var type = filename.substring(filename.lastIndexOf("."));
        if (type != '.xlsx' && type != ".xls") {
            alert("您选择的不是Excel文件");
            return false;
        }

        $btn = $(this).find("button");
        $btn.text($btn.attr("data-loading-text")).attr("disabled", "disabled");
        var formData = new FormData();
        formData.append("excel", document.getElementById("excel").files[0]);
        formData.append("bankNo", bankNo);

        $.ajax({
            url: $(this).attr("action"),
            type: "POST",
            data: formData,
            contentType: false,
            processData: false,
            success: function (data) {
                $("#result").removeClass("hidden").find("code").text(data);
                $btn.text("<@s.message "app.button.save"/>").removeAttr("disabled");
            },
            error: function () {
                $("#result").removeClass("hidden").find("code").text("网络错误，请稍后再试！");
                $btn.text("<@s.message "app.button.save"/>").removeAttr("disabled");
            }
        });

        return false;
    });
</script>

<@extends name="../content-layout.ftl"/>
