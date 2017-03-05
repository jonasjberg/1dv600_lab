// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV600 -- Software Technology
// Assignment 1: Personal planning, Vision and Project Plan
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-02-01.

package lnu.models;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Collections;


/**
 * The book class represents a single unique book.
 */
@XmlRootElement(name = "Book")
@XmlType(propOrder = {"author", "title", "genre", "price", "publish_date",
                      "description"})
public class Book implements Comparable<Book>
{
    private static final String STRING_VALUE_DELIMITER = ",";

    /* An unique id for this book. */
    private String            id;
    /* The title of this book. */
    private String            title;
    /* The author(s) of this book. */
    private ArrayList<String> authors;
    /* The genre of this book. */
    private Genre             genre;
    /* The date this book was published. */
    private String            date;
    /* The price of this book in dollars. */
    private double            price;
    /* A description of this book. */
    private String            description;

    /**
     * Instantiates a new "Book" object.
     * All instance fields are set at object creation through the constructor.
     *
     * @param id           An unique id for this book.
     * @param title        The title of this book.
     * @param genre        The author(s) of this book.
     * @param date         The genre of this book.
     * @param price        The date this book was published.
     * @param description  The price of this book in dollars.
     * @param authors      A description of this book.
     */
    public Book(String id, String title, Genre genre, String date,
                double price, String description, String... authors)
    {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.date = date;
        this.price = price;
        this.description = description;

        this.authors = new ArrayList<>();
        Collections.addAll(this.authors, authors);
    }


    /**
     * @return The id of this book.
     */
    @XmlAttribute
    public String getId()
    {
        return id;
    }

    /**
     * Sets the id of this Book.
     *
     * @param id The new id
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * @return The title of this book.
     */
    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    /**
     * Returns the author of this book. If there are multiple authors, the
     * names are joined with "STRING_VALUE_DELIMITER".
     *
     * @return The author(s) of this book.
     */
    public String getAuthor()
    {
        if (authors.size() == 1) {
            return authors.get(0);
        } else {
            return String.join(STRING_VALUE_DELIMITER, this.authors);
        }
    }

    /**
     * Set the author of this book to a new author or any number
     * of authors as Strings.
     *
     * @param newAuthors The new author(s) of this book.
     */
    public void setAuthor(String... newAuthors)
    {
        if (newAuthors != null) {
            authors.clear();
            Collections.addAll(authors, newAuthors);
        } else {
            // TODO: Log unexpected argument warning.
        }
    }

    /**
     * @return The genre of this book.
     */
    public String getGenre()
    {
        return genre.name();
    }

    /**
     * Sets the genre of this book.
     * @param genre The genre this book belongs to.
     */
    public void setGenre(Genre genre) { this.genre = genre; }

    /**
     * @return The date that this book was published.
     */
    @XmlElement(name = "publish_date")
    public String getDate()
    {
        return date;
    }

    @XmlElement(name = "publish_date")
    public void setDate(String date)
    {
        this.date = date;
    }

    /**
     * @return The price of this book.
     */
    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * @return A description of this book.
     */
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Returns a this book as a human-readable text string.
     *
     * @return This book as a string.
     */
    public String toString()
    {
        /* A bug in either DropWizard and/or Gradle does not allow returning
         * toJSON() from here. Their logging system returns an error for some
         * combinations of characters.
         *
         * ERROR [2017-02-04 18:25:48,186] io.dropwizard.jersey.errors.LoggingExceptionMapper: Error handling a request: 4442be45e520677c
         */
        final String FORMAT = "  %15.15s : %s\n";

        StringBuilder sb = new StringBuilder("{\n");
        sb.append(String.format(FORMAT, "id", getId()));
        sb.append(String.format(FORMAT, "title", getTitle()));
        sb.append(String.format(FORMAT, "genre", getGenre()));
        sb.append(String.format(FORMAT, "date", getDate()));
        sb.append(String.format(FORMAT, "price", getPrice()));
        sb.append(String.format(FORMAT, "description ", getDescription()));
        sb.append(String.format(FORMAT, "author", getAuthor()));

        return sb.append("}\n").toString();
    }

    /**
     * Returns the state of this book as JSON data.
     *
     * @return A JSON representation of this book.
     */
    public String toJSON()
    {
        String       jsonString = null;
        ObjectMapper mapper     = new ObjectMapper();

        try {
            jsonString = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    /**
     * Compare this book with another book.
     *
     * Compares the unique IDs for the books by calling 'getID',
     * followed by comparing the returned strings.
     * If the IDs match, the books are considered duplicates.
     *
     * @param otherBook The book to compare with the calling object.
     * @return Zero (0) if the books are equal, otherwise non-zero.
     */
    @Override
    public int compareTo(Book otherBook)
    {
        try {
            int thisId  = Integer.valueOf(this.getId());
            int otherId = Integer.valueOf(otherBook.getId());
            return thisId - otherId;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return this.getId().compareTo(otherBook.getId());
    }

    /**
     * Compare this book with another object.
     *
     * The comparison returns false if the object is not a book.
     * Otherwise the unique IDs for the books are compared by calling 'getID'.
     * The books are considered duplicates if the IDs match.
     *
     * @param o The object to compare with the calling object.
     * @return True if the books are equals, otherwise False.
     */
    @Override
    public boolean equals(Object o)
    {
        if (o == null) {
            return false;
        } else if (!Book.class.isAssignableFrom(o.getClass())) {
            return false;
        }

        final Book otherBook = (Book) o;
        return this.getId().equals(otherBook.getId());
    }

    public String getPublish_date()
    {
        return getDate();
    }
}
