package ra.run;

import ra.impl.Student;

import java.util.*;


public class StudentManagement {
    static List<Student> listStudent = new ArrayList<>();
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
                    StudentManagement.inputDataStudent();
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

    public static void inputDataStudent() {
        System.out.print("Nhập vào số sinh viên cần nhập thông tin:");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Student st = new Student();
            System.out.println("Nhập vào sinh viên thứ " + (i + 1) + " là :");
            st.inputData(sc, listStudent);
            listStudent.add(st);
        }
    }

    //2. Tính điểm trung bình tất cả sinh viên
    public static void averageOfSubject() {
        for (Student st : listStudent) {
            st.calAvgMark();
        }
        System.out.println("Đã tính điểm trung bình của sinh viên xong");
    }

    //    3. Đánh giá xếp loại các sinh viên
    public static void classificationOfStudent() {
        for (Student st : listStudent) {
            st.avgMarkClassification();
        }
        System.out.println("Đã đánh giá xếp loại các sinh viên xong");
    }

    //4. Tính trạng thái của sinh viên
    public static void statusOfStudent() {
        for (Student st : listStudent) {
            st.statusStudent();
        }
        System.out.println("Đã tính trạng thái của sinh viên xong");
    }


    //5.Hiển thị thông tin sinh viên
    public static void studentDisplayData() {
        System.out.printf("%-15s%-15s%-10s%-15s%-15s%-20s%-25s%-20s%-20s%-20s\n", "Tên sinh viên", "Mã sinh viên", "Tuổi", "Điểm html", "Điểm css", "Điểm javascript", "Điểm trung bình", "Giới tính", "Xếp loại", "Trạng thái");
        for (Student st : listStudent) {
            st.displayData();
        }
    }

    //6.Sắp xếp sinh viên tăng dần theo điểm trung bình
    public static void sortAscendingOfAverage() {
        listStudent.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int)(o1.getAvgMark()-o2.getAvgMark());
            }
        });
        System.out.println("Mảng sau khi sắp xếp sinh viên tăng dần theo điểm trung bình là :");
        System.out.printf("%-15s%-15s%-10s%-15s%-15s%-20s%-25s%-20s%-20s%-20s\n", "Tên sinh viên", "Mã sinh viên", "Tuổi", "Điểm html", "Điểm css", "Điểm javascript", "Điểm trung bình", "Giới tính", "Xếp loại", "Trạng thái");
        for (Student st : listStudent) {
            st.displayData();
        }
    }

    //7. Tìm kiếm sinh viên theo tên sinh viên
    public static void searchOfStudentName() {
        System.out.print("Nhập vào tên sinh viên bạn muốn tìm kiếm =");
        String findStudentName = sc.nextLine();
        boolean isCheckName = false;
        for (Student st : listStudent) {
            if (st.getStudentName().contains(findStudentName)) {
                System.out.println("Thông tin sinh viên mà bạn muốn tìm là :");
                System.out.printf("%-15s%-15s%-10s%-15s%-15s%-20s%-25s%-20s%-20s%-20s\n", "Tên sinh viên", "Mã sinh viên", "Tuổi", "Điểm html", "Điểm css", "Điểm javascript", "Điểm trung bình", "Giới tính", "Xếp loại", "Trạng thái");
                st.displayData();
                isCheckName = true;
            }
        }
        if (!isCheckName) {
            System.out.println("Không tìm thấy sinh viên theo tên mà bạn vừa nhập");
        }
    }

    //    //8.Thống kê sinh viên theo xếp loại
    public static void statisticalClassificationOfStudent() {
        int cntYeu = 0, cntTB = 0, cntKha = 0, cntGioi = 0, cntXuatSac = 0;
        for (Student st : listStudent) {
            switch (st.getClassification()) {
                case "Yếu":
                    cntYeu++;
                    break;
                case "Trung bình":
                    cntTB++;
                    break;
                case "Khá":
                    cntKha++;
                    break;
                case "Giỏi":
                    cntGioi++;
                    break;
                default:
                    cntXuatSac++;
            }
        }
        System.out.printf("Xuất sắc: %d - Giỏi: %d - Khá: %d - Trung bình: %d - Yếu: %d\n", cntXuatSac, cntGioi, cntKha, cntTB, cntYeu);
    }

    //9. Thống kê sinh viên theo trạng thái
    public static void statisticalStatus() {
        int cntFail = 0, cntPass = 0;
        for (Student st : listStudent) {
            if (st.getStatus().equals("PASS")) {
                cntPass++;
            } else {
                cntFail++;
            }
        }
        System.out.printf("PASS: %d - FAIL: %d\n", cntPass, cntFail);
    }
}
