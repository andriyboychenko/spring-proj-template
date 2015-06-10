<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
	<h1>Spring project template with following XML-based configurations:</h1>
	<ul>
		<li>Spring MVC with REST service</li>
		<li>Hibernate HSQL database connection</li>
		<li>Internationalization based on the database MessageSource</li>
		<li>Dependency Injection</li>
		<li>EJB Startup Bean</li>
	</ul>
 
	<h2>Response message : ${message}</h2>	
	
	i18n message : <spring:message code = "message.say.hello" />
	
</body>
</html>
