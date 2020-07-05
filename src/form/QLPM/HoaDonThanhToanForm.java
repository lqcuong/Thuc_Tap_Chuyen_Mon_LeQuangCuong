package form.QLPM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.border.LineBorder;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HoaDonThanhToanForm extends JFrame {

	private JPanel contentPane;
	static String maPhieuKham=new String();
	private JTextField txtHoTen;
	private JTextField txtNgayKham;
	private JTextField txtTienKham;
	private JTextField txtTongTien;
	private JTextField txtTienThuoc;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	DecimalFormat df=new DecimalFormat("#,###");
	public HoaDonThanhToanForm() {
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Họ và tên:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(28, 46, 100, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày khám:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setBounds(341, 46, 100, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tiền khám:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setBounds(28, 117, 100, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tiền thuốc:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_3.setBounds(341, 115, 100, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tổng:");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(379, 184, 62, 25);
		contentPane.add(lblNewLabel_3_1);
		
		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		txtHoTen.setHorizontalAlignment(SwingConstants.TRAILING);
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHoTen.setBounds(136, 46, 170, 25);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		txtNgayKham = new JTextField();
		txtNgayKham.setEditable(false);
		txtNgayKham.setHorizontalAlignment(SwingConstants.TRAILING);
		txtNgayKham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNgayKham.setColumns(10);
		txtNgayKham.setBounds(447, 46, 170, 25);
		contentPane.add(txtNgayKham);
		
		txtTienKham = new JTextField();
		txtTienKham.setEditable(false);
		txtTienKham.setHorizontalAlignment(SwingConstants.TRAILING);
		txtTienKham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTienKham.setColumns(10);
		txtTienKham.setBounds(447, 115, 170, 25);
		contentPane.add(txtTienKham);
		
		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setHorizontalAlignment(SwingConstants.TRAILING);
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(447, 184, 170, 25);
		contentPane.add(txtTongTien);
		
		txtTienThuoc = new JTextField();
		txtTienThuoc.setEditable(false);
		txtTienThuoc.setHorizontalAlignment(SwingConstants.TRAILING);
		txtTienThuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTienThuoc.setColumns(10);
		txtTienThuoc.setBounds(136, 115, 170, 25);
		contentPane.add(txtTienThuoc);
		
		lblNewLabel_4 = new JLabel("VNĐ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_4.setBounds(306, 115, 35, 25);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("VNĐ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_5.setBounds(618, 115, 35, 25);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("VNĐ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_6.setBounds(618, 184, 35, 25);
		contentPane.add(lblNewLabel_6);
		this.setSize(732, 300);
		showChiTietHoaDon();
	}
	public static void createHoaDonThanhToan(String maPK) {
		maPhieuKham=maPK;
		HoaDonThanhToanForm hd=new HoaDonThanhToanForm();
		hd.setVisible(true);
		hd.setLocationRelativeTo(null);
		System.out.println(maPhieuKham);
	}
	public Vector<HoaDonThanhToan> getChiTietHoaDon(String query) {
		System.out.println("AAA");
		Vector<HoaDonThanhToan> hd=new Vector<HoaDonThanhToan>();
		Connection connection=ConnectDatabaseSQL.connectSQL();
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				hd.add(new HoaDonThanhToan(rs.getString("HoTen"), rs.getString("NgayKham"), rs.getInt("ThanhTien"),rs.getString("MaThuoc")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		
		return hd;
	}
	public void showChiTietHoaDon() {
		String query="select BN.HoTen,PK.NgayKham,T.DonGia,CTHD.SoLuongThuoc,T.DonGia*CTHD.SoLuongThuoc as ThanhTien,T.MaThuoc from HoaDon HD, PhieuKham PK, BenhNhan BN,Thuoc T,ChiTietHD CTHD,Benh B where BN.MaBN=PK.MaBN and PK.MaPhieuKham=HD.MaPhieuKham and HD.MaHoaDon=CTHD.MaHoaDon and CTHD.MaThuoc=T.MaThuoc and B.MaBenh=T.MaBenh and PK.MaPhieuKham='"+maPhieuKham+"'";
		Vector<HoaDonThanhToan>hd=getChiTietHoaDon(query);
		int tk=0;
		int tt=0;
		for(int i=0;i<hd.size();i++) {
			if(hd.get(i).getMaThuoc().equals("Thuoc0000")) {
				tt=hd.get(i).getThanhTien();
			}else {
				tk+=hd.get(i).getThanhTien();
			}
		}
		txtHoTen.setText(hd.get(0).getHoTen());
		txtNgayKham.setText(hd.get(0).getNgayKham());
		txtTienKham.setText(df.format(tk)+"");
		txtTienThuoc.setText(df.format(tt)+"");
		txtTongTien.setText(df.format(tt+tk)+"");
		
	}
}
