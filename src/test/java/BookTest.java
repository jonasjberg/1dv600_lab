/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 1DV600 -- Software Technology
 * Assignment 3: Testing
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Created by Jonas Sjöberg (js224eh) on 2017-03-05
 */


import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import lnu.models.Book;
import lnu.models.Genre;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BookTest
{
    final private float FLOAT_TOLERANCE = (float) 0.001;

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

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

    @Test
    public void testGetPublish_date() throws Exception
    {
        assertEquals("1951-08-21", book1.getPublish_date());
        assertEquals("1865-11-26", book2.getPublish_date());
    }

    @Test
    public void testGetPrice() throws Exception
    {
        assertEquals("164.0", book1.getPrice());
        assertEquals("99.0", book2.getPrice());
    }

    @Test
    public void testSetPrice() throws Exception
    {
        book1.setPrice(1);
        assertEquals("1.0", book1.getPrice());
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
    @Ignore
    public void testToJSON() throws Exception
    {
        /* From the Dropwizards documentation, "Testing Dropwizard" at
         * URL: http://www.dropwizard.io/0.8.0/docs/manual/testing.html
         *
         *   This test uses AssertJ assertions and JUnit to test that when a
         *   Person instance is serialized via Jackson it matches the JSON in
         *   the fixture file. (The comparison is done via a normalized JSON
         *   string representation, so whitespace doesn’t affect the results.)
         */
        final Book goodParts = new Book("0596517742",
                                  "JavaScript: The Good Parts",
                                  Genre.PROGRAMMING, "2008-05-01", 17.69,
                                  "Most programming languages contain good and bad parts, but JavaScript has more than its share of the bad, having been developed and released in a hurry before it could be refined. This authoritative book scrapes away these bad features to reveal a subset of JavaScript that's more reliable, readable, and maintainable than the language as a whole—a subset you can use to create truly extensible and efficient code.",
                                  "Douglas Crockford");

        /* .. HOWEVER, ordering *does* affect the result .. */
        assertThat(MAPPER.writeValueAsString(goodParts))
                .isEqualTo(fixture("fixtures/book-is-thin-for-obvious-reasons.json"));
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

    @Test
    public void testEquals() throws Exception
    {
        assertFalse(book1.equals(book2));
        Book book1Clone = new Book("1", "Foundation", Genre.SCIFI, "1951-08-21",
                                   164, BOOK1_DESCRIPTION, "Isaac Asimov");
        assertTrue(book1.equals(book1Clone));
    }
}