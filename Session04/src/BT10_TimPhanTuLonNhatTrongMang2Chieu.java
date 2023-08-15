import java.util.Scanner;

public class BT10_TimPhanTuLonNhatTrongMang2Chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số dòng của mảng 2 chiều =");
        int row = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập vào số cột của mảng 2 chiều =");
        int col = Integer.parseInt(sc.nextLine());
        int [][] arrInt=new int[row][col];
        System.out.println("Nhập mảng");
        for (int i = 0; i <arrInt.length ; i++) {
            for (int j = 0; j <arrInt[i].length ; j++) {
                System.out.printf("arrInt[%d][%d]=",i,j);
                arrInt[i][j]=Integer.parseInt(sc.nextLine());
            }
        }
        //In ra các giá trị trong mảng
        System.out.println("Ma trận các phần tử của mảng là :");
        for (int i = 0; i <arrInt.length ; i++) {
            for (int j = 0; j <arrInt[i].length ; j++) {
                System.out.printf("%d\t",arrInt[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");

        //Tim max
        int max=arrInt[0][0];
        for (int i = 0; i <arrInt.length ; i++) {
            for (int j = 0; j <arrInt[i].length ; j++) {
               if(max<arrInt[i][j]){
                   max=arrInt[i][j];
               }
            }
        }
        System.out.println("Giá trị lớn nhất trong mảng 2 chiều là :"+max);



    }
}
