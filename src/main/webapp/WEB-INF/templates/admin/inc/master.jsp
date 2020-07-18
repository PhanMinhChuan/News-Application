<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header -->
<%@include file="/WEB-INF/templates/tags/taglib.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Bootstrap Admin Theme v3</title>
    <link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath }/resources/admin/images/icon-180x180.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/resources/admin/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- styles -->
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resources/admin/css/style1.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  
  	<div class="header">
  	<!-- day la header -->
	     <tiles:insertAttribute name="header" />
	     
	     <!-- day la header -->
	</div>
<!-- /.header -->
    <div class="page-content">
    	<div class="row">
		  <div class="col-md-2">
		<!--   day la leftbar -->
		  	<tiles:insertAttribute name="leftbar" />
             <!--   day la leftbar -->
		  </div>
		  
				
		  
		</div><!-- /.row -->
		  <div class="col-md-10">
				<div class="row">
		<tiles:insertAttribute name="content" />
		</div></div>
    </div><!-- /.page-content -->

    <!-- Footer -->
     <tiles:insertAttribute name="footer" />
 <!-- Footer -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath }/resources/admin/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/admin/js/custom.js"></script>
  </body>
</html>
    <!-- /.footer -->
