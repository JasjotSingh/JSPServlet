<%@ page import= "java.util.List" %>
<%@ page import= "test.entity.User" %>
<jsp:include page="/include/header_test.jsp"></jsp:include>
<div class="container">
        <div class="row">
           
            <div class="col-md-4 text-center">
                <em><Strong>List Users</Strong></em><br>
                <table >
                	<thead>
                		<tr>
	                		<th>User ID.</th>
	                		<th>User Name</th>
	                		<th>Email</th>
                		</tr>
                	</thead>
                	<tbody>
                		<%
                			List<User> lst = (List)request.getAttribute("userlist");
                			for(User usr: lst){
                				out.print("<tr>");
	                				out.print("<td>"+usr.getId()+"</td>");
	                				out.print("<td>"+usr.getUsername()+"</td>");
	                				out.print("<td>"+usr.getEmail()+"</td>");
                				out.print("</tr>");
                			}
                		%>
                	</tbody>
                </table>
            </div>
            
        </div>
    </div>
<jsp:include page="/include/footer.jsp"></jsp:include>