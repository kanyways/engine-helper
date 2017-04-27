<#assign title="鉴权"/>
<#assign env = RequestParameters.env!'' />
<#assign bankNo = RequestParameters.bankNo!'' />
<#assign accountNo = RequestParameters.accountNo!'测试客户3006186035' />
<#assign accountName = RequestParameters.accountName!'620522201000017606' />
<#assign idNo = RequestParameters.idNo!'320681198511254646' />
<#assign mobileNo = RequestParameters.mobileNo!'13851903765' />

<@override name="content">
<form action="#trans/verify" method="post" class="form">
    <div class="title">鉴权交易(verify)</div>

    <div class="input-group">
        <label>交易环境：</label>
        <select name="env" required>
            <option value="dev">dev环境</option>
            <option value="uat" <#if env=='uat'>selected</#if>>uat环境</option>
        </select>
    </div>

    <div class="input-group">
        <label>银行通道(bankNo)：</label>
        <select name="bankNo" required>
            <#list beChannelConfs as channelConf>
                <option value="${channelConf.bankNo}" <#if bankNo==channelConf.bankNo>selected</#if>>${channelConf.routeName}(${channelConf.bankNo})</option>
            </#list>
        </select>
    </div>

    <div class="input-group">
        <label>卡号(accountNo):</label>
        <input type="text" name="accountNo" value="${accountNo}" required/>
    </div>

    <div class="input-group">
        <label>户名(accountName):</label>
        <input type="text" name="accountName" value="${accountName}" required/>
    </div>

    <div class="input-group">
        <label>证件号(idNo):</label>
        <input type="text" name="idNo" value="${idNo}" required/>
    </div>

    <div class="input-group">
        <label>手机号(mobileNo):</label>
        <input type="text" name="mobileNo" value="${mobileNo}" required/>
    </div>

    <button class="btn btn-success" data-loading-text="正在提交..."><@s.message "app.button.save"/></button>
</form>

<div class="result">
    <#if result??>
        <pre><code>${result?html}</code></pre>
    </#if>
</div>
</@override>

<script>
    $(".form").submit(function () {
        $btn = $(this).find("button");
        $btn.text($btn.attr("data-loading-text")).attr("disabled", "disabled");
        $(".result").addClass("hidden");
    });
</script>

<@extends name="../content-layout.ftl"/>
