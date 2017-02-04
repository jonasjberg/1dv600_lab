// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV600 -- Software Technology
// Assignment 1: Personal planning, Vision and Project Plan
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-02-01.

package lnu.models;

import java.util.ArrayList;
import java.util.Collections;


/**
 * The book class represents a single unique book.
 */
public class Book
{
    private static final String STRING_VALUE_DELIMITER = ",";

    /* An unique id for this book. */
    private final String            id;
    /* The title of this book. */
    private final String            title;
    /* The author(s) of this book. */
    private final ArrayList<String> authors;
    /* The genre of this book. */
    private final String            genre;
    /* The date this book was published. */
    private final String            date;
    /* The price of this book in dollars. */
    private final double            price;
    /* A description of this book. */
    private final String            description;

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
    public Book(String id, String title, String genre, String date,
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
    public String getId()
    {
        return id;
    }

    /**
     * @return The title of this book.
     */
    public String getTitle() { return title; }

    /**
     * Returns the author of this book. If there are multiple authors, the
     * names are joined with "STRING_VALUE_DELIMITER".
     *
     * @return The author(s) of this book.
     */
    public String getAuthors()
    {
        if (authors.size() == 1) {
            return authors.get(0);
        } else {
            return String.join(STRING_VALUE_DELIMITER, this.authors);
        }
    }

    /**
     * @return The genre of this book.
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * @return The date that this book was published.
     */
    public String getDate()
    {
        return date;
    }

    /**
     * @return The price of this book.
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * @return A description of this book.
     */
    public String getDescription()
    {
        return description;
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
        String FORMAT = "%s : %s, ";

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FORMAT, "id: ", getId()));
        sb.append(String.format(FORMAT, "title: ", getTitle()));

        return sb.toString();
    }

    /**
     * Returns the state of this book as JSON data.
     *
     * @return A JSON representation of this book.
     */
    public String toJSON()
    {
        String FORMAT = "\"%s\": \"%s\", ";

        StringBuilder sb = new StringBuilder("{");
        sb.append(String.format(FORMAT, "id", getId()));
        sb.append(String.format(FORMAT, "title", getTitle()));
        sb.append(String.format(FORMAT, "author", getAuthors()));
        sb.append(String.format(FORMAT, "genre", getGenre()));
        sb.append(String.format(FORMAT, "published", getDate()));
        sb.append(String.format(FORMAT, "price", getPrice()));
        sb.append(String.format(FORMAT, "description", getDescription()));
        return sb.append("}").toString();
    }
}
