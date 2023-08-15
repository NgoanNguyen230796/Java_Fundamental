package ra.run;

import java.util.Scanner;

import ra.impl.Student;

public class StudentManagement {
    static Student[] arrStudent = new Student[100];//Toàn cục

    static int index = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập thông tin n sinh viên (n nhập từ bàn phím)");
            System.out.println("2. Tính điểm trung bình tất cả sinh viên");
            System.out.println("3. Đánh giá xếp loại các sinh viên");
            System.out.println("4. Tính trạng thái của sinh viên");
            System.out.println("5. In thông tin các sinh viên");
            System.out.println("6. Sắp xếp sinh viên tăng dần theo điểm trung bình");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8. Thống kê sinh viên theo xếp loại");
            System.out.println("9. Thống kê sinh viên theo trạng thái");
            System.out.println("10. Thoát");
            System.out.print("Sự lựa chọn của bạn:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.inputDataStudent(sc);
//                    StudentManagement.inputDataStudent(sc);
                    break;
                case 2:
//                    2. Tính điểm trung bình tất cả sinh viên
                    StudentManagement.averageOfSubject();
                    break;
                case 3:
                    StudentManagement.classificationOfStudent();
                    break;
                case 4:
                    StudentManagement.statusOfStudent();
                    break;
                case 5:
                    StudentManagement.studentDisplayData();
                    break;
                case 6:
                    StudentManagement.sortAscendingOfAverage();
                    break;
                case 7:
                    StudentManagement.searchOfStudentName();
                    break;
                case 8:
                    StudentManagement.statisticalClassificationOfStudent();
                    break;
                case 9:
                    StudentManagement.statisticalStatus();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-10");
            }
        } while (true);

    }

    public static void inputDataStudent(Scanner sc) {
        System.out.print("Nhập vào số sinh viên cần nhập thông tin:");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            arrStudent[index] = new Student();
            System.out.println("Nhập vào sinh viên thứ " + (index + 1) + " là :");
            arrStudent[index].inputData(sc, arrStudent, index);
            index++;
        }
    }

    //2. Tính điểm trung bình tất cả sinh viên
    public static void averageOfSubject() {
        for (int i = 0; i < index; i++) {
            arrStudent[i].calAvgMark();
        }
        System.out.println("Đã tính điểm trung bình của sinh viên xong");
    }

    //    3. Đánh giá xếp loại các sinh viên
    public static void classificationOfStudent() {
        for (int i = 0; i < index; i++) {
            arrStudent[i].avgMarkClassification();
        }
        System.out.println("Đã đánh giá xếp loại các sinh viên xong");
    }

    //4. Tính trạng thái của sinh viên
    public static void statusOfStudent() {
        for (int i = 0; i < index; i++) {
            arrStudent[i].statusStudent();
        }
        System.out.println("Đã tính trạng thái của sinh viên xong");
    }

    //5.Hiển thị thông tin sinh viên
    public static void studentDisplayData() {
        System.out.printf("%-15s%-15s%-10s%-15s%-15s%-20s%-25s%-20s%-20s%-20s\n", "Tên sinh viên", "Mã sinh viên", "Tuổi", "Điểm html", "Điểm css", "Điểm javascript", "Điểm trung bình", "Giới tính", "Xếp loại", "Trạng thái");
        for (int i = 0; i < index; i++) {
            arrStudent[i].displayData();
        }
    }

    //6.Sắp xếp sinh viên tăng dần theo điểm trung bình
    public static void sortAscendingOfAverage() {
        for (int i = 0; i < index - 1; i++) {
            for (int j = i + 1; j < index; j++) {
                if (arrStudent[i].avgMark > arrStudent[j].avgMark) {
                    Student temp = arrStudent[i];
                    arrStudent[i] = arrStudent[j];
                    arrStudent[j] = temp;
                }
            }
        }
        System.out.println("Mảng sau khi sắp xếp sinh viên tăng dần theo điểm trung bình là :");
        System.out.printf("%-15s%-15s%-10s%-15s%-15s%-20s%-25s%-20s%-20s%-20s\n", "Tên sinh viên", "Mã sinh viên", "Tuổi", "Điểm html", "Điểm css", "Điểm javascript", "Điểm trung bình", "Giới tính", "Xếp loại", "Trạng thái");
        for (int i = 0; i < index; i++) {
            arrStudent[i].displayData();
        }
    }

    //7. Tìm kiếm sinh viên theo tên sinh viên
    public static void searchOfStudentName() {
        System.out.print("Nhập vào tên sinh viên bạn muốn tìm kiếm =");
        String findStudentName = sc.nextLine();
        boolean isCheckName = false;
        for (int i = 0; i < index; i++) {
            if (arrStudent[i].studentName.contains(findStudentName)) {
                System.out.println("Thông tin sinh viên mà bạn muốn tìm là :");
                System.out.printf("%-15s%-15s%-10s%-15s%-15s%-20s%-25s%-20s%-20s%-20s\n", "Tên sinh viên", "Mã sinh viên", "Tuổi", "Điểm html", "Điểm css", "Điểm javascript", "Điểm trung bình", "Giới tính", "Xếp loại", "Trạng thái");
                arrStudent[i].displayData();
                isCheckName = true;
            }
        }
        if (!isCheckName) {
            System.out.println("Không tìm thấy sinh viên theo tên mà bạn vừa nhập");
        }
    }

    //8.Thống kê sinh viên theo xếp loại
    public static void statisticalClassificationOfStudent() {
        String[] arrClassification = new String[index];
        int classificationCount = 0;
        for (int i = 0; i < index; i++) {
            boolean isCheck = false;
            for (int j = i + 1; j < index; j++) {
                if (arrStudent[i].getClassification().contains(arrStudent[j].getClassification())) {
                    isCheck = true;
                    break;
                }
            }
            if (!isCheck) {
                arrClassification[classificationCount] = arrStudent[i].getClassification();
                classificationCount++;
            }
        }
        //Khai báo mảng chứa số lần xuất hiện xếp loại sinh viên giống nhau
        int[] arrClassificationCount = new int[index];
        for (int i = 0; i < classificationCount; i++) {
            int indexCount = 0;
            for (int j = 0; j < index; j++) {
                if (arrClassification[i].contains(arrStudent[j].getClassification())) {
                    indexCount++;
                }
                arrClassificationCount[i] = indexCount;
            }

        }

        for (int i = 0; i < classificationCount; i++) {
            System.out.printf("Xếp loại %s có %d sinh viên\n", arrClassification[i], arrClassificationCount[i]);
        }

    }

    //9. Thống kê sinh viên theo trạng thái
    public static void statisticalStatus() {
        //Tạo 1 mảng chứa status k trùng nhau
        String[] arrStatus = new String[index];
        int statusIndex = 0;
        for (int i = 0; i < index; i++) {
            boolean isCheckStatus = false;
            for (int j = i + 1; j < index; j++) {
                if (arrStudent[i].getStatus().contains(arrStudent[j].getStatus())) {
                    isCheckStatus = true;
                    break;
                }

            }
            if (!isCheckStatus) {
                arrStatus[i] = arrStudent[i].getStatus();
                statusIndex++;
            }
        }

        //Khai báo mảng chứa số lần xuất hiện Status
        int[] arrStatusCount = new int[statusIndex];
        int statusCount = 0;
        for (int i = 0; i < statusIndex; i++) {
            for (int j = 0; j < index; j++) {
                if (arrStatus[i].contains(arrStudent[i].getStatus())) {
                    statusCount++;
                }
            }
            arrStatusCount[i] = statusCount;
        }
        for (int i = 0; i < statusIndex; i++) {
            System.out.printf("Trạng thái %s có %d sinh viên\n", arrStatus[i], arrStatusCount[i]);
        }
    }

}

