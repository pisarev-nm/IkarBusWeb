package com.Nikolay.IkarBusWeb.controller;


import com.Nikolay.IkarBusWeb.model.BusStopsEntity;
import com.Nikolay.IkarBusWeb.repositories.BusStopsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    final BusStopsRepository busStopsRepository;

    public IndexController(BusStopsRepository busStopsRepository)
    {
        this.busStopsRepository=busStopsRepository;
    }
    @GetMapping(value = "/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Nikolay");
        System.out.println(model.get("name"));
        BusStopsEntity bse = new BusStopsEntity();
        bse.setId(199);
        bse.setCity("Сыктывкар");
        //busStopsRepository.save(bse);
        ModelAndView mdv = new ModelAndView("index", model);
        return mdv;
    }
}
