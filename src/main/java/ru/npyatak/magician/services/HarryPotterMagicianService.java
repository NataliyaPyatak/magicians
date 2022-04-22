package ru.npyatak.magician.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ru.npyatak.magician.model.HarryPotter;
import ru.npyatak.magician.model.HermioneGrange;
import ru.npyatak.magician.model.Magician;
import ru.npyatak.magician.model.RonaldWeasley;

/**
 *
 * @author npyatak
 * @since 21.02.2022
 */
@Service
public class HarryPotterMagicianService implements MagicianService
{
    private List<Magician> magicians;
    private static Logger LOG = LoggerFactory.getLogger(HarryPotterMagicianService.class);

    public HarryPotterMagicianService()
    {
        magicians = new ArrayList<>();
        magicians.add(new HarryPotter());
        magicians.add(new HermioneGrange());
        magicians.add(new RonaldWeasley());
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
        LOG.info("Дополнительная инициализация бина HarryPotterMagicianService");
    }
}
