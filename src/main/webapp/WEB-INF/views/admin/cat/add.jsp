<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/templates/tags/taglib.jsp" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }/admin/cat" />
	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Thêm danh mục</div>
			  			</div>
			  			
			  			<c:if test="${not empty msg }">
						<div class="alert alert-danger" role="alert">
							  ${msg }
							</div>
						</c:if>
			  			<form action="${contextPath }/add" method="post">
			  			
				  			<div class="content-box-large box-with-header">
					  			<div>
									<div class="row mb-10"></div>
									<form:errors path="cat.*" cssStyle="color:red;"></form:errors>
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="name">Tên Danh Mục</label>
												<input name="cname" type="text" class="form-control" placeholder="Nhập tên danh mục">
											</div>
											
										</div>
	
									</div>
	
									<hr>
	
									<div class="row">
										<div class="col-sm-12">
											<input type="submit" value="Thêm" class="btn btn-success" />
											<input type="reset" value="Nhập lại" class="btn btn-default" />
										</div>
									</div>
						</form>
							</div>
						</div>
			  		</div>
	  			</div><!-- /.row col-size -->
