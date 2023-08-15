import java.util.Scanner;

public class BT04_2_KiemTraSoTrongChuoi_SuDungisDigitOfCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi =");
        String str = sc.nextLine();
        boolean isCheckCharacter=true;
        for (int i = 0; i <str.length() ; i++) {
            if(Character.isDigit(str.charAt(i))){
                isCheckCharacter=false;
                break;
            }
        }
        if(isCheckCharacter){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
    }
}
