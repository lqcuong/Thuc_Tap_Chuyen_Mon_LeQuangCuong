package form.QLPM;

public class BaoCaoSDThuoc {
	String tenThuoc;
	String donVi;
	int soLuong;
	int soLanDung;
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getSoLanDung() {
		return soLanDung;
	}
	public void setSoLanDung(int soLanDung) {
		this.soLanDung = soLanDung;
	}
	public BaoCaoSDThuoc(String tenThuoc, String donVi, int soLuong, int soLanDung) {
		super();
		this.tenThuoc = tenThuoc;
		this.donVi = donVi;
		this.soLuong = soLuong;
		this.soLanDung = soLanDung;
	}
	public BaoCaoSDThuoc() {
		super();
	}
}
