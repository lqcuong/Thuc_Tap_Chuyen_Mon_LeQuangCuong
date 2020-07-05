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

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThemBenhNhanForm extends JFrame {

	private JPanel contentPane;
	private static JTextField txtMa;
	private static JTextField txtTen;
	private static JTextField txtNamSinh;
	private static JTextField txtDiaChi;
	static JComboBox cbNamNu = new JComboBox();
	static ThemBenhNhanForm f;
	static BenhNhan bn=new BenhNhan();
	
	
	
	
	/**
	 * Create the frame.
	 */
	public ThemBenhNhanForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setSize(540,360);
		JLabel lblNewLabel = new JLabel("BỆNH NHÂN MỚI");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(23, 13, 487, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã BN:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(33, 60, 76, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Họ tên:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(33, 100, 76, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(33, 140, 76, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Năm sinh:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(33, 180, 76, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Địa chỉ:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(33, 220, 76, 25);
		contentPane.add(lblNewLabel_5);
		
		JButton btnThem = new JButton("Thêm");
	
		btnThem.setBounds(130, 262, 97, 25);
		contentPane.add(btnThem);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				f.setVisible(false);
				dispose();
			}
		});
		btnHuy.setBounds(252, 262, 97, 25);
		contentPane.add(btnHuy);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTen.setText("");
				txtNamSinh.setText("");
				txtDiaChi.setText("");
			}
		});
		btnLamMoi.setBounds(374, 262, 97, 25);
		contentPane.add(btnLamMoi);
		
		txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMa.setBounds(108, 60, 366, 25);
		contentPane.add(txtMa);
		txtMa.setColumns(10);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTen.setBounds(108, 100, 366, 25);
		contentPane.add(txtTen);
		txtTen.setColumns(10);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNamSinh.setBounds(108, 180, 366, 25);
		contentPane.add(txtNamSinh);
		txtNamSinh.setColumns(10);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDiaChi.setBounds(108, 220, 366, 25);
		contentPane.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		
		cbNamNu.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbNamNu.setBounds(108, 142, 97, 23);
		contentPane.add(cbNamNu);
		
		
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getTTBN();
				System.out.println(txtTen.getText());
				saveTTBN();
				f.setVisible(false);
				dispose();
				
			}
		});
		
	}
	public static void showFThemBN(ThemBenhNhanForm form) {
		f=form;
//		f.setLocationRelativeTo(null);
//		f.setVisible(true);
		Connection connection=ConnectDatabaseSQL.connectSQL();
		String maBN="";
		try {
			PreparedStatement ps = connection.prepareStatement("select mabn from Benhnhan");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				maBN=rs.getString("mabn");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		maBN=maBN.substring(2);
		int idBN=Integer.parseInt(maBN)+1;
		if(idBN<10) maBN="BN000"+idBN;
		else if(idBN<100) maBN="BN00"+idBN;
		else if(idBN<1000) maBN="BN0"+idBN;
		txtMa.setText(maBN);
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
	}
	public static BenhNhan getBN() {
		return bn;
	}
	public static void getTTBN() {
		if(txtTen.getText()!="" || cbNamNu.getSelectedIndex()!=-1 || txtNamSinh.getText()!="" || txtDiaChi.getText()!="") {
			bn.setMaBN(txtMa.getText());
			bn.setHoTen(txtTen.getText());
			if(cbNamNu.getSelectedIndex()==0)
				bn.setGioiTinh(1);
			else bn.setGioiTinh(0);
			bn.setNamSinh(Integer.parseInt(txtNamSinh.getText()));
			bn.setDiaChi(txtDiaChi.getText());
		}
	}
	public void saveTTBN() {
		Connection connection=ConnectDatabaseSQL.connectSQL();
		String maBN="";
		try {
			PreparedStatement ps2 = connection.prepareStatement("insert into Benhnhan values(N'"+bn.getMaBN()+"',N'"+bn.getHoTen()+"',"+bn.getGioiTinh()+","+bn.getNamSinh()+",N'"+bn.getDiaChi()+"')");
			ps2.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
	}
}
