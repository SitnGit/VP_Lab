package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.service.BalloonService;
import mk.ukim.finki.wp.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    private final BalloonService balloonService;

    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }


    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        model.addAttribute("manufacturers",manufacturerService.findAll());
        model.addAttribute("balloons",balloonService.listAll());
        return "listBalloons";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id,Model model){
        if(this.balloonService.findById(id).isPresent()){
            Balloon balloon = this.balloonService.findById(id).get();
            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
            model.addAttribute("manufacturers",manufacturers);
            model.addAttribute("balloon",balloon);
            return "add-balloon";
        }
        return "redirect:/balloons?error=BalloonNotFound";
    }

    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model){
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturers",manufacturers);
        return "add-balloon";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        this.balloonService.deleteById(id);
        return "redirect:/balloons";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name, @RequestParam String description, @RequestParam Long id){
        this.balloonService.createBalloon(name,description,manufacturerService.getManufacturerById(id));
        return "redirect:/balloons";
    }

    @GetMapping("/orders")
    public String getOrdersPage(Model model){

        return "userOrders";
    }
}
