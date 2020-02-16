# 秒杀项目

### 秒杀优化 
页面优化技术
- 页面缓存+URL缓存+对象缓存
- 页面静态化，前后端分离
- 静态资源优化



1. 页面缓存 - redis
```text
@Autowired
	ThymeleafViewResolver thymeleafViewResolver;
	
	@Autowired
	ApplicationContext applicationContext;
	
	/**
	 * QPS:1267 load:15 mysql
	 * 5000 * 10
	 * QPS:2884, load:5 
	 * */
    @RequestMapping(value="/to_list", produces="text/html")
    @ResponseBody
    public String list(HttpServletRequest request, HttpServletResponse response, Model model,MiaoshaUser user) {
    	model.addAttribute("user", user);
    	//取缓存
    	String html = redisService.get(GoodsKey.getGoodsList, "", String.class);
    	if(!StringUtils.isEmpty(html)) {
    		return html;
    	}
    	List<GoodsVo> goodsList = goodsService.listGoodsVo();
    	model.addAttribute("goodsList", goodsList);
//    	 return "goods_list";
    	SpringWebContext ctx = new SpringWebContext(request,response,
    			request.getServletContext(),request.getLocale(), model.asMap(), applicationContext );
    	//手动渲染
    	html = thymeleafViewResolver.getTemplateEngine().process("goods_list", ctx);
    	if(!StringUtils.isEmpty(html)) {
    		redisService.set(GoodsKey.getGoodsList, "", html);
    	}
    	return html;
    }
```
2. 对象缓存 - redis 

3. 商品详情静态
编程静态页面、调用接口ajax获取数据

MVVM框架：vue、angular、react

4. 秒杀静态化
5. 静态资源优化

- JS/CSS压缩，减少流量
- 多个JS/CSS组合，减少连接数  开源框架：tengine
- CDN就近访问

6. 超卖问题  

    1.数据库加唯一索引：防止用户重复购买  
    2.SQL加库存数据判断：防止库存变成负数  
    
> 注意：必须在满足数据一致性前提下，做缓存优化

### 接口优化
思路：减少数据库访问
    1.系统初始化，把商品库存数量加载到Redis
    2.收到请求，Redis预减库存，库存不足，直接返回，否则进入
    3.请求入队，立即返回排队中
    4.请求出队，生成订单，减少库存
    5.客户端轮询，是否秒杀成功
    
- RabbitMQ安装与SpringBoot集成

    

- Nginx水扩展
- 压测
- 分库、分表中间件 MyCat





