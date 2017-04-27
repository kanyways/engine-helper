<#assign title="首页"/>

<@override name="content">
<div class="func-list">
    <div class="func-item">
        <a href="${ctx}/#resp">
            <img src="${ctx}/static/app/images/resp.png"/>
        </a>
        <p>把Excel中的错误码转成SQL</p>
    </div>
    <div class="func-item">
        <a href="${ctx}/#engine">
            <img src="${ctx}/static/app/images/engine.png"/>
        </a>
        <p>启动或停止dev的查询和对账引擎</p>
    </div>
    <div class="func-item">
        <a href="${ctx}/#trans">
            <img src="${ctx}/static/app/images/trans.png"/>
        </a>
        <p>向dev或uat发起各种交易</p>
    </div>
</div>
</@override>

<@extends name="../content-layout.ftl"/>