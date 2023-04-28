package com.codegans.arreg.controller;

import com.codegans.arreg.model.dto.FullPersonInfo;
import com.codegans.arreg.model.dto.PersonDto;
import com.codegans.arreg.service.PersonnelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PersonController {
    private final PersonnelService personnelService;

    @GetMapping("/personnel")
    public String personnel(Model model) {
        model.addAttribute("personnel", personnelService.getAllPersonnel());
        return "personnel";
    }

    @GetMapping("/personnel/{id}")
    public String person(@PathVariable(value = "id") String id, Model model){
        FullPersonInfo fullPersonInfo = personnelService.getByIdFullInfo(id);
        model.addAttribute("person", fullPersonInfo.getPerson());
        model.addAttribute("militaryCard", fullPersonInfo.getMilitaryIDCard());
        model.addAttribute("transfers", fullPersonInfo.getTransfers());
        return "person";
    }

    @GetMapping("/personnel/add")
    public String addPerson(Model model) {
        model.addAttribute("person", new PersonDto());
        return "addPerson";
    }

    @PostMapping("/personnel/save")
    public String savePerson(@ModelAttribute("person") PersonDto personDto) {
        personnelService.savePerson(personDto);
        return "redirect:/personnel";
    }

}
