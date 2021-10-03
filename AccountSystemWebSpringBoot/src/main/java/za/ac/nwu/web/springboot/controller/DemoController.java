package za.ac.nwu.web.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.domain.service.GeneralResponse;

@RestController
public class DemoController {
    @GetMapping("/ping")
    public GeneralResponse<String> ping(@RequestParam(value = "echo", defaultValue = "pong") String echo) {
        return new GeneralResponse<String>(successful: true, echo);
    }
}