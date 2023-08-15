import java.util.Scanner;

public class BT04_ChuyenDoiNhietDo {
    public static void main(String[] args) {
//        Trong phần này, chúng ta sẽ phát triển một ứng dụng cho phép chuyển đổi nhiệt độ
//        từ độ C sang độ F và ngược lại. Ứng dụng gồm một menu cho phép người dùng lựa
//        chọn việc chuyển đổi nhiệt độ
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("********Menu********");
            System.out.println("1.Chuyển đổi độ F sang độ C");
            System.out.println("2.Chuyển đổi độ C sang độ F");
            System.out.println("3.Thoát");
            System.out.print("Lựa chọn của bạn là:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập vào nhiệt độ F=");
                    double Fahrenheit = Double.parseDouble(sc.nextLine());
                    System.out.println("Nhiệt độ F chuyển đổi sang nhiệt độ C là :"+fahrenheitToCelsius(Fahrenheit));
                    break;
                case 2:
                    System.out.print("Nhập vào nhiệt độ C=");
                    double celsius = Double.parseDouble(sc.nextLine());
                    System.out.println("Nhiệt độ C chuyển đổi sang nhiệt độ F là :"+celsiusToFahrenheit(celsius));
                    break;
                case 3:
                    System.exit(0);
                    break;
            }


        } while (true);

    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }

    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }


}
