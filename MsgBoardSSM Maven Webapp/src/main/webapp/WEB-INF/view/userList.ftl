<#if base==""><#assign base=(request.contextPath)></#if>
<!DOCTYPE html>
<html>
  <head>
    <title>userList.html</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <div>
    <#if username??>
    <p>Welcome,<a>${username}</a>!</p>
	<p><a href="${base}/logout.do">注销</a></p>
    <#else>
	<p><a href="${base}/toLogin.do">登录</a></p>
	<p><a href="${base}/toRegister.do">注册</a></p>
	</#if>
	</div>
  </body>
</html>
