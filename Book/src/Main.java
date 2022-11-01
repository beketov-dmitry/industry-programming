import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class  Main{

    public static void main(String[] args) throws IOException {
        var books = new BookList();
        books.Add(new Book("C++", "Gregori Luczin"));
        books.Add(new Book("C++", "Gregori Luczin"));
        books.Add(new Book("JavaScript", "Bob Marley"));
        books.Add(new Book("11.22.63", "Stephen King"));
        books.Add(new Book("it", "Stephen King"));

        var booksFind = books.FindBooksByAuthor("Stephen King");
        System.out.println("Stephen King's books: ");
        for(var x : booksFind){
            System.out.println(x);
        }
        System.out.println();
        books.FindBooksByAuthorStream("Stephen King");
        System.out.println();
        books.SortByAuthors();
        System.out.println("Books sort by Authors: ");
        for(var x : books){
            System.out.println(x);
        }
        System.out.println();
        books.WriteToJsonFile("output.json");
        var book1 = new BookList();
        System.out.println();
        book1.ReadFromJsonFile("output.json");
        for(var x : book1){
            System.out.println(x.toString());
        }
        System.out.println();
        var bookFilter = books.FindBooksByAuthorStream("Stephen King");
        for(var x : bookFilter){
            System.out.println(x.toString());
        }
        books.groupByAuthor("output.json");
    }
}
