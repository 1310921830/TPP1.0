<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>座位详情</title>
<script src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/css/index.css"/>">
<link rel="stylesheet" href="<c:url value="/css/seat.css"/>">
<script src="<c:url value="/js/index.js"/>"></script>
<script type="text/javascript">
	$(function() {
		//先更新座位
		$("#imid div").each(function() {
			if($(this).attr("data-flag")==0){
				$(this).css("background-image", 'url("img/seat.png")');
			}else{
				$(this).css("background-image", 'url("img/seat2.png")');
			}
		});
		
		//选座
		$("#imid div").click(function() {
			var url = $(this).css("background-image").slice(35,-2);
			
			if(url=='img/seat.png'){
				$(this).css("background-image", 'url("img/seat3.png")');
				//右边更新
				$("#nums").html($("#nums").html()+"<span data-id="+
						$(this).attr("data-id")+">"+
						$(this).attr("data-name")+"</span>");
				var n = Number($("#seatNbs").text());
				$("#seatNbs").text(n+1);
				$("#sumPrice").text(Number($("#price").text())*(n+1));
				
			}else if(url=='img/seat3.png'){
				$(this).css("background-image", 'url("img/seat.png")');
				var name = $(this).attr("data-name");
				//右边更新
				$("#nums span").each(function() {
					if($(this).text()==name){
						$(this).remove();
					}
				});
				var n = Number($("#seatNbs").text());
				$("#seatNbs").text(n-1);
				$("#sumPrice").text(Number($("#price").text())*(n-1));
			}else{
				//alert("不可选");
			};
		});
		
		//提交下单
		$("#bt").click(function() {
			var sumPrice = Number($("#sumPrice").text());
			if(sumPrice==0){
				alert("请选座位");
			}else{
				var strIds = "";
				$("#nums span").each(function() {
					strIds = strIds + $(this).attr("data-id")+",";
				})
				
				//先验证座位
				$.ajax({
					url:"seatsQuery",
					data:{
						"strIds":strIds.slice(0,-1),
						"tel":$("#i1").val(),  
						"sumPrice":$("#sumPrice").text(),
						"uId":$("#uId").val(), 
						"rId":$("#rd").val()
					},
					async:false,
					dataType:"json",
					type:"post",
					success:function(data){
						if(data.result==1){
							var cityId = $("#city input").val();
							var orderId = data.orderId;
							
							window.location.href="payOrder?cityId="+cityId
									+"&orderId="+orderId;
						}else{
							alert("座位已被占，请刷新页面");
						}
					}
				});
				
				
			}
		})
	})
</script>

