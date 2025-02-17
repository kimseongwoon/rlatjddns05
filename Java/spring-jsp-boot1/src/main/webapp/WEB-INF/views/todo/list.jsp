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
    	
    	<!-- 할일 검색 조건 및 필터링 UI -->
    	<div class="row content">
    		<div class="col">
    		 <div class="card">
	   			  <div class="card-body">
					<h5 class="card-title">Search</h5>
					<form action="/spring-jsp-boot1/todo/list" method="get">
                            <input type="hidden" name="size" value="${pageRequestDTO.size}">
                            <div class="mb-3">
                                <input type="checkbox" name="finished" ${pageRequestDTO.finished ? "checked" : ""}>완료여부(finished)
                            </div>
                            <div class="mb-3">
                                <input type="checkbox" name="types" value="t" ${pageRequestDTO.checkType("t") ? "checked" : ""}>제목(title)
                                <input type="checkbox" name="types" value="w" ${pageRequestDTO.checkType("w") ? "checked" : ""}>작성자(writer)
                                <input type="text"  name="keyword" class="form-control" value ='<c:out value="${pageRequestDTO.keyword}"/>' >
                            </div>
                            <div class="input-group mb-3 dueDateDiv">
                                시작날짜: <input type="date" name="from" class="form-control" value="${pageRequestDTO.from}">
                                마침날짜: <input type="date" name="to" class="form-control" value="${pageRequestDTO.to}">
                            </div>
                            <div class="input-group mb-3">
                                <div class="float-end">
                                    <button class="btn btn-primary" type="submit">Search</button>
                                    <button class="btn btn-info clearBtn" type="reset">Clear</button>
                                </div>
                            </div>
	                    </form>
                    </div>
                </div>
            </div>
        </div>
                        
        <!-- 할일 리스트 및 페이징 -->
   	    <div class="row content">
	   		<div class="col">
	   		 <div class="card">
	           <div class="card-header">
	               Featured
	           </div>
	   			  <div class="card-body">
					<h5 class="card-title">Special title treatment</h5>             
            	 		<table class="table">
                            <thead>
	                            <tr>
		                            <th scope="col">Tno</th>
	                                <th scope="col">Title</th>
	                                <th scope="col">Writer</th>
	                                <th scope="col">DueDate</th>
	                                <th scope="col">Finished</th>
	                            </tr>
                            </thead>
                            <tbody>
	                            <c:forEach items="${dtoList}" var="dto">
	                                <tr>
	                                    <th scope="row"><c:out value="${dto.tno}"/></th>
	                                    <td><a href="/spring-jsp-boot1/todo/read?tno=${dto.tno}&${pageRequestDTO.link}" class="text-decoration-none"><c:out value="${dto.title}"/></a></td>
	                                    <td><c:out value="${dto.writer}"/></td>
	                                    <td><c:out value="${dto.dueDate}"/></td>
	                                    <td><c:out value="${dto.finished}"/></td>
	                                </tr>
	                            </c:forEach>
                            </tbody>
                        </table>
                        
                         <!-- 페이징 번호 UI -->
                         <div class="float-end">
                            <ul class="pagination flex-wrap">
                            	<!-- 페이지 이전 버튼 -->
                            	<c:if test="${responseDTO.prev}">
                                    <li class="page-item" style="cursor: pointer;">
                                        <a class="page-link" data-num="${responseDTO.start -1}">Previous</a>
                                    </li>
                                </c:if>
                                <!-- 페이징 번호 -->
                            	<c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                                	<li class="page-item ${responseDTO.page == num ? "active" : ""} " style="cursor: pointer;">
                                        <a class="page-link" data-num="${num}">${num}</a></li>
                                </c:forEach>
                                <!-- 페이지 다음 버튼 -->
                                <c:if test="${responseDTO.next}">
                                    <li class="page-item" style="cursor: pointer;">
                                        <a class="page-link"  data-num="${responseDTO.end + 1}">Next</a>
                                    </li>
                                </c:if>
                            </ul>
                         </div>
                         <script>
                      		// pagination 클릭 처리
	                        document.querySelector(".pagination").addEventListener("click", function (e) {
	                            e.preventDefault();
	                            e.stopPropagation();
	
	                            const target = e.target;
	                            if(target.tagName !== 'A') {
	                                return;
	                            }
	                            const num = target.getAttribute("data-num");
	                            //self.location = `/spring-jsp-boot1/todo/list?page=\${num}`;
	                            
	                            const formObj = document.querySelector("form");
	                            formObj.innerHTML += `<input type='hidden' name='page' value='\${num}'>`
	                            formObj.submit();
	                            
                         	},false);
	                        
		                     // clear버튼 클릭 처리
		                     document.querySelector(".clearBtn").addEventListener("click", function (e){
						        e.preventDefault();
						        e.stopPropagation();
						
						        self.location ='/spring-jsp-boot1/todo/list';                       
	                        },false)
                         </script>
                      </div>	    
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
                      