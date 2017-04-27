<#assign title="对私赎回"/>
<#assign bankNo = RequestParameters.bankNo!'' />
<#assign receiverBankNo = RequestParameters.receiverBankNo!'' />
<#assign receiverAccountNo = RequestParameters.receiverAccountNo!'300113085110013' />
<#assign receiverAccountName = RequestParameters.receiverAccountName!'测试客户3001130851' />
<#assign receiverIdNo = RequestParameters.receiverIdNo!'620111198506020014' />
<#assign routeCode = RequestParameters.routeCode!'' />
<#assign amount = RequestParameters.amount!'0.03' />

<@override name="content">
<form action="#trans/redeemPrivate" method="post" class="form">
    <div class="title">对私赎回交易(redeemPrivate)</div>
    <div class="input-group">
        <label>银行通道(bankNo)：</label>
        <select name="bankNo" required>
            <#list beChannelConfs as channelConf>
                <option value="${channelConf.bankNo}" <#if bankNo==channelConf.bankNo>selected</#if>>${channelConf.routeName}(${channelConf.bankNo})</option>
            </#list>
        </select>
    </div>

    <div class="input-group">
        <label>收款方银行编号(receiverBankNo):</label>
        <input type="text" name="receiverBankNo" value="${receiverBankNo}" required/>
    </div>

    <div class="input-group">
        <label>收款方账号(receiverAccountNo):</label>
        <input type="text" name="receiverAccountNo" value="${receiverAccountNo}" required/>
    </div>

    <div class="input-group">
        <label>收款方户名(receiverAccountName):</label>
        <input type="text" name="receiverAccountName" value="${receiverAccountName}" required/>
    </div>

    <div class="input-group">
        <label>收款方证件号(receiverIdNo):</label>
        <input type="text" name="receiverIdNo" value="${receiverIdNo}" required/>
    </div>

    <div class="input-group">
        <label>出款通道(routeCode):</label>
        <input type="text" name="routeCode" value="${routeCode}" required/>
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
