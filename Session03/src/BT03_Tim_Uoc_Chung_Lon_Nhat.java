import java.util.Scanner;

public class BT03_Tim_Uoc_Chung_Lon_Nhat {
    public static void main(String[] args) {
//        tìm ước số chung lớn nhất của hai số nguyên
        Scanner sc = new Scanner(System.in);
        int number1, number2;
        System.out.print("Nhập vào số nguyên thứ 1 =");
        number1 = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập vào số nguyên thứ 2 =");
        number2 = Integer.parseInt(sc.nextLine());
        if (number1 == 0 || number2 == 0) {
            System.out.printf("Hai số %d và %d k có ước chung lớn nhất", number1, number2);
        }else{
            while (number1 != number2) {
                if (number1 > number2) {
                    number1 = number1 - number2;
                    System.out.printf("Ước chung lớn nhất là %d\n", number1);
                } else {
                    number2 = number2 - number1;
                    System.out.printf("Ước chung lớn nhất là %d\n", number2);
                }
            }
        }



    }
}
