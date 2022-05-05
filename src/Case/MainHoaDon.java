package Case;

import java.util.Scanner;

public class MainHoaDon {

    public static void main(String[] args) {
        QuanLyHoaDon quanLyHoaDon = new QuanLyHoaDon();
        QuanLyPhong quanLyPhong = new QuanLyPhong();

        Scanner sc = new Scanner(System.in);
        Scanner nhapChu = new Scanner(System.in);
        Scanner nhapChu1 = new Scanner(System.in);
        Scanner nhapChu2 = new Scanner(System.in);

        System.out.println("Mời nhập vào thông tin hóa đơn");
        System.out.println("Nhập họ tên khách làng chơi:");
        String ten = nhapChu.nextLine();
        System.out.println("Nhập thời gian khách vào phòng:");
        double tgVao = sc.nextInt();
        System.out.println("Nhập thời gian khách trả phòng");
        double tgRa = sc.nextInt();
        System.out.println("Nhập tiền khách ăn uống trong phòng");
        double tAnUong = sc.nextInt();
        System.out.println("Chọn phòng khách vào: (Nhập số phòng)");
        quanLyPhong.hienThi();
        int idOfPhong = sc.nextInt();
        quanLyHoaDon.them(new HoaDon(ten,tgVao,tgRa,tAnUong,QuanLyPhong.phongList.get(quanLyPhong.timKiemphongSo(idOfPhong))));
        quanLyHoaDon.hienThi();










    }
}

