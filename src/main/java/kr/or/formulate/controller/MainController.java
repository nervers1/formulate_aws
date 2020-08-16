package kr.or.formulate.controller;

import kr.or.formulate.repository.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Controller
public class MainController {

    private final MainService service;

    public MainController(MainService service) {
        this.service = service;
    }

    @GetMapping(path = "/")
    public String now(Model model) {
        LocalDateTime now = service.getCurrent();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일, hh시 mm분 ss초");
        log.info("now : {}", now.format(formatter));
        model.addAttribute("current", now);
        return "time";
    }


    @GetMapping(path = "/layout")
    public String layout() {
        return "layout";
    }


    @GetMapping(path = "/main")
    public String main() {
        return "main/main";
    }


    @GetMapping(path = "/symbolicLink")
    public String symbolicLink() {
        return "main/symbolicLink";
    }

}
