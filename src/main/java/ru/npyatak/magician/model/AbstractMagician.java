package ru.npyatak.magician.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author npyatak
 * @since 23.02.2022
 */
@MappedSuperclass
public class AbstractMagician implements Magician
{
    protected String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Long getId()
    {
        return id;
    }
}
