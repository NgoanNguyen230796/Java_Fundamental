package ra.run;

import ra.entity.Book;

import java.util.Scanner;

public class BookImp {
    public static void main(String[] args) {
        Book[] arrBook = new Book[100];
        Scanner sc = new Scanner(System.in);
        //Khởi tạo biến index của mảng arrBook để quản lý xem đang có bao nhiêu sách
        int index = 0;
        do {
            System.out.println("****************MENU*****************");
            System.out.println("1. Nhập thông tin n sách (n nhập từ bàn phím)");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách (tên sách nhập từ bàn phím)");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập số sách cần nhập dữ liệu: ");
                    int n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        //Khởi tạo đối tượng phần tử thứ index cần nhập thông tin
                        //null
                        arrBook[index] = new Book();
                        System.out.println("Nhập vào sách thứ " + (index + 1) + " là :");
                        //Nhập thông tin cho sinh viên student
                        arrBook[index].inputData(sc, arrBook, index);
                        index++;
                    }
                    break;
                case 2:
                    // Tính lợi nhuận sách
                    for (int i = 0; i < index; i++) {
                        arrBook[i].interestCalculate();
                    }
                    System.out.println("Đã tính xong lợi nhuận của sách");
                    break;
                case 3:
                    //Hiển thị thông tin sách
                    System.out.printf("%-15s%-15s%-25s%-25s%-20s%-20s%-20s\n", "Mã sách", "Tên sách", "Giá nhập", "Giá xuất", "Tác giả", "Lợi nhuận sách", "Năm xuất bản");
                    for (int i = 0; i < index; i++) {
                        arrBook[i].displayData();
                    }
                    break;
                case 4:
                    //Sắp xếp sách theo giá bán tăng dần
                    for (int i = 0; i < index - 1; i++) {
                        for (int j = i + 1; j < index; j++) {
                            if (arrBook[i].getExportPrice() > arrBook[j].getExportPrice()) {
                                //Đổi chỗ 2 phần tử
                                Book temp = arrBook[i];
                                arrBook[i] = arrBook[j];
                                arrBook[j] = temp;
                            }
                        }
                    }
                    System.out.println("Sắp xếp sách theo giá bán tăng dần là :");
                    System.out.printf("%-15s%-15s%-25s%-25s%-20s%-20s%-20s\n", "Mã sách", "Tên sách", "Giá nhập", "Giá xuất", "Tác giả", "Lợi nhuận sách", "Năm xuất bản");
                    for (int i = 0; i < index; i++) {
                        arrBook[i].displayData();
                    }
                    break;
                case 5:
                    //Sắp xếp sách theo lợi nhuận giảm dần

                    for (int i = 0; i < index - 1; i++) {
                        for (int j = i + 1; j < index; j++) {
                            if (arrBook[i].getInterest() < arrBook[j].getInterest()) {
                                Book temp = arrBook[i];
                                arrBook[i] = arrBook[j];
                                arrBook[j] = temp;
                            }
                        }
                    }
                    System.out.println("Sắp xếp sách theo lợi nhuận giảm dần là :");
                    System.out.printf("%-15s%-15s%-25s%-25s%-20s%-20s%-20s\n", "Mã sách", "Tên sách", "Giá nhập", "Giá xuất", "Tác giả", "Lợi nhuận sách", "Năm xuất bản");
                    for (int i = 0; i < index; i++) {
                        arrBook[i].displayData();
                    }
                    break;
                case 6:
                    System.out.print("Vui lòng nhập tên sách mà bạn muốn tìm =");
                    String findBookName = sc.nextLine();
                    boolean isCheckBookName = false;
                    for (int i = 0; i < index; i++) {
                        if (arrBook[i].getBookName().toLowerCase().contains(findBookName.toLowerCase())) {
                            System.out.println("Tên sách mà bạn muốn tìm là =");
                            arrBook[i].displayData();
                            isCheckBookName = true;
                        }
                    }
                    if (!isCheckBookName) {
                        System.out.println("K tìm thấy sách mà bạn muốn tìm");
                    }
                case 7:
                    //7. Thống kê số lượng sách theo năm xuất bản
                    int[] yearArr = new int[index];
                    int arrIndex = 0;
                    for (int i = 0; i < index; i++) {
                        //Kiểm tra  xem có bị trùng hay không, nếu trùng không lưu, ngược thì lưu
                        boolean isCheckYear = false;
                        for (int j = i + 1; j < index; j++) {
                            if (arrBook[i].getYear() == arrBook[j].getYear()) {
                                isCheckYear = true;
                                break;
                            }
                        }
                        //Không trùng --> lưu vào mảng yearArr
                        if (!isCheckYear) {
                            yearArr[arrIndex] = arrBook[i].getYear();
                            arrIndex++;
                        }
                    }
                    //Khai báo mảng chứa số lần xuất hiện của từng năm
                    int[] arrCountYear = new int[arrIndex];
                    for (int i = 0; i < arrIndex; i++) {
                        int indexCountAuthor = 0;
                        for (int j = 0; j < index; j++) {
                            if (yearArr[i] == arrBook[j].getYear()) {
                                indexCountAuthor++;
                            }
                            arrCountYear[i] = indexCountAuthor;
                        }
                    }
                    // Display statistic info
                    for (int i = 0; i < arrIndex; i++) {
                        System.out.printf("Năm %d có số lượng sách là %d\n", yearArr[i], arrCountYear[i]);
                    }
                    break;

                case 8:
                    //8. Thống kê số lượng sách theo tác giả
                    String[] arrAuthor = new String[index];
                    int arrAuthorIndex = 0;
                    for (int i = 0; i < index; i++) {
                        //Kiểm tra  xem có bị trùng hay không, nếu trùng không lưu, ngược thì lưu
                        boolean isCheckAuthor = false;
                        for (int j = i + 1; j < index; j++) {
                            if (arrBook[i].getAuthor().toLowerCase().contains(arrBook[j].getAuthor())) {
                                isCheckAuthor = true;
                                break;
                            }
                        }
                        //Không trùng --> lưu vào mảng yearArr
                        if (!isCheckAuthor) {
                            arrAuthor[arrAuthorIndex] = arrBook[i].getAuthor();
                            arrAuthorIndex++;
                        }
                    }
                    //Khai báo mảng chứa số lần xuất hiện của từng tác giả
                    int[] arrCountAuthor = new int[index];
                    for (int i = 0; i < index; i++) {
                        int indexCountAuthor = 0;
                        for (int j = 0; j < index; j++) {
                            if (arrAuthor[i].contains(arrBook[j].getAuthor())) {
                                indexCountAuthor++;
                            }
                            arrCountAuthor[i] = indexCountAuthor;
                        }
                    }
                    // Display statistic info
                    for (int i = 0; i < index; i++) {
                        System.out.printf("Tác giả %s có số lượng sách là %d\n", arrAuthor[i], arrCountAuthor[i]);
                    }
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-9");
            }
        } while (true);


    }
}
