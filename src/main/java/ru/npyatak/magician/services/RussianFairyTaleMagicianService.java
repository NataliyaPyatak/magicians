package ru.npyatak.magician.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ru.npyatak.magician.model.BabaYaga;
import ru.npyatak.magician.model.Koschey;
import ru.npyatak.magician.model.Magician;

/**
 *
 * @author npyatak
 * @since 21.02.2022
 */
@Component
public class RussianFairyTaleMagicianService implements MagicianService
{
    private static Logger LOG = LoggerFactory.getLogger(RussianFairyTaleMagicianService.class);
    private List<Magician> magicians;

    public RussianFairyTaleMagicianService()
    {
        magicians = new ArrayList<>();
        magicians.add(new BabaYaga());
        magicians.add(new Koschey());
    }

    @Override
    public List<Magician> getMagicians()
    {
        return magicians;
    }

    @Override
    public Magician getMagicianById(Long id)
    {
        List<Magician> found =
                magicians.stream().filter(magician -> magician.getId() == id).collect(Collectors.toList());
        return found.size() == 0 ? null : found.stream().findFirst().get();
    }

    @Override
    public void saveMagician(String name)
    {

    }

    @PostConstruct
    public void init()
    {
        //Дополнительная инициализация бина
        LOG.info("Дополнительная инициализация бина RussianFairyTaleMagicianService");
    }
}
