<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
        
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <div class="row">
    	<div class="col-md-8 col-md-offset-2">
    	
    	
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">Update your status....</div>
				</div>
				
				<div class="panel-body">
					<form:form modelAttribute="statusUpdate">
						<div class="form-group">
							<form:textarea path="text" name="text" rows="10" cols="50"></form:textarea>
						</div>
						<input type="submit" name="submit" value="add status"/>
					</form:form>
				</div>
			</div>    	
    	</div>
    </div>