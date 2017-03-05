/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
** 1DV600 -- Software Technology
** Assignment 3: Testing
** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
** Created by Jonas Sjöberg (js224eh) on 2017-03-05
**/

import lnu.dao.Catalog;
import lnu.models.Book;
import lnu.models.Genre;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class CatalogTest
{
    private Catalog catalog;

    @Before
    public void setUp() throws Exception
    {
        catalog = new Catalog();
    }

    @After
    public void tearDown() throws Exception { /* Unused .. */ }

    @Test
    public void testSetUp() throws Exception
    {
        assertNotNull(catalog);
        assertEquals(0, catalog.getBooks().size());
    }

    @Test
    public void testGetBooks() throws Exception
    {
        final ArrayList<Book> expect = new ArrayList<>();
        final Book b1 = new Book("1", "t1", Genre.HORROR,
                                 "2017-01-01", 1, "d1", "a1");
        catalog.addBook(b1);
        expect.add(b1);
        assertEquals(expect, catalog.getBooks());


        final Book b2 = new Book("2", "t2", Genre.HORROR,
                                 "2017-01-02", 2, "d2", "a2");
        catalog.addBook(b2);
        expect.add(b2);
        assertEquals(expect, catalog.getBooks());
    }

    @Test
    public void testAddBook() throws Exception
    {
        catalog.addBook(new Book("1", "t1", Genre.HORROR,
                                 "2017-01-01", 1, "d1", "a1"));
        assertEquals(1, catalog.getBooks().size());

        catalog.addBook(new Book("1", "t1", Genre.HORROR,
                                 "2017-01-01", 1, "d1", "a1"));
        assertEquals(1, catalog.getBooks().size());

        catalog.addBook(new Book("2", "t2", Genre.HORROR,
                                 "2017-01-02", 2, "d2", "a2"));
        assertEquals(2, catalog.getBooks().size());
    }

    @Test
    public void testAddBooks() throws Exception
    {
        final ArrayList<Book> expect = new ArrayList<>();
        final Book b1 = new Book("1", "t1", Genre.HORROR,
                                 "2017-01-01", 1, "d1", "a1");
        catalog.addBook(b1);
        expect.add(b1);
        assertEquals(expect, catalog.getBooks());
        assertEquals(1, catalog.getBooks().size());
    }
}