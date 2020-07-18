<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="clearfix sidebar">
						<div class="clearfix single_sidebar category_items">
							<h2>Danh mục bất động sản</h2>
						<ul>
						<c:forEach items="${catList}" var="cat">								
								<li class="cat-item"><a href="">${cat.cname}</a>(${cat.cid})</li>
						</c:forEach>
						</ul>
						</div>
						<div class="clearfix single_sidebar">
							<div class="popular_post">
								<div class="sidebar_title"><h2>Xem nhiều</h2></div>
								<ul>
									<c:forEach items="${newLandList}" var="land">								
										<li><a href="">${land.lname}</a></li>
									</c:forEach>
								</ul>
							</div>
							</div>
						
						<div class="clearfix single_sidebar">
							<h2>Danh mục hot</h2>
							<ul>
								<li><a href="">Category Name <span>(12)</span></a></li>
								<li><a href="">Category Name <span>(12)</span></a></li>
								<li><a href="">Category Name <span>(12)</span></a></li>
								<li><a href="">Category Name <span>(12)</span></a></li>
							</ul>
						</div>
					</div>