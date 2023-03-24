package org.medhead.emergencysystem.webclienthospitals.controller;

import lombok.Data;
import org.medhead.emergencysystem.webclienthospitals.model.Hospital;
import org.medhead.emergencysystem.webclienthospitals.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
public class HospitalController {

    @Autowired
    private HospitalService service;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Hospital> listHospital = service.getHospitals();
        model.addAttribute("hospitals", listHospital);
        return "homeHospitals";
    }

    @GetMapping("/createHospital")
    public String createHospital(Model model) {
        Hospital h = new Hospital();
        model.addAttribute("hospital", h);
        return "formNewHospital";
    }

    @GetMapping("/updateHospital/{id}")
    public String updateHospital(@PathVariable("id") final int id, Model model) {
        Hospital h = service.getHospital(id);
        model.addAttribute("hospital", h);
        return "formUpdateHospital";
    }

    @GetMapping("/deleteHospital/{id}")
    public ModelAndView deleteHospital(@PathVariable("id") final int id) {
        service.deleteHospital(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/saveHospital")
    public ModelAndView saveHospital(@ModelAttribute Hospital hospital) {
        if(hospital.getId() != null) { Hospital current = service.getHospital(hospital.getId()); }
        service.saveHospital((hospital));
        return new ModelAndView("redirect:/");
    }
}
