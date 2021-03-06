package Case;

import java.util.InputMismatchException;
import java.util.Scanner;

public class
MainHoaDon {

    public static void main(String[] args) {
        QuanLyHoaDon quanLyHoaDon = new QuanLyHoaDon();
        QuanLyPhong quanLyPhong = new QuanLyPhong();

        Scanner sc = new Scanner(System.in);
        Scanner nhapChu = new Scanner(System.in);
        Scanner nhapChu1 = new Scanner(System.in);
        Scanner nhapChu2 = new Scanner(System.in);

        int luaChon = -1;

        System.out.println("=====Menu Hóa Đơn====");
        System.out.println("1 - Hiển thị danh sách hóa đơn");
        System.out.println("2 - Tạo hóa đơn");
        System.out.println("3 - Sửa thông tin hóa đơn theo số CMND của khách");
        System.out.println("4 - Tìm kiếm hóa đơn theo khoảng thời gian");
        System.out.println("5 - Tính tiền hóa đơn - Xóa luôn hóa đơn");
        System.out.println("6 - Xuất hoá đơn(xuất file csv)");
        System.out.println("7 - Xem lại Menu!");
        System.out.println("8 - Thoát");

        do {
            boolean check = false;
            while (!check) {
                System.out.println("Mời bạn chọn chức năng");
                try {
                    luaChon = sc.nextInt();
                    if (luaChon<0 || luaChon >8) throw new Exception();
                    check = true;
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println(ANSI_RED + "Chỉ được nhập số từ 0 --> 8" + ANSI_RESET);
                }
            }

            if (luaChon == 1) {
                System.out.println(ANSI_BLUE + "====Danh sách hóa đơn!====" + ANSI_RESET);
                quanLyHoaDon.hienThiFull();

            }
            else if (luaChon == 2) {

                System.out.println("Mời nhập vào thông tin hóa đơn");
                System.out.println("Mời nhập số CMND của khách chơi phòng");
                String soCMND = nhapChu.nextLine();
                System.out.println("Nhập họ tên khách làng chơi:");
                String ten = nhapChu.nextLine();

                int tgVao = -1;
                boolean check1 = false;
                while (!check1) {
                    System.out.println("Nhập thời gian khách vào phòng");
                    try {
                        tgVao = sc.nextInt();
                        check1 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }

                int tgRa = -1;
                boolean check2 = false;
                while (!check2) {
                    System.out.println("Nhập thời gian khách trả phòng");
                    try {
                        tgRa = sc.nextInt();
                        check2 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }

                int tAnUong = -1;
                boolean check3 = false;
                while (!check3) {
                    System.out.println("Nhập tiền khách ăn uống trong phòng");
                    try {
                        tAnUong = sc.nextInt();
                        check3 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }

                System.out.println("Chọn phòng khách vào: (Nhập số phòng)");
                quanLyPhong.hienThi();
                int idOfPhong = sc.nextInt();
                quanLyHoaDon.them(new HoaDon(soCMND,ten,tgVao,tgRa,tAnUong,QuanLyPhong.phongList.get(quanLyPhong.timKiemphongSo(idOfPhong))));
//                quanLyHoaDon.hienThi();

            }
            else if (luaChon == 3) {

            }
            else if (luaChon == 4) {

            }
            else if (luaChon == 5) {
                int sum = 0;
//                int sum1 = 0;

                System.out.println("Nhập vào số CMND của khách");
                String soCMND = nhapChu.nextLine();
                quanLyHoaDon.timKiemCMND1(soCMND);
                System.out.println("Nhập số phòng khách vào mua vui: ");
                int idOfPhong = sc.nextInt();
//                int idOfPhong1 = sc.nextInt();

                sum = QuanLyPhong.phongList.get(quanLyPhong.timKiemphongSo(idOfPhong)).getGiaPhong()*(quanLyHoaDon.hoaDonList.get(quanLyHoaDon.timKiemCMND(soCMND)).getTgRa() - quanLyHoaDon.hoaDonList.get(quanLyHoaDon.timKiemCMND(soCMND)).getTgVao()) + quanLyHoaDon.hoaDonList.get(quanLyHoaDon.timKiemCMND(soCMND)).gettAnUong();
//                sum1 = (QuanLyPhong.phongList.get(quanLyPhong.timKiemphongSo(idOfPhong)).getGiaPhong() * (quanLyHoaDon.hoaDonList.get(quanLyPhong.timKiemphongSo(idOfPhong1)).getTgRa() - quanLyHoaDon.hoaDonList.get(quanLyPhong.timKiemphongSo(idOfPhong1)).getTgVao())) + quanLyHoaDon.hoaDonList.get(quanLyPhong.timKiemphongSo(idOfPhong1)).gettAnUong();
//                System.out.println("Tổng tiền khách phải trả là: " + sum1);
//                Viết thêm hàm tìm kiếm phòng số bao nhiêu, hàm trên không đúng! Viết hàm này trong phần Quản Lý hóa đơn chưa có nên ko gọi đúng đc!

                System.out.println("Tổng tiền khách phải nôn ra là: " + sum);
                quanLyHoaDon.xoaHD(soCMND);
            }
            else if (luaChon == 6) {

            }
            else if (luaChon == 7) {
                System.out.println("=====Menu Hóa Đơn====");
                System.out.println("1 - Hiển thị danh sách hóa đơn");
                System.out.println("2 - Tạo hóa đơn");
                System.out.println("3 - Sửa thông tin hóa đơn theo số CMND của khách");
                System.out.println("4 - Tìm kiếm hóa đơn theo khoảng thời gian");
                System.out.println("5 - Tính tiền hóa đơn - Xóa luôn hóa đơn");
                System.out.println("6 - Xuất hoá đơn(xuất file csv)");
                System.out.println("7 - Xem lại Menu!");
                System.out.println("8 - Thoát");
            }


        } while (luaChon != 8);




















    }

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
}

