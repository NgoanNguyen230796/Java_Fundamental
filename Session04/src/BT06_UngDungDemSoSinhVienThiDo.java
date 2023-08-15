import java.util.Scanner;

public class BT06_UngDungDemSoSinhVienThiDo {
    public static void main(String[] args) {
//        chúng ta sẽ phát triển một chức năng cho phép đếm số lượng sinh
//        viên đã thi đỗ một kỳ thi, dựa vào danh sách điểm được nhập vào
//        Sử dụng thang điểm 10, điểm đỗ là từ 5 trở lên.
//        Ứng dụng cho phép nhập vào điểm của tối đa 30 sinh viên, sau đó hiển thị số lượng
//        sinh viên đã thi đỗ.

        Scanner sc= new Scanner(System.in);
        double [] arrayDiem=new double[30];
        System.out.println("Nhập vào điểm của 30SV");
        for (int i = 0; i <arrayDiem.length ; i++) {
            System.out.printf("Điểm của SV thứ "+(i+1)+"=");
            arrayDiem[i]=Double.parseDouble(sc.nextLine());
        }
        //Sử dụng thang điểm 10, điểm đỗ là từ 5 trở lên.
        int count=0;
        for (double element:arrayDiem) {
            if(element>=5){
                count++;
            }
        }
        System.out.println("Số lượng SV đỗ là :"+count);

    }
}
