<%@ page import="uk.org.pmms.docserver.Field" %>



<div class="fieldcontain ${hasErrors(bean: fieldInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="field.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${fieldInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: fieldInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="field.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="type" required="" value="${fieldInstance?.type}"/>

</div>

