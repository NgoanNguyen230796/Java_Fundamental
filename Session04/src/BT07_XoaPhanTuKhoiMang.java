import java.util.Arrays;
import java.util.Scanner;

public class BT07_XoaPhanTuKhoiMang {
    public static void main(String[] args) {
//        chúng ta sẽ phát triển một chương trình thực hiện xoá một phần tử
//        được nhập vào từ bàn phím ra khỏi mảng, nếu phần tử đó xuất hiện trong mảng.

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số phần tử của mảng thứ là =");
        int number = Integer.parseInt(sc.nextLine());
        int[] arrInt = new int[number];
        for (int i = 0; i < arrInt.length; i++) {
            System.out.printf("Nhập vào phần tử thứ " + (i + 1) + "=");
            arrInt[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.print("Nhập vào giá trị cần xóa trong mảng là =");
        int numberDelete = Integer.parseInt(sc.nextLine());

        //Khởi tạo 1 mảng mới để chứa các phần tử sau khi xóa
        // Đếm số phần tử có giá trị numberDelete trong mảng arrInt
        int count = 0;
        for (int i = 0; i < arrInt.length; i++) {
            if (arrInt[i] == numberDelete) {
                count++;
            }
        }
        // Khởi tạo mảng mới với độ dài là arrInt.length -count
        int[] arrIntNew= new int[(arrInt.length-count)];
        int indexArrIntNew=0;
        for (int i = 0; i <arrInt.length ; i++) {
            if(arrInt[i]==numberDelete){
                continue;
            }else{
                arrIntNew[indexArrIntNew]=arrInt[i];
                indexArrIntNew++;
            }
        }

        // In mảng mới sau khi xóa
        System.out.println("Mảng sau khi xóa giá trị "+numberDelete+" ra khỏi mảng là :");
        System.out.println(Arrays.toString(arrIntNew));




    }
}
