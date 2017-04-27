<#assign title="首页"/>

<@override name="content">
<a href="#clear/all" class="underline">清空全部缓存</a>

<div class="result">
    <#if result??>
        <pre><code>${result?html}</code></pre>
    </#if>
</div>
</@override>

<@extends name="../content-layout.ftl"/>