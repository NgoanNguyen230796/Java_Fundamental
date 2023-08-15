import java.util.Scanner;

public class BT15_TimPhanTuLonThu2TrongMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử trong mảng là =");
        int number = Integer.parseInt(sc.nextLine());
        int[] arrInt = new int[number];
        for (int i = 0; i < arrInt.length; i++) {
            System.out.print("Nhập phần tử thứ " + (i+1) + "=");
            arrInt[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Mảng sau khi nhập là :");
        for (int i = 0; i < arrInt.length; i++) {
            System.out.printf("%d\t", arrInt[i]);
        }
        System.out.printf("\n");
        int max = arrInt[0];
        int max2 = 0;
        for (int i = 0; i < arrInt.length; i++) {
            if (max < arrInt[i]) {
                max2 = max;
                max = arrInt[i];

            }

        }
        System.out.println("Phần tử lớn nhất trong mảng là :" + max);
        System.out.println("Phần tử lớn thứ 2 trong mảng là :" + max2);
    }
}
