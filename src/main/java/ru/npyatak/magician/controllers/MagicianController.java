package ru.npyatak.magician.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ru.npyatak.magician.model.Magician;
import ru.npyatak.magician.services.MagicianService;
import ru.npyatak.magician.services.UserMagicianService;

/**
 *
 * @author npyatak
 * @since 22.02.2022
 */
@Controller
public class MagicianController
{
    private List<MagicianService> magicianServices;

    @Autowired
    public MagicianController(List<MagicianService> MagicianServices)
    {
        this.magicianServices = MagicianServices;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value =
            "/magicians")
    @ResponseBody
    public List<Magician> getMagicians()
    {
        List<Magician> magicians = new ArrayList<>();
        magicianServices.forEach(magicianService ->magicians.addAll(magicianService.getMagicians()));
        return magicians;
    }

    @GetMapping(value = "/magician/{id}")
    @ResponseBody
    public Magician getMagiciansById(@PathVariable("id") Long magicianId)
    {
        Magician magician = magicianServices.stream()
                .map(magicianService -> magicianService.getMagicianById(magicianId))
                .filter(Objects::nonNull)
                .findFirst().orElseGet(null);
        return magician;

    }

    @GetMapping(value = "/magician")
    @ResponseBody
    public Magician getMagiciansByParamId(@RequestParam("id") Long magicianId)
    {
        Magician magician = magicianServices.stream()
                .map(magicianService -> magicianService.getMagicianById(magicianId))
                .filter(Objects::nonNull)
                .findFirst().orElseGet(null);
        return magician;

    }

    @GetMapping("/magiciansView")
    public ModelAndView getMagiciansView()
    {
        List<Magician> magicians = magicianServices.stream()
                .map(magicianService -> magicianService.getMagicians())
                .flatMap(List::stream)
                .collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView("magicians");
        modelAndView.addObject("magicians", magicians);
        return modelAndView;
    }

    @GetMapping("/createMagician/{name}")
    public ModelAndView createMagician(@PathVariable String name)
    {
        magicianServices.stream()
                .filter(magicianService -> magicianService instanceof UserMagicianService)
                .findFirst()
                .get().saveMagician(name);
        return getMagiciansView();
    }

}
