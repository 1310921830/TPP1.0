<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影详情</title>
<script src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/css/index.css"/>">
<link rel="stylesheet" href="<c:url value="/css/movie.css"/>">
<script src="<c:url value="/js/index.js"/>"></script>
<script type="text/javascript">
	$(function() {
		$("#cinema>span:first").css("color","red");
		$("#date>span:first").css("color","red");
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var day = date.getDate();
		$("#date span:nth-child(1)").html(month+"月"+day+"日（今天）");
		$("#date span:nth-child(1)").attr("data-date",year+"-"+month+"-"+day);
		$("#date input").val($("#date span:nth-child(1)").attr("data-date"));
		
		date.setDate(day+1);
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var day = date.getDate();
		var week = date.getDay();
		$("#date span:nth-child(2)").html(month+"月"+day+"日（周"+week+"）");
		$("#date span:nth-child(2)").attr("data-date",year+"-"+month+"-"+day);
		
		//切换城市
		$("#cities a").click(function() {
			var name = $(this).html();
			$("#city .span1").html(name);
			var cityId = $(this).attr("id");
			$("#city").find("input").val(cityId);
			var movieId = $("#mfHead input").val();
			window.location.href="movieDetail?cityId="+cityId
			+"&movieId="+movieId;
			
		});
		
		//选择区域
		$(".area").click(function() {
			$(this).css("color","red");
			$(this).siblings().css("color","gray");
			var id = $(this).attr("data-id");
			$("#cinema span").each(function() {
				var areaId = $(this).attr("data-areaId");
				if(areaId!=id){
					$(this).css("display","none");
				}else{
					$(this).css("display","block");
				}
			});
			$("#cinema span").each(function() {
				if($(this).css("display")=="block"){
					$(this).css("color","red");
					$(this).siblings().css("color","gray");
					//改变下面影院信息
					$("#sltName").text($(this).html());
					$("#sltSite").text("地址: "+$(this).attr("data-site"));
					$("#sltTel").text("电话: "+$(this).attr("data-tel"));
					$("#selectCinema input").val($(this).attr("data-id"));
					return false;
				}
			});
		});
		
		//全部区域
		$("#area>span:first").click(function() {
			$(this).css("color","red");
			$(this).siblings().css("color","gray");
			$("#cinema span").css("display","block");
			$("#cinema span").css("color","gray");
			$("#cinema span:first").css("color","red");
			$("#sltName").text($("#cinema span:first").html());
			$("#sltSite").text("地址: "+$("#cinema span:first").attr("data-site"));
			$("#sltTel").text("电话: "+$("#cinema span:first").attr("data-tel"));
			$("#selectCinema input").val($("#cinema span:first").attr("data-id"));
		});
		
		//日期选择
		$("#date span").click(function() {
			$("#date input").val($(this).attr("data-date"));
			$(this).css("color","red");
			$(this).siblings().css("color","gray");
		});
		
		//影院选择
		$("#cinema span").click(function() {
			$(this).css("color","red");
			$(this).siblings().css("color","gray");
			
			$("#sltName").text($(this).html());
			$("#sltSite").text("地址: "+$(this).attr("data-site"));
			$("#sltTel").text("电话: "+$(this).attr("data-tel"));
			$("#selectCinema input").val($(this).attr("data-id"));
		});
		
		//场次更新,发送请求
		$("#areaRight span").click(function() {
			var movieId = $("#mfHead input").val();
			var cinemaId = $("#selectCinema input").val();
			var date = $("#date input").val();
			$.ajax({
				url:"showRounds",
				data:{
					"movieId":movieId,
					"cinemaId":cinemaId,
					"date":date
				},
				async:true,
				dataType:"json",
				type:"post",
				success:function(data){
					$(".rinfo").remove();
					var uid = $("#headinfo input").val();
					$.each(data,function(i,obj){
		        		var $div = $("<div></div>");
		        		$div.attr("class","rinfo");
						var html = '<div class="d1"><span style="font-size: 20px;">'+
						obj.startTime.slice(11,16)+
						'</span><br><span style="font-size: 12px;">预计'+
						obj.endTime.slice(11,16)+
						'散场</span></div><div class="d2"><span>'+
						obj.langType+'</span></div><div class="d3"><span>'+
						obj.room +'</span></div><div class="d4"><span>'+
						obj.seatStatus+'</span></div><div class="d5">&nbsp;&nbsp;&nbsp;&nbsp;'+
						'<span style="font-size: 20px;color: red;">'+
							obj.currentPrice+
						'</span>'+
						'<span style="font-size: 10px;text-decoration: line-through;">'+
							obj.orignPrice+
						'</span></div><div class="d6">';
						if(""==uid){
			 				html = html+'<span class="login" style="color: white;">选座购票</span>';
						}else{
							html = html+'<span class="seatOrder" style="color: white;">选座购票</span>';
						};
						html = html+'<input type="hidden" value="'+obj.id+'"></div>';
						$div.html(html);
						$("#roundInfo").append($div);
					});
				 }
			});
		})
		
		//登录
		$(document).on('click','.login',function(){
			window.open("logShow",'用户登录','width=300,height=300,left=600,top=300');
		});
		
		//购票
		$(document).on('click','.seatOrder',function(){
			var roundId = $(this).next("input").val();
			var cityId = $("#city input").val();
			window.location.href="seatOrder?roundId="+roundId
					+"&cityId="+cityId;
		});
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
	<div id="movieInfo">
		<div id="mfHead">
			<input type="hidden" value="${movie.id }">
			<span><c:out value="${movie.name }"></c:out></span>
			<span style="color: red;"><c:out value="${movie.score }"></c:out></span>
		</div>
		<div id="mfLeft" style="background-image: url('${movie.img}');"></div>
		<div id="mfMid">
			<h5>导演：<c:out value="${movie.dorector }"></c:out></h5>
			<h5>主演：<c:out value="${movie.actor }"></c:out></h5>
			<h5>类型：<c:out value="${movie.type }"></c:out></h5>
			<h5>制片国家/地区：<c:out value="${movie.area }"></c:out></h5>
			<h5>片长：<c:out value="${movie.duration }"></c:out>分钟</h5>
			<p>剧情介绍：：<c:out value="${movie.plot }"></c:out></p>
		</div>
		<div id="mfRight">
			<span>
				上映时间：<c:out value="${movie.showtime }"></c:out>
			</span>
			<br><br>
			<img src="img/010.PNG">
			<br><br>
			<img src="img/010.PNG">
		</div>
	</div>
	<div id="divSale">
		<span>选座购票</span>
	</div>
	<div id="midArea">
		<div id="areaLeft">
			<div>
				<span>选择区域</span>
			</div>
			<div>
				<span>选择影城</span>
			</div>
			<div>
				<span>选择时间</span>
			</div>
		</div>
		<div id="areaRight">
			<div id="area">
				<span style="color: red">全部区域</span>
				<c:forEach items="${areas}" var="area">
					<span data-id="${area.id}" class="area">${area.name}</span>
				</c:forEach>
			</div>
			<div id="cinema">
				<c:forEach items="${cinemas}" var="cinema">
					<span data-id="${cinema.id }" data-areaId="${cinema.areaId}"
					data-site="${cinema.site}" data-tel="${cinema.tel}">
					${cinema.name}
					</span>
				</c:forEach>
			</div>
			<div id="date">
				<span></span>
				<span></span>
				<input type="hidden">
			</div>
		</div>
	</div>
	<div id="selectCinema">
		<input type="hidden" value="${cinemaSelect.id}">
		<span style="color: red" id="sltName">
			<c:out value="${cinemaSelect.name }"></c:out>
		</span>&nbsp;&nbsp;&nbsp;&nbsp;
		<span style="font-size: 13px;color: gray;" id="sltSite">
			地址: <c:out value="${cinemaSelect.site }"></c:out>
		</span>
		<span style="font-size: 13px;color: red;">[地图]</span>
		<span style="font-size: 13px;color: gray;" id="sltTel">
			电话: <c:out value="${cinemaSelect.tel }"></c:out>
		</span>
		<span id="cinfo">查看影院详情 ></span>
	</div>
	<div id="roundInfo">
		<div id="rifHead">
			<div class="d1"><span>放映时间</span></div>
			<div class="d2"><span>语言版本</span></div>
			<div class="d3"><span>放映厅</span></div>
			<div class="d4"><span>座位情况</span></div>
			<div class="d5"><span>现价/影院价（元）</span></div>
			<div class="d6"><span>选座购票</span></div>
		</div>
		<c:forEach items="${rounds}" var="round">
			<div class="rinfo">
				<div class="d1">
					<span style="font-size: 20px;">${fn:substring(round.startTime,11,16) }</span><br>
					<span style="font-size: 12px;">
					预计${fn:substring(round.endTime,11,16)}散场
					</span>
				</div>
				<div class="d2">
					<span>${round.langType }</span>
				</div>
				<div class="d3">
					<span>${round.room }</span>
				</div>
				<div class="d4">
					<span>${round.seatStatus }</span>
				</div>
				<div class="d5">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<span style="font-size: 20px;color: red;">
						${round.currentPrice }
					</span>
					<span style="font-size: 10px;text-decoration: line-through;">
						${round.orignPrice }
					</span>
				</div>
				<div class="d6">
					<c:if test="${empty user }">
		 				<span class="login" style="color: white;">选座购票</span>
		 			</c:if>
		 			<c:if test="${!empty user }">
		 				<span class="seatOrder" style="color: white;">选座购票</span>
		 			</c:if>
					<input type="hidden" value="${round.id}">
				</div>
			</div>		
		</c:forEach>
	</div>
	<div id="foot3"></div>

</body>
</html>