<!DOCTYPE html>
<html>
	<head>
		
		<title>Welcome to Grails</title>
		
		<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<g:form name="testForm">
					  <div class="form-group">
					    <label for="email">Property Ref</label>
					    <input type="text" class="form-control" id="email" name="propertyId" placeholder="Property ID">
					  </div>
					  <div class="form-group">
					    <label for="firstName">Property Owner's Name</label>
					    <input type="text" class="form-control" id="firstName" name="property.owner" placeholder="Owner">
					  </div>
					  <div class="form-group">
					    <label for="lastName">Property Address</label>
					    <input type="text" class="form-control" id="lastName" name="property.address" placeholder="Address">
					  </div>
					  <div class="form-group">
					    <label for="lastName">Date of Transfer</label>
					    <input type="date" class="form-control" id="lastName" name="transfer.dateOfTransfer" placeholder="Date">
					  </div>
					  <g:actionSubmit value="Docx" class="btn btn-default" action="merge"/>
					  <g:actionSubmit value="PDF" class="btn btn-default" action="mergePDF"/>
					</g:form>
				</div>
			</div>
		</div>
	</body>
</html>
