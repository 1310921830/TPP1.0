package com.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Cinema;
import com.entity.Order;
import com.entity.Round;
import com.entity.User;
import com.service.CinemaService;
import com.service.MovieService;
import com.service.OrderService;
import com.service.RoundService;
import com.service.SeatService;
import com.service.UserService;

/**
 * @author Administrator
 * @date 2019年8月22日
 * @version 1.0
 */

@Controller
public class TppController {
	@Autowired
	MovieService ms;// 调用service层的影片接口
	@Autowired
	CinemaService cs;// 调用service层的影院接口
	@Autowired
	UserService us;// 调用service层的用户接口
	@Autowired
	RoundService rs;// 调用service层的场次接口
	@Autowired
	SeatService ss;// 调用service层的座位接口
	@Autowired
	OrderService os;// 调用service层的订单接口
	// 初始化首页

	@RequestMapping(value = "/index")
	public String showIndex(Model model) {
		System.out.println("请求成功");
		// 获取所有城市
		cs.getCities(model);
		// 根据评分获取影片前5位
		ms.getMoviesByScore(model);
		// 获取即将上映影片前5位
		ms.getMoviesFuLimit(model);
		// 获取南京排行前几位的影院
		cs.getCinemasLimit(1, model);
		// 获取当前城市，默认为南京
		cs.getCityById(1, model);
		return "tppIndex";
	}

	// 首页连接请求
	@RequestMapping(value = "/indexNew")
	public String showIndexByCity(int cityId, Model model) {
		System.out.println("请求成功");
		// 获取所有城市
		cs.getCities(model);
		// 根据评分获取影片前5位
		ms.getMoviesByScore(model);
		// 获取即将上映影片前5位
		ms.getMoviesFuLimit(model);
		// 获取当前城市
		cs.getCityById(cityId, model);
		// 获取当前城市排行前几位的影院
		cs.getCinemasLimit(cityId, model);
		return "tppIndex";
	}

	// 首页地区选择 json数据传输
	@ResponseBody
	@RequestMapping(value = "/showCinemas")
	public List<Cinema> showCinemaByCity(int cityId) {
		return cs.getCinemasLimit(cityId);
	}

	// 注册打开窗口
	@RequestMapping(value = "/regShow")
	public String regShow() {
		return "regShow";
	}

	// 注册
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public int register(@RequestParam Map<String, String> map) {
		return us.saveUser(map);
	}

	// 登录打开窗口
	@RequestMapping(value = "/logShow")
	public String logShow() {
		return "logShow";
	}

	// 登录
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestParam Map<String, String> map, HttpSession httpSession) {
		User user = us.getUser(map);
		httpSession.setAttribute("user", user);
		return user;
	}

	// 查看影片详情
	@RequestMapping(value = "/movieDetail")
	public String movieDetail(int cityId, int movieId, Model model) {

		// 从内存中获取所有城市
		cs.getHavingCities(model);
		// 从内存中获取影片
		ms.getMovieById(movieId, model);
		// 获取当前城市
		cs.getCityById(cityId, model);
		// 获取当前城市的地区信息
		cs.getAreasByCity(cityId, model);
		// 获取当前城市下所有影院信息，同时默认加载第一家影院的影片场次信息
		cs.getCinemasByCity(cityId, movieId, model);

		return "movieDetail";
	}

	// 查看场次
	@ResponseBody
	@RequestMapping(value = "/showRounds", method = RequestMethod.POST)
	public List<Round> showRounds(@RequestParam Map<String, Object> map) {

		return rs.getRounds(map);
	}

	// 选择场次 展示座位情况
	@RequestMapping(value = "/seatOrder")
	public String seatOrder(int roundId, int cityId, HttpSession httpSession, Model model) {
		// 未登陆状态下，拒绝访问，自动跳转首页
		if (null == httpSession.getAttribute("user")) {
			return "forward:index";
		}
		// 从内存中获取所有城市
		cs.getHavingCities(model);
		// 获取当前城市
		cs.getCityById(cityId, model);
		// 场次信息
		Round round = rs.getRoundById(roundId);
		model.addAttribute("round", round);
		// 电影信息
		ms.getMovieById(round.getMovieId(), model);
		// 影院信息
		cs.getCinemaById(round.getCinemaId(), model);
		// 座位信息
		ss.getSeats(roundId, model);
		return "seatOrder";
	}

	// 验证座位--包含占座
	@ResponseBody
	@RequestMapping(value = "/seatsQuery", method = RequestMethod.POST)
	public Map<String, Object> seatsQuery(@RequestParam Map<String, String> map) {
		int result = ss.querySeats(map.get("strIds"));
		Map<String, Object> newMap = new HashMap<String, Object>();
		newMap.put("result", result);
		// 生成临时订单
		if (result == 1) {
			long id = os.addOrder(map);
			newMap.put("orderId", id);
		}
		return newMap;
	}

	// 提交订单
	@RequestMapping(value = "/payOrder")
	public String payOrder(long orderId, Integer cityId, Model model, HttpSession httpSession) {
		// 未登陆状态下，拒绝访问，自动跳转首页
		if (null == httpSession.getAttribute("user")) {
			return "forward:index";
		}
		// 从内存中获取所有城市
		cs.getHavingCities(model);
		// 获取当前城市
		cs.getCityById(cityId, model);
		
		// 订单信息
		Order order = os.getOrderById(orderId);
		model.addAttribute("order", order);

		// 场次信息
		Round round = rs.getRoundById(order.getRoundId());
		model.addAttribute("round", round);
		// 电影信息
		ms.getMovieById(round.getMovieId(), model);
		// 影院信息
		cs.getCinemaById(round.getCinemaId(), model);
		// 所选坐位信息
		ss.getSeats(order.getSeatInfo(), model);

		return "payOrder";
	}

	

	// 默认跳过支付过程，直接到达订单详情页面
	@RequestMapping(value = "/orderDetail")
	public String orderDetail(long orderId, Integer cityId, Model model) {

		// 从内存中获取所有城市
		cs.getHavingCities(model);
		// 获取当前城市
		cs.getCityById(cityId, model);
		// 更新订单
		os.updateOrderByPay(orderId);
		// 订单信息
		Order order = os.getOrderById(orderId);
		model.addAttribute("order", order);

		// 场次信息
		Round round = rs.getRoundById(order.getRoundId());
		model.addAttribute("round", round);
		// 电影信息
		ms.getMovieById(round.getMovieId(), model);
		// 影院信息
		cs.getCinemaById(round.getCinemaId(), model);
		// 所选坐位信息
		ss.getSeats(order.getSeatInfo(), model);
		return "orderDetail";
	}
}
