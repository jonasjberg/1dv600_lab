/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
** 1DV600 -- Software Technology
** Assignment 2: Analysis, Design and Implementation
** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
** Created by Jonas Sjöberg (js224eh) on 2017-02-19.
**/

package lnu.dao;

// Use this file to write and read the xml file.
// http://www.journaldev.com/1234/jaxb-tutorial-example-to-convert-object-to-xml-and-xml-to-object
// javax.xml.bind is added as a part of the sdk from java7 and forward.


import lnu.models.Book;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class booksDAO
{
    private static final String  FILE_NAME   = "books.xml";
    private static final Catalog bookCatalog = new Catalog();

    public booksDAO()
    {
    }

    public void getBooks()
    {
        File localBookXmlFile = getFileFromPath(FILE_NAME);
        // bookCatalog.addBooks(readBooksFromFile(localBookXmlFile));
        bookCatalog.addBook(jaxbXMLToObject(localBookXmlFile));
    }

    /**
     * Reads an XML file and converts the entries to Java "Book" Objects.
     *
     * @return The
     */
    private static Book jaxbXMLToObject(File file)
    {
        try {
            JAXBContext  context = JAXBContext.newInstance(Book.class);
            Unmarshaller un      = context.createUnmarshaller();
            Book         book    = (Book) un.unmarshal(file);
            return book;
        } catch (JAXBException e) {
            /* TODO: Error handling, logging. */
            e.printStackTrace();
        }

        return null;
    }

    private File getFileFromPath(String path)
    {
        File file = null;

        try {
            file = new File(path);
        } catch (Exception e) {
            System.out.printf("[ERROR]: %s\n", e.toString());
        }

        return file;
    }

    /**
     * Reads books from an XML file.
     *
     * Source: Big Java Late Object - Horstmann C. 2013 Wiley
     *         Chapter "23.2 Parsing XML Documents" from the "web-chapters"
     *         available at the Book website.
     *
     * @param file The XML file to read.
     * @return
     */
    public ArrayList<Book> readBooksFromFile(File file)
    {
        ArrayList<Book> list = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder  = factory.newDocumentBuilder();
            Document        document = builder.parse(file);

            NodeList nodeList = document.getElementsByTagName("book");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}