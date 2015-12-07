package com.deji.biz;

import com.deji.api.HelloApi;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zcfrank1st on 12/4/15.
 */
@Controller
public class HelloController {
    @Autowired
    private HelloApi helloService;

    @RequestMapping(value="/")
    public ModelAndView index(){
        return new ModelAndView("/content/index.jsp");
    }

    @RequestMapping(value= "/hello", method= RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping(value= "/demo", method= RequestMethod.GET)
    @ResponseBody
    public Demo demo() {
        Demo demo = new Demo();
        demo.setId("1");
        demo.setLine(helloService.hello());
        return demo;
    }

    @RequestMapping(value="/demos", method=RequestMethod.GET)
    @ResponseBody
    public List<Demo> demos() {
        Demo demo1 = new Demo();
        demo1.setId("0");
        demo1.setLine(helloService.hello());

        Demo demo2 = new Demo();
        demo2.setId("1");
        demo2.setLine(helloService.hello());

        List<Demo> list =  new ArrayList<Demo>();
        list.add(demo1);
        list.add(demo2);

        return list;
    }

    @RequestMapping(value = "/jsonp", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject test(String callback) {
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "I'm chao");
        return new JSONPObject(callback, map);
    }
}
