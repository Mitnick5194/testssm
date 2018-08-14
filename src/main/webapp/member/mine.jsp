<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${msg }</h1>
	if you see this page the spring-mvc had runned;
	
	<br><br>
	<button class="getBtn" id="mGetBtn" data-id="10">点我</button>
	
	<script type="text/javascript" src="/member/js/jquery-1.9.1.js"></script>
	<script type="text/javascript">
		$("#mGetBtn").on("click" , function(){
			var id = $(this).attr("data-id");
			$.ajax({
				type: 'post',
				url: 'aj_getMenber.do',
				data: {
					id: id
				},
				success: function(data){
					console.log(data);
					if(!data.isok){
						alert("有错误 : "+data.msg);
						return;
					}
					alert(data.name+"  "+data.age);
				},
				error: function(){
					
				},
				complete: function(){
					
				}
			})
		})
	</script>
</body>
</html>