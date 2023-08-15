import java.util.Arrays;
import java.util.Scanner;

public class BT08_ThemPhanTuVaoMang {
    public static void main(String[] args) {
//        chúng ta sẽ phát triển một chương trình cho phép người dùng khai
//        báo mảng mảng số nguyên gồm N phần tử. Nhập một giá trị bất kỳ từ bàn phím và vị
//        trí cần chèn, giá trị này được chèn vào vị trí đó trong mảng.

        Scanner sc= new Scanner(System.in);
        System.out.print("Nhập vào số phần tử trong mảng =");
        int number=Integer.parseInt(sc.nextLine());
        int [] arrIntOld= new int[number];
        for (int i = 0; i <arrIntOld.length ; i++) {
            System.out.print("Phần tử thứ " +(i+1)+" =");
            arrIntOld[i]=Integer.parseInt(sc.nextLine());
        }
        System.out.println("Mảng sau khi nhập là :");
        System.out.println(Arrays.toString(arrIntOld));
        System.out.print("Nhập vào giá trị cần thêm vào mảng =");
        int numberInsert=Integer.parseInt(sc.nextLine());
        System.out.print("Nhập vào chỉ số cần chèn vào mảng =");
        int indexInsert=Integer.parseInt(sc.nextLine());
        //Khởi tạo mảng mới khi mà thêm giá trị vào mảng
        int [] arrIntNew = new int [(arrIntOld.length+1)];
        // Copy mảng cũ và thêm phần tử cần thêm vào luôn
        for (int i = 0; i <arrIntNew.length ; i++) {
            if(i<indexInsert){
                arrIntNew[i]=arrIntOld[i];
            }else if(i==indexInsert){
                arrIntNew[i]=numberInsert;
            }else{
             arrIntNew[i]=arrIntOld[i-1];
            }
        }
        System.out.println("Mảng sau khi chèn giá trị "+numberInsert+" vào mảng tại vị trí thứ "+indexInsert+" là: ");
        System.out.println(Arrays.toString(arrIntNew));

    }
}
