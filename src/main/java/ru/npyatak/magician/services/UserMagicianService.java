package ru.npyatak.magician.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.npyatak.magician.model.Magician;
import ru.npyatak.magician.model.UserMagician;
import ru.npyatak.magician.repositiry.MagicianRepository;

/**
 *
 * @author npyatak
 * @since 24.02.2022
 */
@Component
public class UserMagicianService implements MagicianService
{
    private MagicianRepository magicianRepository;

    @Autowired
    public UserMagicianService(MagicianRepository magicianRepository)
    {
        this.magicianRepository = magicianRepository;
    }
    @Override
    public List<Magician> getMagicians()
    {
        List<Magician> result = new ArrayList<>();
        magicianRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Magician getMagicianById(Long id)
    {
        return magicianRepository.findById(id).get();
    }

    @Override
    public void saveMagician(String name)
    {
        UserMagician magician = new UserMagician(name);
        magicianRepository.save(magician);
    }
}
