<#assign ctx="${(rca.contextPath)!''}">

<@block name="content"/>

<script>
    document.title = "${title!'未命名'} | <@s.message "app.name"/>";
</script>