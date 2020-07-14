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
	$("#joinform").validate({
		rules:{
			userid:{
				required : true,
				validID : true,
				remote : {
					url : "/register/checkId",
					type : "post",
					data : {
						userid : function(){
							return $('#userid').val();
						}
					}
				}
			},
			password:{
				required : true,
				validPWD : true
			},
			confirm_password:{
				required : true,
				validPWD : true,
//				equalTo : "#password"
			},
			name:{
				required : true,
				validName : true 
			},
			gender:{
				required : true
			},
			email:{
				required : true,
				email : true
			}
		},
		messages:{
			userid:{
				required : "아이디를 입력해주세요.",
				remote : "아이디가 이미 사용 중 입니다."
			},
			password:{
				required : "비밀번호를 입력해주세요."				
			},
			confirm_password:{
				required : "비밀번호 확인을 입력해주세요.",
				equalTo : "비밀번호가 일치하지 않습니다."
			},
			name:{
				required : "이름을 입력해주세요."
			},
			gender:{
				required : "성별을 선택해주세요."
			},
			email:{
				required : "이메일을 입력해주세요.",
				email : "이메일을 확인해주세요."
			}
		},
		//에러메시지 위치 지정
		errorPlacement:function(error,element){
			$(element).closest("form").find("small[id='"+element.attr("id")+"']").append(error);
		}
	})
})

$.validator.addMethod("validID",function(value){
	const regID = /^(?=.*[A-z])(?=.*\d)(?=.*[!@#$%^&])[A-z\d!@#$%^&]{6,12}$/;
	return regID.test(value);
},"영문자, 숫자, 특수문자 조합 6-12자리");
$.validator.addMethod("validPWD",function(value){
	const regPWD = /^(?=.*[A-z])(?=.*\d)(?=.*[!@#$%^&])[A-z\d!@#$%^&]{8,15}$/;
	return regPWD.test(value);
},"영문자, 숫자, 특수문자 조합 8-15자리");
$.validator.addMethod("validName",function(value){
	const regName = /^[가-힣]{2,4}$/;
	return regName.test(value);
}, "한글 2-4자리");