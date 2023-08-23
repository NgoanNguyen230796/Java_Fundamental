package ra.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Book implements Serializable {
    private String bookId;
    private String bookName;
    private float price;

    public Book() {
    }

    public Book(String bookId, String bookName, float price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void inputData(Scanner sc, List<Book>listBook){
        System.out.print("Nhập vào mã sách:");
        do {
            this.bookId=sc.nextLine();
            boolean isCheckTrungBookId=false;
            for (Book book1:listBook) {
                if(book1.getBookId().equalsIgnoreCase(this.bookId)){
                    isCheckTrungBookId=true;
                    break;
                }
            }
            if(isCheckTrungBookId){
                System.err.println("Mã sách đã bị trùng,vui lòng nhập lại");
            }else{
                break;
            }

        }while (true);

        System.out.print("Nhập vào tên sách:");
        this.bookName=sc.nextLine();
        System.out.print("Nhập vào giá sách:");
        do {
            try{
                this.price=Float.parseFloat(sc.nextLine());
                if(this.price>0){
                    break;
                }else{
                    System.err.println("Giá sách phải là số thực lớn hơn 0 ,vui lòng nhập lại");
                }
            }catch (NumberFormatException ex){
                System.err.println("Giá sách phải là số ,vui lòng nhập lại");
            }

        }while (true);

    }

    public void displayData(){
        System.out.printf("%-30s%-30s%-30f\n",this.bookId,this.bookName,this.price);
    }
}
