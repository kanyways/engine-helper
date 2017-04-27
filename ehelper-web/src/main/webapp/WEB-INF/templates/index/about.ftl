<#assign title="首页"/>

<@override name="content">
<p>
    1. 错误码转SQL使用的是poi包。
</p>

<p>
    2. 引擎开关只能在华信内网使用（安全），因为连接是内网连接。
</p>

<p>
    3. 可以对dev和uat发起交易，但都是正常交易。
</p>

<p>
    4. 不会对dev和uat的库进行修改。
</p>

<p>
    5. 使用的缓存是我个人服务器上的缓存，不会使dev和uat缓存丢失。
</p>

<p>
    6. 更多功能，比如一键切换到模拟器或银行测试环境等，敬请期待！
</p>
</@override>

<@extends name="../content-layout.ftl"/>