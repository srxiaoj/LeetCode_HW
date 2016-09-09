
/**
 * Created by thanksgiving on 9/8/16.
 */
public class BookSwapper {
    public void swapTitle(Book book1, Book book2) {
        String temp = book1.getTitle();
        book1.setTitle(book2.getTitle());
        book2.setTitle(temp);
    }

    public static void main(String[] args) {
        Book galaxy = new Book();
        galaxy.setTitle("The Hitchhiker's Guide to the galaxy");
        Book wap = new Book();
        wap.setTitle("War and Peace");
        BookSwapper bookSwapper = new BookSwapper();
        bookSwapper.swapTitle(galaxy, wap);
        System.out.println(galaxy.getTitle() + " " + wap.getTitle());
    }
}

class Book {
    private String title;
    private String author;
    private double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
