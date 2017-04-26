<#assign title="错误码"/>

<@override name="content">
<#--<a href="${ctx}/download/错误码模板.xlsx" class="pull-right">下载错误码模板</a>-->

<form action="#resp/trans" method="post" class="form width-48 pull-left" enctype="multipart/form-data">
    <div class="title">生成错误码SQL</div>
    <div class="input-group">
        <label>银行编号：</label>
        <input type="text" name="bankNo" placeholder="请输入bankNo" required/>
    </div>

    <div class="input-group">
        <label>错误码文件（Excel）：</label>
        <input type="file" name="excel" placeholder="请选择错误码文件" required/>
    </div>

    <button class="btn btn-success" data-loading-text="正在提交..."><@s.message "app.button.save"/></button>
</form>

<div class="pull-right width-48 result">
    <#if result??>
        <pre><code>${result?html}</code></pre>
    </#if>
</div>
</@override>

<script>
    $(".form").submit(function () {
        $btn = $(this).find("button");
        $btn.text($btn.attr("data-loading-text")).attr("disabled", "disabled");
    });
</script>

<@extends name="../content-layout.ftl"/>
