package ru.npyatak.magician.repositiry;

import org.springframework.data.repository.CrudRepository;

import ru.npyatak.magician.model.User;

/**
 *
 * @author npyatak
 * @since 26.02.2022
 */
public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
