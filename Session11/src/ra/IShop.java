package ra;

import java.util.List;
import java.util.Scanner;
public interface IShop <U>{
    void inputData(Scanner sc, List<U> listData);
    void displayData();
}
