package form.QLPM;

public class DSThuocSuDung {
	String loaiThuoc;
	String donVi;
	int soLuong;
	String cachDung;

	public DSThuocSuDung() {
		super();
	}

	public DSThuocSuDung(String loaiThuoc, String donVi, int soLuong, String cachDung) {
		super();
		this.loaiThuoc = loaiThuoc;
		this.donVi = donVi;
		this.soLuong = soLuong;
		this.cachDung = cachDung;
	}

	public String getLoaiThuoc() {
		return loaiThuoc;
	}

	public void setLoaiThuoc(String loaiThuoc) {
		this.loaiThuoc = loaiThuoc;
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

	public String getCachDung() {
		return cachDung;
	}

	public void setCachDung(String cachDung) {
		this.cachDung = cachDung;
	}
}
