package ra.entity;

import ra.IShop;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static ra.run.ShopManagement.sc;
import static ra.run.ShopManagement.listCategories;

public class Categories implements IShop<Categories> {

    private int catalogId;
    private String catalogName;
    private Boolean status;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, Boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.status = status;
    }


    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc, List<Categories> listCategories) {
        System.out.print("Nhập vào mã danh mục sản phẩm (phải là số)= ");
        do {
            String isCheckCatalogIdNumber = sc.nextLine();
            String regexNumber = "\\d+";
            if (Pattern.matches(regexNumber, isCheckCatalogIdNumber)) {
                this.catalogId = Integer.parseInt(isCheckCatalogIdNumber);
                boolean isCheckCatalogId = false;
                for (Categories ca : listCategories) {
                    if (ca.catalogId == this.catalogId) {
                        isCheckCatalogId = true;
                        break;
                    }
                }
                if (isCheckCatalogId) {
                    System.err.println("Mã danh mục sản phẩm đã bị trùng, vui lòng nhập lại");
                } else {
                    break;
                }
            } else {
                System.err.println("Mã danh mục sản phẩm phải là số, vui lòng nhập lại");
            }
        } while (true);
        System.out.print("Nhập vào tên danh mục sản phẩm = ");
        do {
            boolean isCheckCatalogName = false;
            this.catalogName = sc.nextLine();
            for (Categories ca : listCategories) {
                if (ca.catalogName.equals(this.catalogName)) {
                    isCheckCatalogName = true;
                    break;
                }
            }
            if (isCheckCatalogName) {
                System.err.println("Tên danh mục sản phẩm đã bị trùng, vui lòng nhập lại");
            } else {
                break;
            }

        } while (true);
        System.out.print("Nhập vào trạng thái danh mục (true/false)=");

        do {
            String inputStatus = sc.nextLine();
            if (inputStatus.equals("true") || inputStatus.equals("false")) {
                this.status = Boolean.parseBoolean(inputStatus);
                break;
            } else {
                System.err.println("Trạng thái danh mục phải là true/false, vui lòng nhập lại");
            }
        } while (true);
    }

    @Override
    public void displayData() {
        String statusValue = this.status ? "Active" : "InActive";
        System.out.printf("%-30d%-30s%-30s\n", this.catalogId, this.catalogName, statusValue);
    }

    public static int indexDataCatalogIdFind(int catalogIdFind) {
        for (int i = 0; i < listCategories.size(); i++) {
            if (listCategories.get(i).catalogId == catalogIdFind) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isCheckTrungCatalogName(String catalogNameCheck) {
        for (Categories ca : listCategories) {
            if (ca.catalogName.equals(catalogNameCheck)) {
                return true;
            }
        }
        return false;
    }

}
