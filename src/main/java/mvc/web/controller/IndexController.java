package mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {

    @Controller
    @RequestMapping("/")
    public class HelloController {

        @GetMapping
        public String printWelcome() {
            return "index";
        }

    }
}
