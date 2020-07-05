package form.QLPM;

public class DonGiaThuoc {
	String maThuoc,tenThuoc;
	int donGia;
	public String getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public DonGiaThuoc() {
		super();
	}
	public DonGiaThuoc(String maThuoc, String tenThuoc, int donGia) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.donGia = donGia;
	}
}
