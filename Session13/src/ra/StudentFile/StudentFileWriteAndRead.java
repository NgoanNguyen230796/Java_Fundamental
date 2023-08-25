package ra.StudentFile;

import ra.entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static ra.impl.StudentImp.listStudent;

public class StudentFileWriteAndRead {
    public static void writeDataToFile(List<Student> listStudent) {
        //1. Khởi tạo đối tượng file để làm việc với file - tương đối
        File file = new File("listStudent.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            //2. Khởi tạo đối tượng FileOutputStream từ file - Checked Excetion
            fos = new FileOutputStream(file);
            //3. Khởi tạo đối tượng ObjectOutputStream từ fos
            oos = new ObjectOutputStream(fos);
            //4. Sử dụng writeObject để ghi object ra file
            oos.writeObject(listStudent);
            //5. Đẩy dữ liệu từ Stream xuống file
            oos.flush();

        } catch (FileNotFoundException ex1) {
            System.err.println("File không tồn tại");
        } catch (IOException ex2) {
            System.err.println("Lỗi khi ghi dữ liệu ra file");
        } catch (Exception ex) {
            System.err.println("Xảy ra lỗi trong quá trình ghi dữ liệu ra file");
        } finally {
            //6. Đóng các stream
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex1) {
                System.err.println("Xảy ra lỗi khi đóng các stream");
            } catch (Exception ex) {
                System.err.println("Xảy ra lỗi trong quá trình đóng các stream");
            }
        }
    }

    public static List<Student> readDataFromFile() {
        //1. Khởi tạo đối tượng File
        File file = new File("listStudent.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            //2. Khởi tạo đối tượng FileInputStream
            fis = new FileInputStream(file);
            //3. Khởi tạo đối tượng ObjectInputStream
            ois = new ObjectInputStream(fis);
            //4. Đọc dữ liệu object từ file (readObject())
            listStudent = (List<Student>) ois.readObject();
        } catch (FileNotFoundException ex1) {
            System.err.println("Không tồn tại file");
        } catch (IOException ex2) {
            System.err.println("Lỗi khi đọc file");
        } catch (Exception ex) {
            System.err.println("Có lỗi trong quá trình đọc dữ liệu từ file");
        } finally {
            //6. Đóng các stream
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex1) {
                System.err.println("Có lỗi khi đóng stream");
            } catch (Exception ex) {
                System.err.println("Có lỗi trong quá trình đóng các stream");
            }
            return listStudent;
        }
    }
}

