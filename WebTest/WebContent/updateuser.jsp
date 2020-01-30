<jsp:include page="/include/header_test.jsp"></jsp:include>
<div class="container">
	<div class="row">
           
            <div class="col-md-4">
				<form action="<%=request.getContextPath()%>/Operations" method="post" >
                	user name:<input type="text" name="username" value="<%=request.getParameter("username") %>" required="required"><br>
                	email:<input type="email" name="email" value="<%=request.getParameter("email") %>" required="required"><br>
                	<input type="hidden" name="userid" value="<%=request.getParameter("userid") %>">
                	<input type="hidden" name="action" value="updateuser">
					<input type="submit" value="Update User">
                </form>
			</div>
            
	</div>
</div>
<jsp:include page="/include/footer.jsp"></jsp:include>