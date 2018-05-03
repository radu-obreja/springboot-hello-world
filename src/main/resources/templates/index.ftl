<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring Boot Hello World Example with FreeMarker!!!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
    <h2 class="hello-title">Spring Boot Hello World Example with FreeMarker!!!</h2>
    <#list customers as c>
    	${c.customer_label!}<br/>
    </#list>
    <#list customers2 as c>
    	${c.customer_label!}<br/>
    </#list>
    <script src="/js/main.js"></script>
</body>
</html>