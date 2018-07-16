import java.util.Scanner;

class book
{
    private String name;//name of account holder
    private String title;
    private String author;
    private String genre;
    private int rating;//rating will be from 1-5, 1-lowest and 5-highest

    book(String n, String t, String au, String gen,int rat)
    {
        name=n;
        title=t;
        author=au;
        genre=gen;
        rating=rat;
    }
    book()
    {

    }
    //make functions to sort alphabetically,
    // group same author(use regex here), group by genre, sort by rating
}


public class Bookshelf
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

    }
}
