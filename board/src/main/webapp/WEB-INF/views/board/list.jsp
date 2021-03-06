<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board List</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board List Page
                            <button id='regBtn' type='button' class='btn btn-xs pull-right btn-success' onclick="location.href='/board/register'">Register New Board</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>번 호</th>
                                        <th>제 목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>									
                                </thead>
								<!-- 게시판 리스트 반복문 -->
								<tbody>
								<c:forEach var="list" items="${list}" >
									<tr>
                                        <td>${list.bno}</td>
                                        <td><a href="<c:out value='${list.bno}'/>" class="move">"${list.title}</a> &nbsp;<strong>[${list.replycnt}]</strong></td>
                                        <%-- <td><a href="${list.bno}" class="move">"${list.title}</a></td> --%>
                                        <td>${list.writer}</td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.regdate}"/></td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.updatedate}"/></td>
                                    </tr>
								</c:forEach>
								</tbody>
                            </table>
							<div class="row"> <!-- start search -->
                            	<div class="col-md-12">
                            	  <div class="col-md-8"><!--search Form-->
                            			<form action="" id="searchForm">
                            				<select name="type" id="">
                            					<option value=""<c:out value="${empty criteria.type?'selected':''}"/>>=========</option>
                            					<option value="T"<c:out value="${criteria.type=='T'?'selected':''}"/>>제목</option>
                            					<option value="C"<c:out value="${criteria.type=='C'?'selected':''}"/>>내용</option>
                            					<option value="W"<c:out value="${criteria.type=='W'?'selected':''}"/>>작성자</option>
                            					<option value="TC"<c:out value="${criteria.type=='TC'?'selected':''}"/>>제목 or 내용</option>
                            					<option value="TW"<c:out value="${criteria.type=='TW'?'selected':''}"/>>제목 or 작성자</option>
                            					<option value="TCW"<c:out value="${criteria.type=='TCW'?'selected':''}"/>>제목 or 내용 or 작성자</option>
                            				</select>
                            				<input type="text" name="keyword" value="${criteria.keyword}" />
                            				<input type="hidden" name="amount" value="${criteria.amount}" />
                            				<button class="btn btn-default" type="button">검색</button>
                            			</form>
                            	   </div>
                            	   <div class="col-md-2 col-md-offset-2">
                            	   	<!--페이지 목록 갯수 지정하는 폼-->
                            	   	<select class="form-control" name="amount" id="amount">
                            	   		<option value="10" <c:out value="${criteria.amount==10?'selected':''}"/>>10</option>
                            	   		<option value="20" <c:out value="${criteria.amount==20?'selected':''}"/>>20
                            	   		<option value="30" <c:out value="${criteria.amount==30?'selected':''}"/>>30</option>
                            	   		<option value="40" <c:out value="${criteria.amount==40?'selected':''}"/>>40</option>
                            	   	</select>
								  </div>
                             	 </div>                             	 
                      		 </div><!-- end search -->
                            <!-- start Pagination -->
                            <div class="text-center">
                            	<ul class="pagination">
                            		<c:if test="${pageVO.prev}">
                            		<li class="paginate_button previous"><a href="${pageVO.startPage-1}">Previous</a>
                            		</c:if>
                            		<c:forEach var="idx" begin="${pageVO.startPage}" end="${pageVO.endPage}">
                            		<li class="paginate_button ${pageVO.criteria.pageNum==idx?'active':''}"><a href="${idx}">${idx}</a>
                            		</c:forEach>
                            		<c:if test="${pageVO.next}">
                            		<li class="paginate_button next"><a href="${pageVO.endPage+1}">Next</a>
                            		</c:if>
                            	</ul>
                            </div>
                            <!-- end Pagination -->   
                            </div>
                            <!-- end panel-body -->
                        </div>
                        <!-- end panel -->
                    </div>                   
                </div>               
            <!-- /.row -->
<%-- 페이지번호를 누르면 동작하는 폼 --%>
<form action="list" id="actionForm">
	<input type="hidden" name="pageNum" value="${pageVO.criteria.pageNum}" />
	<input type="hidden" name="amount" value="${pageVO.criteria.amount}" />
	<input type="hidden" name="type" value="${pageVO.criteria.type}" />
	<input type="hidden" name="keyword" value="${pageVO.criteria.keyword}" />
</form>
<!-- 모달 추가 -->
<div class="modal" tabindex="-1" role="dialog" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">게시글 등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>게시글이 삭제되었습니다.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<!-- 스크립트 <-->
<script>
$(function(){
	let result='${result}';
	checkModal(result);
	
	//게시글 작성 or 삭제 시 modal이 작동 하는것을 history에서 삭제하는 과정
	history.replaceState({}, null, null);
	
	function checkModal(result){
		if(result === '' || history.state){
			return;
		}		
		if(parseInt(result)>0){
			$(".modal-body").html("게시글 "+parseInt(result)+"번이 등록되었습니다.")
		}	
		$("#myModal").modal("show");
	}	
	
	//사용자가 페이지 번호를 누르면 동작하는 스크립트
	//전송해야 할 폼 가져온 후 
	let actionForm=$("#actionForm");	
	$(".paginate_button a").click(function(e){
		//a 태그의 동작 막기
		e.preventDefault();		
		//pageNum의 값을 변경한 후 
		//${idx}의 숫자를 a태그가 이미 갖고 있기 때문에 this로 추출 가능  
		//a태그는 value로 가져올 수 없기 때문에 attr로 사용
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		//폼 전송
		actionForm.submit();
	})	
	
	$(".form-control").change(function(){
		//amount 값을 변경한 후 
		//select에 amount값이 들어 있기때문에
		actionForm.find("input[name='amount']").val($(this).val());
		//폼 전송
		actionForm.submit();
	})
	
	//타이틀 클릭시 페이지나누기 정보가 있는 폼 보내기
	$(".move").click(function(e){
		//아래와 같이 작성되었던 37번 줄의 a태그를 대체
		//페이지 나누기를 사용했기 때문에 page정보가 필요(pageNum, amount)
		<%--<a href="read?bno=${list.bno}&pageNum=${criteria.pageNum}&amount=${criteria.amount}">${list.title}</a>--%>
		e.preventDefault();
		actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'/>");
		actionForm.attr("action","read");
		actionForm.submit();		
	})
	
	//검색 버튼 클릭시
	$(".btn-default").click(function(){
		//type과 keyword가 비어 있는지 확인하고 메시지 띄워준 후 return
		let type=$("select[name='type']").val();
		let keyword=$("input[name='keyword']").val();		
		console.log(type);
		console.log(keyword);
		if(type === "") {
		/* if(($("select[name='type']") || $("input[name='keyword']")) === "") { */
			alert("검색조건 비우지마!!");
			return false;
		}else if(keyword === ""){
			alert("검색어 비우지마!!");
			return false;
		}else{
		//비어 있지 않으면 폼 전송
			let searchForm=$("#searchForm");			
			searchForm.attr("action", "list");
			searchForm.submit();
		}		
	})
})
</script>
<%@include file="../includes/footer.jsp" %>       