package lnu.models;


import java.util.ArrayList;
import java.util.Collections;


public class Book
{
    private static final String STRING_VALUE_DELIMITER = ",";

    private final String            id;
    private final String            title;
    private final ArrayList<String> authors;
    private final String            genre;
    private final String            date;
    private final double            price;
    private final String            description;

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

    public String getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthors()
    {
        if (authors.size() == 1) {
            return authors.get(0);
        } else {
            return String.join(STRING_VALUE_DELIMITER, this.authors);
        }
    }

    public String getGenre()
    {
        return genre;
    }

    public String getDate()
    {
        return date;
    }

    public double getPrice()
    {
        return price;
    }

    public String getDescription()
    {
        return description;
    }

    public String toString()
    {
        return "MJAOA";
    }

    public String toJSON()
    {
        StringBuilder sb = new StringBuilder("{");

        sb.append("\"id\": \"").append(getId()).append("\", ");
        sb.append("\"title\": \"").append(getTitle()).append("\", ");
        sb.append("\"author\": \"").append(getAuthors()).append("\", ");
        sb.append("\"genre\": \"").append(getGenre()).append("\", ");
        sb.append("\"published\": \"").append(getDate()).append("\", ");
        sb.append("\"price\": \"").append(getPrice()).append("\", ");
        sb.append("\"description\": \"").append(getDescription()).append("\", ");
        sb.append("}");

        return sb.toString();
    }
}
