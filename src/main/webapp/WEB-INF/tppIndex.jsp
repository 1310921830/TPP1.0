<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>淘票票</title>
<script src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/css/index.css"/>">
<script src="<c:url value="/js/index.js"/>"></script>
<script type="text/javascript">
	$(function() {
		
		
		//切换背景条
		$(".bgb").click(function() {
			var url = $("#index_head2").css("background-image");
			if(url=='url("http://127.0.0.1:8080/TPP/img/003.jpg")'){
				$("#index_head2").css("background-image", 'url("img/0031.PNG")');
			}else{
				$("#index_head2").css("background-image", 'url("img/003.jpg")')
			}
		});
		
		//切换到即将上映影片
		$("#a1").click(function() {
			$(this).css("border-bottom","2px solid red");
			$("#cuMv").css("border-bottom","0px solid red");
			$("#index_head3_2").css("display","none");
			$("#index_head3_3").css("display","block");
		});
		
		//切换到正在上映影片
		$("#cuMv").click(function() {
			$(this).css("border-bottom","2px solid red");
			$("#a1").css("border-bottom","0px solid red");
			$("#index_head3_2").css("display","block");
			$("#index_head3_3").css("display","none");
			
		});
		//切换城市
		$("#cities a").click(function() {
			var name = $(this).html();
			$("#city .span1").html(name);
			var cityId = $(this).attr("id");
			$("#city").find("input").val(cityId);
			$.ajax({
				url:"showCinemas?cityId="+cityId,
				async:true,
				dataType:"json",
				type:"get",
				success:function(data){
		        	$(".mid2_1").remove();
					$.each(data,function(i,obj){
						var $div = $("<div class='mid2_1'></div>")
						var html = '<br><span><span style="color: red">'+
						(i+1)+"</span>&nbsp;"+obj.name+
						'</span> <a>选座</a><br><span style="color: gray;">'+
						obj.site+"</span>";
						$div.html(html);
						$("#mid2").append($div);
					});
				 }
			});
		});
		
		$(".btbuy").click(function() {
			var movieId = $(this).next(".mvId").val();//电影id
			var cityId = $("#city").find("input").val();//城市id
			window.location.href="movieDetail?cityId="+cityId
							+"&movieId="+movieId;
		})
		
	})
</script>

</head>
<body>
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
	<div id="index_head1">
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
	<div id="index_head2">
		<input type="button" class="bgb" id="bgb1" value="＜"> 
		<input type="button" class="bgb" id="bgb2" value="＞">
	</div>
	<div id="index_head3">
		<div id="index_head3_1">
			<div>
				<a id="cuMv">正在上映</a>&nbsp;&nbsp;&nbsp;&nbsp;<a id="a1">即将上映</a>
				<a href="#" id="allMv" style="color: red; font-size: 10px">查看全部＜</a>
			</div>
		</div>
		<div id="index_head3_2">
			<c:forEach items="${moviesNowLimit}" var="movie">
				<div class="div_img" style="background-image: url('${movie.img}');">
					<div class="noshow">
						<input type="hidden" value="${movie.id}" class="mvId">
						<br>
						<ul>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;导演：${movie.dorector}</li>

							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;主演：${fn:substring(movie.actor,0, 8)}...</li>

							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类型：${movie.type}</li>

							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地区：${movie.area}</li>

							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;语言：${movie.language}</li>

							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片长：${movie.duration}分钟</li>
						</ul>
					</div>
					<div align="center">
						<span id='index_head3_2_span'>${movie.name} ${movie.score}</span>
					</div>
					<div class="sale_div" align="center">
						<span>选座购票</span>
					</div>
				</div>
			</c:forEach>
		</div>
		<div id="index_head3_3">
			<c:forEach items="${moviesFuLimit}" var="movie">
				<div class="div_img" style="background-image: url('${movie.img}');">
					<div id="noshow">
						<br>
						<ul>
							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;导演：${movie.dorector}</li>

							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;主演：${fn:substring(movie.actor,0, 8)}...</li>

							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类型：${movie.type}</li>

							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地区：${movie.area}</li>

							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;语言：${movie.language}</li>

							<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片长：${movie.duration}分钟</li>
						</ul>
					</div>
					<div align="center">
						<span id='index_head3_2_span'>${movie.name} </span>
					</div>
					<div id="sale_div" align="center" style="background-color: white;">
						<span style="color: black;">上映时间${movie.showtime}</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div id="mid"></div>
	<div id="mid_1">
		<div id="mid1">
			<div id="mid1_1">
				<b>上周票房排行</b> <a href="#" style="color: red; font-size: 10px">全部影片></a>
			</div>

			<c:forEach items="${moviesNowLimit}" var="movie"
				varStatus="movieStatus">

				<div class="mid1_1">
					<div style="background-image: url('${movie.img}');"></div>
					<span class="name"> <span style="color: red">${movieStatus.count}</span>
						&nbsp;&nbsp; ${movie.name}
					</span> <span class="score">${movie.score}</span>
					<input type="button" value="选座购票" class="btbuy">
					<input type="hidden" value="${movie.id}" class="mvId">
				</div>
			</c:forEach>
		</div>
		<div id="mid2">
			<div id="mid2_1">
				<b>热门影院排行</b> <a href="#" style="color: red; font-size: 10px">全部影院></a>
			</div>
			<c:forEach items="${cinemasLimit}" var="cinema"
				varStatus="cinemaStatus">

				<div class="mid2_1">
					<br>
					<span> <span style="color: red">${cinemaStatus.count}</span>
						&nbsp; ${cinema.name}
					</span> <a>选座</a>
					<br>
					<span style="color: gray;">${cinema.site}</span>
					
				</div>
			</c:forEach>
		</div>

		<div id="mid3" style="background-image: url('img/008.PNG');"></div>
	</div>
	<div id="foot">
		<div id="foot1">
			<div id="foot1_1">
				<span style="font-size: 20px">新片观影指南</span>
			</div>
			<div id="foot1_2" style="background-image: url('img/011.PNG');"></div>
		</div>
		<div id="foot2">
			<div id="foot2_1">
				<span style="font-size: 20px">热门预告片</span>
			</div>
			<div id="foot2_2">
				<c:forEach items="${moviesNowLimit}" var="movie">

					<div>
						<div class="fuimg"></div>
						<div>${movie.name}</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div id="foot3"></div>
</body>
</html>