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
<%-- 댓글 영역 --%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
			<i class="fa fa-comments fa-fw"></i>
			reply
			<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">
				New Reply
			</button>
			</div>
			<div class="panel-body">
				<ul class="chat">				
					<li class="left clearfix" data-rno="30">
						<div>
							<div class="header">
								<strong class="primary-font">댓글러00</strong>
								<small class="pull-right text-muted">
									2020.07.15 12:14
								</small>
							</div>
							<p>Good Job!!!</p>
						</div>
					</li>
				</ul>
			</div>			
		</div>
	</div>
</div>
<%-- 댓글 등록 MODAL --%>
<div class="modal" tabindex="-1" role="dialog" id="replyModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h5 class="modal-title">Reply</h5>
      </div>
      <div class="modal-body">
	      <div class="form-group">
	      	<label for="">댓글 내용</label>
	      	<input type="text" class="form-control" name="reply" value="댓글 작성"/>
	      </div>
	      <div class="form-group">
	      	<label for="">작성자</label>
	      	<input type="text" class="form-control" name="replyer" value="작성자"/>
	      </div>
	      <div class="form-group">
	      	<label for="">작성일</label>
	      	<input type="text" class="form-control" name="replydate" value="작성일"/>
	      </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" id="modalRegisterBtn">등록</button>
        <button type="button" class="btn btn-success" id="modalModifyBtn">수정</button>
        <button type="button" class="btn btn-danger" id="modalRemoveBTN">삭제</button>
        <button type="button" class="btn btn-primary" id="modalCloseBtn" data-dismiss="modal">닫기</button>
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
	//현재 글의 글 번호 가져오기
	let bno=${read.bno};
	
	//댓글 영역 가져오기
	let replyUl=$(".chat");
	
	//댓글 영역 내용을 보여주는 함수 호출
	showList(1);
	
	//모달 영역 가져오기
	let modal=$(".modal");	
	//모달 영역이 가지고 있는 input 영역 찾기
	let modalInputReply=modal.find("input[name='reply']");
	let modalInputReplyer=modal.find("input[name='replyer']");
	let modalInputReplydate=modal.find("input[name='replydate']");
	//모달 영역이 가지고 있는 버튼 찾기
	let modalRegisterBtn=$("#modalRegisterBtn");
	let modaModifyrBtn=$("#modaModifyrBtn");
	let modalRemoveBtn=$("#modalRemoveBtn");
	
	$("#addReplyBtn").click(function(){
		//input 안에 들어 있는 내용 없애주기
		modal.find("input").val("");
		//작성날짜 영역 없애기
		modalInputReplydate.closest("div").hide();
		//닫기 버튼만 제외하고 모든 버튼을 숨기기
		modal.find("button[id!='modalCloseBtn']").hide();
		//등록 버튼 다시 보이기
		modalRegisterBtn.show();
		
		
		
		modal.modal("show");
	})
	
	//댓글 작업 호출
	//댓글 등록하기
	
	modalRegisterBtn.on("click",function(){
		var reply={
			bno:bno,
			replyer:modalInputReplyer.val(),
			reply:modalInputReply.val()
		}
		
		regist(reply);		
	})
	
	function regist(reply){
		replyService.add(reply,
			function(result){
				alert(result);
				//modal에 있는 댓글 내용과 관련된 내용 지우기
				modal.find("input").val("");
				//모달 창 종료
				modal.modal("hide");
				//전체 댓글 리스트 보기
				showList(1);
		});//add 종료		
	}

	//댓글 리스트 요청하기
	function showList(page){
		replyService.getList({bno:bno,page:page}, function(list){
			console.log(list);
			
			if(list==null || list.length===0){
				replyUl.html("");
				return;
			}
			
			let str="";
			for(var i=0,len=list.length||0;i<len;i++){
				str+="<li class='left clearfix' data-rno='"+list[i].rno+"''>";
				str+="<div><div class='header'>";
				str+="<strong class='primary-font'>"+list[i].replyer+"</strong>";
				str+="<small class='pull-right text-muted'>"+replyService.displayTime(list[i].replydate)+"</small>";
				str+="</div><p>"+list[i].reply+"</p></div></li>";
			}
			replyUl.html(str);			
		})//getList 종료		
	}
	
	//댓글 삭제
	/*replyService.remove(31, 
			function(result){alert(result);},
			function(msg){
			alert(msg);			
	})//remove 종료*/
	
	//댓글 수정
	/*replyService.modify({rno:999, reply:"댓글 내용 수정"},
			function(result){alert(result);},
			function(error){
				alert("수정 실패");		
	})//modify 종료*/
		
	//댓글 하나 가져오기
	//실제로는 li에 이벤트를 걸어야 하지만 댓글이 나중에 생기는 부분이기 때문에 
	//존재하는 영역에 댓글을 걸고 나중에 생기는 li 태그에 위임하는 방식으로 작성
	$(".chat").on("click", "li", function(){
		//현재 클릭된 댓글의  rno 가져오기
		var rno=$(this).data("rno");
		replyService.getRow(rno,
				function(result){
					console.log(result);
					//도착한 데이터 모달창에 보여주기
					modalInputReply.val(result.reply);
					modalInputReplyer.val(result.replyer);
					modalInputReplydate.val(replyService.displayTime(result.replydate)).attr("readonly", "readonly");
					//현재 읽어온 rno 담아주기
					modal.data("rno", result.rno);
										
					modal.find("button[id='modalRegisterBtn']").hide();					
					modal.modal("show");
					
				},function(error){
			
		})		
	})
})
</script>
<%@include file="../includes/footer.jsp" %>       