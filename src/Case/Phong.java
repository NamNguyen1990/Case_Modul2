package Case;

public class Phong {
    private int phongSo;
    private String loaiPhong;
    private int giaPhong;
    private String trangThai;

    public Phong() {
    }

    public Phong(int phongSo, String loaiPhong, int giaPhong, String trangThai) {
        this.phongSo = phongSo;
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
        this.trangThai = trangThai;
    }

    public int getPhongSo() {
        return phongSo;
    }

    public void setPhongSo(int phongSo) {
        this.phongSo = phongSo;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public int getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(int giaPhong) {
        this.giaPhong = giaPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Phong{" +
                "phongSo = " + phongSo +
                ", loaiPhong = " + loaiPhong  +
                ", giaPhong = " + giaPhong +
                ", trangThai = " + trangThai +
                '}';
    }
}
