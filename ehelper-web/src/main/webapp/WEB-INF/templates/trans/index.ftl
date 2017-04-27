<#assign title="发起交易"/>

<@override name="content">
<div class="trans-list">
    <div class="item">
        <a href="${ctx}/#trans/pay">
            <img src="${ctx}/static/app/images/pay.png"/>
            <p>申购(pay)</p>
        </a>
    </div>
    <div class="item">
        <a href="${ctx}/#trans/redeemPrivate">
            <img src="${ctx}/static/app/images/redeemPrivate.png"/>
            <p>对私赎回(redeemPrivate)</p>
        </a>
    </div>
</div>
</@override>

<@extends name="../content-layout.ftl"/>
