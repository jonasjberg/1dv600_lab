/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
** 1DV600 -- Software Technology
** Assignment 2: Analysis, Design and Implementation
** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
** Created by Jonas Sjöberg (js224eh) on 2017-02-19.
**/

package lnu.resources;


import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Produces(MediaType.APPLICATION_JSON)

@Path("/books")
public class RemoveBookResource
{
    // TODO: Read the 30000 lines of minified server code? (!)
    // TODO: Figure out how to re-compile without rebooting the F*****G VM? (!)

    @DELETE
    @Path("{book_id}")
    public Response deleteBook(@PathParam("book_id") String book_id)
    {
        return null;
    }
}