</head>
<body style="height: 1450px;">
	<div id="index_head">
		<ul>
			<li>网站导航</li>
			<li>联系客服</li>
			<li>卖家中心</li>
			<li>商品分类</li>
			<li>收藏夹</li>
			<li>购物车</li>
			<li>我的淘宝</li>
			<li>淘宝网首页</li>
		</ul>
		<span style="font-size: 10px" id="headinfo">
		<input type="hidden" value="${user.id}" id="uId">
		 <c:if test="${empty user }">
		 	<a style="color: red;" id="login">亲，请登录</a>&nbsp;&nbsp;
			<a id="reg">免费注册</a>&nbsp;&nbsp;手机逛淘宝
		 </c:if>
		<c:if test="${!empty user }">
			<a style="color: red;" id="userinfo">
				<c:out value="${user.nickname }"></c:out>
			</a>&nbsp;&nbsp;
			<a id="out">退出</a>&nbsp;&nbsp;手机逛淘宝
		</c:if> 
		
		</span>
	</div>
	<div id="index_head1" style="border-bottom: 1px solid gray;">
		<div id="tpp_img">
			<img alt="图片不存在" src="img/005.png">
		</div>
		<div id="city" align="center">
			<input type="hidden" value="${ city.id}">
			<span class="span1"><c:out value="${city.name}"></c:out></span> <span id="span1"></span>
		</div>
		<div id="cities">
			<c:forEach items="${cities}" var="city">
			<a id="${city.id}" class="ignore-city">${city.name}</a>
	        
			</c:forEach>
		</div>
		<div id="head1_s1">
			<span class="span1" id="span_index">首页</span>
		</div>
		<div id="head1_s2">
			<span class="span1">影片</span>
		</div>
		<div id="head1_s3">
			<span class="span1">影院</span>
		</div>
		<div id="head1_s4" style="font-size: 13px">
			&nbsp;&nbsp;&nbsp;&nbsp;手机购买</div>
		<div id="head1_s5" style="font-size: 13px">
			&nbsp;&nbsp;&nbsp;&nbsp;客服咨询</div>
	</div>
	<div id="seatHead">
		<input type="hidden" value="${movie.id}" id="mv">
		<input type="hidden" value="${cinema.id}" id="cn">
		<input type="hidden" value="${round.id}" id="rd">
		<span style="color: #26BB7E;">1.选择影片，场次</span>
		<span style="color: red;">2.选座，填手机号</span>
		<span>3.确认订单，支付</span>
		<span>4.支付成功，影院取票观影</span>
	</div>
	<div id="seatBody">
		<div id="left">
			<div id="ihead"></div>
			<span class="ihead">
				<c:out value="${cinema.name }"></c:out>&nbsp;
				<c:out value="${round.room }"></c:out>&nbsp;银幕
			</span>
			<div id="imid">
				<c:forEach items="${seats}" var="seat">
					<div data-name="${seat.name}" 
					data-id="${seat.id}" 
					data-flag="${seat.flag}"></div>
				</c:forEach>
			</div>
			<div id="ifoot">
			<img src="img/seat.png">
			<span style="font-size: 14px;">可选座位</span>&nbsp;&nbsp;
			<img src="img/seat3.png">
			<span style="font-size: 14px;">已选座位</span>&nbsp;&nbsp;
			<img src="img/seat2.png">
			<span style="font-size: 14px;">不可选座位</span>&nbsp;&nbsp;
			</div>
		</div>
		<div id="right">
			<div id="r1">
				<div id="r1_1" style="background-image: url('${movie.img}');"></div>
				<br>
				&nbsp;&nbsp;<span style="font-size: 14px;"><c:out value="${movie.name }"></c:out></span><br>
				&nbsp;&nbsp;<span style="font-size: 13px;color: gray;">版本：<c:out value="${round.langType }"></c:out></span><br>
				&nbsp;&nbsp;<span style="font-size: 13px;color: gray;">片长：<c:out value="${movie.duration }"></c:out>分钟</span>
			</div>
			<div id="r2">
			
			<span>影院:</span>&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="font-size: 16px;color: black;">
				<c:out value="${cinema.name }"></c:out>
			</span><br><br>
			<span>影厅:</span>&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="font-size: 16px;color: black;">
				<c:out value="${round.room }"></c:out>
			</span><br><br>
			<span>场次:</span>&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="font-size: 16px;color: red;">
				<c:out value="${round.startTime }"></c:out>
			</span><br><br>
			<span>座位:</span>&nbsp;&nbsp;&nbsp;&nbsp;
			<div id="nums"></div>
			
			</div>
			<div id="r3">
			<span>原价:</span>&nbsp;&nbsp;&nbsp;&nbsp;
			<span>￥</span>
			<span id="price"><c:out value="${round.currentPrice }"/></span>
			<span>×</span><span id="seatNbs">0</span><br><br>
			<span>总计:</span>&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="font-size: 16px;color: red;">￥</span>
			<span style="font-size: 16px;color: red;" id="sumPrice">0</span>
			</div>
			<div id="r4">
				<span style="color: black;">接受电子码的手机号（11位）</span><br><br>
				<input type="text" value="${user.tel }" id="i1"><br>
				<input type="button" value="确认信息，下单" id="bt">
			</div>
		</div>
	</div>
	<div id="seatFoot"></div>
	<div id="foot3"></div>

</body>
</html>