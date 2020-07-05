package form.QLPM;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PhieuKhamBenhForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoTen;
	private JTextField txtTrieuChung;
	private JTextField txtNgayKham;
	private JTextField txtLoaiBenh;
	private JTable tbDSPhieu;
	static String maBN = new String();
	JComboBox cbMa_NgayPK = new JComboBox();
	static Date dateCenterForm = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * Create the frame.
	 */
	public PhieuKhamBenhForm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("PHIẾU KHÁM BỆNH");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 982, 70);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Họ tên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(75, 112, 130, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Triệu chứng:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(75, 157, 130, 25);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Ngày khám:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(499, 112, 130, 25);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Dự đoán loại bệnh:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(499, 157, 130, 25);
		contentPane.add(lblNewLabel_4);

		txtHoTen = new JTextField();
		txtHoTen.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoTen.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtHoTen.setEditable(false);
		txtHoTen.setBounds(169, 113, 237, 25);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);

		txtTrieuChung = new JTextField();
		txtTrieuChung.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrieuChung.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTrieuChung.setEditable(false);
		txtTrieuChung.setColumns(10);
		txtTrieuChung.setBounds(169, 159, 237, 25);
		contentPane.add(txtTrieuChung);

		txtNgayKham = new JTextField();
		txtNgayKham.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgayKham.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNgayKham.setEditable(false);
		txtNgayKham.setColumns(10);
		txtNgayKham.setBounds(641, 113, 237, 25);
		contentPane.add(txtNgayKham);

		txtLoaiBenh = new JTextField();
		txtLoaiBenh.setHorizontalAlignment(SwingConstants.CENTER);
		txtLoaiBenh.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtLoaiBenh.setEditable(false);
		txtLoaiBenh.setColumns(10);
		txtLoaiBenh.setBounds(641, 159, 237, 25);
		contentPane.add(txtLoaiBenh);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 195, 970, 322);
		contentPane.add(scrollPane);

		tbDSPhieu = new JTable();
		tbDSPhieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setColumnHeaderView(tbDSPhieu);
		scrollPane.setViewportView(tbDSPhieu);
		this.setSize(1000, 600);

		tbDSPhieu.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
		tbDSPhieu.getTableHeader().setBackground(new Color(192, 192, 192));
		tbDSPhieu.getTableHeader().setEnabled(false);
		tbDSPhieu.setRowHeight(30);
		cbMa_NgayPK.setFont(new Font("Tahoma", Font.BOLD, 15));

		cbMa_NgayPK.setBounds(486, 59, 152, 25);
		contentPane.add(cbMa_NgayPK);

		JLabel lblNewLabel_5 = new JLabel("Chọn ngày khám:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(345, 59, 140, 25);
		contentPane.add(lblNewLabel_5);
		
		JButton btnLapPK = new JButton("Lập phiếu khám");
	
		btnLapPK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLapPK.setBounds(824, 530, 146, 25);
		contentPane.add(btnLapPK);

		showThongTinBN(maBN);
		// add action event

		cbMa_NgayPK.addItemListener(new ItemListener() {
//			int demClickChange = 0;

			public void itemStateChanged(ItemEvent change) {
				if (change.getStateChange() == ItemEvent.SELECTED) {
					System.out.println(change.getStateChange()+" và---------- "+ItemEvent.SELECTED);
					Vector<DSThuocSuDung> dsThuocSD = getDSThuoc(
							"select T.TenThuoc,T.DonVi,CTHD.SoLuongThuoc,CD.MoTaCD\n"
									+ "from Thuoc T, HoaDon HD, PhieuKham PK,ChiTietHD CTHD,CachDung CD\n"
									+ "where PK.MaBN='" + maBN
									+ "' and HD.MaPhieuKham=PK.MaPhieuKham and CD.MaCachDung=T.MaCachDung and CTHD.MaThuoc=T.MaThuoc and CTHD.MaHoaDon=HD.MaHoaDon and PK.NgayKham='"
									+ cbMa_NgayPK.getSelectedItem().toString() + "'");
					String[] colName = { "STT", "Tên thuốc", "Đơn vị", "Số lượng", "Cách dùng" };
					DefaultTableModel model = new DefaultTableModel(colName, 0) {
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					System.out.println(cbMa_NgayPK.getSelectedItem().toString());
					for (int i = 0; i < dsThuocSD.size(); i++) {
						model.addRow(new Object[] { i + 1, dsThuocSD.get(i).getLoaiThuoc(), dsThuocSD.get(i).getDonVi(),
								dsThuocSD.get(i).getSoLuong(), dsThuocSD.get(i).getCachDung() });
					}
					getTTPhieuKham();
					tbDSPhieu.setModel(model);
					setSizeTableDS();
//					demClickChange++;
//					txtNgayKham.setText(cbMa_NgayPK.getSelectedItem().toString());
					
				}
			}
		});
		btnLapPK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LapPhieuKhamBenhForm f=new LapPhieuKhamBenhForm();
				f.setVisible(true);
				f.getLPKBForm(f);
				f.setLocationRelativeTo(null);
				f.getTenBN(maBN);
			}
		});
	}

	public void getCTNgayPK(String maBN) {
		String query = "select PK.NgayKham from PhieuKham PK, BenhNhan BN where PK.MaBN='" + maBN + "' and BN.MaBN='"
				+ maBN + "'";
		Vector<String> data = getNgayPK(query);
		showComboBoxCTNgay(data);
		cbMa_NgayPK.setSelectedIndex(-1);
	}

	public void showComboBoxCTNgay(Vector<String> data) {
		for (int i = 0; i < data.size(); i++) {
			cbMa_NgayPK.addItem(data.get(i));
		}
	}

	public void showThongTinBN(String maBN) {
		if (cbMa_NgayPK.getSelectedIndex() == -1) {
			try {
				String query = "select BN.HoTen,PK.NgayKham,Pk.TrieuChung,B.LoaiBenh "
						+ "from BenhNhan BN, PhieuKham PK, Benh B " + "where BN.MaBN='" + maBN
						+ "' and BN.MaBN=PK.MaBN and B.MaBenh = PK.MaBenh";
				Vector<String> temp = getTT(query);
				String hotenbn="";
				Connection connection=ConnectDatabaseSQL.connectSQL();
				PreparedStatement ps=connection.prepareStatement("Select hoten from benhnhan where mabn='"+maBN+"'");
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					hotenbn=rs.getString("hoten");
				}
				ConnectDatabaseSQL.closeDatabaseSQL(connection);
				txtHoTen.setText(hotenbn);
//				txtHoTen.setText(temp.get(0).toString());
//				txtNgayKham.setText(temp.get(1).toString());
//				txtTrieuChung.setText(temp.get(2).toString());
//				txtLoaiBenh.setText(temp.get(3).toString());

			} catch (Exception e) {
				System.out.println("Không có thông tin phiếu khám");
			}
		}
	
		getCTNgayPK(maBN);
		if (dateCenterForm == null) {
			Vector<DSThuocSuDung> dsThuocSD = getDSThuoc("select T.TenThuoc,T.DonVi,CTHD.SoLuongThuoc,CD.MoTaCD\n"
					+ "from Thuoc T, HoaDon HD, PhieuKham PK,ChiTietHD CTHD,CachDung CD\n" + "where PK.MaBN='" + maBN
					+ "' and HD.MaPhieuKham=PK.MaPhieuKham and CD.MaCachDung=T.MaCachDung and CTHD.MaThuoc=T.MaThuoc and CTHD.MaHoaDon=HD.MaHoaDon");
			String[] colName = { "STT", "Tên thuốc", "Đơn vị", "Số lượng", "Cách dùng" };
			DefaultTableModel model = new DefaultTableModel(colName, 0) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			for (int i = 0; i < dsThuocSD.size(); i++) {
				model.addRow(new Object[] { i + 1, dsThuocSD.get(i).getLoaiThuoc(), dsThuocSD.get(i).getDonVi(),
						dsThuocSD.get(i).getSoLuong(), dsThuocSD.get(i).getCachDung() });
			}
			tbDSPhieu.setModel(model);
			setSizeTableDS();
		} else {
			System.out.println("BBBBBBBBBBBBBBBBBbb");

			Vector<DSThuocSuDung> dsThuocSD = getDSThuoc("select T.TenThuoc,T.DonVi,CTHD.SoLuongThuoc,CD.MoTaCD\n"
					+ "from Thuoc T, HoaDon HD, PhieuKham PK,ChiTietHD CTHD,CachDung CD\n" + "where PK.MaBN='" + maBN
					+ "' and HD.MaPhieuKham=PK.MaPhieuKham and CD.MaCachDung=T.MaCachDung and CTHD.MaThuoc=T.MaThuoc and CTHD.MaHoaDon=HD.MaHoaDon and PK.NgayKham='"
					+ sdf.format(dateCenterForm) + "'");
			String[] colName = { "STT", "Tên thuốc", "Đơn vị", "Số lượng", "Cách dùng" };
			cbMa_NgayPK.setSelectedItem(sdf.format(dateCenterForm));
//			txtNgayKham.setText(sdf.format(dateCenterForm));
//			txtTrieuChung.setText(temp.get(2).toString());
//			txtLoaiBenh.setText(temp.get(3).toString());
			DefaultTableModel model = new DefaultTableModel(colName, 0) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			for (int i = 0; i < dsThuocSD.size(); i++) {
				model.addRow(new Object[] { i + 1, dsThuocSD.get(i).getLoaiThuoc(), dsThuocSD.get(i).getDonVi(),
						dsThuocSD.get(i).getSoLuong(), dsThuocSD.get(i).getCachDung() });
			}
			getTTPhieuKham();
			tbDSPhieu.setModel(model);
			setSizeTableDS();
		}
	}

	public void getTTPhieuKham() {
		try {
			String query = "select BN.HoTen,PK.NgayKham,PK.TrieuChung,B.LoaiBenh "
					+ "from BenhNhan BN, PhieuKham PK, Benh B " + "where BN.MaBN='" + maBN
					+ "' and BN.MaBN=PK.MaBN and B.MaBenh = PK.MaBenh and PK.NgayKham='"+cbMa_NgayPK.getSelectedItem().toString()+"'";
			Vector<String> temp = getTT(query);
			for(int i=0;i<temp.size();i++) {
			}
//			txtHoTen.setText(temp.get(0).toString());
			txtNgayKham.setText(temp.get(1).toString());
			txtTrieuChung.setText(temp.get(2).toString());
			if(temp.get(3)==null)
				txtLoaiBenh.setText("");
			else txtLoaiBenh.setText(temp.get(3).toString());
		} catch (Exception e) {
			System.out.println("Không có thông tin phiếu khám");
		}
	}

	public Vector<DSThuocSuDung> getDSThuoc(String query) {
		Vector<DSThuocSuDung> data = new Vector<DSThuocSuDung>();
		Connection connection = ConnectDatabaseSQL.connectSQL();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data.add(new DSThuocSuDung(rs.getString("TenThuoc"), rs.getString("DonVi"), rs.getInt("SoLuongThuoc"),
						rs.getString("MoTaCD")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		return data;
	}

	public Vector<String> getTT(String query) {
		Vector<String> data = new Vector<String>();
		Connection connection = ConnectDatabaseSQL.connectSQL();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data.add(rs.getString(1));
				data.add(rs.getString(2));
				data.add(rs.getString(3));
				data.add(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		return data;
	}

	public Vector<String> getNgayPK(String query) {
		Vector<String> data = new Vector<String>();
		Connection connection = ConnectDatabaseSQL.connectSQL();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data.add(rs.getString("NgayKham"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		return data;
	}

	static PhieuKhamBenhForm pk;

	public static void createPhieuKhamBenh(String relaMaBN, Date date) {
		maBN = relaMaBN;
		dateCenterForm = date;
		pk = new PhieuKhamBenhForm();
		pk.setLocationRelativeTo(null);
		pk.setVisible(true);
	}

	public void setSizeTableDS() {
		TableColumnModel coloModel = tbDSPhieu.getColumnModel();
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(0);
		coloModel.getColumn(0).setPreferredWidth(10);
		coloModel.getColumn(1).setPreferredWidth(200);
		coloModel.getColumn(2).setPreferredWidth(50);
		coloModel.getColumn(3).setPreferredWidth(80);
		coloModel.getColumn(4).setPreferredWidth(500);
		coloModel.getColumn(0).setCellRenderer(centerRender);
		coloModel.getColumn(2).setCellRenderer(centerRender);
		coloModel.getColumn(3).setCellRenderer(centerRender);
	}
}
