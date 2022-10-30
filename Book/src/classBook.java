import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;


class Book implements Comparable<Book>{
    public String nameBook;
    public String nameAuthor;
    Book(){
        nameAuthor = "";
        nameBook = "";
    }
    Book(String name_, String Author_){
        nameBook = name_;
        nameAuthor = Author_;
    }
    public void toJson(String filename) throws IOException {
        FileWriter out = new FileWriter(filename);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String res = gson.toJson(new Book(this.nameBook, this.nameAuthor));
        out.append(res);
        out.flush();
    }
    @Override
    public int compareTo(Book o) {
        return nameBook.compareTo(o.nameBook);
    }

    @Override
    public String toString() {
        return nameBook + " " + nameAuthor;
    }
    static class compareByAuthor implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.nameAuthor.compareTo(o2.nameAuthor);
        }
    }
}




