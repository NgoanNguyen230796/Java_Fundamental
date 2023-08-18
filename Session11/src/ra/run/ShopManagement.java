package ra.run;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static ra.entity.Categories.*;
import static ra.entity.Product.indexDataProductIdFind;
import static ra.entity.Product.isCheckCatalogIdInListProduct;

public class ShopManagement {
    public static List<Categories> listCategories = new ArrayList<>();
    public static List<Product> listProduct = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("*************************SHOP MANAGEMENT*************************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn là:");
            do {
                String inputChoiceCategories=sc.nextLine();
                String regexNumber = "\\d+";
                if(Pattern.matches(regexNumber,inputChoiceCategories)){
                    int choiceCategories=Integer.parseInt(inputChoiceCategories);
                    switch (choiceCategories) {
                        case 1:
                            ShopManagement.catalogMenu();
                            break;
                        case 2:
                            ShopManagement.productMenu();
                            break;
                        case 3:
                            System.exit(0);
                        default:
                            System.err.println("Vui lòng nhập lựa chọn của bạn từ 1-3");
                    }
                    break;
                }else{
                    System.err.println("Lựa chọn các mục trong SHOP MANAGEMENT phải là số,vui lòng nhập lại");
                }

            }while (true);

        } while (true);
    }

    public static void catalogMenu() {
        boolean isExitCatalogMenu = true;
        do {
            System.out.println("*************************CATALOG MANAGEMENT*************************");
            System.out.println("1. Thêm mới danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật tên danh mục theo mã danh mục");
            System.out.println("4. Xóa danh mục theo mã danh mục (Danh mục chưa chứa sản phẩm)");
            System.out.println("5. Thoát (Quay lại Shop Management)");
            System.out.print("Lựa chọn của bạn là:");
            do {
                String inputChoiceCatalog=sc.nextLine();
                String regexNumber = "\\d+";
                if(Pattern.matches(regexNumber,inputChoiceCatalog)){
                    int choiceCatalog=Integer.parseInt(inputChoiceCatalog);
                    switch (choiceCatalog) {
                        case 1:
                            ShopManagement.inputDataCatalog();
                            break;
                        case 2:
                            ShopManagement.displayDataCatalog();
                            break;
                        case 3:
                            ShopManagement.displayDataCatalog();
                            ShopManagement.updateCatalogName();
                            break;
                        case 4:
                            ShopManagement.displayDataCatalog();
                            ShopManagement.deleteCatalogByCatalogId();
                            break;
                        case 5:
                            isExitCatalogMenu = false;
                            break;
                        default:
                            System.err.println("Vui lòng nhập lựa chọn của bạn từ 1-5");
                    }
                    break;
                }else{
                    System.err.println("Lựa chọn các mục trong CATALOG MANAGEMENT phải là số,vui lòng nhập lại");
                }
            }while (true);
        } while (isExitCatalogMenu);
    }

    public static void productMenu() {
        boolean isExitProductMenu = true;
        do {
            System.out.println("*************************PRODUCT MANAGEMENT*************************");
            System.out.println("1. Thêm mới sản phẩm (Khi thêm cho phép chọn danh mục sản phẩm mà sản phẩm thuộc về)");
            System.out.println("2. Hiển thị thông tin sản phẩm");
            System.out.println("3. Cập nhật giá sản phẩm theo mã sản phẩm");
            System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("5. Sắp xếp sản phẩm theo giá sản phẩm tăng dần");
            System.out.println("6. Sắp xếp sản phẩm theo tên tăng dần");
            System.out.println("7. Thống kê số lượng sản phẩm theo danh mục sản phẩm");
            System.out.println("8. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("9. Thoát (Quay lại Shop Management)");
            System.out.print("Lựa chọn của bạn là:");
            do {
                String inputChoiceProduct=sc.nextLine();
                String regexNumber = "\\d+";
                if(Pattern.matches(regexNumber,inputChoiceProduct)){
                    int choiceProduct=Integer.parseInt(inputChoiceProduct);
                    switch (choiceProduct) {
                        case 1:
                            //1.Nhập thông tin sản phẩm
                            System.out.print("Nhập số lượng sản phẩm mà bạn muốn thêm :");
                            do {
                                String stringInputNumber=sc.nextLine();
                                if(Pattern.matches(regexNumber,stringInputNumber)){
                                    int number = Integer.parseInt(stringInputNumber);
                                    for (int i = 0; i < number; i++) {
                                        System.out.println("Nhập vào sản phẩm thứ " + (i + 1) + ":");
                                        Product pr = new Product();
                                        pr.inputData(sc,listProduct);
                                        //2.Cho chọn sản phẩm thuộc danh mục nào-Hiển thị danh mục để cho người dùng chọn
                                        System.out.println("*************************CatalogName Menu*************************");
                                        for (int j = 0; j < listCategories.size(); j++) {
                                            System.out.println((j + 1) + " . " + listCategories.get(j).getCatalogName());
                                        }
                                        System.out.print("Chọn danh mục mà bạn muốn thêm sản phẩm vào :");
                                        do {
                                            String stringInputCatalogId=sc.nextLine();
                                            if(Pattern.matches(regexNumber,stringInputCatalogId)){
                                                int choiceNumber = Integer.parseInt(stringInputCatalogId);
                                                pr.setCatalogId(listCategories.get(choiceNumber - 1));
                                                listProduct.add(pr);
                                                break;
                                            }else{
                                                System.err.println("Danh mục mà bạn muốn thêm sản phẩm vào phải là số,vui lòng nhập lại");
                                            }
                                        }while (true);

                                    }
                                    System.out.println("Đã thêm mới sản phẩm xong");
                                    break;
                                }else{
                                    System.err.println("Số lượng sản phẩm mà bạn muốn thêm phải là số,vui lòng nhập lại");
                                }

                            }while (true);
                            break;
                        case 2:
                            ShopManagement.displayDataProduct();
                            break;
                        case 3:
                            ShopManagement.displayDataProduct();
                            ShopManagement.updatePriceByProductId();
                            break;
                        case 4:
                            ShopManagement.displayDataProduct();
                            ShopManagement.deleteProductByProductId();
                            break;
                        case 5:
                            ShopManagement.sortByAscendingProductPrice();
                            System.out.println("Sắp xếp sản phẩm theo giá sản phẩm tăng dần là :");
                            ShopManagement.displayDataProduct();
                            break;
                        case 6:
                            ShopManagement.sortByAscendingProductName();
                            System.out.println("Sắp xếp sản phẩm theo tên tăng dần là :");
                            ShopManagement.displayDataProduct();
                            break;
                        case 7:
                            ShopManagement.groupProductsByCatalogName();
                            break;
                        case 8:
                            ShopManagement.displayDataProduct();
                            ShopManagement.searchByProductName();
                            break;
                        case 9:
                            isExitProductMenu = false;
                            break;
                        default:
                            System.err.println("Vui lòng nhập lựa chọn của bạn từ 1-9");
                    }
                    break;
                }
                else{
                    System.err.println("Lựa chọn các mục trong PRODUCT MANAGEMENT phải là số,vui lòng nhập lại");
                }
            }while (true);
        } while (isExitProductMenu);
    }
    //1. Thêm mới danh mục
    public static void inputDataCatalog() {
        System.out.print("Nhập số lượng danh mục mà bạn muốn thêm :");
        do {
            String inputNumber=sc.nextLine();
            String regexNumber = "\\d+";
            if(Pattern.matches(regexNumber,inputNumber)){
                int number = Integer.parseInt(inputNumber);
                for (int i = 0; i < number; i++) {
                    System.out.println("Nhập vào danh mục thứ " + (i + 1) + ":");
                    Categories categories = new Categories();
                    categories.inputData(sc,listCategories);
                    listCategories.add(categories);
                }
                System.out.println("Đã thêm mới danh mục sản phẩm xong");
                break;
            }else{
                System.err.println("Số lượng danh mục mà bạn muốn thêm phải là số,vui lòng nhập lại");
            }
        }while (true);


    }
    //2. Hiển thị thông tin các danh mục
    public static void displayDataCatalog() {
        System.out.printf("%-30s%-30s%-30s\n", "Mã danh mục", "Tên danh mục", "Trạng thái danh mục");
        for (Categories ca : listCategories) {
            ca.displayData();
            System.out.println("-------------------------------------------------------------------------------");
        }
    }
    //3. Cập nhật tên danh mục theo mã danh mục
    public static void updateCatalogName() {
        System.out.print("Nhập vào mã danh mục mà bạn muốn thay đổi tên danh mục =");
        do {
            String stringCatalogId=sc.nextLine();
            String regexNumber = "\\d+";
            if(Pattern.matches(regexNumber,stringCatalogId)){
                int catalogIdFind = Integer.parseInt(stringCatalogId);
                int isCheckIndexNumber = indexDataCatalogIdFind(catalogIdFind);
                if (isCheckIndexNumber < 0) {
                    System.out.println("Không tìm thấy mã danh mục: "+catalogIdFind+" mà bạn muốn tìm");
                } else {
                    System.out.print("Bạn muốn thay đổi tên danh mục từ " + listCategories.get(isCheckIndexNumber).getCatalogName() + " thành : ");
                    do {
                        String catalogNameChange = sc.nextLine();
                        boolean isCheckTrung = isCheckTrungCatalogName(catalogNameChange);
                        if (isCheckTrung) {
                            System.err.println("Mã danh mục sản phẩm đã bị trùng, vui lòng nhập lại");
                        } else {
                            System.out.print("Đã thay đổi tên danh mục từ " + listCategories.get(isCheckIndexNumber).getCatalogName() + " thành : " + catalogNameChange);
                            listCategories.get(isCheckIndexNumber).setCatalogName(catalogNameChange);
                            System.out.print("\n");
                            break;
                        }
                    } while (true);
                }
                break;
            }else{
                System.err.println("Mã danh mục phải là số,vui lòng nhập lại");
            }
        }while (true);
    }


    //4.Xóa danh mục theo mã danh mục (Danh mục chưa chứa sản phẩm)
    public static void deleteCatalogByCatalogId(){
        System.out.print("Nhập vào mã danh mục mà bạn muốn xóa= ");
        do {
            String inputData=sc.nextLine();
            String regexNumber = "\\d+";
            if(Pattern.matches(regexNumber,inputData)){
                int catalogIdFind=Integer.parseInt(inputData);
                int isCheckFind=indexDataCatalogIdFind(catalogIdFind);
                if(isCheckFind<0){
                    System.out.println("Không tìm thấy mã danh mục : " + catalogIdFind+" mà bạn muốn xóa");
                    break;
                }else{
                   boolean isCheckCatalogIdByCatalogIdInProduct=isCheckCatalogIdInListProduct(catalogIdFind);
                   if(!isCheckCatalogIdByCatalogIdInProduct){
                       listCategories.remove(isCheckFind);
                       System.out.println("Đã xóa xong danh mục với mã danh mục là:"+catalogIdFind);
                       break;
                   }else{
                       System.out.println("Rất tiếc mã danh mục "+catalogIdFind+" có chứa sản phẩm,không thể xóa danh mục này");
                       break;
                   }
                }
            }else{
                System.err.println("Mã danh mục bắt buộc phải là số,vui lòng nhập lại");
            }

        }while (true);

    }

    //2. Hiển thị thông tin sản phẩm
    public static void displayDataProduct() {
        System.out.printf("%-20s%-20s%-20s%-20s%-30s%-40s\n", "Mã sản phẩm", "Tên sản phẩm", "Giá sản phẩm", "Tiêu đề sản phẩm", "Trạng thái sản phảm", "Tên danh mục thuộc về");
        for (Product pr : listProduct) {
            pr.displayData();
        }
    }

    // 3. Cập nhật giá sản phẩm theo mã sản phẩm
    public static void updatePriceByProductId() {
        System.out.print("Nhập vào mã sản phẩm mà bạn muốn thay đổi giá =");
        String inputProductId = sc.nextLine();
        int isCheckIndexProductId = indexDataProductIdFind(inputProductId);
        if (isCheckIndexProductId < 0) {
            System.out.println("Không tìm thấy mã sản phẩm: "+inputProductId+ " mà bạn muốn thay đổi giá");
        } else {
            System.out.print("Bạn muốn thay đổi giá của mã sản phẩm " + inputProductId + " từ " + listProduct.get(isCheckIndexProductId).getPrice() + " thành : ");
            float priceChange = Float.parseFloat(sc.nextLine());
            System.out.println("Đã thay đổi giá của mã sản phẩm " + inputProductId + " từ " + listProduct.get(isCheckIndexProductId).getPrice() + " thành : " + priceChange);
            listProduct.get(isCheckIndexProductId).setPrice(priceChange);
        }

    }
    //4. Xóa sản phẩm theo mã sản phẩm
    public static void deleteProductByProductId(){
        System.out.print("Nhập vào mã sản phẩm mà bạn muốn xóa =");
        String inputProductIdDelete=sc.nextLine();
        int isCheckIndexProductIdDelete=indexDataProductIdFind(inputProductIdDelete);
        if(isCheckIndexProductIdDelete<0){
            System.out.println("Không tìm thấy mã sản phẩm: "+inputProductIdDelete+ " mà bạn muốn xóa");
        }else{
            System.out.println("Đã xóa xong sản phẩm "+inputProductIdDelete);
            listProduct.remove(isCheckIndexProductIdDelete);
        }
    }
    //5. Sắp xếp sản phẩm theo giá sản phẩm tăng dần
    public static void sortByAscendingProductPrice(){
        listProduct.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int)(o1.getPrice()-o2.getPrice());
            }
        });
    }
    //6. Sắp xếp sản phẩm theo tên tăng dần
    public static void sortByAscendingProductName(){
        listProduct.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getProductName().compareTo(o2.getProductName());
            }
        });
    }
    //7. Thống kê số lượng sản phẩm theo danh mục sản phẩm
    public static void groupProductsByCatalogName(){
        List<String> listCatalogName=new ArrayList<>();
        for (Product pr:listProduct) {
           if(!listCatalogName.contains(pr.getCatalogId().getCatalogName())){
               listCatalogName.add(pr.getCatalogId().getCatalogName());
           }
        }
        System.out.println("Thống kê số lượng sản phẩm theo danh mục sản phẩm mà sản phẩm thuộc về là :");
        System.out.printf("%-40s%-40s\n","Tên danh mục","Số lượng sản phẩm");
        for (String itemCatalogName:listCatalogName) {
            int count=0;
            for (Product pr:listProduct) {
                if(pr.getCatalogId().getCatalogName().equals(itemCatalogName)){
                    count++;
                }
            }
            System.out.printf("%-40s%-40d\n",itemCatalogName,count);
            System.out.println("--------------------------------------------------------------");
        }
    }
    //8. Tìm kiếm sản phẩm theo tên sản phẩm
    public static void searchByProductName(){
        System.out.print("Nhập vào tên sản phẩm mà bạn muốn tìm kiếm = ");
        String findByProductName=sc.nextLine();
        boolean isFindProductName=false;
        for (Product pr:listProduct) {
            if(pr.getProductName().contains(findByProductName)){
                System.out.printf("%-20s%-20s%-20s%-20s%-30s%-40s\n", "Mã sản phẩm", "Tên sản phẩm", "Giá sản phẩm", "Tiêu đề sản phẩm", "Trạng thái sản phảm", "Tên danh mục thuộc về");
                pr.displayData();
                isFindProductName=true;
                break;
            }
        }
        if(!isFindProductName){
            System.out.println("Không tìm thấy sản phẩm theo sản phẩm mà bạn vừa nhập");
        }

    }

}
