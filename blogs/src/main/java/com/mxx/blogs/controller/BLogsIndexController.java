package com.mxx.blogs.controller;

import com.mxx.blogs.service.BLogsIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/logs")
public class BLogsIndexController {
    @Autowired
    private BLogsIndexService bLogsIndexService;
    @RequestMapping("/index")
    public String IndexBlog(HttpServletRequest request){
        request.setAttribute("result",request);
        return "index";
    }
}
