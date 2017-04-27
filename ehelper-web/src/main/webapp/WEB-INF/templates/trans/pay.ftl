<#assign title="申购"/>
<#assign bankNo = RequestParameters.bankNo!'' />
<#assign senderAccountName = RequestParameters.senderAccountName!'测试客户3006186035' />
<#assign senderAccountNo = RequestParameters.senderAccountNo!'620522201000017606' />
<#assign senderIdNo = RequestParameters.senderIdNo!'320681198511254646' />
<#assign mobileNo = RequestParameters.mobileNo!'13851903765' />
<#assign amount = RequestParameters.amount!'0.05' />

<@override name="content">
<form action="#trans/pay" method="post" class="form">
    <div class="title">申购交易(redeemPrivate)</div>
    <div class="input-group">
        <label>银行通道(bankNo)：</label>
        <select name="bankNo" required>
            <#list beChannelConfs as channelConf>
                <option value="${channelConf.bankNo}" <#if bankNo==channelConf.bankNo>selected</#if>>${channelConf.routeName}(${channelConf.bankNo})</option>
            </#list>
        </select>
    </div>

    <div class="input-group">
        <label>出款方账号(senderAccountNo):</label>
        <input type="text" name="senderAccountNo" value="${senderAccountNo}" required/>
    </div>

    <div class="input-group">
        <label>出款方户名(senderAccountName):</label>
        <input type="text" name="senderAccountName" value="${senderAccountName}" required/>
    </div>

    <div class="input-group">
        <label>出款方证件号(senderIdNo):</label>
        <input type="text" name="senderIdNo" value="${senderIdNo}" required/>
    </div>

    <div class="input-group">
        <label>手机号(mobileNo):</label>
        <input type="text" name="mobileNo" value="${mobileNo}" required/>
    </div>

    <div class="input-group">
        <label>交易金额(amount):</label>
        <input type="text" name="amount" value="${amount}" required/>
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
    });
</script>

<@extends name="../content-layout.ftl"/>
