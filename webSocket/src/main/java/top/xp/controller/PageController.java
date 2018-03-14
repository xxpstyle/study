package top.xp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webSocket")
public class PageController {
    @RequestMapping("page")
    public String page() {
        return "page";
    }
}
