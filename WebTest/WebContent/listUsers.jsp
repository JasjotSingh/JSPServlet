<%@ page import= "java.util.List" %>
<%@ page import= "test.entity.User" %>
<jsp:include page="/include/header_test.jsp"></jsp:include>
<div class="container">
        <div class="row">
           
            <div class="col-md-4 text-center">
                <em><Strong>List Users</Strong></em><br>
                <table>
                	<thead>
                		<tr>
	                		<th style="text-aline:center">User ID.</th>
	                		<th style="text-aline:center">User Name</th>
	                		<th style="text-aline:center">Email</th>
	                		<th style="text-aline:center">Operation</th>
                		</tr>
                	</thead>
                	<tbody>
                		<%
                			String tempUrl = "";
                			List<User> lst = (List)request.getAttribute("userlist");
                			if(lst != null){
	                			for(int i = 0 ; i < lst.size(); i++){
	                				out.print("<tr>");
		                				out.print("<td>"+lst.get(i).getId()+"</td>");
		                				out.print("<td>"+lst.get(i).getUsername()+"</td>");
		                				out.print("<td>"+lst.get(i).getEmail()+"</td>");
		                				tempUrl = request.getContextPath()+"/Operations?page=update&userid="+lst.get(i).getId();
		                				out.print("<td><a href='"+tempUrl+"'>update</a>"+"<td>");
	                				out.print("</tr>");
	                			}
                			}
                		%>
                	</tbody>
                </table>
            </div>
            
        </div>
    </div>
<jsp:include page="/include/footer.jsp"></jsp:include>