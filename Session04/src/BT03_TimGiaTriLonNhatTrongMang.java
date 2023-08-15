import java.util.Scanner;

public class BT03_TimGiaTriLonNhatTrongMang {
    public static void main(String[] args) {
//        Trong phần này, chúng ta sẽ phát triển một ứng dụng cho phép xác định phần tử có
//        giá trị lớn nhất trong mảng.
//        Ứng dụng cho phép người dùng lần lượt nhập vào giá trị tài sản của các tỷ phú thế
//        giới (đơn vị tỉ đô), tối đa cho phép nhập 20 giá trị, sau đó hiển thị giá trị tài sản lớn
//        nhất và vị trí của nó trong danh sách.
        Scanner sc= new Scanner(System.in);
        int [] arrint =new int[20];
        System.out.println("Nhập giá trị cho các phần tử mảng :");
        for (int i = 0; i <arrint.length; i++) {
            System.out.print("Giá trị của phần tử thứ "+i+"=");
            arrint[i]=Integer.parseInt(sc.nextLine());
        }
        int max=arrint[0];
        int index=0;
        for (int i = 0; i <arrint.length ; i++) {
            if(max<arrint[i]){
                max=arrint[i];
                index=i;
            }
        }
        System.out.println("Giá trị lớn nhất trong mảng là :"+max);
        System.out.println("Vị trí giá trị lớn nhất trong mảng là :"+index);
    }
}
