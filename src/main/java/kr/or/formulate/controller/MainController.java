package kr.or.formulate.controller;

import kr.or.formulate.repository.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

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
        log.info("now : {}", now);
        model.addAttribute("current", now);
        return "time";
    }

    @GetMapping(path = "/404")
    public String notFound(Model model) {
        model.addAttribute("message", "404 Not Found");
        return "/errorPages/404";
    }

    @GetMapping(path = "/500")
    public String internalServerError(Model model) {
        model.addAttribute("message", "Internal Server Error");
        return "/errorPages/500";
    }


}
