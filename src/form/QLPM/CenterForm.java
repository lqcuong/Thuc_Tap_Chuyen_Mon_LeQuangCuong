package form.QLPM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.color.CMMException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.JTextField;

public class CenterForm extends JFrame {

	private JPanel contentPane;
	JPanel pnlHeader = new JPanel();
	JLabel lblQLPMT = new JLabel("QU\u1EA2N L\u00DD PH\u00D2NG M\u1EA0CH T\u01AF");
	JPanel pnlLeft = new JPanel();
	JLabel lblBenhNhan = new JLabel("BỆNH NHÂN");
	JLabel lblKhamBenh = new JLabel("KHÁM BỆNH");
	JLabel lblBaoCao = new JLabel("B\u00C1O C\u00C1O");
	JLabel lblQuyDinh = new JLabel("QUY ĐỊNH");
	JSeparator sprTool_1 = new JSeparator();
	JSeparator sprTool_2 = new JSeparator();
	JSeparator sprTool_3 = new JSeparator();
	JPanel pnlRight = new JPanel();
	JPanel pnlContent = new JPanel();
	JPanel pnlTools = new JPanel();
	JButton btnXoa = new JButton("Xóa");
	private final JPanel pnlKhamBenh = new JPanel();
	JLabel lblTitle = new JLabel("");
	JDateChooser dateChooserDate = new JDateChooser();
	JButton btnTimKiem = new JButton("Tìm kiếm");
	private final JScrollPane scrollPaneKB = new JScrollPane();
	private final JTable tbDSKhamBenh = new JTable();
	String relaMaBN = new String();
	Vector<String> relaMaPhieuKham = new Vector<String>();
	private final JPanel pnlBenhNhan = new JPanel();
	private final JTable tbDSBenhNhan = new JTable();
	private final JPanel pnlBaoCao = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JComboBox cbBaoCao = new JComboBox();
	private final JScrollPane scrollPaneDoanhThu = new JScrollPane();
	private final JTable tbBaoCao = new JTable();
	private final JPanel pnlDoanhThuNgay = new JPanel();
	private final JLabel lblNewLabel_1 = new JLabel("Tháng:");
	JYearChooser yearBaoCao = new JYearChooser();
	private final JComboBox cbMonthBaoCao = new JComboBox();
	private final JButton btnXemBaoCao = new JButton("Xem");
	private final JPanel pnlSuDungThuoc = new JPanel();
	private final JScrollPane scrollPaneSuDungThuoc = new JScrollPane();
	private final JLabel lblNewLabel_1_2 = new JLabel("Tháng:");
	private final JYearChooser yearBaoCaoThuoc = new JYearChooser();
	private final JLabel lblNewLabel_1_1_1 = new JLabel("Năm:");
	private final JComboBox cbMonthBaoCaoThuoc = new JComboBox();
	private final JButton btnXemBaoCaoThuoc = new JButton("Xem");
	private JTable tbSuDungThuoc;
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	JPanel pnlQuyDinh = new JPanel();
	JComboBox cbQuyDinh = new JComboBox();
	JPanel pnlQD1 = new JPanel();
	private final JPanel pnlQD2 = new JPanel();
	private final JPanel pnlQD4 = new JPanel();
	private final JLabel lblNewLabel_2 = new JLabel("Số lượng bệnh nhân tối đa trong ngày:");
	private final JTextField txtSLQD1 = new JTextField();
	private final JButton btnCapNhatQD1 = new JButton("Cập nhật");
	static int qd1_SL=0;
	private JTable tbDSBenh;
	private final JLabel lblNewLabel_5 = new JLabel("Loại bệnh:");
	private final JLabel lblNewLabel_6 = new JLabel("Mô tả:");
	private JTextField txtMaBenh;
	private JTextField txtLoaiBenh;
	private JTextField txtMoTaBenh;
	Vector<Benh>dsBenh;
	Vector<Thuoc>dsThuoc;
	private final JTable tbDSThuoc = new JTable();
	private final JLabel lblNewLabel_4 = new JLabel("Mã thuốc:");
	private final JLabel lblNewLabel_4_1 = new JLabel("Tên thuốc:");
	private final JLabel lblNewLabel_4_1_1 = new JLabel("Đơn vị:");
	private final JLabel lblNewLabel_4_1_1_1 = new JLabel("Cách dùng:");
	private final JButton btnCapNhatThuoc = new JButton("Cập nhật");
	private final JTextField txtMaThuoc = new JTextField();
	private final JTextField txtTenThuoc = new JTextField();
	private final JTextField txtDonVi = new JTextField();
	private final JTextArea txtCachDung = new JTextArea();
	JComboBox cbCachDung = new JComboBox();
	private final JLabel lblNewLabel_7 = new JLabel("Thay đổi tiền khám:");
	private final JTextField txtTienKham = new JTextField();
	private final JButton btnTienKham = new JButton("Thay đổi");
	private JTable tbDonGiaThuoc;
	private JTextField txtDonGia;
	Vector<Integer>donGiaThuoc;
	private final JButton btnThem = new JButton("Thêm");
	private final JButton btnLamMoi = new JButton("Làm mới");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CenterForm frame = new CenterForm();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CenterForm() {
		txtTienKham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTienKham.setBounds(182, 13, 100, 25);
		txtTienKham.setColumns(10);
		txtSLQD1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSLQD1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSLQD1.setBounds(452, 44, 94, 25);
		txtSLQD1.setColumns(10);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Add icon
		
		//-------------------
//		pnlSuDungThuoc.setLayout(null);
//		pnlSuDungThuoc.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
//		pnlSuDungThuoc.setBounds(0, 48, 909, 505);
//		pnlSuDungThuoc.setVisible(false);
//		pnlContent.add(pnlSuDungThuoc);
//		scrollPaneSuDungThuoc.setBorder(null);
//		scrollPaneSuDungThuoc.setBounds(0, 53, 909, 451);
//		
//		pnlSuDungThuoc.add(scrollPaneSuDungThuoc);
//		
//		tbSuDungThuoc = new JTable();
//		tbSuDungThuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		scrollPaneSuDungThuoc.setColumnHeaderView(tbSuDungThuoc);
//		scrollPaneSuDungThuoc.setViewportView(tbSuDungThuoc);
//		tbSuDungThuoc.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
//		tbSuDungThuoc.getTableHeader().setBackground(new Color(192, 192, 192));
//		tbSuDungThuoc.getTableHeader().setEnabled(false);
//		tbSuDungThuoc.setRowHeight(30);
//		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblNewLabel_1_2.setBounds(304, 13, 60, 25);
//		
//		pnlSuDungThuoc.add(lblNewLabel_1_2);
//		yearBaoCaoThuoc.setHorizontalAlignment(0);
//		yearBaoCaoThuoc.setFont(new Font("Tahoma", Font.BOLD, 15));
//		yearBaoCaoThuoc.setBounds(492, 13, 80, 25);
//		
//		pnlSuDungThuoc.add(yearBaoCaoThuoc);
//		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblNewLabel_1_1_1.setBounds(445, 13, 48, 25);
//		
//		pnlSuDungThuoc.add(lblNewLabel_1_1_1);
//		cbMonthBaoCaoThuoc.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
//		cbMonthBaoCaoThuoc.setFont(new Font("Tahoma", Font.BOLD, 15));
//		cbMonthBaoCaoThuoc.setBounds(359, 13, 74, 25);
//		
//		pnlSuDungThuoc.add(cbMonthBaoCaoThuoc);
//
//		btnXemBaoCaoThuoc.setFont(new Font("Tahoma", Font.BOLD, 15));
//		btnXemBaoCaoThuoc.setBounds(575, 13, 80, 25);
//		
//		pnlSuDungThuoc.add(btnXemBaoCaoThuoc);
		//---------------
		pnlHeader.setLayout(null);
		pnlHeader.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.controlHighlight));
		pnlHeader.setBackground(SystemColor.activeCaption);
		pnlHeader.setBounds(0, 0, 1194, 100);
		contentPane.add(pnlHeader);
		lblQLPMT.setForeground(Color.BLACK);

		lblQLPMT.setHorizontalAlignment(SwingConstants.CENTER);
		lblQLPMT.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblQLPMT.setBounds(0, 0, 1194, 100);
		pnlHeader.add(lblQLPMT);

		pnlLeft.setLayout(null);
		pnlLeft.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(227, 227, 227)));
		pnlLeft.setBackground(SystemColor.activeCaption);
		pnlLeft.setBounds(0, 100, 170, 665);
		contentPane.add(pnlLeft);

		lblBenhNhan.setOpaque(true);
		lblBenhNhan.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenhNhan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBenhNhan.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblBenhNhan.setBackground(new Color(220, 220, 220));
		lblBenhNhan.setBounds(12, 62, 150, 110);
		pnlLeft.add(lblBenhNhan);

		lblKhamBenh.setOpaque(true);
		lblKhamBenh.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhamBenh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKhamBenh.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblKhamBenh.setBackground(new Color(220, 220, 220));
		lblKhamBenh.setBounds(12, 192, 150, 110);
		pnlLeft.add(lblKhamBenh);

		lblBaoCao.setOpaque(true);
		lblBaoCao.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaoCao.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBaoCao.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblBaoCao.setBackground(new Color(220, 220, 220));
		lblBaoCao.setBounds(12, 322, 150, 110);
		pnlLeft.add(lblBaoCao);
		lblQuyDinh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickedMenu(4);
			}
		});

		lblQuyDinh.setOpaque(true);
		lblQuyDinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuyDinh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuyDinh.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblQuyDinh.setBackground(new Color(220, 220, 220));
		lblQuyDinh.setBounds(12, 460, 150, 110);
		pnlLeft.add(lblQuyDinh);

		sprTool_1.setBounds(12, 182, 150, 2);
		pnlLeft.add(sprTool_1);

		sprTool_2.setBounds(12, 312, 150, 2);
		pnlLeft.add(sprTool_2);

		sprTool_3.setBounds(12, 442, 150, 2);
		pnlLeft.add(sprTool_3);

		pnlRight.setLayout(null);
		pnlRight.setBackground(SystemColor.activeCaption);
		pnlRight.setBounds(170, 100, 1024, 665);
		contentPane.add(pnlRight);
		
		pnlContent.setBounds(47, 37, 909, 553);
		pnlRight.add(pnlContent);
		pnlContent.setLayout(null);
		//--------------------------
		pnlQuyDinh.setBounds(0, 0, 909, 553);
		pnlContent.add(pnlQuyDinh);
		pnlQuyDinh.setLayout(null);
		pnlQD1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pnlQD4.setBounds(0, 61, 909, 492);
		
		pnlQuyDinh.add(pnlQD4);
		pnlQD4.setLayout(null);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(40, 13, 132, 25);
		
		pnlQD4.add(lblNewLabel_7);
		
		pnlQD4.add(txtTienKham);
	
		btnTienKham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTienKham.setBounds(294, 14, 97, 25);
		
		pnlQD4.add(btnTienKham);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(40, 73, 806, 238);
		pnlQD4.add(scrollPane_2);
		
		tbDonGiaThuoc = new JTable();
		tbDonGiaThuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_2.setColumnHeaderView(tbDonGiaThuoc);
		scrollPane_2.setViewportView(tbDonGiaThuoc);;
		JLabel lblNewLabel_8 = new JLabel("Đơn giá:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(40, 323, 56, 25);
		pnlQD4.add(lblNewLabel_8);
		
		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDonGia.setBounds(107, 323, 116, 25);
		pnlQD4.add(txtDonGia);
		txtDonGia.setColumns(10);
		
		JButton btnDonGia = new JButton("Thay đổi");

		btnDonGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDonGia.setBounds(235, 323, 97, 25);
		pnlQD4.add(btnDonGia);
		pnlQD2.setBounds(0, 61, 909, 492);
		pnlQuyDinh.add(pnlQD2);
		pnlQD2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 29, 526, 164);
		pnlQD2.add(scrollPane);
		
		tbDSBenh = new JTable();
		tbDSBenh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setColumnHeaderView(tbDSBenh);
		scrollPane.setViewportView(tbDSBenh);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 241, 526, 204);
		pnlQD2.add(scrollPane_1);
		tbDSThuoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		scrollPane_1.setColumnHeaderView(tbDSThuoc);
		scrollPane_1.setViewportView(tbDSThuoc);
		JLabel lblNewLabel_3 = new JLabel("Mã bệnh:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(567, 47, 80, 20);
		pnlQD2.add(lblNewLabel_3);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(567, 82, 80, 20);
		
		pnlQD2.add(lblNewLabel_5);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(567, 122, 80, 20);
		
		pnlQD2.add(lblNewLabel_6);
		
		JButton btnThemBenh = new JButton("Thêm");
		
		btnThemBenh.setBounds(567, 150, 97, 25);
		pnlQD2.add(btnThemBenh);
		
		JButton btnXoaBenh = new JButton("Xóa");

		btnXoaBenh.setBounds(673, 150, 97, 25);
		pnlQD2.add(btnXoaBenh);
		
		JButton btnCapNhatBenh = new JButton("Cập nhật");
		
		btnCapNhatBenh.setBounds(782, 150, 97, 25);
		pnlQD2.add(btnCapNhatBenh);
		
		txtMaBenh = new JTextField();
		txtMaBenh.setEditable(false);
		txtMaBenh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaBenh.setBounds(659, 47, 220, 20);
		pnlQD2.add(txtMaBenh);
		txtMaBenh.setColumns(10);
		
		txtLoaiBenh = new JTextField();
		txtLoaiBenh.setEditable(false);
		txtLoaiBenh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLoaiBenh.setColumns(10);
		txtLoaiBenh.setBounds(659, 81, 220, 20);
		pnlQD2.add(txtLoaiBenh);
		
		txtMoTaBenh = new JTextField();
		txtMoTaBenh.setEditable(false);
		txtMoTaBenh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMoTaBenh.setColumns(10);
		txtMoTaBenh.setBounds(659, 122, 220, 20);
		pnlQD2.add(txtMoTaBenh);
		lblNewLabel_4.setBounds(567, 255, 80, 20);
		
		pnlQD2.add(lblNewLabel_4);
		lblNewLabel_4_1.setBounds(567, 290, 80, 20);
		
		pnlQD2.add(lblNewLabel_4_1);
		lblNewLabel_4_1_1.setBounds(567, 325, 80, 20);
		
		pnlQD2.add(lblNewLabel_4_1_1);
		lblNewLabel_4_1_1_1.setBounds(567, 360, 80, 20);
		
		pnlQD2.add(lblNewLabel_4_1_1_1);

		btnCapNhatThuoc.setBounds(782, 420, 97, 25);
		
		pnlQD2.add(btnCapNhatThuoc);
		txtMaThuoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaThuoc.setEditable(false);
		txtMaThuoc.setColumns(10);
		txtMaThuoc.setBounds(659, 254, 220, 20);
		
		pnlQD2.add(txtMaThuoc);
		txtTenThuoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenThuoc.setEditable(false);
		txtTenThuoc.setColumns(10);
		txtTenThuoc.setBounds(659, 289, 220, 20);
		
		pnlQD2.add(txtTenThuoc);
		txtDonVi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDonVi.setEditable(false);
		txtDonVi.setColumns(10);
		txtDonVi.setBounds(659, 324, 220, 20);
		
		pnlQD2.add(txtDonVi);
		txtCachDung.setDisabledTextColor(Color.BLACK);
		txtCachDung.setWrapStyleWord(true);
		txtCachDung.setLineWrap(true);
		txtCachDung.setBackground(SystemColor.controlHighlight);
		txtCachDung.setForeground(Color.BLACK);
		txtCachDung.setEnabled(false);
		txtCachDung.setEditable(false);
		txtCachDung.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCachDung.setColumns(10);
		txtCachDung.setBounds(659, 359, 220, 48);
		
		pnlQD2.add(txtCachDung);
		cbCachDung.setModel(new DefaultComboBoxModel(new String[] {"CD0000 - NULL", "CD0001 - Ngày uống 2 lần, mỗi lần 1 viên(gói), trước ăn 1 giờ sáng, chiều", "CD0002 - Ngày uống 2 lần, mỗi lần 1 viên(gói), sau ăn sáng, chiều", "CD0003 - Ngày uống 3 lần, mỗi lần 1 viên(gói), trước ăn 1 giờ sáng, trưa, chiều", "CD0004 - Ngày uống 3 lần, mỗi lần 1 viên(gói), sau ăn sáng, trưa, chiều "}));
		
		
		cbCachDung.setBounds(659, 357, 220, 48);
		pnlQD2.add(cbCachDung);
		pnlQD1.setBounds(12, 61, 885, 479);
		pnlQuyDinh.add(pnlQD1);
		
		pnlQD1.setLayout(null);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(193, 44, 259, 25);
		
		pnlQD1.add(lblNewLabel_2);
		
		pnlQD1.add(txtSLQD1);
		
		btnCapNhatQD1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapNhatQD1.setBounds(547, 44, 97, 25);
		
		pnlQD1.add(btnCapNhatQD1);
		//
		
		
		//
		
		cbQuyDinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		cbQuyDinh.setModel(new DefaultComboBoxModel(new String[] {"QĐ1: Thay đổi số lượng bệnh nhân tối đa trong ngày.", "QĐ2: Thay đổi số lượng loại bệnh, thuốc, đơn vị tính, cách dùng.", "QĐ4: Thay đổi tiền khám, đơn giá thuốc."}));
		cbQuyDinh.setBounds(159, 13, 505, 25);
		pnlQuyDinh.add(cbQuyDinh);
		//---------------------------
		pnlKhamBenh.setVisible(false);
		pnlKhamBenh.setBounds(0, 0, 909, 553);

		pnlContent.add(pnlKhamBenh);
		pnlKhamBenh.setLayout(null);

		dateChooserDate.setDateFormatString("dd-MM-yyyy");
		dateChooserDate.setBounds(336, 0, 164, 29);
		pnlKhamBenh.add(dateChooserDate);

		pnlTools.setLayout(null);
		pnlTools.setOpaque(false);
		pnlTools.setBounds(478, 600, 500, 40);
		pnlRight.add(pnlTools);

		btnXoa.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnXoa.setBounds(350, 5, 100, 30);
		pnlTools.add(btnXoa);
		
		btnThem.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnThem.setBounds(200, 5, 100, 30);
		
		pnlTools.add(btnThem);
		btnLamMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showDSBenhNhan("select * from BenhNhan");
			}
		});
		btnLamMoi.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnLamMoi.setBounds(50, 5, 100, 30);
		
		pnlTools.add(btnLamMoi);

		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(47, 13, 909, 25);
		pnlRight.add(lblTitle);

		this.setSize(1200, 800);
		dateChooserDate.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnTimKiem.setBounds(501, 0, 100, 29);
		pnlKhamBenh.add(btnTimKiem);
		scrollPaneKB.setBounds(0, 42, 909, 511);

		pnlKhamBenh.add(scrollPaneKB);

		tbDSKhamBenh.setFont(new Font("Tahoma", Font.PLAIN, 15));

		scrollPaneKB.setColumnHeaderView(tbDSKhamBenh);
		scrollPaneKB.setViewportView(tbDSKhamBenh);
		tbDSKhamBenh.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
		tbDSKhamBenh.getTableHeader().setBackground(new Color(192, 192, 192));
		tbDSKhamBenh.getTableHeader().setEnabled(false);
		tbDSKhamBenh.setRowHeight(30);
		pnlBenhNhan.setVisible(false);
		pnlBenhNhan.setBounds(0, 0, 909, 553);

		pnlContent.add(pnlBenhNhan);
		pnlBenhNhan.setLayout(null);

		JScrollPane scrollPanelBN = new JScrollPane();
		scrollPanelBN.setBounds(0, 0, 909, 553);
		pnlBenhNhan.add(scrollPanelBN);
		tbDSBenhNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tbDSBenhNhan.setBounds(0, 0, 1, 1);
		tbDSBenhNhan.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
		tbDSBenhNhan.getTableHeader().setBackground(new Color(192, 192, 192));
		tbDSBenhNhan.getTableHeader().setEnabled(false);
		tbDSBenhNhan.setRowHeight(30);
		scrollPanelBN.setColumnHeaderView(tbDSBenhNhan);
		scrollPanelBN.setViewportView(tbDSBenhNhan);

		pnlBaoCao.setBounds(0, 0, 909, 553);
		pnlContent.add(pnlBaoCao);
		pnlBaoCao.setLayout(null);
		//
		JLabel lblNewLabel = new JLabel("Báo cáo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(304, 10, 70, 25);
		pnlBaoCao.add(lblNewLabel);
		cbBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cbBaoCao.setBounds(372, 10, 200, 25);
		pnlBaoCao.add(cbBaoCao);
		pnlDoanhThuNgay.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		pnlDoanhThuNgay.setBounds(0, 48, 909, 505);

		pnlBaoCao.add(pnlDoanhThuNgay);
		pnlDoanhThuNgay.setLayout(null);
		scrollPaneDoanhThu.setBorder(null);
		scrollPaneDoanhThu.setBounds(0, 53, 909, 451);

		pnlDoanhThuNgay.add(scrollPaneDoanhThu);
		tbBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 16));

		scrollPaneDoanhThu.setColumnHeaderView(tbBaoCao);
		scrollPaneDoanhThu.setViewportView(tbBaoCao);
		tbBaoCao.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
		tbBaoCao.getTableHeader().setBackground(new Color(192, 192, 192));
		tbBaoCao.getTableHeader().setEnabled(false);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(304, 13, 60, 25);

		pnlDoanhThuNgay.add(lblNewLabel_1);

		yearBaoCao.getSpinner().setLocation(0, 10);
		yearBaoCao.setBounds(492, 13, 80, 25);
		yearBaoCao.setFont(new Font("Tahoma", Font.BOLD, 15));
		yearBaoCao.setHorizontalAlignment(0);
		pnlDoanhThuNgay.add(yearBaoCao);

		JLabel lblNewLabel_1_1 = new JLabel("Năm:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(445, 13, 48, 25);
		pnlDoanhThuNgay.add(lblNewLabel_1_1);
		cbMonthBaoCao.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbMonthBaoCao.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		cbMonthBaoCao.setBounds(359, 13, 74, 25);

		pnlDoanhThuNgay.add(cbMonthBaoCao);

		btnXemBaoCao.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXemBaoCao.setBounds(575, 13, 80, 25);

		pnlDoanhThuNgay.add(btnXemBaoCao);//

		//-------------------------------
		pnlSuDungThuoc.setLayout(null);
		pnlSuDungThuoc.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		pnlSuDungThuoc.setBounds(0, 48, 909, 505);
		pnlSuDungThuoc.setVisible(false);
		pnlBaoCao.add(pnlSuDungThuoc);
		scrollPaneSuDungThuoc.setBorder(null);
		scrollPaneSuDungThuoc.setBounds(0, 53, 909, 451);
		
		pnlSuDungThuoc.add(scrollPaneSuDungThuoc);
		
		tbSuDungThuoc = new JTable();
		tbSuDungThuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPaneSuDungThuoc.setColumnHeaderView(tbSuDungThuoc);
		scrollPaneSuDungThuoc.setViewportView(tbSuDungThuoc);
		tbSuDungThuoc.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
		tbSuDungThuoc.getTableHeader().setBackground(new Color(192, 192, 192));
		tbSuDungThuoc.getTableHeader().setEnabled(false);
		tbSuDungThuoc.setRowHeight(30);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(304, 13, 60, 25);
		
		pnlSuDungThuoc.add(lblNewLabel_1_2);
		yearBaoCaoThuoc.setHorizontalAlignment(0);
		yearBaoCaoThuoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		yearBaoCaoThuoc.setBounds(492, 13, 80, 25);
		
		pnlSuDungThuoc.add(yearBaoCaoThuoc);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(445, 13, 48, 25);
		
		pnlSuDungThuoc.add(lblNewLabel_1_1_1);
		cbMonthBaoCaoThuoc.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbMonthBaoCaoThuoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbMonthBaoCaoThuoc.setBounds(359, 13, 74, 25);
		
		pnlSuDungThuoc.add(cbMonthBaoCaoThuoc);

		btnXemBaoCaoThuoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXemBaoCaoThuoc.setBounds(575, 13, 80, 25);
		
		pnlSuDungThuoc.add(btnXemBaoCaoThuoc);
		
		pnlTools.setVisible(false);
		
		
		
		
		//Quy định
//		pnlQuyDinh.setBounds(0, 0, 909, 553);
//		pnlContent.add(pnlQuyDinh);

		//
//		pnlBaoCao.setBounds(0, 0, 909, 553);
//		pnlContent.add(pnlBaoCao);
//		pnlBaoCao.setLayout(null);
		clickedMenu(0);
		// design

		// add action
		lblBenhNhan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clickedMenu(1);
			}
		});
		lblKhamBenh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickedMenu(2);
			}
		});
		lblBaoCao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickedMenu(3);
			}
		});
		
		btnTimKiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (dateChooserDate.getDate() != null) {
					SimpleDateFormat sdfv2=new SimpleDateFormat("yyyy-MM-dd");
					String query = "select BN.MaBN, BN.HoTen,BN.GioiTinh,BN.NamSinh,BN.DiaChi\n"
							+ "from BenhNhan BN, PhieuKham PK\n" + "where PK.NgayKham like '"
							+ sdfv2.format(dateChooserDate.getDate()) + "' and BN.MaBN=PK.MaBN";
					showDSBenhNhan(query);
				} else
					showDSBenhNhan("select * from BenhNhan");

			}
		});

		tbDSKhamBenh.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int col = tbDSKhamBenh.getSelectedColumn();
				int row = tbDSKhamBenh.getSelectedRow();
				if (e.getClickCount() == 2) {
					if (col == 6) {
						relaMaBN = tbDSKhamBenh.getValueAt(row, 1).toString();
						PhieuKhamBenhForm.createPhieuKhamBenh(relaMaBN, dateChooserDate.getDate());
					}
				}
			}
		});
		tbDSBenhNhan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int col = tbDSBenhNhan.getSelectedColumn();
				int row = tbDSBenhNhan.getSelectedRow();
				if (e.getClickCount() == 2) {
					if (col == 5) {
						HoaDonThanhToanForm.createHoaDonThanhToan(relaMaPhieuKham.get(row));
					}
				}
			}
		});
		btnXemBaoCao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showDoanhThu(Integer.parseInt(cbMonthBaoCao.getSelectedItem().toString()), yearBaoCao.getYear());
			}
		});
		btnXemBaoCaoThuoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showBCSuDungThuoc(Integer.parseInt(cbMonthBaoCaoThuoc.getSelectedItem().toString()), yearBaoCaoThuoc.getYear());
			}
		});
		cbBaoCao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent change) {
				if (change.getStateChange() == ItemEvent.SELECTED) {
					getKieuDoanhThu();
				}
			}
		});
		cbQuyDinh.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					getKieuQuyDinh();
				}
				
			}
		});
		btnCapNhatQD1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Connection connection=ConnectDatabaseSQL.connectSQL();
				try {
					PreparedStatement ps=connection.prepareStatement("update QuyDinh set Soluong= "+Integer.parseInt(txtSLQD1.getText())+" where maQD='QD1'");
					ps.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ConnectDatabaseSQL.closeDatabaseSQL(connection);
				
			}
		});
		tbDSBenh.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int col = tbDSBenh.getSelectedColumn();
				int row = tbDSBenh.getSelectedRow();
				txtMaBenh.setText(dsBenh.get(row+1).maBenh);
				txtLoaiBenh.setText(dsBenh.get(row+1).loaiBenh);
				txtMoTaBenh.setText(dsBenh.get(row+1).moTaBenh);
				txtMoTaBenh.setEditable(false);
				txtLoaiBenh.setEditable(false);
				btnThemBenh.setText("Thêm");
			}
		});
		btnThemBenh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnThemBenh.getText().equals("Thêm")) {
					int m_temp=Integer.parseInt(dsBenh.get(dsBenh.size()-1).maBenh.toString().substring(4))+1;
					String m_benh="";
					if(m_temp<10) m_benh="Benh000"+m_temp;
					else if(m_temp<100) m_benh="Benh00"+m_temp;
					else if(m_temp<1000) m_benh="Benh0"+m_temp;
					
					txtMaBenh.setText(m_benh);
					txtLoaiBenh.setText("");
					txtLoaiBenh.setEditable(true);
					txtMoTaBenh.setText("");
					txtMoTaBenh.setEditable(true);
					btnThemBenh.setText("Lưu");
				}
				else {
					if(txtLoaiBenh.getText().equals("")==false) {
						Connection connection=ConnectDatabaseSQL.connectSQL();
						try {
							PreparedStatement ps=connection.prepareStatement("Insert into Benh values('"+txtMaBenh.getText()+"','"+txtLoaiBenh.getText()+"','"+txtMoTaBenh.getText()+"')");
							ps.execute();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						showDSBenh();
						ConnectDatabaseSQL.closeDatabaseSQL(connection);
					}
				}
			}
		});
		btnXoaBenh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection connection=ConnectDatabaseSQL.connectSQL();
				try {
					PreparedStatement ps=connection.prepareStatement("delete from Benh where mabenh='"+txtMaBenh.getText()+"'");
					txtMaBenh.setText("");
					txtLoaiBenh.setText("");
					txtMoTaBenh.setText("");
					ps.execute();
				} catch (SQLException ev) {
					// TODO Auto-generated catch block
					ev.printStackTrace();
				}
				showDSBenh();
				ConnectDatabaseSQL.closeDatabaseSQL(connection);
			}
		});
		btnCapNhatBenh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnCapNhatBenh.getText().equals("Cập nhật")==true) {
					txtLoaiBenh.setEditable(true);
					txtMoTaBenh.setEditable(true);
					btnCapNhatBenh.setText("Lưu");
				}else {
					Connection connection=ConnectDatabaseSQL.connectSQL();
					try {
						PreparedStatement ps=connection.prepareStatement("update Benh set loaibenh='"+txtLoaiBenh.getText()+"',motabenh='"+txtMoTaBenh.getText()+"' where mabenh='"+txtMaBenh.getText()+"'");
						ps.execute();
					} catch (SQLException ev) {
						// TODO Auto-generated catch block
						ev.printStackTrace();
					}
					showDSBenh();
					ConnectDatabaseSQL.closeDatabaseSQL(connection);
					txtLoaiBenh.setEditable(false);
					txtMoTaBenh.setEditable(false);
					btnCapNhatBenh.setText("Cập nhật");
				}
			}
		});
		tbDSThuoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int col = tbDSThuoc.getSelectedColumn();
				int row = tbDSThuoc.getSelectedRow();
				txtMaThuoc.setText(dsThuoc.get(row+1).maThuoc);
				txtTenThuoc.setText(dsThuoc.get(row+1).tenThuoc);
				txtDonVi.setText(dsThuoc.get(row+1).donVi);
				txtCachDung.setText(dsThuoc.get(row+1).cachDung);
				
				txtMaThuoc.setEditable(false);
				txtTenThuoc.setEditable(false);
				txtDonVi.setEditable(false);
				txtCachDung.setEditable(false);
				txtCachDung.setVisible(true);
				btnCapNhatThuoc.setText("Cập nhật");
			}
		});
		btnCapNhatThuoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(btnCapNhatThuoc.getText().equals("Cập nhật")==true) {
					txtCachDung.setVisible(false);
					cbCachDung.setVisible(true);
					btnCapNhatThuoc.setText("Lưu");
				}else {
					int temp=cbCachDung.getSelectedIndex();
					String m_cd="CD000"+temp;
					Connection connection=ConnectDatabaseSQL.connectSQL();
					try {
						PreparedStatement ps=connection.prepareStatement("update Thuoc set macachdung='"+m_cd+"' where mathuoc='"+txtMaThuoc.getText()+"'");
						ps.execute();
						System.out.println("ĐÃ update");
					} catch (SQLException ev) {
						// TODO Auto-generated catch block
						ev.printStackTrace();
					}
					showDSThuoc();
					
					ConnectDatabaseSQL.closeDatabaseSQL(connection);
					txtCachDung.setVisible(true);
					cbCachDung.setVisible(false);
					btnCapNhatBenh.setText("Cập nhật");
				}
			}
		});
		tbDonGiaThuoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int col = tbDonGiaThuoc.getSelectedColumn();
				int row = tbDonGiaThuoc.getSelectedRow();
				txtDonGia.setText(donGiaThuoc.get(row+1)+"");
			}
		});
		btnTienKham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtTienKham.getText().matches("[+-]?\\d*(\\.\\d+)?")==true) {
					Connection connection=ConnectDatabaseSQL.connectSQL();
					try {
						PreparedStatement ps=connection.prepareStatement("update Thuoc set dongia="+Integer.parseInt(txtTienKham.getText())+" where mathuoc='thuoc0000'");
						ps.execute();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ConnectDatabaseSQL.closeDatabaseSQL(connection);
				}
			}
		});
		btnDonGia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=tbDonGiaThuoc.getSelectedRow();
				if(row>=0 && txtDonGia.getText().matches("[+-]?\\d*(\\.\\d+)?")==true) {
					Connection connection=ConnectDatabaseSQL.connectSQL();
					try {
						PreparedStatement ps=connection.prepareStatement("update Thuoc set dongia="+Integer.parseInt(txtDonGia.getText())+" where mathuoc='"+dsThuoc.get(row+1).maThuoc+"'");
						ps.execute();
						System.out.println(dsThuoc.get(row+1).maThuoc);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					showDonGiaThuoc();
				}
			}
		});
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(pnlBenhNhan.isVisible()==true) {
				}
				else if(pnlKhamBenh.isVisible()==true) {
					f.setVisible(true);
					f.showFThemBN(f);
					f.setLocationRelativeTo(null);
					BenhNhan bn=f.getBN();
				}
			}
		});
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(pnlBenhNhan.isVisible()==true) {
					
				}
				else if(pnlKhamBenh.isVisible()==true) {
					int row=tbDSKhamBenh.getSelectedRow();
					String maBN=getDSBenhNhan("select * from benhnhan").get(row).getMaBN();
					System.out.println(row+"--"+maBN);
					Connection connection=ConnectDatabaseSQL.connectSQL();
					try {
						PreparedStatement ps=connection.prepareStatement("delete from benhnhan where mabn='"+maBN+"'");
						ps.execute();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ConnectDatabaseSQL.closeDatabaseSQL(connection);
					showDSBenhNhan("select * from benhnhan");
				}
			}
		});

		f.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				showDSBenhNhan("select * from benhnhan");
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	ThemBenhNhanForm f=new ThemBenhNhanForm();
	public void clickedMenu(int i) {
		if (i == 1) {
			lblBenhNhan.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 18));
			lblKhamBenh.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblBaoCao.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblQuyDinh.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblBenhNhan.setForeground(Color.WHITE);
			lblKhamBenh.setForeground(Color.black);
			lblBaoCao.setForeground(Color.black);
			lblQuyDinh.setForeground(Color.black);
			lblBenhNhan.setBackground(new Color(128, 128, 128));
			lblKhamBenh.setBackground(new Color(220, 220, 220));
			lblBaoCao.setBackground(new Color(220, 220, 220));
			lblQuyDinh.setBackground(new Color(220, 220, 220));
			lblTitle.setText("DANH SÁCH BỆNH NHÂN");
			showDSBenhNhan("select * from BenhNhan");
			pnlKhamBenh.setVisible(true);
			pnlBenhNhan.setVisible(false);
			pnlBaoCao.setVisible(false);
			pnlQuyDinh.setVisible(false);
			pnlTools.setVisible(true);
		} else if (i == 2) {
			lblBenhNhan.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblKhamBenh.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 18));
			lblBaoCao.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblQuyDinh.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblBenhNhan.setForeground(Color.black);
			lblKhamBenh.setForeground(Color.white);
			lblBaoCao.setForeground(Color.black);
			lblQuyDinh.setForeground(Color.black);
			lblBenhNhan.setBackground(new Color(220, 220, 220));
			lblKhamBenh.setBackground(new Color(128, 128, 128));
			lblBaoCao.setBackground(new Color(220, 220, 220));
			lblQuyDinh.setBackground(new Color(220, 220, 220));
			lblTitle.setText("DANH SÁCH KHÁM BỆNH");
			showDSBenhNhanTab2(
					"select BN.HoTen,PK.NgayKham,B.LoaiBenh,PK.TrieuChung,PK.MaPhieuKham from BenhNhan BN, PhieuKham PK, Benh B where BN.MaBN=PK.MaBN and PK.MaBenh=B.MaBenh ");
			pnlKhamBenh.setVisible(false);
			pnlBenhNhan.setVisible(true);
			pnlBaoCao.setVisible(false);
			pnlQuyDinh.setVisible(false);
			pnlTools.setVisible(false);
		} else if (i == 3) {
			lblBenhNhan.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblKhamBenh.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblBaoCao.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 18));
			lblQuyDinh.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblBenhNhan.setForeground(Color.black);
			lblKhamBenh.setForeground(Color.black);
			lblBaoCao.setForeground(Color.white);
			lblQuyDinh.setForeground(Color.black);
			lblBenhNhan.setBackground(new Color(220, 220, 220));
			lblKhamBenh.setBackground(new Color(220, 220, 220));
			lblBaoCao.setBackground(new Color(128, 128, 128));
			lblQuyDinh.setBackground(new Color(220, 220, 220));
			lblTitle.setText("BÁO CÁO");
			pnlKhamBenh.setVisible(false);
			pnlBenhNhan.setVisible(false);
			pnlBaoCao.setVisible(true);
			pnlQuyDinh.setVisible(false);
			showDoanhThuTheoNgay();
			pnlTools.setVisible(false);
		}else if(i==4) {
			lblBenhNhan.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblKhamBenh.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblBaoCao.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblQuyDinh.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 18));
			lblBenhNhan.setForeground(Color.black);
			lblKhamBenh.setForeground(Color.black);
			lblBaoCao.setForeground(Color.black);
			lblQuyDinh.setForeground(Color.white);
			lblBenhNhan.setBackground(new Color(220, 220, 220));
			lblKhamBenh.setBackground(new Color(220, 220, 220));
			lblBaoCao.setBackground(new Color(220, 220, 220));
			lblQuyDinh.setBackground(new Color(128, 128, 128));
			lblTitle.setText("CHỈNH SỬA QUY ĐỊNH");
			pnlKhamBenh.setVisible(false);
			pnlBenhNhan.setVisible(false);
			pnlBaoCao.setVisible(false);
			pnlQuyDinh.setVisible(true);
			getKieuQuyDinh();
			pnlTools.setVisible(false);
		}
		else if (i == 0) {
			lblBenhNhan.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblKhamBenh.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblBaoCao.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblQuyDinh.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblBenhNhan.setForeground(Color.black);
			lblKhamBenh.setForeground(Color.black);
			lblBaoCao.setForeground(Color.black);
			lblQuyDinh.setForeground(Color.black);
			lblBenhNhan.setBackground(new Color(220, 220, 220));
			lblKhamBenh.setBackground(new Color(220, 220, 220));
			lblBaoCao.setBackground(new Color(220, 220, 220));
			lblQuyDinh.setBackground(new Color(220, 220, 220));
			pnlKhamBenh.setVisible(false);
			pnlBenhNhan.setVisible(false);
			pnlBaoCao.setVisible(false);
			pnlQuyDinh.setVisible(false);
			pnlTools.setVisible(false);
		}

	}

	public Vector<BenhNhan> getDSBenhNhan(String query) {
		Vector<BenhNhan> dsBN = new Vector<BenhNhan>();
		Connection connection = ConnectDatabaseSQL.connectSQL();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dsBN.add(new BenhNhan(rs.getString("MaBN"), rs.getString("HoTen"), rs.getInt("GioiTinh"),
						rs.getInt("NamSinh"), rs.getString("DiaChi")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		return dsBN;
	}

	public void showDSBenhNhan(String query) {
		String[] colName = { "STT", "Mã BN", "Họ tên", "Giới tính", "Năm sinh", "Địa chỉ", "Phiếu khám" };

		DefaultTableModel model = new DefaultTableModel(colName, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		Vector<BenhNhan> dsBN = getDSBenhNhan(query);
		for (int i = 0; i < dsBN.size(); i++) {
			if (dsBN.get(i).getGioiTinh() == 0) {
				model.addRow(new Object[] { i + 1, dsBN.get(i).getMaBN(), dsBN.get(i).getHoTen(), "Nữ",
						dsBN.get(i).getNamSinh(), dsBN.get(i).getDiaChi(), "Xem" });
			} else if (dsBN.get(i).getGioiTinh() == 1) {
				model.addRow(new Object[] { i + 1, dsBN.get(i).getMaBN(), dsBN.get(i).getHoTen(), "Nam",
						dsBN.get(i).getNamSinh(), dsBN.get(i).getDiaChi(), "Xem" });
			}
		}

		tbDSKhamBenh.setModel(model);
		setSizeTableDS();

	}

	public Vector<BenhNhanTab2> getDSBenhNhanTab2(String query) {
		Vector<BenhNhanTab2> dsBN = new Vector<BenhNhanTab2>();
		Connection connection = ConnectDatabaseSQL.connectSQL();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dsBN.add(new BenhNhanTab2(rs.getString("HoTen"), rs.getString("NgayKham"), rs.getString("LoaiBenh"),
						rs.getString("TrieuChung"), rs.getString("MaPhieuKham")));
				relaMaPhieuKham.add(rs.getString("MaPhieuKham"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		return dsBN;
	}

	public void showDSBenhNhanTab2(String query) {
		String[] colName = { "STT", "Họ tên", "Ngày khám", "Loại bệnh", "Triệu chứng", "Hóa đơn" };

		DefaultTableModel model = new DefaultTableModel(colName, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		Vector<BenhNhanTab2> dsBN = getDSBenhNhanTab2(query);
		for (int i = 0; i < dsBN.size(); i++) {
			model.addRow(new Object[] { i + 1, dsBN.get(i).getHoTen(), dsBN.get(i).getNgayKham(),
					dsBN.get(i).getLoaiBenh(), dsBN.get(i).getTrieuChung(), "Xem" });
		}
		tbDSBenhNhan.setModel(model);
		setSizeTableDSTab2();
	}

	public void setSizeTableDS() {
		TableColumnModel coloModel = tbDSKhamBenh.getColumnModel();
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(0);
		coloModel.getColumn(0).setPreferredWidth(10);
		coloModel.getColumn(1).setPreferredWidth(50);
		coloModel.getColumn(2).setPreferredWidth(200);
		coloModel.getColumn(3).setPreferredWidth(80);
		coloModel.getColumn(4).setPreferredWidth(80);
		coloModel.getColumn(5).setPreferredWidth(200);
		coloModel.getColumn(6).setPreferredWidth(100);
		coloModel.getColumn(0).setCellRenderer(centerRender);
		coloModel.getColumn(6).setCellRenderer(centerRender);
	}

	public void setSizeTableDSTab2() {
		TableColumnModel coloModel = tbDSBenhNhan.getColumnModel();
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(0);
		coloModel.getColumn(0).setPreferredWidth(10);
		coloModel.getColumn(1).setPreferredWidth(200);
		coloModel.getColumn(2).setPreferredWidth(80);
		coloModel.getColumn(3).setPreferredWidth(100);
		coloModel.getColumn(4).setPreferredWidth(200);
		coloModel.getColumn(5).setPreferredWidth(80);
		coloModel.getColumn(0).setCellRenderer(centerRender);
		coloModel.getColumn(5).setCellRenderer(centerRender);
	}

	public void createItemCbBaoCao() {
		Object[] itemCbBaoCao = {  "Doanh thu theo ngày" , "Sử dụng thuốc" };
		for (int i = 0; i < itemCbBaoCao.length; i++) {
			cbBaoCao.addItem(itemCbBaoCao[i]);
		}
	}

	public Vector<BaoCaoDoanhThu> getDoanhThu(int thang, int nam) {
		Vector<BaoCaoDoanhThu> data = new Vector<BaoCaoDoanhThu>();
		String query = "declare @demSLThang float;\r\n" + "select @demSLThang=sum(CTHD.SoLuongThuoc*T.DonGia)\r\n"
				+ "from HoaDon HD,BenhNhan BN, PhieuKham PK,ChiTietHD CTHD, Thuoc T\r\n"
				+ "where HD.MaPhieuKham=PK.MaPhieuKham and BN.MaBN=PK.MaBN and CTHD.MaHoaDon=HD.MaHoaDon and PK.MaBN=BN.MaBN and CTHD.MaThuoc = T.MaThuoc and MONTH(HD.NgayLapHD)="
				+ thang + " and YEAR(HD.NgayLapHD)=" + nam + "group by MONTH(HD.NgayLapHD)\r\n"
				+ "select HD.NgayLapHD,count(DISTINCT BN.MaBN) as SoLuongBN,sum(CTHD.SoLuongThuoc*T.DonGia) as DoanhThu,(sum(CTHD.SoLuongThuoc*T.DonGia)/@demSLThang)*100 as TyLe\r\n"
				+ "from HoaDon HD,BenhNhan BN, PhieuKham PK,ChiTietHD CTHD, Thuoc T\r\n"
				+ "where HD.MaPhieuKham=PK.MaPhieuKham and BN.MaBN=PK.MaBN and CTHD.MaHoaDon=HD.MaHoaDon and PK.MaBN=BN.MaBN and CTHD.MaThuoc = T.MaThuoc and MONTH(HD.NgayLapHD)="
				+ thang + " and YEAR(HD.NgayLapHD)=" + nam + "group by HD.NgayLapHD";
		Connection connection = ConnectDatabaseSQL.connectSQL();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data.add(new BaoCaoDoanhThu(rs.getDate("NgayLapHD"), rs.getInt("SoLuongBN"), rs.getInt("DoanhThu"),
						rs.getFloat("TyLe")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		return data;
	}

	public void showDoanhThu(int thang, int nam) {
		Object[] colName = { "STT", "Ngày", "Số bệnh nhân", "Doanh thu (VNĐ)", "Tỉ lệ (%)" };
		Vector<BaoCaoDoanhThu> data = getDoanhThu(thang, nam);
		DefaultTableModel model = new DefaultTableModel(colName, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		DecimalFormat df=new DecimalFormat("###,###.##");
		
		for (int i = 0; i < data.size(); i++) {
			model.addRow(new Object[] { i + 1, sdf.format(data.get(i).getNgayBC()), data.get(i).getSoBN(),
					df.format(data.get(i).getDoanhThu()), df.format(data.get(i).getTyLe()) });
		}
		tbBaoCao.setModel(model);
		setSizeTableBaoCao();
	}

	public void setSizeTableBaoCao() {
		TableColumnModel coloModel = tbBaoCao.getColumnModel();
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(0);
		tbBaoCao.setRowHeight(30);
		coloModel.getColumn(0).setPreferredWidth(10);
		coloModel.getColumn(1).setPreferredWidth(200);
		coloModel.getColumn(2).setPreferredWidth(80);
		coloModel.getColumn(3).setPreferredWidth(200);
		coloModel.getColumn(4).setPreferredWidth(100);
		coloModel.getColumn(0).setCellRenderer(centerRender);
		coloModel.getColumn(1).setCellRenderer(centerRender);
		coloModel.getColumn(2).setCellRenderer(centerRender);
		coloModel.getColumn(3).setCellRenderer(centerRender);
		coloModel.getColumn(4).setCellRenderer(centerRender);
	}
	public void setSizeTableBaoCaoThuoc() {
		TableColumnModel coloModel = tbSuDungThuoc.getColumnModel();
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(0);
		tbSuDungThuoc.setRowHeight(30);
		coloModel.getColumn(0).setPreferredWidth(10);
		coloModel.getColumn(1).setPreferredWidth(200);
		coloModel.getColumn(2).setPreferredWidth(80);
		coloModel.getColumn(3).setPreferredWidth(200);
		coloModel.getColumn(4).setPreferredWidth(100);
		coloModel.getColumn(0).setCellRenderer(centerRender);
		coloModel.getColumn(1).setCellRenderer(centerRender);
		coloModel.getColumn(2).setCellRenderer(centerRender);
		coloModel.getColumn(3).setCellRenderer(centerRender);
		coloModel.getColumn(4).setCellRenderer(centerRender);
	}
	public void getKieuDoanhThu() {
		if(cbBaoCao.getSelectedIndex()==0) {
			pnlDoanhThuNgay.setVisible(true);
			pnlSuDungThuoc.setVisible(false);
		}
		else if(cbBaoCao.getSelectedIndex()==1) {
			pnlDoanhThuNgay.setVisible(false);
			pnlSuDungThuoc.setVisible(true);
		}
	}
	public void showDoanhThuTheoNgay() {
		cbBaoCao.removeAllItems();
		createItemCbBaoCao();


	}
	public Vector<BaoCaoSDThuoc> getSuDungThuoc(int thang, int nam) {
		Vector<BaoCaoSDThuoc> data = new Vector<BaoCaoSDThuoc>();
		String query = "select T.TenThuoc,T.DonVi,sum(CTHD.SoLuongThuoc) as SoLuongThuoc, count(CTHD.MaCTHD) as SoLanDung\r\n" + 
				"from Thuoc T,ChiTietHD CTHD,BenhNhan BN, PhieuKham PK, HoaDon HD\r\n" + 
				"where T.MaThuoc=CTHD.MaThuoc and PK.MaPhieuKham=HD.MaPhieuKham \r\n" + 
				"and T.TenThuoc not like N'Phí khám bệnh' and HD.MaHoaDon=CTHD.MaHoaDon and PK.MaBN=BN.MaBN and Month(HD.NgayLapHD)="+thang+" and Year(HD.NgayLapHD)="+nam + 
				"group by T.TenThuoc, T.DonVi";
		Connection connection = ConnectDatabaseSQL.connectSQL();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data.add(new BaoCaoSDThuoc(rs.getString("TenThuoc"), rs.getString("DonVi"), rs.getInt("SoLuongThuoc"),
						rs.getInt("SoLanDung")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		return data;
	}
	public void showBCSuDungThuoc(int thang, int nam) {
		Object[] colName = { "STT", "Thuốc", "Đơn vị", "Số lượng", "Số lần dùng" };
		Vector<BaoCaoSDThuoc> data = getSuDungThuoc(thang, nam);
		DefaultTableModel model = new DefaultTableModel(colName, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for (int i = 0; i < data.size(); i++) {
			model.addRow(new Object[] { i + 1, data.get(i).getTenThuoc(),data.get(i).getDonVi(),data.get(i).getSoLuong(),data.get(i).getSoLanDung() });
		}
		tbSuDungThuoc.setModel(model);
		setSizeTableBaoCaoThuoc();
	}
	public void setQuyDinh1() {
		
	}
	public void getKieuQuyDinh() {
		if(cbQuyDinh.getSelectedIndex()==0) {
			pnlQD1.setVisible(true);
			txtSLQD1.setText(getQD1()+"");
			pnlQD2.setVisible(false);
			pnlQD4.setVisible(false);
		}
		else if(cbQuyDinh.getSelectedIndex()==1) {
			pnlQD1.setVisible(false);
			pnlQD2.setVisible(true);
			showDSBenh();
			showDSThuoc();
			pnlQD4.setVisible(false);
		}
		else if(cbQuyDinh.getSelectedIndex()==2) {
			pnlQD1.setVisible(false);
			pnlQD2.setVisible(false);
			pnlQD4.setVisible(true);
			showDonGiaThuoc();
			showGiaKham();
		}
	}
	public int getQD1() {
		int sl=0;
		Connection connection=ConnectDatabaseSQL.connectSQL();
		try {
			PreparedStatement ps=connection.prepareStatement("select SoLuong from QuyDinh where MaQD='QD1'");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				sl=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		return sl;
	}
	public void showDSBenh() {
		String query="Select * from Benh";
		dsBenh=new Vector<Benh>();
		String[] colNames= {"Mã bệnh","Loại bệnh","Mô tả bệnh"};
		Connection connection=ConnectDatabaseSQL.connectSQL();
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				dsBenh.add(new Benh(rs.getString("mabenh"),rs.getString("loaibenh"),rs.getString("motabenh")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		DefaultTableModel model = new DefaultTableModel(colNames, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for(int i=1;i<dsBenh.size();i++) {
			model.addRow(new Object[] {dsBenh.get(i).maBenh,dsBenh.get(i).loaiBenh,dsBenh.get(i).moTaBenh});
		}
		tbDSBenh.setModel(model);
		setSizeTableDSBenh();
		
	}
	public void setSizeTableDSBenh() {
		TableColumnModel coloModel = tbDSBenh.getColumnModel();
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(0);
		tbDSBenh.setRowHeight(30);
		coloModel.getColumn(0).setPreferredWidth(50);
		coloModel.getColumn(1).setPreferredWidth(200);
		coloModel.getColumn(2).setPreferredWidth(80);
		coloModel.getColumn(0).setCellRenderer(centerRender);
		coloModel.getColumn(1).setCellRenderer(centerRender);
		coloModel.getColumn(2).setCellRenderer(centerRender);
		tbDSBenh.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		tbDSBenh.getTableHeader().setBackground(new Color(192, 192, 192));
		tbDSBenh.getTableHeader().setEnabled(false);
		tbDSBenh.setRowHeight(30);
	}
	public void showDSThuoc() {
		cbCachDung.setVisible(false);
		String query="select mathuoc, tenthuoc, donvi,cd.MoTaCD\r\n" + 
				"from Thuoc t , CachDung cd\r\n" + 
				"where t.MaCachDung=cd.MaCachDung";
		dsThuoc=new Vector<Thuoc>();
		String[] colNames= {"Mã thuốc","Tên thuốc","Đơn vị","Cách dùng"};
		Connection connection=ConnectDatabaseSQL.connectSQL();
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				dsThuoc.add(new Thuoc(rs.getString("mathuoc"),rs.getString("tenthuoc"),rs.getString("donvi"),rs.getString("motacd")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		DefaultTableModel model = new DefaultTableModel(colNames, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for(int i=1;i<dsThuoc.size();i++) {
			model.addRow(new Object[] {dsThuoc.get(i).maThuoc,dsThuoc.get(i).tenThuoc,dsThuoc.get(i).donVi,dsThuoc.get(i).cachDung});
		}
		tbDSThuoc.setModel(model);
		setSizeTableDSThuoc();
		
	}
	public void setSizeTableDSThuoc() {
		TableColumnModel coloModel = tbDSThuoc.getColumnModel();
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(0);
		tbDSThuoc.setRowHeight(30);
		coloModel.getColumn(0).setPreferredWidth(80);
		coloModel.getColumn(1).setPreferredWidth(100);
		coloModel.getColumn(2).setPreferredWidth(80);
		coloModel.getColumn(3).setPreferredWidth(200);
		coloModel.getColumn(0).setCellRenderer(centerRender);
		coloModel.getColumn(1).setCellRenderer(centerRender);
		coloModel.getColumn(2).setCellRenderer(centerRender);
		coloModel.getColumn(3).setCellRenderer(centerRender);
		tbDSThuoc.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		tbDSThuoc.getTableHeader().setBackground(new Color(192, 192, 192));
		tbDSThuoc.getTableHeader().setEnabled(false);
		tbDSThuoc.setRowHeight(30);
	}
	public void showGiaKham() {
		Connection connection=ConnectDatabaseSQL.connectSQL();
		int dsTK=0;
		try {
			PreparedStatement ps=connection.prepareStatement("select dongia from thuoc where mathuoc='thuoc0000'");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				dsTK=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		txtTienKham.setText(dsTK+"");
	}
	public void showDonGiaThuoc() {
		String query="select mathuoc, tenthuoc, donvi,cd.MoTaCD,t.dongia\r\n" + 
				"from Thuoc t , CachDung cd\r\n" + 
				"where t.MaCachDung=cd.MaCachDung";
		dsThuoc=new Vector<Thuoc>();
		donGiaThuoc=new Vector<Integer>();
		String[] colNames= {"Mã thuốc","Tên thuốc","Đơn giá"};
		Connection connection=ConnectDatabaseSQL.connectSQL();
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				dsThuoc.add(new Thuoc(rs.getString("mathuoc"),rs.getString("tenthuoc"),rs.getString("donvi"),rs.getString("motacd")));
				donGiaThuoc.add(rs.getInt("dongia"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectDatabaseSQL.closeDatabaseSQL(connection);
		DefaultTableModel model = new DefaultTableModel(colNames, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for(int i=1;i<dsThuoc.size();i++) {
			model.addRow(new Object[] {dsThuoc.get(i).maThuoc,dsThuoc.get(i).tenThuoc,donGiaThuoc.get(i)});
		}
		tbDonGiaThuoc.setModel(model);
		setSizeTableDSDonGia();
	}
	public void setSizeTableDSDonGia() {
		TableColumnModel coloModel = tbDonGiaThuoc.getColumnModel();
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(0);
		tbDonGiaThuoc.setRowHeight(30);
		coloModel.getColumn(0).setPreferredWidth(80);
		coloModel.getColumn(1).setPreferredWidth(300);
		coloModel.getColumn(0).setCellRenderer(centerRender);
		coloModel.getColumn(1).setCellRenderer(centerRender);
		tbDonGiaThuoc.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		tbDonGiaThuoc.getTableHeader().setBackground(new Color(192, 192, 192));
		tbDonGiaThuoc.getTableHeader().setEnabled(false);
		tbDonGiaThuoc.setRowHeight(30);
	}

}
