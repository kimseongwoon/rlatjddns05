<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
    	<div class="row">
    		<div class="col">
    			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				  <div class="container-fluid">
				    <a class="navbar-brand" href="#">Navbar</a>
				    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				      <span class="navbar-toggler-icon"></span>
				    </button>
				    <div class="collapse navbar-collapse" id="navbarNav">
				      <ul class="navbar-nav">
				        <li class="nav-item">
				          <a class="nav-link active" aria-current="page" href="/spring-jsp-boot1/todo/list">할일 리스트</a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href="/spring-jsp-boot1/todo/register">등록</a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href="#">Pricing</a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link disabled">Disabled</a>
				        </li>
				      </ul>
				    </div>
				  </div>
				</nav>
    		</div>
    	</div>
    	
    	<!-- 에러 내용 보여주기 -->
    	<div class="row">
    		<div class="col">
    			<c:forEach items="${errors}" var="error">
    				<div class="alert alert-danger" role="alert">
					  ${error.defaultMessage}
					</div>   	
                </c:forEach>
    		</div>
    	</div>
    	
    	<div class="row content">
    		<div class="col">
    		 <div class="card">
               <div class="card-header">
                   Featured
               </div>
	   		   <div class="card-body">
                        <div class="input-group mb-3">
                            <span class="input-group-text">TNO</span>
                            <input type="text" name="tno" class="form-control"
                                   value=<c:out value="${dto.tno}"></c:out> readonly>
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text">Title</span>
                            <input type="text" name="title" class="form-control"
                                   value='<c:out value="${dto.title}"></c:out>' readonly>
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">DueDate</span>
                            <input type="date" name="dueDate" class="form-control"
                                   value=<c:out value="${dto.dueDate}"></c:out> readonly>

                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">Writer</span>
                            <input type="text" name="writer" class="form-control"
                                   value=<c:out value="${dto.writer}"></c:out> readonly>

                        </div>

                        <div class="form-check">
                            <label class="form-check-label" >
                                Finished &nbsp;
                            </label>
                            <input class="form-check-input" type="checkbox" name="finished" ${dto.finished?"checked":""} disabled >
                        </div>

                        <div class="my-4">
                            <div class="float-end">
                                <button type="button" class="btn btn-primary">Modify</button>
                                <button type="button" class="btn btn-secondary">List</button>
                            </div>
                        </div>
						
						<script>
							//목록 페이지로 이동하는 이벤트 처리
	                        document.querySelector(".btn-secondary").addEventListener("click", function(e){
	                            self.location = "/spring-jsp-boot1/todo/list?${pageRequestDTO.link}";
	                        },false)
	                        
	                        // Modify 버튼을 눌렀을 때 이벤트 처리
	                        document.querySelector(".btn-primary").addEventListener("click", function(e){
                                self.location = `/spring-jsp-boot1/todo/modify?tno=${dto.tno}&${pageRequestDTO.link}`;
                            },false)
						</script>
                    </div>	  
		   	  </div>
    		</div>
    	</div>
    	<div class="row footer">
    		<div class="row fixed-bottom" style="z-index: -100">
	            <footer class="py-1 my-1 ">
	                <p class="text-center text-muted">Footer</p>
	            </footer>
	        </div>
    	</div>
    </div>
    
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
</body>
</html>