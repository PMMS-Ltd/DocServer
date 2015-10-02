
<%@ page import="uk.org.pmms.docserver.Templates" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'templates.label', default: 'Templates')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><i class="glyphicon glyphicon-home"></i> <g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><i class="glyphicon glyphicon-plus"></i> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="list" action="importTemplates"><i class="glyphicon glyphicon-import"></i> Import Templates</g:link></li>
			</ul>
		<div id="list-templates" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-condensed">
			<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'templates.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="filePath" title="${message(code: 'templates.filePath.label', default: 'File Path')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'templates.name.label', default: 'Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${templatesInstanceList}" status="i" var="templatesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${templatesInstance.id}">${fieldValue(bean: templatesInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: templatesInstance, field: "filePath")}</td>
					
						<td>${fieldValue(bean: templatesInstance, field: "name")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${templatesInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
