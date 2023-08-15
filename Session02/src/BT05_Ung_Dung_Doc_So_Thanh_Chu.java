import java.util.Scanner;

public class BT05_Ung_Dung_Doc_So_Thanh_Chu {
    public static void main(String[] args) {
//        Giả sử bạn đang tham gia viết chương trình cho máy đo chiều cao cân nặng,
//        hãy viết một chương trình có khả năng đọc các số nguyên không âm có tối đa 3 chữ số.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một số tối đa 3 chữ số =");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.printf("%d sau khi phiên âm sang chữ là : ", number);
        int donVi = number % 10;
        int chuc = (number / 10) % 10;
        int tram = number / 100;
        String str_donVi, str_chuc = "", str_tram = "", str_output = "";
        switch (donVi) {
            case 0:
                str_donVi = "Zero";
                break;
            case 1:
                str_donVi = "One";
                break;
            case 2:
                str_donVi = "Two";
                break;
            case 3:
                str_donVi = "Three";
                break;
            case 4:
                str_donVi = "Four";
                break;
            case 5:
                str_donVi = "Five";
                break;
            case 6:
                str_donVi = "Six";
                break;
            case 7:
                str_donVi = "Seven";
                break;
            case 8:
                str_donVi = "Eight";
                break;
            default:
                str_donVi = "Nine";
        }
        switch (chuc) {
            case 1:
                switch (donVi) {
                    case 0:
                        str_chuc = "Ten";
                        break;
                    case 1:
                        str_chuc = "Eleven";
                        break;
                    case 2:
                        str_chuc = "Twelve";
                        break;
                    case 5:
                        str_chuc = "Fifteen";
                        break;
                    default:
                        str_chuc = str_donVi + "teen";

                }
                break;
            case 2:
                str_chuc = "Twenty";
                break;
            case 3:
                str_chuc = "Thirty";
                break;
            case 4:
                str_chuc = "Forty";
                break;
            case 5:
                str_chuc = "Fifty";
                break;
            case 6:
                str_chuc = "Sixty";
                break;
            case 7:
                str_chuc = "Seventy";
                break;
            case 8:
                str_chuc = "Eighty";
                break;
            case 9:
                str_chuc = "Ninety";
                break;

        }
        if (number < 10) {
            str_output = str_donVi;
        } else if (number < 20) {
            str_output = str_chuc;
        } else if (number < 100) {
            if (donVi == 0) {
                str_output = str_chuc;
            } else {
                str_output = str_chuc + "-" + str_donVi;
            }
        } else if (number < 1000) {
            switch (tram) {
                case 1:
                    str_tram = "One";
                    break;
                case 2:
                    str_tram = "Two";
                    break;
                case 3:
                    str_tram = "Three";
                    break;
                case 4:
                    str_tram = "Four";
                    break;
                case 5:
                    str_tram = "Five";
                    break;
                case 6:
                    str_tram = "Six";
                    break;
                case 7:
                    str_tram = "Seven";
                    break;
                case 8:
                    str_tram = "Eight";
                    break;
                case 9:
                    str_tram = "Nine";
                    break;
            }
            str_tram += " hundred";
            if (chuc == 0) {
                if (donVi == 0) {
                    str_output = str_tram;
                } else {
                    str_output = str_tram + " " + str_donVi;
                }
            } else if (chuc == 1) {
                str_output = str_tram + " " + str_chuc;
            } else {
                if (donVi==0){
                    str_output = str_tram + " " + str_chuc;
                }else {
                    str_output = str_tram + " and " + str_chuc + "-" + str_donVi;
                }
            }
        }
        System.out.println(str_output);

    }
}
