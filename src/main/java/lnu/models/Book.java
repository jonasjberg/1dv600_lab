package lnu.models;


public class Book
{
    private final double id;
    private final String title;
    private final String author;
    private final String genre;
    private final String date;
    private final double price;
    private final String description;

    public Book(double id, String title, String author, String genre,
                String date, double price, String description)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.date = date;
        this.price = price;
        this.description = description;
    }

    public double getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
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
}
