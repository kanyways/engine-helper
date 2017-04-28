<#assign title="交易查询"/>
<#assign env = RequestParameters.env!'' />
<#assign serialNo = RequestParameters.serialNo!'' />

<@override name="content">
<form action="#query/trans" method="POST" class="form">
    <div class="title">交易查询</div>

    <div class="input-group">
        <label>交易环境：</label>
        <select name="env" required>
            <option value="dev">dev环境</option>
            <option value="uat" <#if env=='uat'>selected</#if>>uat环境</option>
        </select>
    </div>

    <div class="input-group">
        <label>流水号(serialNo)：</label>
        <input type="text" name="serialNo" value="${serialNo}" placeholder="请输入serialNo" required/>
    </div>

    <button class="btn btn-success" data-loading-text="正在提交..."><@s.message "app.button.save"/></button>
</form>

    <#if result??>
    <div class="result">
        <pre><code>${result?html}</code></pre>
    </div>
    </#if>
</@override>

<script>
    $(".form").submit(function () {
        $btn = $(this).find("button");
        $btn.text($btn.attr("data-loading-text")).attr("disabled", "disabled");

        $(".result").addClass("hidden");
    });
</script>

<@extends name="../content-layout.ftl"/>
