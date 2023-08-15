import java.util.Scanner;

public class BT06_Hien_Thi_20_So_Nguyen_To_Dau_Tien {
    public static void main(String[] args) {
//        chúng ta sẽ phát triển một ứng dụng cho phép hiển thị 20 số nguyên
//        tố đầu tiên.
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhập vào số lượng số nguyên tố cần in ra màn hình :");
        int number=Integer.parseInt(sc.nextLine());
        int count=0;
        int N=2;

        while(count<number){
            boolean isPrime=true;
            for (int i = 2; i <= Math.sqrt(N); i++) {
                if(N%i==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                System.out.printf("%d\t",N);
                count++;
            }
            if(number==count){
                break;
            }
            N++;
        }

    }
}
