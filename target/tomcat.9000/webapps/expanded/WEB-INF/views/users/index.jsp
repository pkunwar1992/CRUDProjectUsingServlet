<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Users</h1>
</div>

<div class="pull-right">
    <a href="${SITE_URL}/admin/users/add" class="btn btn-primary btn-xs">
        <span class="glypicon glyphicon-plus"></span>
    </a>
</div>
<table class="table table-striped table-hover">
    <thead class="table-success">
        <tr>
            <th>ID</th>
            <th>User Name</th>
            <th>Email</th>
            <th>Contact No</th>  
            <th>Status</th>  
            <th>Action</th> 
        </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${requestScope.users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.contactNo}</td>
            <td>
        <c:if test="${user.status}">
            <label class="label label-success">Active</label>
        </c:if>
        <c:if test="${!user.status}">
            <label class="label label-danger">Inactive</label>
        </c:if>
        </td>
        <td>
            <a href="${SITE_URL}/admin/users/edit/${user.id}" 
               class="btn btn-warning btn-xs">
                <span class="glyphicon glyphicon-pencil"></span>
            </a>
            <a href="${SITE_URL}/admin/users/delete/${user.id}" 
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
