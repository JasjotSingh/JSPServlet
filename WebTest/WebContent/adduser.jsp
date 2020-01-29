<jsp:include page="/include/header_test.jsp"></jsp:include>
<div class="container">
	<div class="row">
           
            <div class="col-md-4">
				<form action="<%=request.getContextPath()%>/Operations" method="post" >
                	user name:<input type="text" name="username" required="required"><br>
                	email:<input type="email" name="email" required="required"><br>
                	<input type="hidden" name="action" value="adduser">
					<input type="submit" value="Add User">
                </form>
			</div>
            
	</div>
</div>
<jsp:include page="/include/footer.jsp"></jsp:include>