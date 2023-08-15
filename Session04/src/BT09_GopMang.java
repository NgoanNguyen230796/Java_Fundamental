import java.util.Scanner;
import java.util.Arrays;

public class BT09_GopMang {
    public static void main(String[] args) {
//        Trong phần này, chúng ta sẽ phát triển một chương trình cho phép gộp 2 mảng thành
//        một mảng thứ 3.

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số phần tử của mảng thứ 1 là =");
        int number1 = Integer.parseInt(sc.nextLine());
        int[] arrInt1 = new int[number1];
        for (int i = 0; i < arrInt1.length; i++) {
            System.out.printf("Nhập vào phần tử thứ " + (i + 1) + "=");
            arrInt1[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.print("Nhập vào số phần tử của mảng thứ 2 là =");
        int number2 = Integer.parseInt(sc.nextLine());
        int[] arrInt2 = new int[number2];
        for (int i = 0; i < arrInt2.length; i++) {
            System.out.printf("Nhập vào phần tử thứ " + (i + 1) + "=");
            arrInt2[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Mảng 1 sau khi nhập là :");
        for (int i = 0; i < arrInt1.length; i++) {
            System.out.printf("%d\t", arrInt1[i]);
        }
        System.out.printf("\n");
        System.out.println("Mảng 2 sau khi nhập là :");
        for (int i = 0; i < arrInt2.length; i++) {
            System.out.printf("%d\t", arrInt2[i]);
        }
        System.out.printf("\n");
        System.out.println("Mảng sau khi gộp mảng 1 và mảng 2 là :");
        int[] arrInt3 = new int[(number1 + number2)];

        System.arraycopy(arrInt1,0, arrInt3, 0, number1);

        System.arraycopy(arrInt2, 0, arrInt3, number1, number2);

        System.out.println(Arrays.toString(arrInt3));

//        int pos = 0;
//        for (int element : arrInt1) {
//            arrInt3[pos] = element;
//            pos++;
//        }
//
//        for (int element : arrInt2) {
//            arrInt3[pos] = element;
//            pos++;
//        }
//        System.out.println(Arrays.toString(arrInt3));
    }
}
