package Case;

import java.util.ArrayList;
import java.util.List;

public class QuanLyHoaDon {

    List<HoaDon> hoaDonList = new ArrayList<>();
    private int soHD = 0;

    public QuanLyHoaDon() {
    }

    public QuanLyHoaDon(List<HoaDon> hoaDonList, int soHD) {
        this.hoaDonList = hoaDonList;
        this.soHD = soHD;
    }

    public List<HoaDon> getHoaDonList() {
        return hoaDonList;
    }

    public void setHoaDonList(List<HoaDon> hoaDonList) {
        this.hoaDonList = hoaDonList;
    }

    public int getSoHD() {
        return soHD;
    }

    public void setSoHD(int soHD) {
        this.soHD = soHD;
    }

    public void them (HoaDon hoaDon) {
        hoaDonList.add(hoaDon);
        soHD++;
        System.out.println(ANSI_BLUE + "Bạn đã thêm thành công 1 hóa đơn mới" + ANSI_RESET);
    }
    public void xoaHD (String soCMND) {
        int indexOf = timKiemCMND(soCMND);
        if (indexOf == -1) {
            System.out.println("Không có số CMND này");
        } else {
            hoaDonList.remove(indexOf);
        }
    }

    public void hienThiFull() {
        int soHD = 0;
        boolean check = false;
        for (int i=0; i<hoaDonList.size(); i++) {
            System.out.println(hoaDonList.get(i));
            soHD++;
            System.out.println("Số hóa đơn thứ: " + soHD);
            System.out.println("------------------------------------------------------------");
            check = true;
        }

        if (check == false) {
            System.out.println(ANSI_RED + "Chưa có hóa đơn nào được thêm mới!" + ANSI_RESET);
        }
    }

    public int timKiemCMND (String soCMND) {  // Cái này trả về vị trí (chỉ vị trí ko hiển thị thông tin) phục vụ cho việc sửa theo Số CMND nhập vào
        for (int i = 0; i < hoaDonList.size(); i++) {
            if (hoaDonList.get(i).getSoCMND().equals(soCMND)) {
                return i;
            }
        }
        return -1;
    }
    public void suaHoaDon (String soCMND, HoaDon hoaDon) { // Cái này sửa theo phòng Số nhập vào
        int indexOf = timKiemCMND(soCMND);
        if (indexOf == -1) {
            System.out.println(ANSI_RED + "Không có phòng nào có số như trên" + ANSI_RESET);
        } else {
            hoaDonList.set(indexOf, hoaDon);
            System.out.println(ANSI_BLUE + "Bạn đã sửa thành công thông tin Phòng trên" + ANSI_RESET);
        }
    }

    public void timKiemCMND1 (String soCMND) {
        boolean check = false;
        for (int i=0; i<hoaDonList.size(); i++) {
            if (hoaDonList.get(i).getSoCMND().equals(soCMND)) {
                System.out.println(hoaDonList.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println(ANSI_RED + "Nhập không đúng (không có số CMND này trong hóa đơn)" + ANSI_RESET);
        }
    }














    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
}
