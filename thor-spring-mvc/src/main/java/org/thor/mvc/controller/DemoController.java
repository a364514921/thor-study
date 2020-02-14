package org.thor.mvc.controller;


import org.thor.mvc.annotation.*;
import org.thor.mvc.service.DemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-31 下午3:30
 * @Version: V1.0
 */
@ThorController("demoController")
@ThorRequestMapping("/demo")
public class DemoController {

    @ThorAutowired("demoServiceImpl")
    private DemoService demoService;

    /**
     * 获取用户信息
     *
     * @param name
     * @param age
     * @param request
     * @param response
     */
    @ThorRequestMapping("/query")
    public void getUser(@ThorRequestParam("name") String name,
                        @ThorRequestParam("age") String age,
                        HttpServletRequest request, HttpServletResponse response) {
        try {
            String result = demoService.query(name, age);
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
