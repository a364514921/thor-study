package org.thor.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thor.miaosha.common.CodeMsg;
import org.thor.miaosha.common.Result;
import org.thor.miaosha.entity.User;
import org.thor.miaosha.redis.RedisService;
import org.thor.miaosha.redis.UserKey;
import org.thor.miaosha.service.UserService;

/**
 * @description: Demo 接口
 * @author: wangyiqiang
 * @date: 2020-02-12 上午6:47
 * @version: V1.0
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    /**
     * 1.rest api json输出 2.页面
     *
     * @return
     */
    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("Hello Thor");
    }

    @RequestMapping("/helloError")
    @ResponseBody
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "Joshua");
        return "hello";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public Result<User> getUser() {
        return Result.success(userService.getById(1));
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Result<String> testTransactional() {
        return Result.success("操作成功，ID：" );
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
        redisService.set(UserKey.getById, "1", "wangyq");
        return Result.success(true);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<String> redisGet() {
        String value = redisService.get(UserKey.getById, "1", String.class);
        return Result.success(value);
    }

}
