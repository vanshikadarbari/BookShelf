import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class book
{
    String title;
    String author;
    String genre;
    int rating;//rating will be from 1-5, 1-lowest and 5-highest

    book(String t, String au, String gen,int rat)
    {
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


class Bookshelf
{
    public static void main(String[] args)
            throws IOException
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of users.");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            System.out.println("What is your name?");
            String name=sc.next();
            String fname=name+".txt";
            PrintWriter writer = new PrintWriter(fname, "UTF-8");

            System.out.println("How many books do you want to input?");
            int nob=sc.nextInt();
            sc.nextLine();
            for(int j=0;j<nob;j++)
            {
                System.out.println("Enter the title of the book.");
                String title=sc.next();

                System.out.println("Enter the author of the book.");
                String author=sc.next();

                System.out.println("Enter the genre.");
                String genre=sc.next();

                System.out.println("How much would you rate it on a scale from 1-5, with 1 being the lowest?");
                int rate=sc.nextInt();

                book b=new book(title,author,genre,rate);
                writer.println("Title: "+b.title);
                writer.println("Written by: "+b.author);
                writer.println("Genre: "+b.genre);
                writer.println("Rating: "+b.rating);
                writer.print("\n\n\n");

            }
            writer.close();


        }



    }
}
