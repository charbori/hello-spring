package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    //viewResolver대신에 httpMessageConverter가 동작한다.
    //byte 처리 등등 기타 여러 HttpmessageConverter가 기본으로 등록되어 있음
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // "hello spring"
        //String HttpMessageConverter가 기본문자처리
    }

    @GetMapping("hello-api")
    @ResponseBody
    //viewResolver대신에 httpMessageConverter가 동작한다.
    //byte 처리 등등 기타 여러 HttpmessageConverter가 기본으로 등록되어 있음
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();

        hello.setName(name);

        //json 방식으로 전달된다.
        //디폴트는 json방식으로 전달되며. 다 그렇게 쓴다. xml은 찾아서 변경해야 한다.
        return hello;
        //String MappingJackson2HttpMessageConverter가 기본객체처리
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
