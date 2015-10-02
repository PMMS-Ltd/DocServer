<%@ page import="uk.org.pmms.docserver.Templates" %>



<div class="fieldcontain ${hasErrors(bean: templatesInstance, field: 'description', 'error')} required">
	<label for="description" class="control-label">
		<g:message code="templates.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" class="form-control" required="" value="${templatesInstance?.description}"/>

</div>
<g:if test="${!templatesInstance?.filePath }">
	<label for="templateFile">
		<g:message code="templates.filePath.label" default="Template File" />
		<span class="required-indicator">*</span>
	</label>
	<input name="templateFile" class="form-control" required="" type="file"/>

</g:if>
<g:else>
<div class="fieldcontain ${hasErrors(bean: templatesInstance, field: 'filePath', 'error')} required">
	<label for="filePath">
		<g:message code="templates.filePath.label" default="File Path" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField class="form-control" name="filePath" required="" value="${templatesInstance?.filePath}"/>

</div>
</g:else>
<div class="fieldcontain ${hasErrors(bean: templatesInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="templates.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField class="form-control" name="name" required="" value="${templatesInstance?.name}"/>

</div>
<div class="fieldcontain ${hasErrors(bean: templatesInstance, field: 'dataObjects', 'error')}">
<label for="name">
		<g:message code="templates.mergeFields.label" default="Data Objects" />
		
	</label>
				<g:select name="dataObjects" from="${uk.org.pmms.docserver.DataObjects.list()}"
					multiple="multiple" optionKey="id" size="20"
					value="${templatesInstance?.dataObjects*.id}"
					class="many-to-many form-control form-control" />
</div>

