package com.example.exchangeratecalculator.rate;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RateController {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

@GetMapping(path = "/r")
public Rate getRates(){
    String url = String.format("https://tests.voucher.tumai.to/api/v1/rate/ZAR/USD/");
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Rate> response = restTemplate.getForEntity(url, Rate.class);
    return response.getBody();
}


    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping(value = "/p2", method = RequestMethod.POST)
    public ModelAndView showF() {
        ModelAndView modelAndView = new ModelAndView("rH");
        return modelAndView;
    }


    @RequestMapping(value = "/rH", method = RequestMethod.GET)
    @ResponseBody
    public Rate submit(@Validated @ModelAttribute("rate")Rate rate,
                         BindingResult result, ModelMap model, @RequestParam (name ="base_currency_code") String base_currency_code, @RequestParam (name = "pair_currency_code") String pair_currency_code) {
        String url = String.format("https://tests.voucher.tumai.to/api/v1/rate/"
                + base_currency_code + "/"
                + pair_currency_code + "/");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Rate> response = restTemplate.getForEntity(url, Rate.class);
        return response.getBody();
    }
}

