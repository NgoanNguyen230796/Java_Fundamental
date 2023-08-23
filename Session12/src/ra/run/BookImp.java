package ra.run;

import ra.entity.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookImp {
    static Scanner sc = new Scanner(System.in);
    static List<Book> listBook = new ArrayList<>();

    public static void main(String[] args) {
        do {
            System.out.println("**********************Menu**********************");
            System.out.println("1. Nhập thông tin các sách");
            System.out.println("2. In thông tin các sách ra file demo.txt");
            System.out.println("3. Đọc file demo.txt và in ra các sách có giá trong khoảng 10000 đến 20000");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn là :");
            do {
                try {
                    int choice = Integer.parseInt(sc.nextLine());
                    if (choice > 0) {
                        switch (choice) {
                            case 1:
                                BookImp.inpuDataBook();
                                System.out.println("Đã nhập xong thông tin của sách");
                                break;
                            case 2:
                                BookImp.writeDataToFile(listBook);
                                break;
                            case 3:
                               BookImp.displayDataBook();
                                break;
                            case 4:
                                System.exit(0);
                            default:
                                System.err.println("Vui lòng nhập lựa chọn của bạn từ 1-4");
                        }
                        break;
                    } else {
                        System.err.println("Lựa chọn phải là số nguyên lớn hơn 0,vui lòng nhập lại");
                    }

                } catch (NumberFormatException ex) {
                    System.err.println("Lựa chọn phải là số,vui lòng nhập lại");
                }
            } while (true);
        } while (true);
    }

    public static void inpuDataBook() {
        System.out.println("Nhập vào số lượng sách bạn muốn thêm vào :");
        do {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number > 0) {
                    for (int i = 0; i < number; i++) {
                        System.out.println("Nhập vào thông tin sách thứ " + (i + 1) + " là :");
                        Book book1 = new Book();
                        book1.inputData(sc, listBook);
                        listBook.add(book1);
                    }
                    break;
                } else {
                    System.out.println("Số lượng sách muốn nhập phải là số nguyên lớn hơn 0,vui lòng nhập lại");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Số lượng sách muốn nhập phải là số,vui lòng nhập lại");
            }


        } while (true);

    }

    public static void writeDataToFile(List<Book> listBook) {
        //1. Khởi tạo đối tượng file để làm việc với file - tương đối
        File file = new File("demo.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            //2. Khởi tạo đối tượng FileOutputStream từ file - Checked Excetion
            fos = new FileOutputStream(file);
            //3. Khởi tạo đối tượng ObjectOutputStream từ fos
            oos = new ObjectOutputStream(fos);
            //4. Sử dụng writeObject để ghi object ra file
            oos.writeObject(listBook);
            //5. Đẩy dữ liệu từ Stream xuống file
            oos.flush();

        } catch (FileNotFoundException ex1) {
            System.err.println("File không tồn tại");
        } catch (IOException ex2) {
            System.err.println("Lỗi khi ghi dữ liệu ra file");
        } catch (Exception ex) {
            System.err.println("Xảy ra lỗi trong quá trình ghi dữ liệu ra file");
        } finally {
            //6. Đóng các stream
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex1) {
                System.err.println("Xảy ra lỗi khi đóng các stream");
            } catch (Exception ex) {
                System.err.println("Xảy ra lỗi trong quá trình đóng các stream");
            }
        }
    }

    public static List<Book> readDataFromFile() {
        //1. Khởi tạo đối tượng File
        File file = new File("demo.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Book> listBookRead = null;
        try {
            //2. Khởi tạo đối tượng FileInputStream
            fis = new FileInputStream(file);
            //3. Khởi tạo đối tượng ObjectInputStream
            ois = new ObjectInputStream(fis);
            //4. Đọc dữ liệu object từ file (readObject())
            listBookRead = (List<Book>) ois.readObject();
        } catch (FileNotFoundException ex1) {
            System.err.println("Không tồn tại file");
        } catch (IOException ex2) {
            System.err.println("Lỗi khi đọc file");
        } catch (Exception ex) {
            System.err.println("Có lỗi trong quá trình đọc dữ liệu từ file");
        } finally {
            //6. Đóng các stream
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex1) {
                System.err.println("Có lỗi khi đóng stream");
            } catch (Exception ex) {
                System.err.println("Có lỗi trong quá trình đóng các stream");
            }
            return listBookRead;
        }
    }

    public static void displayDataBook(){
        List<Book> listBookRead=BookImp.readDataFromFile();
        System.out.println("In ra các sách có giá trong khoảng 10000 đến 20000 là :");
        System.out.printf("%-30s%-30s%-30s\n","Mã sách","Tên sách","Giá sách");
        for (Book book : listBookRead) {
            if(book.getPrice()>10000 && book.getPrice()<20000){
                book.displayData();
                System.out.println("------------------------------------------------------------------");
            }

        }
    }
}
