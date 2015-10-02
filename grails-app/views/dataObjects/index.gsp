
<%@ page import="uk.org.pmms.docserver.DataObjects" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dataObjects.label', default: 'DataObjects')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-dataObjects" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><i class="glyphicon glyphicon-home"></i> <g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><i class="glyphicon glyphicon-plus"></i> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
				
			</ul>
		<div id="list-dataObjects" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-bordered">
			<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'dataObjects.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'dataObjects.name.label', default: 'Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${dataObjectsInstanceList}" status="i" var="dataObjectsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${dataObjectsInstance.id}">${fieldValue(bean: dataObjectsInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: dataObjectsInstance, field: "name")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${dataObjectsInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
