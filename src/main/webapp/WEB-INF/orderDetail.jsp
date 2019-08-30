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
<script src="<c:url value="/js/index.js"/>"></script>
<style type="text/css">
	#orderinfo{
		width: 990px;
		height: 421px;
		margin: 0 auto;
		margin-top: 40px;
		background-color: #F5F5F5;
	}
	#orderinfo span{
		display: block;
		color: gray;
		margin-top: 5px;
		font-size: 14px;
		position: relative;
		top:20px;
	}
	
</style>
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
	<div id="orderinfo">
		<span style="font-size: 24px;">订单状态：交易成功(已出票)</span>

		<span style="color: red;font-size: 16px;">影片名称：<c:out value="${movie.name}"></c:out></span>
		<span>所在影院：<c:out value="${cinema.name}"/></span>
              	<span><c:out value="${cinema.site}"/></span>

		<span>上映时间：<c:out value="${round.startTime}"/></span>
		<span>座位信息：<c:out value="${selectSeats.size()}"/>张</span>
				<c:forEach items="${selectSeats}" var="seat">
					<span class="sn" data-id="${seat.id}" style="color: red;">
					${seat.name}
					</span> 
				</c:forEach>
		<span>购买总价： ¥<c:out value="${order.sumPrice}"/></span>
		<span>序列号：<c:out value="${order.orderNumb}"/></span>
		<span>验证码：<c:out value="${order.identifyCode}"/></span>
		<span>兑换须知：请使用序列号和验证码在影院取票机或柜台取票，如有问题致电淘宝客服：0571-88157838</span>

		<span>订单号：<c:out value="${order.id}"/></span>
		
		
		<span>下单时间：<c:out value="${order.orderTime}"/></span>

		<span>买家昵称：<c:out value="${user.nickname}"/></span>
		<span>接收影票的手机号码：<c:out value="${order.tel}"/></span>
	</div>
	<div id="foot3"></div>

</body>
</html>