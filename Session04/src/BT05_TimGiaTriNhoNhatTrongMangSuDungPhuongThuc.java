public class BT05_TimGiaTriNhoNhatTrongMangSuDungPhuongThuc {
    public static void main(String[] args) {
//        chúng ta sẽ phát triển một chương trình cho phép tìm kiếm giá trị
//        nhỏ nhất trong một mảng cho trước.
        int [] arrInt={3,5,7,8,9,13,16,1,24,17,44,78};
        int minArrInt=minArray(arrInt);
        System.out.println("Giá trị nhỏ nhất trong mảng là :"+minArrInt);

    }
    public static int minArray(int [] array){
        int min= array[0];
        for (int i = 0; i <array.length ; i++) {
            if(min>array[i]){
                min=array[i];
            }
        }
        return min;
    }

}
