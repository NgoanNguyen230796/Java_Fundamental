package ra.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static ra.impl.StudentImp.listStudent;
import static ra.impl.StudentImp.sc;

public class Student implements IEntity<Student>, Serializable {
    private String studentId;
    private String studentName;

    private Date birthday;
    private int age;
    private boolean sex;
    private float mark_html;
    private float mark_css;
    private float mark_javascript;
    private float avgMark;
    private String rank;

    public Student() {
    }

    public Student(String studentId, String studentName, Date birthday, int age, boolean sex, float mark_html, float mark_css, float mark_javascript, float avgMark, String rank) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthday = birthday;
        this.age = age;
        this.sex = sex;
        this.mark_html = mark_html;
        this.mark_css = mark_css;
        this.mark_javascript = mark_javascript;
        this.avgMark = avgMark;
        this.rank = rank;
    }

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getMark_html() {
        return mark_html;
    }

    public void setMark_html(float mark_html) {
        this.mark_html = mark_html;
    }

    public float getMark_css() {
        return mark_css;
    }

    public void setMark_css(float mark_css) {
        this.mark_css = mark_css;
    }

    public float getMark_javascript() {
        return mark_javascript;
    }

    public void setMark_javascript(float mark_javascript) {
        this.mark_javascript = mark_javascript;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public void inputData(Scanner sc, List<Student> listStudent) {
        this.studentId = inputStudentId();
        this.studentName = inputStudentName();
        this.birthday = inputStudentBirthday();
        this.sex = inputStudentSex();
        this.mark_html=inputHtmlScore();
        this.mark_css=inputCssScore();
        this.mark_javascript=inputJavascriptScore();
    }

    @Override
    public void displayData() {
        //String studentId, String studentName, SimpleDateFormat ft, String birthday, int age, boolean sex, float mark_html, float mark_css, float mark_javascript, float avgMark
        String studentSex = (this.sex) ? "Nữ" : "Nam";
        System.out.printf("%-15s%-30s%-10d%-17.2f%-15.2f%-20.2f%-25.2f%-20s%-20s\n", this.studentId, this.studentName, this.age, this.mark_html, this.mark_css, this.mark_javascript, this.avgMark,studentSex,this.rank);
    }

    @Override
    public void calAge() {
        LocalDate localDate = LocalDate.now();
        SimpleDateFormat dYear=new SimpleDateFormat("yyyy");
        this.age=(localDate.getYear()-Integer.parseInt(dYear.format(this.birthday)));
    }

    @Override
    public void calAvgMark_Rank() {
        this.avgMark = (this.mark_html + this.mark_css + this.mark_javascript) / 3;
        if (this.avgMark < 5) {
            this.rank = "Yếu";
        } else if (this.avgMark < 7) {
            this.rank = "Trung bình";
        } else if (this.avgMark < 8) {
            this.rank = "Khá";
        } else if (this.avgMark < 9) {
            this.rank = "Giỏi";
        } else {
            this.rank = "Xuất sắc";
        }
    }


    public String inputStudentId() {
        System.out.print("Nhập vào mã sinh viên = ");
        while (true) {
            try {
                String id = sc.nextLine();
                boolean isCheckStudentId = isCheckTrungStudentId(id);
                if (isCheckStudentId) {
                    System.err.println("Mã sinh viên đã bị trùng, vui lòng nhập lại");
                } else {
                    //mã sinh viên gồm 4 ký tự, bắt đầu là ký tự S
                    if (id.length() == 4 && id.startsWith("S")) {
                        return id;
                    } else {
                        System.err.println("Mã sinh viên gồm 4 ký tự, bắt đầu là ký tự S, vui lòng nhập lại");
                    }
                }
            } catch (NullPointerException ex) {
                System.err.println("Mã sinh viên không được để trống,vui lòng nhập lại");
            }
        }
    }

    public static boolean isCheckTrungStudentId(String studentIdNeedCheck) {
        for (Student st : listStudent) {
            if (st.studentId.toLowerCase().equalsIgnoreCase(studentIdNeedCheck)) {
                return true;
            }
        }
        return false;
    }

    public static String inputStudentName() {
        //Tên danh mục (không trùng nhau, từ 6-30 kí tự)
        System.out.print("Nhập vào tên sinh viên = ");
        while (true) {
            try {
                String name = sc.nextLine();
                if (name.length() >= 10 && name.length() <= 50) {
                    return name;
                } else {
                    System.err.println("Tên sinh viên phải có độ dài từ 10-50 ký tự, vui lòng nhập lại");
                }

            } catch (NullPointerException ex) {
                System.err.println("Tên sinh viên không được để trống, vui lòng nhập lại");
            }
        }
    }

    public static Date inputStudentBirthday() {
        Date birthday;
        SimpleDateFormat formatBirthday = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dYear=new SimpleDateFormat("yyyy");
        System.out.print("Nhập vào ngày sinh của sinh viên = ");
        while (true) {
            try {
                birthday = formatBirthday.parse(sc.nextLine());
                int changeYear= Integer.parseInt(dYear.format(birthday));
                if (changeYear <= 2005) {
                    return birthday;
                } else {
                    System.err.println("Ngày sinh phải có năm sinh trước năm 2005 , vui lòng nhập lại");
                }

            } catch (ParseException pe) {
                System.err.println("Ngày sinh không đúng định dạng dd/MM/yyyy, vui lòng nhập lại");
            }
        }
    }

    public static boolean inputStudentSex() {
        System.out.print("Nhập vào giới tính sinh viên (true/false) = ");
        while (true) {
            String sex = sc.nextLine();
            if (sex.equalsIgnoreCase("true") || sex.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(sex);
            } else {
                System.err.println("Giới tính sinh viên phải là true/false, vui lòng nhập lại");
            }
        }
    }

    public static float inputHtmlScore() {
        System.out.print("Nhập vào điểm HTML = ");
        while (true) {
            try {
                float htmlScore = Float.parseFloat(sc.nextLine());
                if (htmlScore >= 0 && htmlScore <= 10) {
                    return htmlScore;
                } else {
                    System.err.println("Điểm HTML phải có giá trị trong khoảng 0-10, vui lòng nhập lại");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Điểm HTML phải số, vui lòng nhập lại");
            }

        }

    }
    public static float inputCssScore() {
        System.out.print("Nhập vào điểm CSS = ");
        while (true) {
            try {
                float cssScore = Float.parseFloat(sc.nextLine());
                if (cssScore >= 0 && cssScore <= 10) {
                    return cssScore;
                } else {
                    System.err.println("Điểm CSS phải có giá trị trong khoảng 0-10, vui lòng nhập lại");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Điểm CSS phải số, vui lòng nhập lại");
            }

        }

    }
    public static float inputJavascriptScore() {
        System.out.print("Nhập vào điểm Javascript = ");
        while (true) {
            try {
                float javascriptScore = Float.parseFloat(sc.nextLine());
                if (javascriptScore >= 0 && javascriptScore <= 10) {
                    return javascriptScore;
                } else {
                    System.err.println("Điểm Javascript phải có giá trị trong khoảng 0-10, vui lòng nhập lại");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Điểm Javascript phải số, vui lòng nhập lại");
            }

        }

    }
}
