/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
** 1DV600 -- Software Technology
** Assignment 2: Analysis, Design and Implementation
** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
** Created by Jonas Sjöberg (js224eh) on 2017-02-19.
**/

package lnu.dao;


import lnu.models.Book;

import java.util.ArrayList;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-02-19.
 *
 * The "Catalog" classes is a container for all books in the library.
 */
public class Catalog
{
    private ArrayList<Book> books;

    /**
     * Instantiates a new "Catalog" object.
     */
    public Catalog()
    {
        books = new ArrayList<>();
    }

    /**
     * Get all books in the catalog.
     *
     * @return All the books in the catalog.
     */
    public ArrayList<Book> getBooks()
    {
        return books;
    }

    /**
     * Get all books in the catalog in JSON format.
     *
     * @return All the books in the catalog as a JSON string.
     */
    public String getBooksAsJSON()
    {
        StringBuilder sb = new StringBuilder();

        for (Book book : books) {
            sb.append(book.toJSON()).append(",");
        }

        if (sb.lastIndexOf(",") == sb.length() ) {
            sb.deleteCharAt(sb.length());
        }

        return sb.toString();
    }

    /**
     * Add any number of books to the catalog of books.
     *
     * @param newBooks The books to add.
     */
    public void addBook(Book... newBooks)
    {
        for (Book b : newBooks) {
            addBook(b);
        }
    }

    /**
     * Add a book to the catalog of books.
     *
     * @param newBook The book to add.
     */
    public void addBook(Book newBook)
    {
        if (books.contains(newBook)) {
            // TODO: Handle duplicate entry.
        } else {
            books.add(newBook);
        }
    }
}
