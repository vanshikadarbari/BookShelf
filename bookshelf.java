import java.io.*;


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

        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of users.");
        int n=Integer.parseInt(sc.readLine());
        for(int i=1;i<=n;i++)
        {
            System.out.println("What is your name?");
            String name=sc.readLine();
            name=name.toLowerCase();
            String fname=name+".txt";
            PrintWriter writer=null;
            FileWriter fw=null;
            boolean filexists;
            filexists = new File(fname).exists();

            if(!filexists)
            writer = new PrintWriter(fname, "UTF-8");
            else
            {
                fw=new FileWriter(fname,true);
                //bw = new BufferedWriter(fw);
            }

            System.out.println("How many books do you want to input?");
            int nob=Integer.parseInt(sc.readLine());
            for(int j=0;j<nob;j++)
            {
                System.out.println("Enter the title of the book.");
                String title=sc.readLine();


                System.out.println("Enter the author of the book.");
                String author=sc.readLine();

                System.out.println("Enter the genre.");
                String genre=sc.readLine();

                System.out.println("How much would you rate it on a scale from 1-5, with 1 being the lowest?");
                int rate=Integer.parseInt(sc.readLine());


                book b=new book(title,author,genre,rate);
                if(!filexists)
                {
                    writer.println("Title: "+b.title);
                    writer.println("Written by: "+b.author);
                    writer.println("Genre: "+b.genre);
                    writer.println("Rating: "+b.rating);
                    writer.print("\n\n\n");
                    writer.flush();
                }
                else
                {
                    fw.write("Title: "+b.title+"\n");
                    fw.write("Written by: "+b.author+"\n");
                    fw.write("Genre: "+b.genre+"\n");
                    fw.write("Rating: "+b.rating+"\n");
                    fw.write("\n\n\n");
                }

            }
            if(writer!=null)
            writer.close();
            if(fw!=null)
            fw.close();



        }



    }
}
