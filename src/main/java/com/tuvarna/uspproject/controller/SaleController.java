package com.tuvarna.uspproject.controller;

import com.tuvarna.uspproject.model.Sale;
import com.tuvarna.uspproject.service.api.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.UUID;

@Controller
@RequestMapping("/sales")
public final class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    protected ModelAndView findSales(ModelAndView modelAndView) {
        Collection<Sale> sales = saleService.findAll();
        modelAndView.addObject("sales", sales).setViewName("view-sales");
        return modelAndView;
    }

    @GetMapping("/add")
    protected ModelAndView addSale(ModelAndView modelAndView) {
        modelAndView.addObject("sale", new Sale()).setViewName("add-sale");
        return modelAndView;
    }

    @PostMapping("/add")
    protected ModelAndView processAddSale(@Valid @ModelAttribute("sale") Sale sale, BindingResult bindingResult, ModelAndView modelAndView) {
        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("add-sale");
            return modelAndView;
        }
        saleService.save(sale);
        modelAndView.setViewName("redirect:/sales");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    protected ModelAndView editSale(@PathVariable("id") UUID id, ModelAndView modelAndView) {
        Sale sale = saleService.findById(id);
        modelAndView.addObject("sale", sale).setViewName("edit-sale");
        return modelAndView;
    }

    protected ModelAndView processEditSale(@Valid @ModelAttribute("sale") Sale sale, BindingResult bindingResult, ModelAndView modelAndView) {
        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("edit-sale");
            return modelAndView;
        }
        saleService.update(sale);
        modelAndView.setViewName("redirect:/sales");
        return modelAndView;
    }
}
