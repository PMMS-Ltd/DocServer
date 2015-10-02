<%@ page import="uk.org.pmms.docserver.Batch" %>



<div class="fieldcontain ${hasErrors(bean: batchInstance, field: 'status', 'error')} required">
	<label for="status" class="control-label">
		<g:message code="batch.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="status" class="form-control" from="${batchInstance.constraints.status.inList}" required="" value="${batchInstance?.status}" valueMessagePrefix="batch.status"/>

</div>

<div class="fieldcontain ${hasErrors(bean: batchInstance, field: 'batchName', 'error')} required">
	<label for="batchName">
		<g:message code="batch.batchName.label" default="Batch Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="batchName" class="form-control" required="" value="${batchInstance?.batchName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: batchInstance, field: 'documents', 'error')} ">
	<label for="documents">
		<g:message code="batch.documents.label" default="Documents" />
		
	</label>
	<g:select name="documents" class="form-control" from="${uk.org.pmms.docserver.MergeRequest.list()}" multiple="multiple" optionKey="id" size="5" value="${batchInstance?.documents*.id}" class="many-to-many"/>

</div>

