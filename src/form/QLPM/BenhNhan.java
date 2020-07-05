package form.QLPM;

public class BenhNhan {
	private String maBN;
	private String hoTen;
	private int gioiTinh;
	private int namSinh;
	private String diaChi;
	public BenhNhan() {
		super();
	}
	public BenhNhan(String maBN, String hoTen, int gioiTinh, int namSinh, String diaChi) {
		super();
		this.maBN = maBN;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
	}
	public String getMaBN() {
		return maBN;
	}
	public void setMaBN(String maBN) {
		this.maBN = maBN;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "BenhNhan [maBN=" + maBN + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", namSinh=" + namSinh
				+ ", diaChi=" + diaChi + "]";
	}
}
