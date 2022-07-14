package ch.zli.m223.punchclock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Klasse:
 *
 * @author: Tobias Sauter
 * @version:
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/")
    public String login(){
        return "login";
    }
}
