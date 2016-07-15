<!DOCTYPE html>
<html>
  <head>
    <title>userList.html</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <div>
    
    
	<#macro repeat count>
	<#list 1..count as x>
		<#nested x,x/2,x==count>
	</#list>
	</#macro>

	<@repeat count=5;a b c>
		<p>${a}--${b}--${c}</p> 
	</@repeat>
	<hr>
	<p>
结果为：
1--0.5--false
2--1--false
3--1.5--false
4--2--false
5--2.5--true
</p>
<#assign x = "定义一个变量x" > 
	</div>
  </body>
</html>


