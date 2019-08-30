<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<script src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			var nickname = $("#i1").val();
			var tel = $("#i2").val();
			var password = $("#i3").val();
			var name = $("#i4").val();
			$.ajax({
				url:"register",
				data:{
					"nickname":nickname,
					"tel":tel,
					"password":password,
					"name":name
				},
				async:true,
				dataType:"text",
				type:"post",
				success:function(data){
					if(data==1){
						window.close();
						window.opener.alert("注册成功");
					}else{
						$("#sp").html("注册失败");
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
			<td width=50%>昵称</td>
			<td width=50%>
				<input type="text" name="nickname" id="i1">
			</td>
		</tr>
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
		<tr align="center">
			<td>姓名</td>
			<td>
				<input type="text" name="name" id="i4">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="提交" id="btn">
				<span style="color: red" id="sp"></span>
			</td>
		</tr>
	</table>
</body>
</html>