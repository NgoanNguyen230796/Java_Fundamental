import java.util.Scanner;

public class BT08_NoiChuoiCoDoDaiBangNhau {
    public static void main(String[] args) {
//        Nhập vào 2 chuỗi, nối 2 chuỗi với nhau, nếu 2 chuỗi có độ dài không bằng nhau
//        thì tiến hành cắt bỏ các ký tự đầu của chuỗi dài hơn đến khi chúng bằng nhau thì
//        tiến hành nối lại. (Sử dụng phương thức subString(start,length) của lớp String)
//        Ví dụ: “Wellcome” và “home” → nối lại thành “comehome”
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi thứ 1 =");
        String str1 = sc.nextLine();
        System.out.print("Nhập vào chuỗi thứ 2 =");
        String str2 = sc.nextLine();
        System.out.println("Độ dài chuỗi 1 là ="+str1.length());
        System.out.println("Độ dài chuỗi 2 là ="+str2.length());
        if (str1.length() > str2.length()) {
            int lengthChenhLech1=str1.length() - str2.length();
            String cutStr1 = str1.substring(lengthChenhLech1);
            System.out.println("Sau khi nối 2 chuỗi có độ dài bằng nhau là " + cutStr1.concat(str2));
        } else if (str2.length()>str1.length()) {
            int lengthChenhLech2=str2.length() - str1.length();
            String cutStr2 = str2.substring(lengthChenhLech2);
            System.out.println("Sau khi nối 2 chuỗi có độ dài bằng nhau là " + str1.concat(cutStr2));
        } else {
            System.out.println("Sau khi nối 2 chuỗi có độ dài bằng nhau là " + str1.concat(str2));
        }
    }


}
