import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private float htmlScore;
    private float cssScore;
    private float javascriptScore;
    private float avgScore;

    //Phương thức Contstructor
    //default constructor
    public Student() {
    }

    //constructor khởi tạo tất cả thông tin sinh viên
    public Student(String studentId, String studentName, int age, boolean sex, float htmlScore, float cssScore, float javascriptScore, float avgScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.htmlScore = htmlScore;
        this.cssScore = cssScore;
        this.javascriptScore = javascriptScore;
        this.avgScore = avgScore;
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public float getHtmlScore() {
        return htmlScore;
    }

    public float getCssScore() {
        return cssScore;
    }

    public float getJavascriptScore() {
        return javascriptScore;
    }

//    public float getAvgScore() {
//        return avgScore;
//    }

//    public void setAvgScore(float avgScore) {
//        this.avgScore = avgScore;
//    }

    public String getSex(){
        if (this.sex){
            return "Nữ";
        }else{
            return "Nam";
        }
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    //Phương thức inputData(): cho phép nhập tất cả thông tin sinh viên từ bàn phím (Trừ avgScore)
    public void inputData(Scanner sc) {
        System.out.print("Nhập vào mã sinh viên =");
        this.studentId = sc.nextLine();
        System.out.print("Nhập vào tên sinh viên =");
        this.studentName = sc.nextLine();
        System.out.print("Nhập vào tuổi sinh viên =");
        this.age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập vào giới tính sinh viên =");
        this.sex = Boolean.parseBoolean(sc.nextLine());
        System.out.print("Nhập vào điểm HTML sinh viên =");
        this.htmlScore = Float.parseFloat(sc.nextLine());
        System.out.print("Nhập vào điểm CSS sinh viên =");
        this.cssScore = Float.parseFloat(sc.nextLine());
        System.out.print("Nhập vào điểm Javascript sinh viên =");
        this.javascriptScore = Float.parseFloat(sc.nextLine());
    }

    //Phương thức displayData(): cho phép hiển thị tất cả thông tin sinh viên ra màn hình consol
    public void displayData() {
        System.out.printf("Mã sinh viên : %s - Tên sinh viên: %s - Tuổi sinh viên: %d - Giới tính: %s \n", this.studentId, this.studentName, this.age,getSex());
        System.out.printf("Điểm HTML:%.1f - Điểm CSS :%.1f - Điểm Javascript:%.1f\n", this.htmlScore, this.cssScore, this.javascriptScore);
        System.out.printf("Điểm trung bình là : %.2f\n",getAvgScore());
    }

    //Phương thức calAvgScore(): cho phép tính điểm trung bình của sinh viên (kết quả lưu vào thuộc tính avgScore)
    public void calAvgScore() {
        this.avgScore = (this.htmlScore + this.cssScore + this.javascriptScore) / 3;
    }

    public float getAvgScore() {
        return avgScore;
    }

}
