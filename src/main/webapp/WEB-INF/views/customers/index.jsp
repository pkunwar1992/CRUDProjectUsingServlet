<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Customers</h1>
</div>

<div class="pull-right">
    <a href="${SITE_URL}/admin/customers/add" class="btn btn-primary btn-xs">
        <span class="glypicon glyphicon-plus"></span>
    </a>
</div>
<table class="table table-striped table-hover">
    <thead class="table-success">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Contact No</th>  
            <th>Status</th>  
            <th>Action</th> 
        </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${requestScope.customers}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName} ${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>${customer.contactNo}</td>
            <td>
        <c:if test="${customer.status}">
            <label class="label label-success">Active</label>
        </c:if>
        <c:if test="${!customer.status}">
            <label class="label label-danger">Inactive</label>
        </c:if>
        </td>
        <td>
            <a href="${SITE_URL}/admin/customers/edit/${customer.id}" 
               class="btn btn-warning btn-xs">
                <span class="glyphicon glyphicon-pencil"></span>
            </a>
            <a href="${SITE_URL}/admin/customers/delete/${customer.id}" 
               onclick="return confirm('Are you sureto Delete ?')" 
               class="btn btn-danger btn-xs">
                <span class="glyphicon glyphicon-trash"></span>
            </a>
        </td>
        </tr>
    </c:forEach>
</tbody>
</table>
<%@include file="../shared/footer.jsp" %>       
