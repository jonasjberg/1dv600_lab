package lnu.resources;


import lnu.models.Book;
import lnu.models.Genre;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


// Response will be JSON
@Produces(MediaType.APPLICATION_JSON)

// This is the class that will be called when "localhost:9090/api/books" get
// called by the browser.
// FOR THE CURIOUS: Take a look in the config.yml to find out why "/api" is
// present in the path.
@Path("/books")
public class GetBooksResource
{

    @GET
    public String getBooks()
    {
        Book book1 = new Book(
                "978-0521370950",
                "The Art of Electronics",
                Genre.ENGINEERING,
                "1989-07-28",
                59.00,
                "This is the thoroughly revised and updated second edition of" +
                " the hugely successful The Art of Electronics. Widely " +
                "accepted as the authoritative text and reference on " +
                "electronic circuit design, both analog and digital, this " +
                "book revolutionized the teaching of electronics by " +
                "emphasizing the methods actually used by circuit designers " +
                "- a combination of some basic laws, rules of thumb, and a " +
                "large bag of tricks. The result is a largely nonmathematical" +
                " treatment that encourages circuit intuition, brainstorming," +
                " and simplified calculations of circuit values and " +
                "performance.",
                "Paul Horowitz", "Winfield Hill");

        Book book2 = new Book(
                "978-0750699433",
                "CMOS Cookbook, Second Edition",
                Genre.ENGINEERING,
                "1997-02-27",
                35.06,
                "The CMOS Cookbook contains all you need to know to " +
                "understand and successfully use CMOS (Complementary " +
                "Metal-Oxide Semiconductor) integrated circuits. Written in a" +
                " cookbook format that requires little math, this " +
                "practical, user-oriented book covers all the basics for " +
                "working with digital logic and many of its end applications.",
                "Don Lancaster", "Howard M. Berlin");

        // System.out.println("book1.toString(): " + book1.toString());
        // System.out.println("book2.toString(): " + book2.toString());

        // return book2.toJSON();
        return book1.toJSON() + "," + book2.toJSON();
    }
}
