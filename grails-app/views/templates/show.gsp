
<%@ page import="uk.org.pmms.docserver.Templates" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'templates.label', default: 'Templates')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><i class="glyphicon glyphicon-home"></i> <g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><i class="glyphicon glyphicon-th-list"></i> <g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><i class="glyphicon glyphicon-plus"></i> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		
		<div id="show-templates" class="content scaffold-show" role="main">
			<h1 class="page-header">${templatesInstance.name }</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list templates">
			
				<g:if test="${templatesInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="templates.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${templatesInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${templatesInstance?.filePath}">
				<li class="fieldcontain">
					<span id="filePath-label" class="property-label"><g:message code="templates.filePath.label" default="File Path" /></span>
					
						<span class="property-value" aria-labelledby="filePath-label"><g:link action="downloadDocument" params="[documentId: templatesInstance.filePath]"><g:fieldValue bean="${templatesInstance}" field="filePath"/></g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${templatesInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="templates.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${templatesInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:if test="${templatesInstance.dataObjects?.size() > 0 }">
			<h4>Data Objects</h4>
			<table class="table table-condensed">
					
			<g:each in="${templatesInstance?.dataObjects }" var="d">
				<tr>
					<th>${d.name }</th>
					<td>${d.description }</td>
				</tr>
			</g:each>
			</table>
			</g:if>
			<g:form url="[resource:templatesInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="btn btn-sm btn-default" action="edit" resource="${templatesInstance}"><i class="glyphicon glyphicon-pencil"></i> <g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-sm btn-danger" action="delete" value="X Delete" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
			<div class="row">
				<div class="col-xs-8">
					<g:form name="formFields" controller="mailMerge" class="form-horizontal">
						<g:render template="mergeForm" model="['fields': fields, 'filePath': templatesInstance?.filePath]"/>
						
						<g:actionSubmit value="Docx" action="merge" class="btn btn-sm btn-primary"/>
						<g:actionSubmit value="PDF" action="mergePDF" class="btn btn-sm btn-danger"/>
					</g:form>
				</div>
			</div>
			
		</div>
		
	</body>
</html>
