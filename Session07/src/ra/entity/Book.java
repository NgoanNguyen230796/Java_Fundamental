package ra.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Book {
    //Các thuộc tính
    public String bookId;
    public String bookName;
    public float importPrice;
    public float exportPrice;
    public String author;

    public float interest;
    public int year;

    //Các constructors


    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    // Method -Các phương thức


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

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //Phương thức nhập dữ liệu sách có validate dữ liệu đầu vào
    public void inputData(Scanner sc, Book[] arrBook, int index) {
        System.out.print("Nhập vào mã sách= ");
        do {
            this.bookId = sc.nextLine();
            //Trong  mảng đã có phần tử
            if (index != 0) {
                boolean isCheckBookId = false;
                for (int i = 0; i < index; i++) {
                    if (arrBook[i].bookId.equals(this.bookId)) {
                        isCheckBookId = true;
                        break;
                    }
                }
                if (!isCheckBookId) {
                    break;
                } else {
                    System.err.println("Mã sách đã tồn tại, vui lòng nhập lại");
                }
            }
            //Trong mảng chưa có phần tử nào cả
            else {
                break;
            }
        } while (true);

        System.out.print("Nhập vào tên sách = ");
        String bookNameRegex = "^[B][a-z0-9_-]{3}$";

        do {
            this.bookName = sc.nextLine();
            //Trong mảng chưa có phần tử nào cả
            if (index == 0) {
                //Check xem có phần tử nào có tên k theo regexName hay k
                if (!Pattern.matches(bookNameRegex, this.bookName)) {
                    System.err.println("Tên sách phải gồm 4 ký tự, bắt đầu là ký tự B ,vui lòng nhập lại");
                } else {
                    break;
                }
            }
            // //Trong  mảng đã có phần tử
            else {
                // //Check xem có phần tử nào có tên k theo regexName hay k
                if (!Pattern.matches(bookNameRegex, this.bookName)) {
                    System.err.println("Tên sách phải gồm 4 ký tự, bắt đầu là ký tự B ,vui lòng nhập lại");
                }
                //Check xem có phần tử nào bị trùng tên trong mảng hay k
                else {
                    boolean isCheckBookName = false;
                    for (int i = 0; i < index; i++) {
                        if (arrBook[i].bookName.equalsIgnoreCase(this.bookName)) {
                            isCheckBookName = true;
                            break;
                        }
                    }
                    if (!isCheckBookName) {
                        break;
                    } else {
                        System.err.println("Tên sách đã tồn tại, vui lòng nhập lại");
                    }
                }
            }
        } while (true);
        System.out.print("Nhập vào giá nhập sách = ");
        do {
            this.importPrice = Float.parseFloat(sc.nextLine());
            if (this.importPrice <= 0) {
                System.err.println("Vui lòng nhập giá nhập sách có giá trị lớn hơn 0");
            } else {
                break;
            }
        } while (true);

        System.out.print("Nhập vào giá xuất sách = ");
        do {
            this.exportPrice = Float.parseFloat(sc.nextLine());
            if (this.exportPrice <= (1.3 * this.importPrice)) {
                System.err.println("Vui lòng nhập giá xuất sách, có giá trị lớn hơn ít nhất 30% so với giá nhập");
            } else {
                break;
            }

        } while (true);

        System.out.print("Nhập vào tên tác giả sách =");
        String regexAuthor = "^(?=.{6,50}$)[A-Za-zÀ-ỹ][A-Za-zÀ-ỹ ]*$";
        do{
            this.author = sc.nextLine();
            if (!Pattern.matches(regexAuthor, this.author)) {
                System.err.println("Vui lòng nhập tên tác giả, có từ 6-50 ký tự");
            } else {
                break;
            }

        } while (true);
        System.out.print("Nhập vào năm xuất bản sách =");
        final int YEARBOOK = 2000;
        do {
            this.year = Integer.parseInt(sc.nextLine());
            if (this.year < YEARBOOK) {
                System.err.println("Vui lòng nhập năm xuất bản sách, ít nhất xuất bản sau năm 2000");
            } else {
                break;
            }
        } while (true);
    }

    //Lợi nhuận sách tính theo công thức
    //interest = exportPrice – importPrice
    public void interestCalculate() {
        this.interest = (this.exportPrice - this.importPrice);
    }

    //Hiển thị dữ liệu sách
    public void displayData() {
        System.out.printf("%-15s%-15s%-25f%-25f%-20s%-20f%-20d\n",this.bookId,this.bookName,this.importPrice,this.exportPrice,this.author,this.interest,this.year);
    }



}
