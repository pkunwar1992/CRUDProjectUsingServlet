<%@include file="shared/header.jsp" %>
<div class="page-header">
    <h1>Login</h1>
</div>
<form method="post" action="">
    <div>
        <label>User Name</label>
        <input type="text" name="username" class="form-control" required/>
    </div>
     <div>
        <label>Password</label>
        <input type="password" name="password" class="form-control" required/>
    </div>
    <input type="hidden" name="_csrf" value="${sessionScope._csrf_token}"/>
    <button type="submit" class="btn btn-success">Login</button>
</form>
<%@include file="shared/footer.jsp" %>
