/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
** 1DV600 -- Software Technology
** Assignment 2: Analysis, Design and Implementation
** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
** Created by Jonas Sjöberg (js224eh) on 2017-02-19.
**/

package lnu.models;


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
