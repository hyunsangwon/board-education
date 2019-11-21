<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="cPath" value="${pageContext.request.contextPath }"></c:set>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="author" content="Sangwon Hyun">
  <title>BOARD</title>
<!-- 공통으로 쓰이는 css파일을넣는다.-->
<link type="text/css" rel="stylesheet" href="${cPath}/resources/css/default/all.css" />
<link type="text/css" rel="stylesheet" href="${cPath}/resources/css/default/sb-admin.css" />
<!-- ico image -->
<link rel="shortcut icon" href="${cPath}/resources/img/sangwon.ico" />
<!-- 공통으로 쓰이는 js파일을넣는다.-->
<script type="text/javascript" src="${cPath}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${cPath}/resources/js/sb-admin.min.js"></script>
<script type="text/javascript" src="${cPath}/resources/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">

	$(function() {
		$("#boardList tr").hover(
				function () {
					$(this).children().removeClass('graytd');
					$(this).addClass('hover');
				},
				function () {
					$(this).removeClass('hover');
					$(this).children().addClass('graytd');
				}
			);
	});
	
	/* 게시판 상세페이지 이동  
	 * boardNo : 게시판 번호
	*/
	function load_board_detail(boardNo){
		console.log('게시판 번호 ===>'+boardNo);
		location.href = "${cPath}/board/detail/"+boardNo;
	}
	
	/* 페이징  */
	function do_page(pageNum){
		 console.log('페이지 이동 ===> '+pageNum);
		 location.href = "${cPath}/board/page/"+pageNum+"/rows/"+10;
	}
	
</script>
	<style type="text/css">
		.hover{background-color:#fdf7df;}
		.graytd{background-color:#fcfcfc;}
	</style>
</head>

<body id="page-top">

  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="index.html">Start Bootstrap</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
      <i class="fas fa-bars"></i>
    </button>

    <!-- Navbar Search -->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
        <div class="input-group-append">
          <button class="btn btn-primary" type="button">
            <i class="fas fa-search"></i>
          </button>
        </div>
      </div>
    </form>

    <!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0">
      <li class="nav-item dropdown no-arrow mx-1">
        <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-bell fa-fw"></i>
          <span class="badge badge-danger">9+</span>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item dropdown no-arrow mx-1">
        <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-envelope fa-fw"></i>
          <span class="badge badge-danger">7</span>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item dropdown no-arrow">
        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-user-circle fa-fw"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
          <a class="dropdown-item" href="#">Settings</a>
          <a class="dropdown-item" href="#">Activity Log</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
        </div>
      </li>
    </ul>

  </nav>

  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="index.html">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span>
        </a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>Pages</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Login Screens:</h6>
          <a class="dropdown-item" href="login.html">Login</a>
          <a class="dropdown-item" href="register.html">Register</a>
          <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
          <div class="dropdown-divider"></div>
          <h6 class="dropdown-header">Other Pages:</h6>
          <a class="dropdown-item" href="404.html">404 Page</a>
          <a class="dropdown-item" href="blank.html">Blank Page</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="charts.html">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Charts</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="tables.html">
          <i class="fas fa-fw fa-table"></i>
          <span>Tables</span></a>
      </li>
    </ul>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="#">Dashboard</a>
          </li>
          <li class="breadcrumb-item active">Overview</li>
        </ol>
        
		<div class="col-sm-offset-2 col-sm-10" style="margin: 10px;">
			<a class="btn btn-primary" style="width: 150px;" href="${cPath}/board/write">게시판 작성</a>
		</div>
		
        <!-- DataTables Example -->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i>
            Data Table Example</div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>글쓴이</th>
                    <th>날짜</th>
                  </tr>
                </thead>
                <tbody id="boardList">
                  <c:choose>
   					<c:when test="${fn:length(boardList)>0}">
		   				<c:forEach items="${boardList}" var="row">
					   		 <tr onclick="load_board_detail(${row.boardNo})" style="cursor: pointer">
					   			<td>${row.no}</td>
					   			<td>${row.title}</td>
					   			<td>${row.name}</td>
					   			<td>${row.writeDate}</td>
					   		</tr>
		   				</c:forEach>
   					</c:when>
		   			<c:otherwise>
		   				<td colspan="4">작성된 게시물이  없습니다.</td>
		   			</c:otherwise>
		   		</c:choose>
                </tbody>
              </table>
            </div>
          </div>
          <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
        </div>
		<!--Paging -->
		<div class="row">
				<div class="col-sm-12 col-md-7">
					<ul class="pagination">
						<c:if test="${pageHandler.prev}">
							<tr>
								<li class="page-item"><a class="page-link" href="javascript:do_page(${pageHandler.getStartPage()-1});">Previous</a></li>
							</tr>
						</c:if>
						<c:forEach begin="${pageHandler.getStartPage()}" end="${pageHandler.getEndPage()}" var="idx" >
							<li class="page-item"><a class="page-link" href="javascript:do_page(${idx});">${idx}</a></li>
						</c:forEach>
						<c:if test="${pageHandler.next}">
							<tr>
								<li class="page-item"><a class="page-link" href="javascript:do_page(${pageHandler.getEndPage()+1});">Next</a></li>
							</tr>
						</c:if>
					</ul>
				</div>
		</div>
      </div>
      <!-- /.container-fluid -->
    </div>
    <!-- /.content-wrapper -->
  </div>
  <!-- /#wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

</body>
</html>