import java.util.Scanner;

public class BT14_DemSoLanXuatHienCuaKyTuTrongChuoi {
    public static void main(String[] args) {
//        chúng ta sẽ phát triển một cho phép đếm số lần xuất hiện của một
//        ký tự được nhập vào từ bàn phím cho một chuỗi cho trước
        String arrString;
        char inputChar;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhập chuỗi là :");
        arrString = sc.nextLine();

        System.out.print("Hãy nhập ký tự cần tìm trong chuỗi là =");
        inputChar=sc.nextLine().charAt(0);
        int count=0;
        for (int i = 0; i <arrString.length() ; i++) {
            if(arrString.toLowerCase().charAt(i)==inputChar){
                count++;
            }
        }
        if(count<1){
            System.out.println("Không tìm thấy ký tự trong chuỗi");
        }else {
            System.out.println("Ký tự xuất hiện "+count+ " lần trong chuỗi");
        }

    }
}
