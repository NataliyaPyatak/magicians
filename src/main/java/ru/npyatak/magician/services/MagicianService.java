package ru.npyatak.magician.services;

import java.util.List;

import ru.npyatak.magician.model.Magician;

/**
 *
 * @author npyatak
 * @since 21.02.2022
 */
public interface MagicianService
{
    List<Magician> getMagicians();

    Magician getMagicianById(Long id);

    void saveMagician(String name);
}
