package form.QLPM;

public class HoaDonThanhToan {
	String hoTen;
	String ngayKham;
	int thanhTien;
	String maThuoc;
	public HoaDonThanhToan(String hoTen, String ngayKham, int thanhTien, String maThuoc) {
		super();
		this.hoTen = hoTen;
		this.ngayKham = ngayKham;
		this.thanhTien = thanhTien;
		this.maThuoc = maThuoc;
	}
	public HoaDonThanhToan() {
		super();
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getNgayKham() {
		return ngayKham;
	}
	public void setNgayKham(String ngayKham) {
		this.ngayKham = ngayKham;
	}
	public int getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}
	public String getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	
}
