import java.util.Scanner;

public class BT01_Kiem_Tra_So_Nguyen_To {
    public static void main(String[] args) {
//        chúng ta sẽ phát triển một ứng dụng cho phép kiểm tra một số xem
//        có phải là số nguyên tố hay không.
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập 1 số nguyên từ bàn phím=");
        int number = Integer.parseInt(sc.nextLine());
        boolean isCheck = true;
        if (number < 2) {
            System.out.printf("%d k là số nguyên tố", number);
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isCheck = false;
                    break;
                }
            }
            if (isCheck) {
                System.out.printf("%d là số nguyên tố", number);
            } else {
                System.out.printf("%d k là số nguyên tố", number);
            }
        }
    }
}
