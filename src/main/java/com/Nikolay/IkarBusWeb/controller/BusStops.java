package com.Nikolay.IkarBusWeb.controller;

import com.Nikolay.IkarBusWeb.model.BusStopsEntity;
import com.Nikolay.IkarBusWeb.repositories.BusStopsRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class BusStops {

    public BusStopsRepository busStopsRepository;
    public BusStops(BusStopsRepository busStopsRepository)
    {
        this.busStopsRepository=busStopsRepository;
    }

    @RequestMapping(value = {"/busstops"}, method = RequestMethod.GET)
    public ModelAndView busstops() {
        ModelAndView mav = new ModelAndView("busstops");

        mav.addObject("BusStopsEntity", busStopsRepository.findAll());

        return mav;
    }


    @RequestMapping(value = "/addBusstop", method = RequestMethod.GET)
    public ModelAndView addBusstop() {
        ModelAndView mav = new ModelAndView("addBusstop");

        BusStopsEntity bse = new BusStopsEntity();
        mav.addObject("bse", bse);

        return mav;
    }

    @RequestMapping(value = "/busstops", method = RequestMethod.POST)
    public ModelAndView saveBusstop(@ModelAttribute("bse") BusStopsEntity bse)
    {
        ModelAndView mav = new ModelAndView("busstops");

        BusStopsEntity newBusStop = new BusStopsEntity();
        newBusStop.setId(bse.getId());
        newBusStop.setCity(bse.getCity());

        busStopsRepository.save(newBusStop);

        mav.addObject("BusStopsEntity", busStopsRepository.findAll());

        return mav;
    }

    @RequestMapping(value = "/addBusstop/{id}", method = RequestMethod.GET)
    public ModelAndView editBusstop(@PathVariable("id") int id ) {
        ModelAndView mav = new ModelAndView("addBusstop");

        Optional<BusStopsEntity> bse = busStopsRepository.findById(id);
        mav.addObject("bse", bse);


        return mav;
    }

    @RequestMapping(value = "/deleteBusstop/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBusstop(@PathVariable("id") int id ) {
        ModelAndView mav = new ModelAndView("deleteBusstop");

        Optional<BusStopsEntity> bse = busStopsRepository.findById(id);
        mav.addObject("bse", bse);


        return mav;
    }

    /*@RequestMapping(value = "/busstops/delete{id}", method = RequestMethod.POST)
    public ModelAndView deleteBackBusstop(@PathVariable("id") int id)
    {
        ModelAndView mav = new ModelAndView("busstops");

        //busStopsRepository.deleteById(id);

        mav.addObject("BusStopsEntity", busStopsRepository.findAll());

        return mav;
    }*/

    @RequestMapping(value = {"/busstops/delete{id}"}, method = RequestMethod.GET)
    public ModelAndView busstops1(@PathVariable("id") int id) {
        busStopsRepository.deleteById(id);
        ModelAndView mav = new ModelAndView("busstops");
        mav.addObject("BusStopsEntity", busStopsRepository.findAll());

        return mav;
    }

}
