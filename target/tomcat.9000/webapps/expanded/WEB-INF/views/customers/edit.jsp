<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Edit Customers</h1>
</div>
<form method="post" action="${SITE_URL}/admin/customers">
    <div class="form-group">
        <label>First Name</label>
        <input type="text" name="firstName" 
               value="${requestScope.customer.firstName}" required="required" 
               placeholder="Enter first name" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Last Name</label>
        <input type="text" name="lastName" 
               value="${requestScope.customer.lastName}" required="required" 
               placeholder="Enter last name" class="form-control"/>
    </div>  
    <div class="form-group">
        <label>Email</label>
        <input type="text" name="email" value="${requestScope.customer.email}" 
               required="required" placeholder="Enter your email" 
               class="form-control"/>
    </div>  
    <div class="form-group">
        <label>Contact number</label>
        <input type="text" name="contactNo" 
               value="${requestScope.customer.contactNo}" required="required" 
               placeholder="Enter contact number" class="form-control"/>
    </div>  
    <div class="form-inline">
        <label>Status</label>
        <label><input type="checkbox" name="status" value="1" 
                      <c:if test="${requestScope.customer.status}">checked
                      </c:if> >Active
        </label>
        </div>
        <input type="hidden" name="id" value="${requestScope.customer.id}"/>
    <input type="hidden" name="_csrf" value="${sessionScope._csrf_token}"/>
    <input type="hidden" name="_csrf" value="12345"/>
    <button type="submit" class="btn btn-success">Save</button>
    <a href="${SITE_URL}/admin/customers" class="btn btn-danger">Back</a>
</form>
<%@include file="../shared/footer.jsp" %>