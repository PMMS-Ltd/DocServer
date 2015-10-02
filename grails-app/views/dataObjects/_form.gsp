<%@ page import="uk.org.pmms.docserver.DataObjects" %>



<div class="fieldcontain ${hasErrors(bean: dataObjectsInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="dataObjects.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${dataObjectsInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: dataObjectsInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="dataObjects.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${dataObjectsInstance?.name}"/>

</div>

