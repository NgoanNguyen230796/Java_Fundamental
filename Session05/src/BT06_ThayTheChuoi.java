import java.util.Scanner;

public class BT06_ThayTheChuoi {
    public static void main(String[] args) {
//        Nhập vào 1 chuỗi, thay thế các chuỗi “Academy” thành “Học viện”. (Sử dụng
//        phương thức replace trong String)
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi =");
        String str1 = sc.nextLine();
        //Kiểm tra trong chuỗi str1 có chuỗi “Academy” hay không
        if(str1.contains("Academy")==true){
            String replaceStr1=str1.replace("Academy","Học viện");
            System.out.println("Chuỗi sau khi thay thế chuỗi Academy thành Học viện là :"+replaceStr1);
        }else{
            System.out.println("Chuỗi bạn vừa nhập không có chứa chuỗi Academy");
        }
    }
}
