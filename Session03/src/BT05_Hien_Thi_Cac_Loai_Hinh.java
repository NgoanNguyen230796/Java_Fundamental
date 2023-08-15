import java.util.Scanner;

public class BT05_Hien_Thi_Cac_Loai_Hinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("************MENU***************");
            System.out.println("1. Print the Rectangle");//Hình chữ nhật
            System.out.println("2. Print the square triangle");//Tam giác vuông
            System.out.println("3. Print isosceles triangle");//Tam giác cân
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter the width of the rectangle");
                    int width = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the height of the rectangle");
                    int height = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            //In theo dòng
                            System.out.printf("*\t");
                        }
                        //Hết dòng thì xuống dòng
                        System.out.printf("\n");
                    }
                    break;
                case 2:
                    boolean isExist = true;
                    do {
                        System.out.println("*************Square Triangle**************");
                        System.out.println("1. Top-Left");
                        System.out.println("2. Top-Right");
                        System.out.println("3. Bottom-Left");
                        System.out.println("4. Bottom-Right");
                        System.out.println("5. Exit");
                        System.out.print("Your choice: ");
                        int squareType = Integer.parseInt(scanner.nextLine());
                        switch (squareType) {
                            case 1:
                                System.out.println("Enter the height of Triangle:");
                                int heightTopLeft = Integer.parseInt(scanner.nextLine());
                                for (int i = heightTopLeft; i >= 1; i--) {
                                    //In theo dòng
                                    for (int j = 1; j <= i; j++) {
                                        System.out.printf("*\t");
                                    }
                                    //Hết dòng xuống dòng
                                    System.out.printf("\n");
                                }
                                break;
                            case 2:
                                System.out.println("Enter the height of Triangle:");
                                int heightTopRight = Integer.parseInt(scanner.nextLine());
                                for (int i = heightTopRight; i >= 1; i--) {
                                    //In theo dòng
                                    //In khoảng trắng
                                    for (int j = 1; j <= heightTopRight - i; j++) {
                                        System.out.printf(" \t");
                                    }
                                    //In *
                                    for (int k = 1; k <= i; k++) {
                                        System.out.printf("*\t");
                                    }
                                    //Hết dòng xuống dòng
                                    System.out.printf("\n");
                                }
                                break;
                            case 3:
                                System.out.println("Enter the height of Triangle:");
                                int heightBottomLeft = Integer.parseInt(scanner.nextLine());
                                for (int i = 1; i <= heightBottomLeft; i++) {
                                    //In theo dòng
                                    for (int j = 1; j <= i; j++) {
                                        System.out.printf("*\t");
                                    }
                                    //Hết dòng xuống dòng
                                    System.out.printf("\n");
                                }
                                break;
                            case 4:
                                System.out.println("Enter the height of Triangle:");
                                int heightBottomRight = Integer.parseInt(scanner.nextLine());
                                for (int i = 1; i <= heightBottomRight; i++) {
                                    //In theo dòng
                                    //In khoảng trắng
                                    for (int j = 1; j <= heightBottomRight - i; j++) {
                                        System.out.printf(" \t");
                                    }
                                    //In *
                                    for (int k = 1; k <= i; k++) {
                                        System.out.printf("*\t");
                                    }
                                    //Hết dòng xuống dòng
                                    System.out.printf("\n");
                                }
                                break;
                            case 5:
                                isExist = false;
                                break;
                            default:
                                System.err.println("Please enter number 1-5");
                        }
                    } while (isExist);
                    break;
                case 3:
                    System.out.println("Enter the height of Triangle:");
                    int heightIsosceles = Integer.parseInt(scanner.nextLine());
                    int k = 0;
                    for (int i = 1; i < heightIsosceles; i++, k = 0) {
                        //In khoảng trắng
                        for (int j = 1; j <= heightIsosceles - i; j++) {
                            System.out.printf(" \t");
                        }
                        //In *
                        while (k != 2 * i - 1) {
                            System.out.printf("*\t");
                            k++;
                        }
                        //Xuống dòng
                        System.out.printf("\n");
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.err.println("Please enter number 1-4");
            }
        } while (true);


    }
}
