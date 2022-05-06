package Case;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainPhong {

    public static void main(String[] args) throws IOException {
        QuanLyPhong quanLyPhong = new QuanLyPhong();

        Scanner sc = new Scanner(System.in);
        Scanner nhapChu = new Scanner(System.in);
        Scanner nhapChu1 = new Scanner(System.in);
        Scanner nhapChu2 = new Scanner(System.in);

        int luaChon = -1;

        System.out.println("=====Menu Chọn Phòng====");
//        System.out.println(ANSI_RED + "NOTE: Nhập 0 lần đầu tiên để hiện thị phòng có sẵn trước khi thêm mới, nếu không sẽ mất toàn bộ dữ liệu!" + ANSI_RESET);
//        System.out.println("0 - Hiển thị danh sách phòng có sẵn");
        System.out.println("1 - Hiển thị số lượng phòng");
        System.out.println("2 - Thêm 1 phòng mới");
        System.out.println("3 - Sửa thông tin phòng theo số phòng");
        System.out.println("4 - Hiển thị Phòng Còn/Phòng Hết");
        System.out.println("5 - Thay đổi trạng thái phòng (Từ Còn phòng --> Hết phòng hoặc ngược lại)");
        System.out.println("6 - Tìm Phòng theo số phòng (hiển thị 1 Phòng duy nhất)");
        System.out.println("7 - Tìm Phòng theo giá {hiển thị" + " " + ANSI_RED + "(những phòng)" + ANSI_RESET + " " + "cùng mức giá}");
        System.out.println("8 - Xem lại danh sách Menu");
        System.out.println("9 - Thoát");

        do {

            boolean check2 = false;
            while (!check2) {
                System.out.println("Mời bạn chọn chức năng");
                try {
                    luaChon = sc.nextInt();
                    if (luaChon<0 || luaChon >9) throw new Exception();
                    check2 = true;
                } catch (InputMismatchException e) {
                    System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println(ANSI_RED + "Chỉ được nhập số từ 0 --> 9" + ANSI_RESET);
                }
            }
//            if (luaChon == 0) {
//
//                System.out.println("Danh sách phòng có sẵn");
//                QuanLyPhong.setPhongList(GhiDocFile.readFromFile("KtraMD2.csv",quanLyPhong.phongList));
//
//            }
            if (luaChon == 1) {
                System.out.println(ANSI_BLUE + "====Danh sách phòng====" + ANSI_RESET);
                quanLyPhong.hienThi();
            }
            else if (luaChon == 2) {
                System.out.println("Mời nhập thông tin phòng mới");
                int phongSo = -1;
                boolean check = false;
                while (!check) {
                    System.out.println("Nhập vào phòng số");
                    try {
                        phongSo = sc.nextInt();
                        check = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }
                System.out.println("Nhập vào loại phòng");
                String loaiPhong = nhapChu.nextLine();
                int giaPhong = -1;
                boolean check1 = false;
                while (!check1) {
                    System.out.println("Nhập vào giá phòng");
                    try {
                        giaPhong = sc.nextInt();
                        check1 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }
                System.out.println("Nhập vào trạng thái của phòng (Còn Phòng" + ANSI_RED + "(Con)" + ANSI_RESET + "/Hết Phòng" + ANSI_RED+ "(Het)"+ ANSI_RESET +")");
                String trangThai = nhapChu.nextLine();

                Phong phong = new Phong(phongSo,loaiPhong,giaPhong,trangThai);

                System.out.println("Bạn có muốn thêm Phòng này vào danh sách phòng mới không?" + ANSI_RED + "[Chọn: Y/E(Exit) hoặc nhập bất kỳ để không thêm]" + ANSI_RESET);
                System.out.println(ANSI_RED + "NOTE: Nhập 0 lần đầu tiên để hiện thị phòng có sẵn trước khi thêm phòng mới, nếu không sẽ mất toàn bộ dữ liệu!" + ANSI_RESET);
                char result, a = 'Y', b = 'E';
                result = nhapChu1.next().charAt(0);
                if (result == a) {
                    quanLyPhong.them(phong);
                    GhiDocFile.writeToFile("KtraMD2.csv",quanLyPhong.phongList);
                }
                if (result == b) {
                    System.exit(0);
                }

            }
            else if (luaChon == 3) {
                int soPhongS = -1;
                boolean check3 = false;
                while (!check3) {
                    System.out.println("Nhập số Phòng muốn sửa là:");
                    try {
                        soPhongS = sc.nextInt();
                        check3 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }

                int soPhongM = -1;
                boolean check4 = false;
                while (!check4) {
                    System.out.println("Sửa Phòng này thành số mới là:");
                    try {
                        soPhongM = sc.nextInt();
                        check4 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }

                System.out.println("Nhập vào loại cho Phòng mới:");
                String loaiPhong = nhapChu.nextLine();

                int giaPhong = -1;
                boolean check5 = false;
                while (!check5) {
                    System.out.println("Nhập vào giá mới cho Phòng này:");
                    try {
                        giaPhong = sc.nextInt();
                        check5 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }

                System.out.println("Nhập trạng thái mới cho Phòng này là:");
                String trangThai = nhapChu.nextLine();

                Phong phong1 = new Phong(soPhongM,loaiPhong,giaPhong,trangThai);
                quanLyPhong.suaPhongSo(soPhongS,phong1);
                GhiDocFile.writeToFile("KtraMD2.csv",quanLyPhong.phongList);

            }
            else if (luaChon == 4) {

                System.out.println("Bạn muốn hiển thị Phòng ở trạng thái Còn Phòng hay Hết Phòng?" + ANSI_RED + "[Chọn: C/H/E(Exit) hoặc nhập bất kỳ để thoát]" + ANSI_RESET);
                char result, a = 'C', b = 'H', c = 'E';
                result = nhapChu2.next().charAt(0);

                if (result == a) {
                    quanLyPhong.timKiemConPhong();
                }
                if (result == b) {
                    quanLyPhong.timKiemHetPhong();
                }
                if (result == c) {
                    System.exit(0);
                }

            }
            else if (luaChon == 5) {

                int soPhongCN = -1;
                boolean check6 = false;
                while (!check6) {
                    System.out.println("Nhập số Phòng cần cập nhật trạng thái!");
                    try {
                        soPhongCN = sc.nextInt();
                        check6 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }

                System.out.println("Bạn muốn Cập nhật Phòng này về trạng thái Còn Phòng hay Hết Phòng?" + ANSI_RED + "[Chọn: C/H/E(Exit) hoặc nhập bất kỳ để thoát]" + ANSI_RESET);
                char result, a = 'C', b = 'H', c = 'E';
                result = nhapChu2.next().charAt(0);

                if (result == a) {
                    quanLyPhong.chuyensoPHetsangCon(soPhongCN);
                    GhiDocFile.writeToFile("KtraMD2.csv",quanLyPhong.phongList);
                }
                if (result == b) {
                    quanLyPhong.chuyensoPConsangHet(soPhongCN);
                    GhiDocFile.writeToFile("KtraMD2.csv",quanLyPhong.phongList);
                }
                if (result == c) {
                    System.exit(0);
                }

            }
            else if (luaChon == 6) {

                int phongSo = -1;
                boolean check3 = false;
                while (!check3) {
                    System.out.println("Nhập Phòng số mấy cần tìm");
                    try {
                        phongSo = sc.nextInt();
                        check3 = true;
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Chỉ được nhập số" + ANSI_RESET);
                        sc.nextLine();
                    }
                }
                quanLyPhong.timKiemPhongSo(phongSo);

            }
            else if (luaChon == 7) {

                System.out.println("Nhập vào giá Phòng cần tìm");
                String giaPhong = nhapChu.nextLine();
                quanLyPhong.timKiemPhongGia(giaPhong);

            }
            else if (luaChon == 8) {
                System.out.println("=====Menu Chọn Phòng====");
                System.out.println(ANSI_RED + "NOTE: Nhập 0 lần đầu tiên để hiện thị phòng có sẵn trước khi thêm mới, nếu không sẽ mất toàn bộ dữ liệu!" + ANSI_RESET);
                System.out.println("0 - Hiển thị danh sách phòng có sẵn");
                System.out.println("1 - Hiển thị số lượng phòng");
                System.out.println("2 - Thêm 1 phòng mới");
                System.out.println("3 - Sửa thông tin phòng theo số phòng");
                System.out.println("4 - Hiển thị Phòng Còn/Phòng Hết");
                System.out.println("5 - Thay đổi trạng thái phòng (Từ Còn phòng --> Hết phòng hoặc ngược lại)");
                System.out.println("6 - Tìm Phòng theo số phòng (hiển thị 1 Phòng duy nhất)");
                System.out.println("7 - Tìm Phòng theo giá {hiển thị" + " " + ANSI_RED + "(những phòng)" + ANSI_RESET + " " + "cùng mức giá}");
                System.out.println("8 - Xem lại danh sách Menu");
                System.out.println("9 - Thoát");
            }
        } while (luaChon != 9);
    }

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


}
