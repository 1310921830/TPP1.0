<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<script src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
$(function() {
	$("#btn").click(function() {
		var tel = $("#i2").val();
		var password = $("#i3").val();
		
		$.ajax({
			url:"login",
			data:{
				"tel":tel,
				"password":password,
			},
			async:true,
			dataType:"json",
			type:"post",
			success:function(data){
				if(null!=data){
					var str='<a style="color: red;" id="userinfo">'+
					data.nickname+'</a>&nbsp;&nbsp'+
					'<a id="out">退出</a>&nbsp;&nbsp;手机逛淘宝';
					window.opener.$("#headinfo").html(str);
					window.opener.$(".login").attr("class","seatOrder");
					window.close();
				}else{
					alert("登录失败");
				}
			}
		});
	})
})
</script>
</head>
<body>
	<table border="1" cellpadding="0" height=280px bgcolor="#E4E4E4" align="center">
		
		<tr align="center">
			<td>手机号</td>
			<td>
				<input type="text" name="tel" id="i2">
			</td>
		</tr>
		<tr align="center">
			<td>密码</td>
			<td>
				<input type="password" name="password" id="i3">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="登录" id="btn">
				
			</td>
		</tr>
	</table>
</body>
</html>