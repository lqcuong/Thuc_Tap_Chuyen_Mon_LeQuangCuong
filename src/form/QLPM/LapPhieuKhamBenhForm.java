package form.QLPM;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class LapPhieuKhamBenhForm extends JFrame {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private JPanel contentPane;
	private static JTextField txtHoTen;
	private JTextField txtTrieuChung;
	private JTextField txtSoLuong1;
	private JTextField txtSoLuong2;
	private JTextField txtSoLuong3;
	static String maBNOld;
	JComboBox cbBenh = new JComboBox();
	JComboBox cbTenThuoc1 = new JComboBox();
	JComboBox cbTenThuoc2 = new JComboBox();
	JComboBox cbTenThuoc3 = new JComboBox();
	static LapPhieuKhamBenhForm form;
	JDateChooser dateChooser = new JDateChooser();
	static Vector<Thuoc>dsThuoc;
	static Vector<Benh> dsBenh;
	
	
	public LapPhieuKhamBenhForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(825, 502);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LẬP PHIẾU KHÁM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(0, 0, 754, 86);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 89, 91, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày lập:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(457, 89, 89, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Triệu chứng:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 161, 91, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Bệnh:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(457, 161, 89, 25);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Cấp thuốc:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_1_1.setBounds(109, 211, 124, 25);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHoTen.setBounds(109, 89, 292, 25);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		txtTrieuChung = new JTextField();
		txtTrieuChung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTrieuChung.setColumns(10);
		txtTrieuChung.setBounds(109, 161, 292, 25);
		contentPane.add(txtTrieuChung);
		

		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(553, 89, 216, 25);
		contentPane.add(dateChooser);
		cbBenh.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==ItemEvent.SELECTED) {
					int j=cbBenh.getSelectedIndex();
					cbTenThuoc1.removeAllItems();
					cbTenThuoc2.removeAllItems();
					cbTenThuoc3.removeAllItems();
					if(j==0) {
						
						for(int i=1;i<7;i++) {
							cbTenThuoc1.setSelectedIndex(-1);
							cbTenThuoc2.setSelectedIndex(-1);
							cbTenThuoc3.setSelectedIndex(-1);
							cbTenThuoc1.addItem(dsThuoc.get(i).tenThuoc);
							cbTenThuoc2.addItem(dsThuoc.get(i).tenThuoc);
							cbTenThuoc3.addItem(dsThuoc.get(i).tenThuoc);
						}
					}else if(j==1) {
						for(int i=7;i<13;i++) {
							cbTenThuoc1.setSelectedIndex(-1);
							cbTenThuoc2.setSelectedIndex(-1);
							cbTenThuoc3.setSelectedIndex(-1);
							cbTenThuoc1.addItem(dsThuoc.get(i).tenThuoc);
							cbTenThuoc2.addItem(dsThuoc.get(i).tenThuoc);
							cbTenThuoc3.addItem(dsThuoc.get(i).tenThuoc);
						}
					}else if(j==2) {
						for(int i=13;i<19;i++) {
							cbTenThuoc1.setSelectedIndex(-1);
							cbTenThuoc2.setSelectedIndex(-1);
							cbTenThuoc3.setSelectedIndex(-1);
							cbTenThuoc1.addItem(dsThuoc.get(i).tenThuoc);
							cbTenThuoc2.addItem(dsThuoc.get(i).tenThuoc);
							cbTenThuoc3.addItem(dsThuoc.get(i).tenThuoc);
						}
					}else if(j==3) {
						for(int i=19;i<25;i++) {
							cbTenThuoc1.setSelectedIndex(-1);
							cbTenThuoc2.setSelectedIndex(-1);
							cbTenThuoc3.setSelectedIndex(-1);
							cbTenThuoc1.addItem(dsThuoc.get(i).tenThuoc);
							cbTenThuoc2.addItem(dsThuoc.get(i).tenThuoc);
							cbTenThuoc3.addItem(dsThuoc.get(i).tenThuoc);
						}
					}else if(j==4) {
						for(int i=25;i<31;i++) {
							cbTenThuoc1.setSelectedIndex(-1);
							cbTenThuoc2.setSelectedIndex(-1);
							cbTenThuoc3.setSelectedIndex(-1);
							cbTenThuoc1.addItem(dsThuoc.get(i).tenThuoc);
							cbTenThuoc2.addItem(dsThuoc.get(i).tenThuoc);
							cbTenThuoc3.addItem(dsThuoc.get(i).tenThuoc);
						}
					}
				}
			}
		});
		
		
		cbBenh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbBenh.setBounds(553, 161, 216, 25);
		contentPane.add(cbBenh);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Tên thuốc:");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1.setBounds(165, 260, 89, 25);
		contentPane.add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Số lượng:");
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_1.setBounds(462, 260, 89, 25);
		contentPane.add(lblNewLabel_1_2_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_2 = new JLabel("Tên thuốc:");
		lblNewLabel_1_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_2.setBounds(165, 316, 89, 25);
		contentPane.add(lblNewLabel_1_2_1_1_1_2);
		
		JLabel lblNewLabel_1_2_1_1_1_3 = new JLabel("Số lượng");
		lblNewLabel_1_2_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_3.setBounds(462, 316, 89, 25);
		contentPane.add(lblNewLabel_1_2_1_1_1_3);
		
		JLabel lblNewLabel_1_2_1_1_1_4 = new JLabel("Tên thuốc:");
		lblNewLabel_1_2_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_4.setBounds(165, 364, 89, 25);
		contentPane.add(lblNewLabel_1_2_1_1_1_4);
		
		JLabel lblNewLabel_1_2_1_1_1_5 = new JLabel("Số lượng:");
		lblNewLabel_1_2_1_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1_1_5.setBounds(462, 364, 89, 25);
		contentPane.add(lblNewLabel_1_2_1_1_1_5);
		
		txtSoLuong1 = new JTextField();
		txtSoLuong1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSoLuong1.setColumns(10);
		txtSoLuong1.setBounds(532, 260, 209, 25);
		contentPane.add(txtSoLuong1);
		
		txtSoLuong2 = new JTextField();
		txtSoLuong2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSoLuong2.setColumns(10);
		txtSoLuong2.setBounds(532, 316, 209, 25);
		contentPane.add(txtSoLuong2);
		
		txtSoLuong3 = new JTextField();
		txtSoLuong3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSoLuong3.setColumns(10);
		txtSoLuong3.setBounds(532, 364, 209, 25);
		contentPane.add(txtSoLuong3);
		
		JButton btnThem = new JButton("Thêm");
		
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(425, 417, 97, 25);
		contentPane.add(btnThem);
		
		JButton btnHuy = new JButton("Hủy");
		
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHuy.setBounds(535, 417, 97, 25);
		contentPane.add(btnHuy);
		
		JButton btnLamMoi = new JButton("Làm mới");
	
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLamMoi.setBounds(644, 417, 97, 25);
		contentPane.add(btnLamMoi);
		
		
		cbTenThuoc1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbTenThuoc1.setBounds(240, 262, 216, 25);
		contentPane.add(cbTenThuoc1);
		
		
		cbTenThuoc2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbTenThuoc2.setBounds(240, 318, 216, 25);
		contentPane.add(cbTenThuoc2);
		
		
		cbTenThuoc3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbTenThuoc3.setBounds(240, 364, 216, 25);
		contentPane.add(cbTenThuoc3);
		showThuocABenh();
		btnLamMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dateChooser.setDate(null);
				txtTrieuChung.setText("");
				cbBenh.setSelectedIndex(-1);
				cbTenThuoc1.setSelectedIndex(-1);
				cbTenThuoc2.setSelectedIndex(-1);
				cbTenThuoc3.setSelectedIndex(-1);
				txtSoLuong1.setText("");
				txtSoLuong2.setText("");
				txtSoLuong3.setText("");
			}
		});
		btnHuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				form.setVisible(false);
				dispose();
			}
		});
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				savePhieuKham();
				form.setVisible(false);
				dispose();
			}
		});
	}
	public void savePhieuKham() {
		String maPhieuKham="",maHoaDon="",maCTHD="";
		int idPK=0,idHD=0,idCTHD=0;
		
		Connection connection=ConnectDatabaseSQL.connectSQL();
		try {
			PreparedStatement pss0=connection.prepareStatement("select * from hoadon");
			ResultSet rs=pss0.executeQuery();
			while(rs.next()) maHoaDon=rs.getString("mahoadon");
			pss0=connection.prepareStatement("select * from chitiethd");
			rs=pss0.executeQuery();
			while(rs.next()) maCTHD=rs.getString("macthd");
			pss0=connection.prepareStatement("select * from phieukham");
			rs=pss0.executeQuery();
			while(rs.next()) maPhieuKham=rs.getString("maphieukham");
			maHoaDon=maHoaDon.substring(2);
			idHD=Integer.parseInt(maHoaDon)+1;
			if(idHD<10) maHoaDon="HD000"+idHD;
			else if(idHD<100) maHoaDon="HD00"+idHD;
			else if(idHD<1000) maHoaDon="HD0"+idHD;
			
			maCTHD=maCTHD.substring(4);
			idCTHD=Integer.parseInt(maCTHD)+1;
			if(idCTHD<10) maCTHD="CTHD000"+idCTHD;
			else if(idCTHD<100) maCTHD="CTHD00"+idCTHD;
			else if(idCTHD<1000) maCTHD="CTHD0"+idCTHD;
			
			maPhieuKham=maPhieuKham.substring(2);
			idPK=Integer.parseInt(maPhieuKham)+1;
			if(idPK<10) maPhieuKham="PK000"+idPK;
			else if(idPK<100) maPhieuKham="PK00"+idPK;
			else if(idPK<1000) maPhieuKham="PK0"+idPK;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("HD"+maHoaDon+"--CTDH"+maCTHD+"--PK"+maPhieuKham);
		try {
			int i_benh=cbBenh.getSelectedIndex();
			
			
			int i_thuoc1=cbTenThuoc1.getSelectedIndex();
			int i_thuoc2=cbTenThuoc2.getSelectedIndex();
			int i_thuoc3=cbTenThuoc3.getSelectedIndex();
			switch(i_benh) {
			case 0:
				break;
			case 1:
				i_thuoc1+=6;
				i_thuoc2+=6;
				i_thuoc3+=6;
				break;
			case 2:
				i_thuoc1+=12;
				i_thuoc2+=12;
				i_thuoc3+=12;
				break;
			case 3:
				i_thuoc1+=18;
				i_thuoc2+=18;
				i_thuoc3+=18;
				break;
			case 4:
				i_thuoc1+=24;
				i_thuoc2+=24;
				i_thuoc3+=24;
				break;
			}
			System.out.println(i_thuoc1+"----"+i_thuoc2+"----"+i_thuoc3);
			PreparedStatement ps0=connection.prepareStatement("insert into PhieuKham values('"+maPhieuKham+"','"+sdf.format(dateChooser.getDate())+"',N'"+txtTrieuChung.getText()+"','"+maBNOld+"','"+dsBenh.get(i_benh+1).maBenh+"')");
			ps0.execute();
			PreparedStatement ps1=connection.prepareStatement("insert into HoaDon values('"+maHoaDon+"','"+sdf.format(dateChooser.getDate())+"','"+maPhieuKham+"')");
			ps1.execute();
			PreparedStatement psKham=connection.prepareStatement("insert into ChiTietHD values('"+maCTHD+"',1,'"+maHoaDon+"','Thuoc0000')");
			psKham.execute();
			maCTHD=maCTHD.substring(4);
			idCTHD=Integer.parseInt(maCTHD)+1;
			if(idCTHD<10) maCTHD="CTHD000"+idCTHD;
			else if(idCTHD<100) maCTHD="CTHD00"+idCTHD;
			else if(idCTHD<1000) maCTHD="CTHD0"+idCTHD;
			PreparedStatement ps2=connection.prepareStatement("insert into ChiTietHD values('"+maCTHD+"',"+Integer.parseInt(txtSoLuong1.getText())+",'"+maHoaDon+"','"+dsThuoc.get(i_thuoc1+1).maThuoc+"')");
			ps2.execute();
			if(txtSoLuong2.getText().equals("")==false) {
				maCTHD=maCTHD.substring(4);
				idCTHD=Integer.parseInt(maCTHD)+1;
				if(idCTHD<10) maCTHD="CTHD000"+idCTHD;
				else if(idCTHD<100) maCTHD="CTHD00"+idCTHD;
				else if(idCTHD<1000) maCTHD="CTHD0"+idCTHD;
				PreparedStatement ps3=connection.prepareStatement("insert into ChiTietHD values('"+maCTHD+"',"+Integer.parseInt(txtSoLuong2.getText())+",'"+maHoaDon+"','"+dsThuoc.get(i_thuoc2+1).maThuoc+"')");
				ps3.execute();
			}
			if(txtSoLuong3.getText().equals("")==false) {
				maCTHD=maCTHD.substring(4);
				idCTHD=Integer.parseInt(maCTHD)+1;
				if(idCTHD<10) maCTHD="HD000"+idCTHD;
				else if(idCTHD<100) maCTHD="HD00"+idCTHD;
				else if(idCTHD<1000) maCTHD="HD0"+idCTHD;
				PreparedStatement ps4=connection.prepareStatement("insert into ChiTietHD values('"+maCTHD+"',"+Integer.parseInt(txtSoLuong3.getText())+",'"+maHoaDon+"','"+dsThuoc.get(i_thuoc3+1).maThuoc+"')");
				ps4.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		
	}
	public static void getLPKBForm(LapPhieuKhamBenhForm f) {
		form=f;
	}
	public static void getTenBN(String maBN) {
		maBNOld=maBN;
		System.out.println(maBN);
		Connection connection=ConnectDatabaseSQL.connectSQL();
		String hoTen="";
		try {
			
			PreparedStatement ps=connection.prepareStatement("select * from benhnhan where mabn='"+maBN+"'");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				hoTen=rs.getString("hoten");
			}
			txtHoTen.setText(hoTen);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		
	}
	public void showThuocABenh() {
		dsBenh=new Vector<Benh>();
		dsThuoc=new Vector<Thuoc>();
		Connection connection=ConnectDatabaseSQL.connectSQL();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from thuoc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				dsThuoc.add(new Thuoc(rs.getString("mathuoc"), rs.getString("tenthuoc"), "", ""));
			}
			ps=connection.prepareStatement("select * from Benh");
			rs=ps.executeQuery();
			while(rs.next()) {
				dsBenh.add(new Benh(rs.getString("mabenh"), rs.getString("loaibenh"), ""));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		for(int i=1;i<dsBenh.size();i++) {
			cbBenh.addItem(dsBenh.get(i).loaiBenh.toString());
		}
		for(int i=1;i<dsThuoc.size();i++) {
			cbTenThuoc1.addItem(dsThuoc.get(i).tenThuoc);
			cbTenThuoc2.addItem(dsThuoc.get(i).tenThuoc);
			cbTenThuoc3.addItem(dsThuoc.get(i).tenThuoc);
			
		}
		cbBenh.setSelectedIndex(-1);
		cbTenThuoc1.setSelectedIndex(-1);
		cbTenThuoc2.setSelectedIndex(-1);
		cbTenThuoc3.setSelectedIndex(-1);
	}
}
