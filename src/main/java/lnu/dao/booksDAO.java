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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class booksDAO
{
    private static final String FILE_NAME = "books.xml";

    public booksDAO()
    {

    }

    private static Book jaxbXMLToObject() {
        try {
            JAXBContext  context = JAXBContext.newInstance(Book.class);
            Unmarshaller un      = context.createUnmarshaller();
            Book         book     = (Book) un.unmarshal(new File(FILE_NAME));
            return book;
        } catch (JAXBException e) {
            /* TODO: Error handling, logging. */
            e.printStackTrace();
        }

        return null;
    }

}