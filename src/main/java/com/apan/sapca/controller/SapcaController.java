package com.apan.sapca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by apanc on 21-Mar-16.
 */
@Controller
public class SapcaController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello there";
    }


}
