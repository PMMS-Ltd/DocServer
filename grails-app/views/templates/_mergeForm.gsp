<g:if test="${fields.size() > 0 }">
<g:each in="${fields}" var="f">
<div class="form-group">
	
			<label for="${f}" class="col-xs-4 control-label">${f}</label>
			<div class="col-xs-8">
				<input type="text" id="${f}" name="fields.${f}" class="form-control">
			</div>
	
	</div>
</g:each>
<input type="hidden" name="templatePath" value="${filePath }"/>
<input type="hidden" name="docFormat" value="" id="docFormat"/>
  </g:if>
  <g:else>
  	<h3 class="text-muted">No Form Fields Defined!</h3>
  </g:else>