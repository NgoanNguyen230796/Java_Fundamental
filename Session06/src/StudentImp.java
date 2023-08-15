
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class StudentImp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] arrStudent = new Student[100];
        int count = 0;
        do {

            System.out.println("***********MENU***********");
            System.out.println("1. Nhập vào thông tin n sinh viên (n nhập từ bàn phím)");
            System.out.println("2. Tính điểm trung bình tất cả sinh viên");
            System.out.println("3. Hiển thị thông tin tất cả sinh viên");
            System.out.println("4. Sắp xếp sinh viên theo điểm trung bình giảm dần");
            System.out.println("5. Tìm kiếm sinh viên theo tên sinh viên (Tên sinh viên cần tìm nhập từ bàn phím)");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn là :");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập vào n (số lượng sinh viên tối đa là 100)=");
                    int n = Integer.parseInt(sc.nextLine());
                    if (n <= 100) {
                        for (int i = 0; i < n; i++) {
                            System.out.println("Nhập vào sinh viên thứ " + (i + 1));
//                            arrStudent[i] = new Student();
//                            arrStudent[i].inputData(sc);
                            arrStudent[count] = new Student();
                            arrStudent[count].inputData(sc);
                            arrStudent[count].calAvgScore();
                            count++;
                        }
                    } else {
                        System.out.println("Vui lòng nhập số lượng sinh viên nhỏ hơn hoặc bằng 100");
                    }
                    break;

                case 2:
                    if (count > 0) {
                        float totalAvgScore = 0;
                        for (int i = 0; i < count; i++) {
                            totalAvgScore += arrStudent[i].getAvgScore();
                        }
                        System.out.printf("Điểm trung bình của tất cả các sinh viên là :%.2f", totalAvgScore);
                        System.out.println("\n");
                    } else {
                        System.out.println("count nhỏ hơn 0");
                    }
                    break;

                case 3:
                    for (int i = 0; i < count; i++) {
                        System.out.println("Thông tin của sinh viên thứ " + (i + 1) + " là : ");
                        arrStudent[i].displayData();
                        System.out.println("\n");
                    }
                    break;
                case 4:
                    Student[] arrStudentNew = new Student[count];
//                   Đẩy toàn bộ dữ liệu trong arrStudent vào arrStudentNew
                    for (int k = 0; k <count ; k++) {
                        arrStudentNew[k] = arrStudent[k];
                    }
                    for (int i = 0; i < count - 1; i++) {
                        for (int j = i + 1; j < count; j++) {
                            if (arrStudentNew[i].getAvgScore() < arrStudentNew[j].getAvgScore()) {
                                Student temp = arrStudentNew[i];
                                arrStudentNew[i] = arrStudentNew[j];
                                arrStudentNew[j] = temp;
                            }
                        }
                    }
                    System.out.println("Sắp xếp sinh viên theo điểm trung bình giảm dần :");
                    for (int i = 0; i < count; i++) {
                        arrStudentNew[i].displayData();
                        System.out.println("\n");
                    }
                    break;
                case 5:
//                    Tìm kiếm sinh viên theo tên sinh viên (Tên sinh viên cần tìm nhập từ
//                    bàn phím)
                    System.out.print("Nhập vào tên sinh viên bạn cần tìm kiếm :");
                    String findStudentName = sc.nextLine();
                    boolean isCheck = true;
                    for (int i = 0; i < count; i++) {
//                        if (arrStudent[i].getStudentName().equalsIgnoreCase(findStudentName)) {
                            if (arrStudent[i].getStudentName().toLowerCase().contains(findStudentName)) {
                            arrStudent[i].displayData();
                            System.out.println("\n");
                            isCheck = false;
                        }
                    }
                    if (isCheck) {
                        System.out.println("K tìm thấy tên sinh viên mà bạn muốn tìm kiếm");
                    }

                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập lựa chọn của bạn từ 1-5");
            }


        } while (true);

    }


}