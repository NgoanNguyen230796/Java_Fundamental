import java.util.Scanner;
import java.util.regex.Pattern;

public class BT04_1_KiemTraSoTrongChuoi_SuDungRegex {
    public static void main(String[] args) {
//        Nhập vào 1 chuỗi, kiểm tra trong chuỗi có ký tự số không, nếu có in ra “YES”
//        ngược lại in ra “NO”.  (Sử dụng Regex)
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi =");
        String str = sc.nextLine();
        String regexNumber="\\d+";
        if(Pattern.matches(regexNumber,str)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }



    }
}
