package ru.npyatak.magician.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author npyatak
 * @since 31.03.2022
 */
@Controller
public class ImageController
{
    @GetMapping("/image/good")
    public ModelAndView getMagiciansView(final HttpServletRequest request,
            final HttpServletResponse response) throws IOException
    {
        ModelAndView modelAndView = new ModelAndView("image");
        List<String> imgs = new ArrayList<>();
        imgs.add("https://www.imgonline.com.ua/examples/bee-on-daisy.jpg");
        modelAndView.addObject("imgs", imgs);
        modelAndView.addObject("some", "some");
        return modelAndView;
    }

    @GetMapping(
            value = "/image",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getSomeImage() throws IOException
    {
        List<String> imgs = new ArrayList<>();
        File file = new File("/home/npyatak/Изображения/Ситуационный план.png");
        byte[] fileContent = Files.readAllBytes(file.toPath());
        return fileContent;
    }
}
