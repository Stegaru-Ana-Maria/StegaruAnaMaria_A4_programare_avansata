package org.example.test;

import org.junit.Test;
import org.example.ArtistDao;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class ArtistDaoTest {
    private ArtistDao artistDao;
    @Test
    public void testCreate() throws SQLException {
        String name = "The Beatles";
        artistDao.create(name);

        Integer id = artistDao.findByName(name);
        assertNotNull(id);
    }

    @Test
    public void testFindByName() throws SQLException {
        String name = "Led Zeppelin";
        artistDao.create(name);

        Integer id = artistDao.findByName(name);
        assertNotNull(id);
        assertEquals(name, artistDao.findById(id));
    }
    @Test
    public void testFindById() throws SQLException {
        String name = "Pink Floyd";
        artistDao.create(name);

        Integer id = artistDao.findByName(name);
        assertNotNull(id);
        assertEquals(name, artistDao.findById(id));
    }

    @Test
    public void testDeleteAll() throws SQLException {
        String name = "The Who";
        artistDao.create(name);

        artistDao.deleteAll();
        assertNull(artistDao.findByName(name));
    }


}

