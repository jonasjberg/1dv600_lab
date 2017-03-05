/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
** 1DV600 -- Software Technology
** Assignment 2: Analysis, Design and Implementation
** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
** Created by Jonas Sjöberg (js224eh) on 2017-02-19.
**/

import lnu.dao.BooksDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BooksDAOTest
{
    private BooksDAO booksDAO;

    @Before
    public void setUp() throws Exception
    {
        booksDAO = new BooksDAO();

    }

    @After
    public void tearDown() throws Exception { /* Unused .. */ }

    @Test
    public void testSetUp() throws Exception
    {
        assertNotNull(booksDAO);
    }

    @Test
    public void testReadBooksFromFile() throws Exception
    {

    }
}