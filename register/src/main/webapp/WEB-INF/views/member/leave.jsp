<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<form>
	<div class="card"  style="width: 40rem;margin:40px auto;">	
		<div class="card-header">
	    	<h4>회원탈퇴</h4>
	  	</div>
	 	<div class="card-body">	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="text" name="userid" id="userid" class="form-control" value="${auth.userid}" readonly/>
			 		<small id="userid" class="text-info"></small>		
				</div>
			</div>	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="password" name="password" id = "password" class="form-control" placeholder="비밀번호" autofocus="autofocus"/>
					<small id="password" class="text-info"></small>
				</div>	
			</div>				
			<div class="form-group text-center">		
				<button type="submit" class="btn btn-primary">탈퇴</button>
			    <button type="button" class="btn btn-secondary" onclick="location.href='/'" id="leavecancel">취소</button>		
			</div>
		</div>
	</div>	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
$(function(){
	//userid와 password를 서버로 보내서 회원 탈퇴
	//json 형태로 보낸 후 성공하면 index로 이동하기
	//http://localhost:8080/leave + delete
	$(".btn-primary").click(function(e){
		e.preventDefault();
		
		let userid=$("#userid").val();
		let password=$("#password").val();
		
		let param={
				userid:userid,
				password:password
		};
		
		$.ajax({
			url:'leave',
			type:'delete',
			contentType:'application/json',
			data:JSON.stringify(param),
			success:function(data){
				console.log(data);
				location.href='/';
			},
			error:function(xhr, txtStatus, error) {
				let msg=xhr.responseText;
				if(msg==='fail'){
					alert('현재 비밀번호를 확인해 주세요.');
					$("#password").val("");
					$("#password").focus();
				}
			}
		})
	})
})
</script>	
</form>
