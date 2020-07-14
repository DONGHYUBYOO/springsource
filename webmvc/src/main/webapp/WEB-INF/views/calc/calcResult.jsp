<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>계산 결과</h1>
	<!-- 도메인 객체에 이름을 주지 않은 경우 -->
	<h2>도메인 객체 이름 정의 안함 : ${calculatorVO.num1} ${calculatorVO.op} ${calculatorVO.num2} = ${result}</h2>	
	<!-- 도메인 객체에 이름을 준 경우 -->
	<h2>도메인 객체 이름 정의 : ${vo.num1} ${vo.op} ${vo.num2} = ${result}</h2>
	<!-- Model에 담은 경우 -->
	<h2>Model에 담은 경우 : ${num1} ${op} ${num2} = ${result}</h2>	
</body>
</html>        