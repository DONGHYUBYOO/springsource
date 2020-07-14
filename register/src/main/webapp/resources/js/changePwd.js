/**
 * joinForm.jsp 유효성 검증
 */

//규칙
//아이디 : 영문자, 숫자, 특수문자 조합으로 6-12자리
//비밀번호 : 영문자, 숫자, 특수문자 조합으로 8-15자리
//이름 : 한글, 2-4자리
//성별 : 필수
//이메일 : 이메일 검증
$(function(){
	$("#changePwd").validate({
		rules:{
			password:{
				required : true,
//				remote : {
//					url : "/register/checkPWD",
//					type : "post",
//					data : {
//						userid : function(){
//							return $('#passwod').val();
//						}
//					}
//				}
			},
			new_password:{
				required : true,
				validPWD : true,
			},
			confirm_password:{
				required : true,
//				equalTo : "#new_password"
			}
		},
		messages:{
			password:{
				required : "비밀번호를 입력해주세요."				
			},
			new_password:{
				required : "새 비밀번호를 입력해주세요."			
			},
			confirm_password:{
				required : "새 비밀번호 확인을 입력해주세요.",
				equalTo : "새 비밀번호가 일치하지 않습니다."
			}
		},
		//에러메시지 위치 지정
		errorPlacement:function(error,element){
			$(element).closest("form").find("small[id='"+element.attr("id")+"']").append(error);
		}
	})
})

$.validator.addMethod("validPWD",function(value){
	const regPWD = /^(?=.*[A-z])(?=.*\d)(?=.*[!@#$%^&])[A-z\d!@#$%^&]{8,15}$/;
	return regPWD.test(value);
},"영문자, 숫자, 특수문자 조합 8-15자리");