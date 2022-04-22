package ru.npyatak.magician.repositiry;

import org.springframework.data.repository.CrudRepository;

import ru.npyatak.magician.model.UserMagician;

/**
 *
 * @author npyatak
 * @since 24.02.2022
 */
public interface MagicianRepository extends CrudRepository<UserMagician, Long>
{
}
