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
<style type="text/css">
	#time{
		width:990px;
		height: 88px;
		margin: 0 auto;
		background-color: #FFF3F3;
		margin-top: 20px;
	}
	#t_s1{
		position: relative;
		top:30px;
		left:10px;
		color: red;
	}
	#t_s2{
		width: 195px;
		height: 58px;
		background-image: url("img/time.png");
		background-repeat: no-repeat;
		float: right;
		margin-top: 15px;
	}
	#t_s2 span{
		display:block;
		font-size: 14px;
		color: gray;
		position: relative;
		left:50px;
	}
	
	table{
		width: 990px;
		height: 265px;
		border: 0.3px solid #EFEFEF;
		font-size: 12px;
	}
	td{
		border: 0.5px solid #DDDDDD;
	}
	.t2 td{
		background-color: #EFEFEF;
		
	}
	img{
	float:left;
	margin-left: 20px;
	margin-right: 20px;
	}
	.sn{
		display: block;
		border: 0.5px solid #DDDDDD;
		width:100px;
		height: 28px;
		margin-bottom: 10px;
		margin-top: 10px;
	}
	#t1 span{
		display: block;
		
	}
	#payfoot1{
		width:990px;
		height: 80px;
		margin: 0 auto;
	}
	#payfoot1 span{
		float: right;
	}
	#payfoot2{
		width:990px;
		height: 42px;
		margin: 0 auto;
	}
	#payfoot2 input{
		float: right;
		width:220px;
		height: 42px;
		background-color: red;
		color: white;
	}
</style>
<script type="text/javascript">
	$(function() {
		var n = 900;//总计时15分钟900秒
		var otime = $("#ordTime").val();//订单时间
		var orderTime = new Date(otime).getTime();//毫秒
		//每秒钟调用一次
		var timeId = setInterval(function()  {
			var nowTime = new Date().getTime();//现在时间
			var time = 900-Math.floor((nowTime-orderTime)/1000);//剩余的秒数
			
			var m = "";//分钟
			if(time/60<10){
				m = m +"0"+Math.floor(time/60);
			}else{
				m = m+Math.floor(time/60);
			}
			var s = "";//秒
			if(time%60<10){
				s = s +"0"+time%60;
			}else{
				s = s+time%60;
			}
			$("#count").text(m+":"+s);
			
		}, 1000);
		
		//超时调用
		setTimeout(function(){
			clearInterval(timeId);
			var n =window.confirm("时间已过，订单失效,可以重新选座或者回淘票票首页");
			if(n==true){
				history.back();
			}else{
				window.location.href="index";
			};		
		}, 900000+orderTime-new Date().getTime());
		
		//支付
		$("#paymoney").click(function() {
			var orderId=$("#orderId").text();
			var cityId = $("#city input").val();
			window.location.href="orderDetail?orderId="+Number(orderId)
					+"&cityId="+cityId;
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
		<input type="hidden" value="${user.id}">
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
		<span style="color: #26BB7E;">1.选择影片，场次</span>
		<span style="color: #26BB7E;">2.选座，填手机号</span>
		<span style="color: red;">3.确认订单，支付</span>
		<span>4.支付成功，影院取票观影</span>
	</div>
	<div id="time">
		<span id="t_s1">请您确认您的订单信息，并在15分钟内完成付款，如超时系统将自动释放座位</span>
		<div id="t_s2">
			<span>剩余支付时间</span>
			<span id="count" style="font-size: 24px;color: red;"></span>
		</div>
	</div>
	<table cellspacing="0" align="center">
		<tr style="height: 32px;">
			<td colspan="2" style="text-align: left;border-right: none">
			订单号：<span id="orderId"><c:out value="${order.id}"></c:out></span>
			<input type="hidden" value="${order.orderTime }" id="ordTime">
			</td>
			<td colspan="3" style="text-align: right;border-left: none">
			选座票由<span>m1905</span>提供， 客服热线：<span>0571-88157838</span>
			</td>
			
		</tr>
		<tr style="height: 41px;text-align: center;" class="t2">
			<td style="width: 269px;">电影</td>
			<td style="width: 239px;">场次</td>
			<td style="width: 121px;">票数/座位</td>
			<td style="width: 129px;">金额小计</td>
			<td style="width: 231px;">接收电子码的电话号码</td>
		</tr>
		<tr style="height: 191px;" align="center">
			<td id="t1" align="left">
				<img src="${movie.img }" width="84px" height="124px">
				<span>
					<b><c:out value="${movie.name }"></c:out></b>
				</span><br>
				<span>
					版本：<c:out value="${round.langType }"></c:out>
				</span><br>
				<span>
					片长：<c:out value="${movie.duration }"></c:out>
				</span>
			</td>
			<td style="font-size: 16px;" id="t2">
				<span>
					<c:out value="${cinema.name }"></c:out>
				</span><br><br>
				<span>
					<c:out value="${round.room }"></c:out>
				</span><br><br>
				<span style="color: red;">
					<c:out value="${round.startTime }"></c:out>
				</span>
			</td>
			<td>
				<c:out value="${selectSeats.size() }"></c:out>张<br>
				<c:forEach items="${selectSeats}" var="seat">
					<span class="sn" data-id="${seat.id}">${seat.name}</span> 
				</c:forEach>
			</td>
			<td>
				<span style="font-size: 24px;color: red;">￥${order.sumPrice}</span>
			</td>
			<td>
				<span style="font-size: 24px;">
					<c:out value="${user.tel }"></c:out>
				</span><br>
				1.短信可能会被手机软件拦截，请到该软件中查找短信<br>
				2.若要修改手机号，需要您重新下单
			</td>
		</tr>
	</table>
	<div id="payfoot1">
		<span style="font-size: 24px;color: red;"><b>￥${order.sumPrice}</b></span>
		<span>实付款：</span>
	</div>
	<div id="payfoot2">
		<input type="button" value="确认订单，立即支付" id="paymoney">
	</div>
	<div id="foot3"></div>

</body>
</html>