import java.util.Scanner;

public class BT04_Tinh_Chi_So_Can_Nang_Cua_Co_The {
    public static void main(String[] args) {
//        Chỉ số khối cơ thể (Body mass index-BMI) là một thước đo sức khoẻ
//        dựa trên cân nặng và chiều cao. Nó được tính bằng cách lấy cân nặng đơn vị
//        tính kilogam chia cho bình phương của chiều cao đơn vị tính mét. Công thức:
//        bmi = weight / height mũ 2
        double weight,height,bmi;
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhập vào số cân nặng=");
        weight=Double.parseDouble(sc.nextLine());
        System.out.print("Nhập vào chiều cao (m)=");
        height=Double.parseDouble(sc.nextLine());
        bmi=weight/Math.pow(height,2);
        System.out.println("bmi---->"+bmi);
        if(bmi<18.5){
            System.out.println("Qúa gầy");
        }else if(bmi<25.0){
            System.out.println("Bình thường");
        }else if(bmi<30.0){
            System.out.println("Quá béo");
        }else{
            System.out.println("Béo phì");
        }
    }
}
