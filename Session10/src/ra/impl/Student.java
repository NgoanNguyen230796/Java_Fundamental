package ra.impl;

import ra.IStudent;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudent, Serializable {
    public String studentId;
    public String studentName;
    public int age;

    public float htmlScore;
    public float cssScore;
    public float javascriptScore;

    public boolean sex;
    public String classification;

    public String status;

    public float avgMark;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHtmlScore() {
        return htmlScore;
    }

    public void setHtmlScore(float htmlScore) {
        this.htmlScore = htmlScore;
    }

    public float getCssScore() {
        return cssScore;
    }

    public void setCssScore(float cssScore) {
        this.cssScore = cssScore;
    }

    public float getJavascriptScore() {
        return javascriptScore;
    }

    public void setJavascriptScore(float javascriptScore) {
        this.javascriptScore = javascriptScore;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    @Override
    public void inputData(Scanner sc, List<Student> listStudent) {
        System.out.print("Nhập vào mã sinh viên = ");
        do {
            this.studentId = sc.nextLine();
            boolean isCheckStudentId = false;
            for (Student str : listStudent) {
                if(str.studentId.equals(this.studentId)){
                    isCheckStudentId = true;
                    break;
                }
            }
            if (isCheckStudentId) {
                System.err.println("Mã sinh viên đã bị trùng, vui lòng nhập lại");
            } else {
                if (this.studentId.length() == 4 && this.studentId.startsWith("SV")) {
                    break;
                } else {
                    System.err.println("Mã sinh viên phải gồm 4 Ký tự bắt đầu là ký tự SV, vui lòng nhập lại");
                }
            }

        } while (true);
        //Tên sinh viên (String) – Gồm 6-50 ký tự
        System.out.print("Nhập vào tên sinh viên = ");
        do {
            this.studentName = sc.nextLine();
            boolean isCheckStudentName = false;
            if (this.studentName.length() >= 6 && this.studentName.length() <= 50) {
                break;
            } else {
                System.err.println("Tên sinh viên phải gồm 6-50 ký tự,vui lòng nhập lại");
            }
        } while (true);

        //Tuổi (int) – Có giá trị lớn hơn hoặc bằng 18
        System.out.print("Nhập vào tuổi sinh viên = ");
        do {
            this.age = Integer.parseInt(sc.nextLine());
            if (this.age >= 18) {
                break;
            } else {
                System.err.println("Tuổi sinh viên phải có giá trị lớn hơn hoặc bằng 18,vui lòng nhập lại");
            }
        } while (true);
        // Điểm html, css, javascript (float) – có giá trị trong khoảng 0- 10
        System.out.print("Nhập vào điểm HTML = ");
        do {
            this.htmlScore = Float.parseFloat(sc.nextLine());
            if (this.htmlScore >= 0 && this.htmlScore <= 10) {
                break;
            } else {
                System.err.println("Điểm html phải có giá trị trong khoảng 0- 10,vui lòng nhập lại");
            }
        } while (true);
        System.out.print("Nhập vào điểm CSS = ");
        do {
            this.cssScore = Float.parseFloat(sc.nextLine());
            if (this.cssScore >= 0 && this.cssScore <= 10) {
                break;
            } else {
                System.err.println("Điểm css phải có giá trị trong khoảng 0- 10,vui lòng nhập lại");
            }
        } while (true);
        System.out.print("Nhập vào điểm Javascript = ");
        do {
            this.javascriptScore = Float.parseFloat(sc.nextLine());
            if (this.javascriptScore >= 0 && this.javascriptScore <= 10) {
                break;
            } else {
                System.err.println("Điểm javascript phải có giá trị trong khoảng 0- 10,vui lòng nhập lại");
            }
        } while (true);
        System.out.print("Nhập vào giới tính sinh viên (true/false)= ");
        this.sex = Boolean.parseBoolean(sc.nextLine());
    }

    @Override
    public void displayData() {
        String studentSex = (this.sex) ? "Nữ" : "Nam";
        System.out.printf("%-15s%-15s%-10d%-17.2f%-15.2f%-20.2f%-25.2f%-20s%-20s%-20s\n", this.studentId,this.studentName,this.age,this.htmlScore,this.cssScore,this.javascriptScore,this.avgMark,studentSex,this.classification,this.status);
    }

    @Override
    public void calAvgMark() {
        this.avgMark = (this.htmlScore + this.cssScore + this.javascriptScore) / 3;
    }

    public void avgMarkClassification() {
        if (this.avgMark < 5) {
            this.classification = "Yếu";
        } else if (this.avgMark < 7) {
            this.classification = "Trung bình";
        } else if (this.avgMark < 8) {
            this.classification = "Khá";
        } else if (this.avgMark < 9) {
            this.classification = "Giỏi";
        } else {
            this.classification = "Xuất sắc";
        }
    }

//    Xây dựng phương thức tính trạng thái sinh viên : Nếu điểm trung bình
//>= MARK_PASS thì trạng thái là PASS ngược lại là FAIL

    public void statusStudent() {
        final int MARK_PASS = 5;
        if (this.avgMark >= MARK_PASS) {
            this.status = "PASS";
        } else {
            this.status = "FAIL";
        }
    }
}
