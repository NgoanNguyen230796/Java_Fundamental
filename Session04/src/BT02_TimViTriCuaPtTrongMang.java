import java.util.Scanner;

public class BT02_TimViTriCuaPtTrongMang {
    public static void main(String[] args) {
//        Trong phần này, chúng ta sẽ phát triển một ứng dụng cho phép tìm vị trí của một
//        phần tử trong mảng.
//        Ứng dụng có sẵn một danh sách tên của sinh viên, cho phép người dùng nhập vào
//        một tên sinh viên, sau đó hiển thị vị trí của sinh viên đó trong danh sách (nếu tìm
//        thấy) hoặc là thông báo không tìm thấy.

        String[] arrStudents = {"Ngoan", "Trang", "Thu", "Nam", "Tuan", "Hai", "Ngan", "Lan", "Vu"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào tên sinh viên mà bạn muốn tìm =");
        String findStudentName = sc.nextLine();
        boolean isCheck = true;
        for (int i = 0; i < arrStudents.length; i++) {
            if (arrStudents[i].equals(findStudentName)) {
                System.out.println("Vị trí của sinh viên đó trong danh sách là:" + i);
                isCheck = false;
                break;
            }
        }
        if (isCheck) {
            System.out.println("Không tìm thấy");
        }

    }
}
