<#assign title="引擎开关"/>

<@override name="content">
<table class="table">
    <thead>
    <tr>
        <th>引擎ID</th>
        <th>引擎名称</th>
        <th>引擎类型</th>
        <th>银行编号</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
        <#list engines as engine>
        <tr>
            <td>${engine.engId}</td>
            <td>${engine.engNm}</td>
            <td>${engine.engKy}</td>
            <td>${engine.engCo}</td>
            <td>
                <a href="http://10.199.101.212:8090/engine/?opt=START&engId=${engine.engId}" class="underline" target="_blank">启动</a>
                <a href="http://10.199.101.212:8090/engine/?opt=STOP&engId=${engine.engId}" class="underline" target="_blank">停止</a>
            </td>
        </tr>
        </#list>
    </tbody>
</table>
</@override>

<@extends name="../content-layout.ftl"/>
