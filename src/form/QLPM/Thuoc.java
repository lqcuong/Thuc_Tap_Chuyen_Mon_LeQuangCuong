package form.QLPM;

public class Thuoc {
	String maThuoc,tenThuoc,donVi,cachDung;

	public Thuoc(String maThuoc, String tenThuoc, String donVi, String cachDung) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.donVi = donVi;
		this.cachDung = cachDung;
	}

	public Thuoc() {
		super();
	}

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

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public String getCachDung() {
		return cachDung;
	}

	public void setCachDung(String cachDung) {
		this.cachDung = cachDung;
	}
	
}
