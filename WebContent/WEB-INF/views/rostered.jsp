<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>排班管理</title>
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
                    <li class="active">
                        <a href="Management_pb.jsp">排班管理</a>
                    </li>
                    <li>
                        <a href="Management_kq.jsp">考勤查询</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题行 -->
		<div class="row">
		<div class="col-md-12">
				<h1>排班信息</h1>
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
							<th>星期一</th>
							<th>星期二</th>
							<th>星期三</th>
							<th>星期四</th>
							<th>星期五</th>
							<th>星期六</th>
							<th>星期日</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
                         <tr>
                            <td class="success">1</td>
							<td >李泽霖</td>
							<td class="info">上班</td>
							<td class="info">上班</td>
							<td class="info">上班</td>
							<td class="info">上班</td>
							<td class="info">上班</td>
							<td class="warning">休息</td>
							<td class="danger">加班</td>
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