package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    //url get
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","spring!!");

        // viewResolver가 @controller 리턴 값을 받음
        // 스프링 부트 템플릿엔진 기본 viewName 매핑
        // resources:templates/ + {ViewName} + .html
        // templates hello.html 자동 찾음
        return "hello";
    }
}
