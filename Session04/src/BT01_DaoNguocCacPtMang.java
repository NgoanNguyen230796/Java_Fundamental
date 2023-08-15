import java.util.Scanner;

public class BT01_DaoNguocCacPtMang {
    public static void main(String[] args) {
//        Trong phần này, chúng ta sẽ phát triển một ứng dụng cho phép tìm vị trí của một
//        phần tử trong mảng.
//        Ứng dụng có sẵn một danh sách tên của sinh viên, cho phép người dùng nhập vào
//        một tên sinh viên, sau đó hiển thị vị trí của sinh viên đó trong danh sách (nếu tìm
//        thấy) hoặc là thông báo không tìm thấy.

        Scanner sc = new Scanner(System.in);
        int[] arrInt = new int[20];
        System.out.println("Nhập các phần tử cho mảng: ");
        for (int i = 0; i < arrInt.length; i++) {
            System.out.print("Nhập phần tử thứ " + i + "= ");
            arrInt[i] = Integer.parseInt(sc.nextLine());
        }
        // Hiển thị mảng vừa nhập
        System.out.println("Các phần tử trong mảng sau khi đã nhập là :");
        for (int i = 0; i < arrInt.length; i++) {
            System.out.printf("%d\t", arrInt[i]);
        }
        System.out.printf("\n");
        //Đảo ngược mảng là
        for (int i = 0; i < arrInt.length / 2; i++) {
            int tmp = arrInt[i];
            arrInt[i] = arrInt[arrInt.length - 1 - i];
            arrInt[arrInt.length - 1 - i] = tmp;
        }
        System.out.println("Mảng sau khi đảo ngược là :");
        for (int i = 0; i < arrInt.length; i++) {
            System.out.printf("%d\t", arrInt[i]);
        }
        System.out.printf("\n");

    }
}
