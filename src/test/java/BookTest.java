/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 1DV600 -- Software Technology
 * Assignment 3: Testing
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Created by Jonas Sjöberg (js224eh) on 2017-03-05
 */


import lnu.models.Book;
import lnu.models.Genre;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BookTest
{
    final private float FLOAT_TOLERANCE = (float) 0.001;

    Book book1;
    Book book2;
    final String BOOK1_DESCRIPTION = "Foundation is the first novel in Isaac Asimovs Foundation Trilogy (later expanded into The Foundation Series). Foundation is a cycle of five interrelated short stories, first published as a single book by Gnome Press in 1951. Collectively they tell the story of the Foundation, an institute to preserve the best of galactic civilization after the collapse of the Galactic Empire.";
    final String BOOK2_DESCRIPTION = "Alice in Wonderland tells of a girl named Alice falling through a rabbit hole into a fantasy world populated by peculiar, anthropomorphic creatures. The tale plays with logic, giving the story lasting popularity with adults as well as with children. It is considered to be one of the best examples of the literary nonsense genre. Its narrative course and structure, characters and imagery have been enormously influential in both popular culture and literature, especially in the fantasy genre.";

    @Before
    public void setUp() throws Exception
    {
        book1 = new Book("1", "Foundation", Genre.SCIFI, "1951-08-21", 164,
                         BOOK1_DESCRIPTION, "Isaac Asimov");
        book2 = new Book("5", "Alice in Wonderland", Genre.NOVEL, "1865-11-26",
                         99, BOOK2_DESCRIPTION, "Lewis Carroll");
    }

    @After
    public void tearDown() throws Exception { /* Not used. */}

    @Test
    public void getId() throws Exception
    {
        assertEquals("1", book1.getId());
        assertEquals("5", book2.getId());
    }

    @Test
    public void testSetId() throws Exception
    {
        book1.setId("66");
        assertEquals("66", book1.getId());
    }

    @Test
    public void testGetTitle() throws Exception
    {
        assertEquals("Foundation", book1.getTitle());
        assertEquals("Alice in Wonderland", book2.getTitle());
    }

    @Test
    public void setTitle() throws Exception
    {
        book1.setTitle("New Title");
        assertEquals("New Title", book1.getTitle());
    }

    @Test
    public void testGetAuthor() throws Exception
    {
        assertEquals("Isaac Asimov", book1.getAuthor());
        assertEquals("Lewis Carroll", book2.getAuthor());
    }

    @Test
    public void testSetAuthor() throws Exception
    {
        book1.setAuthor("New Author 1");
        assertEquals("New Author 1", book1.getAuthor());
    }

    @Test
    public void testGetGenre() throws Exception
    {
        assertEquals(Genre.SCIFI.toString(), book1.getGenre());
        assertEquals(Genre.NOVEL.toString(), book2.getGenre());
    }

    @Test
    public void testSetGenre() throws Exception
    {
        book1.setGenre(Genre.HORROR);
        assertEquals(Genre.HORROR.toString(), book1.getGenre());
    }

    @Test
    public void testGetDate() throws Exception
    {
        assertEquals("1951-08-21", book1.getDate());
        assertEquals("1865-11-26", book2.getDate());
    }

    @Test
    public void testSetDate() throws Exception
    {
        book1.setDate("2066-12-24");
        assertEquals("2066-12-24", book1.getDate());
    }

    @Ignore
    @Test
    public void testGetPublish_date() throws Exception
    {
        // TODO: Implement ..
    }

    @Test
    public void testGetPrice() throws Exception
    {
        assertEquals(164, book1.getPrice(), FLOAT_TOLERANCE);
        assertEquals(99, book2.getPrice(), FLOAT_TOLERANCE);
    }

    @Test
    public void testSetPrice() throws Exception
    {
        book1.setPrice(1);
        assertEquals(1, book1.getPrice(), FLOAT_TOLERANCE);
    }

    @Test
    public void testGetDescription() throws Exception
    {
        assertEquals(BOOK1_DESCRIPTION, book1.getDescription());
        assertEquals(BOOK2_DESCRIPTION, book2.getDescription());
    }

    @Test
    public void testSetDescription() throws Exception
    {
        final String d = "fech is not a git command. Did you mean rm -rf /?";
        book1.setDescription(d);
        assertEquals(d, book1.getDescription());
    }

    @Ignore
    @Test
    public void testToString() throws Exception
    {
        // TODO: Implement ..
    }

    @Test
    public void testToJSON() throws Exception
    {
        final String expectBook1JSON = "{\"id\":\"1\",\"title\":\"Foundation\",\"genre\":\"SCIFI\",\"date\":\"1951-08-21\",\"price\":164.0,\"description\":\"Foundation is the first novel in Isaac Asimovs Foundation Trilogy (later expanded into The Foundation Series). Foundation is a cycle of five interrelated short stories, first published as a single book by Gnome Press in 1951. Collectively they tell the story of the Foundation, an institute to preserve the best of galactic civilization after the collapse of the Galactic Empire.\",\"author\":\"Isaac Asimov\",\"publish_date\":\"1951-08-21\"}";
        final String expectBook2JSON = "{\"id\":\"5\",\"title\":\"Alice in Wonderland\",\"genre\":\"NOVEL\",\"date\":\"1865-11-26\",\"price\":99.0,\"description\":\"Alice in Wonderland tells of a girl named Alice falling through a rabbit hole into a fantasy world populated by peculiar, anthropomorphic creatures. The tale plays with logic, giving the story lasting popularity with adults as well as with children. It is considered to be one of the best examples of the literary nonsense genre. Its narrative course and structure, characters and imagery have been enormously influential in both popular culture and literature, especially in the fantasy genre.\",\"author\":\"Lewis Carroll\",\"publish_date\":\"1865-11-26\"}";
        assertEquals(expectBook1JSON, book1.toJSON());
        assertEquals(expectBook2JSON, book2.toJSON());
    }

    @Test
    public void testCompareTo() throws Exception
    {
        boolean firstComp = book1.compareTo(book2) >= 0;
        assertFalse(firstComp);

        Book book1Clone = new Book("1", "Foundation", Genre.SCIFI, "1951-08-21",
                                   164, BOOK1_DESCRIPTION, "Isaac Asimov");
        boolean secondComp = book1.compareTo(book1Clone) >= 0;
        assertTrue(secondComp);
    }

    @Ignore
    @Test
    public void testEquals() throws Exception
    {
        assertFalse(book1.equals(book2));
        Book book1Clone = new Book("1", "Foundation", Genre.SCIFI, "1951-08-21",
                                   164, BOOK1_DESCRIPTION, "Isaac Asimov");
        assertTrue(book1.equals(book1Clone));
    }
}