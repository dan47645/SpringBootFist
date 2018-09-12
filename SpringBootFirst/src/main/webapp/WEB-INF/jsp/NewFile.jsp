<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
	<div class="table-responsive">
	  <table class="table">
	     <thead>
		    <tr>
		      <th>编号</th>
		      <th>姓名</th>
		      <th>权限</th>
		    </tr>
		  </thead>
		  <tbody>
		  
		  <c:forEach items="${demo }" var="item" >
		  	<tr>
		      <td>${item.id }</td>
		      <td>${item.name }</td>
		      <td>${item.role }</td>
		    </tr>
		  </c:forEach>
		   
		  </tbody>
	  </table>
	</div>
