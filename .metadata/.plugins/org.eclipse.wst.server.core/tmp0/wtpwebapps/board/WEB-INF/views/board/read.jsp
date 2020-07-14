<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Read</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>            
            <div class="row">
                <div class="col-lg-12">
                	<div class="panel panel-default">
                        <div class="panel-heading">
                           Board Read Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                			<form action="" role="form">
                				<div class="form-group">
                					<label>Bno</label>
                					<input class="form-control" name="bno" value="${read.bno}" readonly="readonly">                				
                				</div> 
                				<div class="form-group">
                					<label>Title</label>
                					<input class="form-control" name="title" value="${read.title}" readonly="readonly">                				
                				</div>  
                				<div class="form-group">
                					<label>Content</label>
                					<textarea class="form-control" rows="3" name="content" readonly="readonly">${read.content}</textarea>               				
                				</div> 
                				<div class="form-group">
                					<label>Writer</label>
                					<input class="form-control" name="writer" value="${read.writer}" readonly="readonly">                				
                				</div>  
                				<%-- <button type="button" class="btn btn-default" onclick="location.href='/board/modify?bno=${read.bno}'">Modify</button> --%>     			
                				<button type="button" class="btn btn-default">Modify</button>     			
                				<!-- <button type="button" class="btn btn-info" onclick="location.href='/board/list'">List</button> -->          			
                				<button type="button" class="btn btn-info">List</button>     			
                				
                			</form>
                		</div>
                	</div>
                </div>
            </div>    
<%-- 페이지 나누기와 다른 작업들을 위해 폼 작성 --%>                   
<form action="" id="myForm">
	<input type="hidden" name="bno" value="${read.bno}"/>
	<input type="hidden" name="pageNum" value="${criteriaVO.pageNum}"/>
	<input type="hidden" name="amount" value="${criteriaVO.amount}"/>
	<input type="hidden" name="type" value="${criteriaVO.type}"/>
	<input type="hidden" name="keyword" value="${criteriaVO.keyword}"/>
</form>
<script>
$(function(){
	let form=$("#myForm");
	$(".btn-default").click(function(){
		form.attr("action","modify");	//http://~/board/modify
		form.submit();		
	})
	$(".btn-info").click(function(){
		form.attr("action","list");	//http://~/board/list?bno=20
		//bno는 삭제하기
		form.find("input[name='bno']").remove();	//http://~/board/list?
		form.submit();		
	})
})
</script>
<script src="/resources/js/reply.js"></script>
<script>
$(function(){
	//댓글 작업 호출
	replyService.add();	
})
</script>
<%@include file="../includes/footer.jsp" %>       