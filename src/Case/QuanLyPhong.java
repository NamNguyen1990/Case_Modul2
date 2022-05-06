package Case;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuanLyPhong {
    public static List<Phong> phongList = new ArrayList<>();

    public static final String CON = "Con";
    public static final String HET = "Het";

    public static List<Phong> getPhongList() {
        return phongList;
    }

    public static void setPhongList(List<Phong> phongList) {
        QuanLyPhong.phongList = phongList;
    }

    static {

        try {
            QuanLyPhong.setPhongList(GhiDocFile.readFromFile("KtraMD2.csv",QuanLyPhong.phongList));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void them (Phong phong) {
        phongList.add(phong);
        System.out.println(ANSI_BLUE + "Bạn đã thêm thành công 1 phòng mới" + ANSI_RESET);
    }

    public void hienThi() {
        boolean check = false;
        for (int i=0; i<phongList.size(); i++) {
            System.out.println(phongList.get(i));
            check = true;
        }
        if (check == false) {
            System.out.println(ANSI_RED + "Chưa có phòng nào được thêm mới!" + ANSI_RESET);
        }
    }

    public void timKiemPhongSo(int phongSo) {   // Cái này trả về thông tin (hiển thị luôn thông tin) phục vụ cho tìm kiếm theo số Phòng
        boolean check = false;
        for (int i=0; i<phongList.size(); i++) {
            if (phongList.get(i).getPhongSo() == phongSo) {
                System.out.println(phongList.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println(ANSI_RED + "Không có Phòng nào có số này" + ANSI_RESET);
        }
    }

    public void timKiemPhongGia (String giaPhong) {  // Cái này trả về các thông tin (hiển thị luôn thông tin) phục vụ cho việc tìm kiếm theo giá nhập vào
        boolean check = false;
        for (int i=0; i<phongList.size(); i++) {
            if (String.valueOf(phongList.get(i).getGiaPhong()).contains(giaPhong)) {
                System.out.println(phongList.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println(ANSI_RED + "Nhập không đúng (không có Phòng này)" + ANSI_RESET);
        }
    }
    public int timKiemphongSo (int phongSo) {  // Cái này trả về vị trí (chỉ vị trí ko hiển thị thông tin) phục vụ cho việc sửa theo phòng Số nhập vào
        for (int i = 0; i < phongList.size(); i++) {
            if (phongList.get(i).getPhongSo() == phongSo) {
                return i;
            }
        }
        return -1;
    }
    public void suaPhongSo (int phongSo, Phong phong) { // Cái này sửa theo phòng Số nhập vào
        int indexOf = timKiemphongSo(phongSo);
        if (indexOf == -1) {
            System.out.println(ANSI_RED + "Không có phòng nào có số như trên" + ANSI_RESET);
        } else {
            phongList.set(indexOf, phong);
            System.out.println(ANSI_BLUE + "Bạn đã sửa thành công thông tin Phòng trên" + ANSI_RESET);
        }
    }

    public void timKiemConPhong() {   // Cái này trả về các vị trí(hiển thị luôn thông tin) phục vụ cho tìm kiếm theo Phòng còn
        boolean check = false;
        for (int i=0; i<phongList.size(); i++) {
            if (phongList.get(i).getTrangThai().equals(CON)) {
                System.out.println(phongList.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println(ANSI_RED + "Tất cả các phòng đều ở trạng thái Hết!" + ANSI_RESET);
        }
    }

    public void timKiemHetPhong() {   // Cái này trả về các vị trí(hiển thị luôn thông tin) phục vụ cho tìm kiếm theo Phòng hết
        boolean check = false;
        for (int i=0; i<phongList.size(); i++) {
            if (phongList.get(i).getTrangThai().equals(HET)) {
                System.out.println(phongList.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println(ANSI_RED + "Tất cả đều đang ở trạng thái Còn Phòng!" + ANSI_RESET);
        }
    }

    public void chuyensoPConsangHet (int soPhong) { // Cái này sửa theo số CMND nhập vào
        int indexOf = timKiemphongSo(soPhong);
        if (indexOf == -1) {
            System.out.println(ANSI_RED + "Không có Phòng nào có số này" + ANSI_RESET);
        } else {
            phongList.get(indexOf).setTrangThai("Hết Phòng");
            System.out.println(ANSI_BLUE + "Bạn đã cập nhật thành công!" + ANSI_RESET);
        }
    }

    public void chuyensoPHetsangCon (int soPhong) { // Cái này sửa theo số CMND nhập vào
        int indexOf = timKiemphongSo(soPhong);
        if (indexOf == -1) {
            System.out.println(ANSI_RED + "Không có Phòng nào có số này" + ANSI_RESET);
        } else {
            phongList.get(indexOf).setTrangThai("Còn Phòng");
            System.out.println(ANSI_BLUE + "Bạn đã cập nhật thành công!" + ANSI_RESET);
        }
    }

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
}
