import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class BookList implements Iterable{
    public ArrayList<Book> books;
    public BookList() {
        books = new ArrayList<Book>();
    }
    public void Add(Book b){
        books.add(b);
    }
    public Book Get(int ind){
        return books.get(ind);
    }
    public void SortByNames(){
        Collections.sort(books);
    }
    public void SortByAuthors(){
        Collections.sort(books, new Book.compareByAuthor());
    }
    public int BinarySearchByName(String name) {
        return Collections.binarySearch(books, new Book(name, null), Book::compareTo);
    }
    public void ReadFromJsonFile(String jsonFileName) throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(jsonFileName));
        var bookList = gson.fromJson(reader, BookList.class);
        books = bookList.books;
        reader.close();
    }

    public void WriteToJsonFile(String jsonFileName) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Writer writer = Files.newBufferedWriter(Paths.get(jsonFileName));
        gson.toJson(this, writer);
        writer.close();
    }
    public void groupByAuthor(String jsonFileName) throws IOException {
        Map<String, List<Book>> map = books.stream().collect(Collectors.groupingBy(Book::getNameAuthor, toList()));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Writer writer = Files.newBufferedWriter(Paths.get(jsonFileName));
        gson.toJson(map, writer);
        writer.close();
    }
    public BookList FindBooksByAuthor(String authorName) {
        BookList booksByAuthor = new BookList();
        for (var book : books) {
            if (book.nameAuthor.equals(authorName)) {
                booksByAuthor.Add(book);
            }
        }
        return booksByAuthor;
    }
    public BookList FindBooksByAuthorStream(String authorName_) {
        var res = books.stream().filter(book -> book.nameAuthor == authorName_);
        var filteredBooks = new BookList();
        Collections.addAll(filteredBooks.books, res.toArray(Book[]::new));
        return filteredBooks;
    }
    @Override
    public Iterator<Book> iterator(){
        return new BookListIterator();
    }
    class BookListIterator implements Iterator<Book>{
        Book nextBook;
        int currentIndex;
        public BookListIterator() {
            nextBook = books.get(0);
            currentIndex = 0;
        }
        @Override
        public boolean hasNext(){
            return currentIndex < books.size();
        }
        @Override
        public Book next() {
            Book result = nextBook;
            if (++currentIndex < books.size()) {
                nextBook = books.get(currentIndex);
            }
            return result;
        }
    }
}
