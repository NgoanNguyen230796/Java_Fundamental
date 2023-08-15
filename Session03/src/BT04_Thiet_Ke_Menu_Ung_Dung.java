import java.util.Scanner;

public class BT04_Thiet_Ke_Menu_Ung_Dung {
    public static void main(String[] args) {
//        phát triển một ứng dụng cho phép người dùng hiển thị
//        một menu các hình mà ứng dụng có thể vẽ, kèm theo số thứ tự, người dùng chọn
//        một lựa chọn bằng cách nhập và số thứ tự trên menu và ứng dụng sẽ vẽ hình tương
//        ứng.
        Scanner sc= new Scanner(System.in);
        do {
            System.out.println("*******Menu*******");
            System.out.println("1.Hình chữ nhật");
            System.out.println("2.Hình chữ vuông");
            System.out.println("3.Hình tam giác");
            System.out.println("4.Thoát");
            System.out.print("Sự lựa chọn của bạn là :");
            int choice=Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j <7 ; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println();
                    }

                    break;
                case 2:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j <3 ; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println();
                    }

                    break;
                case 3:
                    for (int i = 1; i <5 ; i++) {
                        for (int j = 1; j < 10; j++) {
                           if(Math.abs(5-j)<=(i-1)){
                               System.out.print(" * ");
                           }else{
                               System.out.print("   ");
                           }
                        }
                        System.out.println();

                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập lựa chọn từ 1-4");
            }
        }while (true);

    }
}
