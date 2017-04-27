<#assign title="引擎开关"/>

<@override name="content">
<#list engines as engine>
    <div>${engine.engNm}</div>
</#list>
</@override>

<@extends name="../content-layout.ftl"/>
