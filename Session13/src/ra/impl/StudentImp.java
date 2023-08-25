package ra.impl;

import ra.StudentFile.StudentFileWriteAndRead;
import ra.entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentImp {
    public static Scanner sc = new Scanner(System.in);
    public static List<Student> listStudent = new ArrayList<>();

    public static void main(String[] args) {
        //Đọc dữ liệu từ file listStudent.txt
        StudentFileWriteAndRead.readDataFromFile();
        do {
            System.out.println("*****************************MENU************************");
            System.out.println("1. Nhập thông tin các sinh viên");
            System.out.println("2. Tính tuổi các sinh viên");
            System.out.println("3. Tính điểm trung bình và xếp loại sinh viên");
            System.out.println("4. Sắp xếp sinh viên theo tuổi tăng dần");
            System.out.println("5. Thống kê sinh viên theo xếp loại sinh viên");
            System.out.println("6. Cập nhật thông tin sinh viên theo mã sinh viên");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8.  Hiển thị thông tin sinh viên");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn của bạn là =");
            int choiceMain = validateChoiceMain();
            switch (choiceMain) {
                case 1:
                    StudentImp.inputDataStudent();
                    break;
                case 2:
                    StudentImp.age();
                    break;
                case 3:
                    StudentImp.averageOfSubject();
                    break;
                case 4:
                    StudentImp.sortAscendingOfAge();
                    break;
                case 5:
                    StudentImp.statisticalClassificationOfStudent();
                    break;
                case 6:
                    StudentImp.displayData();
                    StudentImp.updateStudentByStudentId();
                    break;
                case 7:
                    StudentImp.displayData();
                    StudentImp.searchStudentByStudentName();
                    break;
                case 8:
                    StudentImp.displayData();
                    break;
                case 9:
                    StudentFileWriteAndRead.writeDataToFile(listStudent);
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập lựa chọn của bạn từ 1-8");
            }



        } while (true);
    }

    public static int validateChoiceMain() {
        int choiceMain;
        while (true) {
            try {
                choiceMain = Integer.parseInt(sc.nextLine());
                if (choiceMain > 0) {
                    break;
                } else {
                    System.err.println("Lựa chọn của bạn phải là số nguyên lớn hơn 0,vui lòng nhập lại");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Lựa chọn của bạn phải là số,vui lòng nhập lại");
            }
        }
        return choiceMain;
    }

    public static void inputDataStudent() {
        System.out.print("Nhập số lượng sinh viên mà bạn muốn thêm :");
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number > 0) {
                    for (int i = 0; i < number; i++) {
                        System.out.println("Nhập vào sinh viên thứ " + (i + 1) + ":");
                        Student st = new Student();
                        st.inputData(sc, listStudent);
                        listStudent.add(st);
                    }
                    System.out.println("Đã thêm mới thông tin sinh viên xong");
                    break;
                } else {
                    System.err.println("Số lượng sinh viên mà bạn muốn thêm phải là số nguyên lớn hơn 0,vui lòng nhập lại");
                }

            } catch (NumberFormatException ex) {
                System.err.println("Số lượng sinh viên mà bạn muốn thêm phải là số,vui lòng nhập lại");
            }
        }
    }
    public static void age() {
        for (Student st : listStudent) {
            st.calAge();
        }
        System.out.println("Đã tính xong tuổi của sinh viên xong");
    }

    public static void averageOfSubject() {
        for (Student st : listStudent) {
            st.calAvgMark_Rank();
        }
        System.out.println("Đã tính điểm trung bình và xếp loại sinh viên của sinh viên xong");
    }

    public static void displayData(){
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.printf("%-15s%-30s%-10s%-15s%-15s%-20s%-25s%-20s%-20s\n","Mã sinh viên", "Tên sinh viên" , "Tuổi", "Điểm html", "Điểm css", "Điểm javascript", "Điểm trung bình", "Giới tính", "Xếp loại");
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        for (Student st:listStudent) {
            st.displayData();
        }

    }


    //4. Sắp xếp sinh viên theo tuổi tăng dần
    public static void sortAscendingOfAge() {
        listStudent.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int)(o1.getAge()-o2.getAge());
            }
        });
        System.out.println("Sắp xếp sinh viên theo tuổi tăng dần là :");
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.printf("%-15s%-30s%-10s%-15s%-15s%-20s%-25s%-20s%-20s\n","Mã sinh viên", "Tên sinh viên" , "Tuổi", "Điểm html", "Điểm css", "Điểm javascript", "Điểm trung bình", "Giới tính", "Xếp loại");
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        for (Student st : listStudent) {
            st.displayData();
        }
    }
    //5. Thống kê sinh viên theo xếp loại sinh viên
    public static void statisticalClassificationOfStudent() {
        int cntYeu = 0, cntTB = 0, cntKha = 0, cntGioi = 0, cntXuatSac = 0;
        for (Student st : listStudent) {
            switch (st.getRank()) {
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
        System.out.println("Thống kê sinh viên theo xếp loại sinh viên là :");
        System.out.printf("%-30s%-30s\n","Xếp loại","Số lượng");
        System.out.printf("%-30s%-30d\n","Xuất sắc",cntXuatSac);
        System.out.printf("%-30s%-30d\n","Giỏi",cntGioi);
        System.out.printf("%-30s%-30d\n","Khá",cntKha);
        System.out.printf("%-30s%-30d\n","Trung bình",cntTB);
        System.out.printf("%-30s%-30d\n","Yếu",cntYeu);
    }
    //6. Cập nhật thông tin sinh viên theo mã sinh viên
    public static void updateStudentByStudentId(){
        System.out.println("Nhập vào mã sinh viên mà bạn muốn cập nhật lại thông tin");
        String inputStudentId=sc.nextLine();
        int isCheckIndex=findStudentByStudentId(inputStudentId);
        if(isCheckIndex>=0){
            listStudent.get(isCheckIndex).setStudentName(Student.inputStudentName());
            listStudent.get(isCheckIndex).setBirthday(Student.inputStudentBirthday());
            listStudent.get(isCheckIndex).setSex(Student.inputStudentSex());
            listStudent.get(isCheckIndex).setMark_html(Student.inputHtmlScore());
            listStudent.get(isCheckIndex).setMark_css(Student.inputCssScore());
            listStudent.get(isCheckIndex).setMark_javascript(Student.inputJavascriptScore());
            listStudent.get(isCheckIndex).calAge();
            listStudent.get(isCheckIndex).calAvgMark_Rank();
            System.out.println("Đã cập nhập xong thông tin sinh viên với mã sinh viên là "+inputStudentId);
        }else{
            System.out.println("Không tìm thấy thông tin sinh viên theo mã sinh viên "+inputStudentId+" mà bạn vừa nhập");
        }

    }

    public static int findStudentByStudentId(String studentIdCheck){
        for (int i = 0; i <listStudent.size() ; i++) {
            if(listStudent.get(i).getStudentId().equals(studentIdCheck)){
                return i;
            }
        }
        return -1;
    }

    public static void searchStudentByStudentName(){
        System.out.println("Nhập vào tên sinh viên cần tìm: ");
        String studentName = sc.nextLine();
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.printf("%-15s%-15s%-10s%-15s%-15s%-20s%-25s%-20s%-20s\n","Mã sinh viên", "Tên sinh viên" , "Tuổi", "Điểm html", "Điểm css", "Điểm javascript", "Điểm trung bình", "Giới tính", "Xếp loại");
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        for (Student st:listStudent) {
            if(st.getStudentName().toLowerCase().contains(studentName.toLowerCase())){
                st.displayData();
            }else{
                System.out.println("Không tìm thấy sinh viên với tên "+studentName+" mà bạn vừa nhập");
            }
        }
    }


}

