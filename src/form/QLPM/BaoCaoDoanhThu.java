package form.QLPM;

import java.util.Date;

public class BaoCaoDoanhThu {
	Date ngayBC;
	int soBN;
	int doanhThu;
	float tyLe;
	public Date getNgayBC() {
		return ngayBC;
	}
	public void setNgayBC(Date ngayBC) {
		this.ngayBC = ngayBC;
	}
	public int getSoBN() {
		return soBN;
	}
	public void setSoBN(int soBN) {
		this.soBN = soBN;
	}
	public int getDoanhThu() {
		return doanhThu;
	}
	public void setDoanhThu(int doanhThu) {
		this.doanhThu = doanhThu;
	}
	public float getTyLe() {
		return tyLe;
	}
	public void setTyLe(float tyLe) {
		this.tyLe = tyLe;
	}
	public BaoCaoDoanhThu(Date ngayBC, int soBN, int doanhThu, float tyLe) {
		super();
		this.ngayBC = ngayBC;
		this.soBN = soBN;
		this.doanhThu = doanhThu;
		this.tyLe = tyLe;
	}
	public BaoCaoDoanhThu() {
		super();
	}
}
