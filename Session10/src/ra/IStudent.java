package ra;


import ra.impl.Student;

import java.util.List;
import java.util.Scanner;

public interface IStudent {
    int MARK_PASS = 5;

    //Phương thức trừu tượng, không có thân, không có phần triển khai
    public abstract void inputData(Scanner sc, List<Student> listStudent);

    public abstract void displayData();

    public abstract void calAvgMark();
}

