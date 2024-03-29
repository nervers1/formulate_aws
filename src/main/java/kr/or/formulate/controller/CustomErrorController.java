package kr.or.formulate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping(value = "/error", produces=MediaType.TEXT_PLAIN_VALUE)
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        log.info("CustomErrorController -> status : {}", status);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            String VIEW_PATH = "errorPages/";
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return VIEW_PATH + "404";
            }
            if (statusCode == HttpStatus.FORBIDDEN.value()) {
                return VIEW_PATH + "500";
            }
        }
        return "error";
    }

    @GetMapping(path = "/404", produces=MediaType.TEXT_PLAIN_VALUE)
    public String notFound(Model model) {
        return "errorPages/404";
    }

    @GetMapping(path = "/500", produces=MediaType.TEXT_PLAIN_VALUE)
    public String internalServerError(Model model) {
        return "errorPages/500";
    }

//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }

}

