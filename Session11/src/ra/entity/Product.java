package ra.entity;

import ra.IShop;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static ra.run.ShopManagement.*;
import static ra.run.ShopManagement.listCategories;

public class Product implements IShop<Product> {
    private String productId;
    private String productName;
    private float price;
    private String title;

    private Categories catalogId;

    private Boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float price, String title, Categories catalogId, Boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.catalogId = catalogId;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Categories getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Categories catalogId) {
        this.catalogId = catalogId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc, List<Product> listProduct) {
        System.out.print("Nhập vào mã sản phẩm gồm 5 ký tự bắt đầu là P = ");
        do {
            this.productId = sc.nextLine();
            boolean isCheckProductId = false;
            for (Product pr : listProduct) {
                if (pr.productId.equals(this.productId)) {
                    isCheckProductId = true;
                    break;
                }
            }
            if (isCheckProductId) {
                System.err.println("Mã sản phẩm đã bị trùng, vui lòng nhập lại");
            } else {
                if (this.productId.length() == 5 && this.productId.charAt(0) == 'P') {
                    break;
                } else {
                    System.err.println("Mã sản phẩm phải gồm 5 ký tự bắt đầu là P,vui lòng nhập lại");
                }
            }
        } while (true);
        System.out.print("Nhập vào tên sản phẩm = ");
        do {
            this.productName = sc.nextLine();
            boolean isCheckProductName = false;
            for (Product pr : listProduct) {
                if (pr.productName.equals(this.productName)) {
                    isCheckProductName = true;
                    break;
                }
            }
            if (isCheckProductName) {
                System.err.println("Tên sản phẩm đã bị trùng, vui lòng nhập lại");
            } else {
                break;
            }

        } while (true);
        System.out.print("Nhập vào giá sản phẩm = ");
        do {
            String inputPrice = sc.nextLine();
            String regexNumber = "\\d+";
            if (Pattern.matches(regexNumber, inputPrice)) {
                this.price = Integer.parseInt(inputPrice);
                break;
            } else {
                System.err.println("Giá sản phẩm phải là số,vui lòng nhập lại");
            }

        } while (true);
        System.out.print("Nhập vào tiêu đề sản phẩm = ");
        this.title = sc.nextLine();
        System.out.print("Nhập vào trạng thái sản phẩm (true/false)= ");
        do {
            String inputStatus = sc.nextLine();
            if (inputStatus.equals("true") || inputStatus.equals("false")) {
                this.status = Boolean.parseBoolean(inputStatus);
                break;
            } else {
                System.err.println("Trạng thái sản phẩm phải là true/false,vui lòng nhập lại");
            }
        } while (true);
    }

    @Override
    public void displayData() {
        String statusValue = this.status ? "Active" : "InActive";
        System.out.printf("%-20s%-20s%-20f%-20s%-30s%-40s\n", this.productId, this.productName, this.price, this.title, statusValue, getCatalogId().getCatalogName());
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static int indexDataProductIdFind(String productIdFind) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).productId.equals(productIdFind)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isCheckCatalogIdInListProduct(int inputCatalogId) {
        for (Product pr : listProduct) {
            if (pr.getCatalogId().getCatalogId() == inputCatalogId) {
                return true;
            }
        }
        return false;
    }
}
