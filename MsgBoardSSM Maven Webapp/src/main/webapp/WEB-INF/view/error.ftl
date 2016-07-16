<#if base==""><#assign base=(request.contextPath)></#if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 style="color: red;">${errorMsg }</h2>
<h3><a href="${base }/index.do">返回首页</a></h3>
</body>
</html>