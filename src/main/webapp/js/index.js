/**
 * 
 */
$(function() {
	$(".div_img").click(function() {
		var movieId = $(this).find(".mvId").val();//电影id
		var cityId = $("#city").find("input").val();//城市id
		
		
		window.location.href="movieDetail?cityId="+cityId
						+"&movieId="+movieId;
	})
	
	//登录
	$("#login").click(function() {
		window.open("logShow",'用户登录','width=300,height=300,\
				left=600,top=300');
	});
	
	//注册
	$("#reg").click(function() {
		window.open("regShow",'用户注册','width=300,height=300,left=600,top=300');
	});
	
	//首页功能
	$("#span_index").click(function() {
		var cityId = $("#city").find("input").val();
		window.location.href="http://127.0.0.1:8080/TPP/indexNew?cityId="+cityId;
	});
})