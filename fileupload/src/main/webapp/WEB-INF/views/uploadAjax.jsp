<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadAjax</title>
</head>
<body>
<h1>Upload Ajax</h1>
<div class="uploadDiv">
	<input type="file" name="uploadFile" multiple />
</div>
<button id="uploadBtn">upload</button>
<div class="uploadResult">
	<ul>
	
	</ul>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script>
$(function(){
	$("#uploadBtn").click(function(){
		//form 형태로 데이터를 구성할 수 있다
		//key-value의 형태로 값을 찾아온다
		let formData = new FormData();
		
		//첨부파일 목록 가져오기
		let uploadFile=$("input[name='uploadFile']");		
		let files=uploadFile[0].files;
		console.log(files);
		
		//form의 형태로 붙이기
		//첨부파일 Type 및 Size 제한
		for(var i=0;i<files.length;i++){
			if(!checkExtension(files[i].name, files[i].size)){
				return false;
			}
			formData.append("uploadFile", files[i]);
		}
		
		
		//processData : 데이터를 query string(http://~~?uploadFile=테스트.txt&)으로 변환할 것인지 결정 
		//				(Default : application/x-www-form-urlencoded로 true)
		//contentType : 파일의 경우에 enctype은 multipart/form-data로 보내야 하기 때문에 false로 지정 
		//				(Default : application/x-www-form-urlencoded로 true)
		$.ajax({
			url:"uploadAjax",
			type:"post",
			processData:false,
			contentType:false,
			data:formData,
			success:function(result){
				alert(result);
			},
			error:function(xhr, status, error){
				alert(xhr.responseText);
			}
		})
	})
	
	//첨부파일 Type 및 Size 제한
	function checkExtension(fileName, fileSize){
		let regex = new RegExp("(.*?)\.(exe|sh|zip|alx)$");
		let maxSize=2097152;
		
		if(fileSize>maxSize){
			alert("파일 크기 초과");
			return false;
		}
		if(regex.test(fileName)){
			alert("해당 종류의 파일은 업로드 할 수 없습니다. (exe, sh, zip, alx)")
			return false;
		}
		return true;
	}
})
</script>
</body>
</html>