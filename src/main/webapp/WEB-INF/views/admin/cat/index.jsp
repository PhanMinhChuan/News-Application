<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/tags/taglib.jsp" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }/admin/cat" />
  			<div class="content-box-large">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">Quản lý danh mục</div>
		  			</div>
				</div>
				<hr>	
				<div class="row">
					<div class="col-md-8">
						<a href="${contextPath }/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

					</div>
                	<div class="col-md-4">
                 	 <div class="input-group form">
                       <input type="text" class="form-control" placeholder="Search...">
                       <span class="input-group-btn">
                         <button class="btn btn-primary" type="button">Search</button>
                       </span>
                  	 </div>
                  	</div>
				</div>
				<br />
				<c:if test="${not empty msg }">
					<div class="alert alert-success" role="alert">
					  ${msg }
					</div>
				</c:if>
				
				<div class="row">
  				<div class="panel-body">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên Danh Mục</th>
								<th>Chức Năng</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${catList ne null }">
							<c:forEach items="${catList }" var="cat">
							
							<c:set var="urlEdit" value="${contextPath }/edit/${cat.cid }" />
							<c:set var="urlDel" value="${contextPath }/del/${cat.cid }" />
							<tr class="odd gradeX">
								<td>${cat.cid }</td>
								<td>${cat.cname }</td>
								<td class="center text-center">
									<a href="${urlEdit}" title="Sửa" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
                                    <a onclick="return confirm('Bạn có chắc chắn muốn xóa?');" href="${urlDel}" title="Xóa" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
								</td>
							</tr>
							</c:forEach>
							</c:if>
						</tbody>
					</table>
					
					<!-- Pagination -->
					<nav class="text-center" aria-label="...">
					   <ul class="pagination">
					      <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					      <c:forEach begin="1" end="${totalPage}" var="i">
					      	<li class="active"><a href="${pageContext.request.contextPath}/admin/land/index/${i}">${i} <span class="sr-only">(current)</span></a></li>
					      </c:forEach>
					      <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
					   </ul>
					</nav>
					<!-- /.pagination -->
					
  				</div>
  				</div><!-- /.row -->
  			</div><!-- /.content-box-large -->

