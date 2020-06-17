<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>员工管理</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript"
	src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
<link
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
	<link rel="stylesheet" href="${APP_PATH}/WEB-INF/views/css/style.css" />
<script
	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="header">
    <div class="header_logo"></div>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="Management_yg.jsp">员工管理系统</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="Management_yg.jsp">员工管理</a>
                    </li>
                    <li>
                        <a href="Management_pb.jsp">排班管理</a>
                    </li>
                    <li class="active">
                        <a href="Management_kq.jsp">考勤查询</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<!-- 搭建显示页面 -->
	<div class="container">
	<div class="row">
		<div class="col-md-12">
				<h2>查询条件</h2>
			</div>
			</div>
	<table class="table">
		<tr><th>
			<form class="form-inline">
      <div class="form-group">
       <label for="exampleInputName2">姓名：</label>
       <input type="text" class="form-control" id="exampleInputName2" placeholder="李泽霖">
      </div>
      <div class="form-group">
       <label for="exampleInputEmail2">部门：</label>
       <input type="email" class="form-control" id="exampleInputEmail2" placeholder="开发部">
      </div>
      <button type="submit" class="btn btn-default">查询</button>
</form>
		</th>
		</tr>
	</table>
		<!-- 标题行 -->
		<div class="row">
		<div class="col-md-12">
				<h2>查询结果</h2>
			</div>
			</div>
		<!-- 数据行 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered">
					<thead>
						<tr>
						    <th>Id</th>
							<th>姓名</th>
							<th>签到(次)</th>
							<th>迟到(次)</th>
							<th>早退(次)</th>
							<th>病假(次)</th>
							<th>事假(次)</th>
							<th>出差(次)</th>
							<th>旷工(次)</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
                         <tr>
                            <td >1</td>
							<td >李泽霖</td>
							<td >26</td>
							<td >5</td>
							<td >3</td>
							<td >1</td>
							<td >1</td>
							<td >15</td>
							<td >4</td>
							<td >
								<button class="btn btn-primary btn-sm">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									编辑
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
<!--		<!-- 分页行 -->
<!--		<div class="row">
<!--			<!-- 分页信息 -->
<!--			<div class="col-md-6" id="page_info_area"></div>
<!--			<!-- 分页条 -->
<!--			<div class="col-md-6" id="page_nav_area"></div>
<!--		</div>
<!--	</div>
	<!-- 显示分页信息 -->
		<div class="row">
			<!--分页文字信息  -->
			<div class="col-md-6">当前1页,总10页,总100条记录</div>
			<!-- 分页条信息 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
  <ul class="pagination">
  <li class="disabled"><a href="#">首页</a></li>
    <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
    <li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>
    <li class="disabled"><a href="#">2</a></li>
    <li class="disabled"><a href="#">3</a></li>
    <li class="disabled"><a href="#">4</a></li>
    <li class="disabled"><a href="#">5</a></li>
<li class="disabled"><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
      <li class="disabled"><a href="#">尾页</a>
      </li>
  </ul>
</nav>
			</div>
		</div>
		</div>
</body>
</html>