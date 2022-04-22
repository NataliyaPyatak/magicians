package ru.npyatak.magician.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author npyatak
 * @since 24.02.2022
 */
@Entity
@Table(name = "magicians")
public class UserMagician extends AbstractMagician
{
    public UserMagician(String name)
    {
        this.name = name;
    }

    public UserMagician()
    {

    }
}
