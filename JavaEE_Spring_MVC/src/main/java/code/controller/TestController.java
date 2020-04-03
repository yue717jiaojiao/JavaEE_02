package code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/")

public class TestController {

    @RequestMapping("test")
    public String testapi(){
        String s =  "/index.jsp";
        return s;
    }
}
