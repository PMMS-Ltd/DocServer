
<%@ page import="uk.org.pmms.docserver.Batch" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'batch.label', default: 'Batch')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-batch" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-batch" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-bordered">
			<thead>
					<tr>
					
						<g:sortableColumn property="status" title="${message(code: 'batch.status.label', default: 'Status')}" />
					
						<g:sortableColumn property="batchName" title="${message(code: 'batch.batchName.label', default: 'Batch Name')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'batch.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'batch.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${batchInstanceList}" status="i" var="batchInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${batchInstance.id}">${fieldValue(bean: batchInstance, field: "status")}</g:link></td>
					
						<td>${fieldValue(bean: batchInstance, field: "batchName")}</td>
					
						<td><g:formatDate date="${batchInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${batchInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${batchInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
