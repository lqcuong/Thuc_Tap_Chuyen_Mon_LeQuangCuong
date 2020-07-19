USE [master]
GO
/****** Object:  Database [QuanLyPhongMachTu]    Script Date: 07/01/2020 6:03:17 PM ******/
CREATE DATABASE [QuanLyPhongMachTu]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyPhongMachTu', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyPhongMachTu.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyPhongMachTu_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyPhongMachTu_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QuanLyPhongMachTu] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyPhongMachTu].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyPhongMachTu] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyPhongMachTu] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyPhongMachTu] SET QUERY_STORE = OFF
GO
USE [QuanLyPhongMachTu]
GO
/****** Object:  Table [dbo].[Benh]    Script Date: 07/01/2020 6:03:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Benh](
	[MaBenh] [varchar](10) NOT NULL,
	[LoaiBenh] [nvarchar](50) NULL,
	[MoTaBenh] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaBenh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BenhNhan]    Script Date: 07/01/2020 6:03:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BenhNhan](
	[MaBN] [varchar](10) NOT NULL,
	[HoTen] [nvarchar](30) NULL,
	[GioiTinh] [bit] NULL,
	[NamSinh] [int] NULL,
	[DiaChi] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaBN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CachDung]    Script Date: 07/01/2020 6:03:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CachDung](
	[MaCachDung] [varchar](10) NOT NULL,
	[MoTaCD] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCachDung] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHD]    Script Date: 07/01/2020 6:03:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHD](
	[MaCTHD] [varchar](10) NOT NULL,
	[SoLuongThuoc] [int] NULL,
	[MaHoaDon] [varchar](10) NULL,
	[MaThuoc] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCTHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 07/01/2020 6:03:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [varchar](10) NOT NULL,
	[NgayLapHD] [date] NULL,
	[MaPhieuKham] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuKham]    Script Date: 07/01/2020 6:03:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuKham](
	[MaPhieuKham] [varchar](10) NOT NULL,
	[NgayKham] [date] NULL,
	[TrieuChung] [nvarchar](100) NULL,
	[MaBN] [varchar](10) NULL,
	[MaBenh] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhieuKham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[QuyDinh]    Script Date: 07/01/2020 6:03:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QuyDinh](
	[MaQD] [varchar](10) NULL,
	[TenQD] [nvarchar](100) NULL,
	[NoiDung] [nvarchar](100) NULL,
	[SoLuong] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Thuoc]    Script Date: 07/01/2020 6:03:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thuoc](
	[MaThuoc] [varchar](10) NOT NULL,
	[TenThuoc] [nvarchar](50) NULL,
	[MoTaThuoc] [nvarchar](100) NULL,
	[DonVi] [nvarchar](30) NULL,
	[DonGia] [money] NULL,
	[MaBenh] [varchar](10) NULL,
	[MaCachDung] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Benh] ([MaBenh], [LoaiBenh], [MoTaBenh]) VALUES (N'Benh0000', N' ', NULL)
INSERT [dbo].[Benh] ([MaBenh], [LoaiBenh], [MoTaBenh]) VALUES (N'Benh0001', N'Viêm dạ dày cấp mãn tính', NULL)
INSERT [dbo].[Benh] ([MaBenh], [LoaiBenh], [MoTaBenh]) VALUES (N'Benh0002', N'nCovid-19', NULL)
INSERT [dbo].[Benh] ([MaBenh], [LoaiBenh], [MoTaBenh]) VALUES (N'Benh0003', N'Gan nhiễm mỡ', NULL)
INSERT [dbo].[Benh] ([MaBenh], [LoaiBenh], [MoTaBenh]) VALUES (N'Benh0004', N'Sốt xuất huyết', NULL)
INSERT [dbo].[Benh] ([MaBenh], [LoaiBenh], [MoTaBenh]) VALUES (N'Benh0005', N'Viêm khớp', NULL)
GO
INSERT [dbo].[BenhNhan] ([MaBN], [HoTen], [GioiTinh], [NamSinh], [DiaChi]) VALUES (N'BN0001', N'Đặng Tuấn Anh', 1, 1998, N'Hải Phòng')
INSERT [dbo].[BenhNhan] ([MaBN], [HoTen], [GioiTinh], [NamSinh], [DiaChi]) VALUES (N'BN0002', N'Đỗ Thị Hòa', 0, 1963, N'Vĩnh Phúc')
INSERT [dbo].[BenhNhan] ([MaBN], [HoTen], [GioiTinh], [NamSinh], [DiaChi]) VALUES (N'BN0003', N'Lê Tấn Trường', 1, 1990, N'Hải Phòng')
INSERT [dbo].[BenhNhan] ([MaBN], [HoTen], [GioiTinh], [NamSinh], [DiaChi]) VALUES (N'BN0004', N'Nguyễn Văn Hảo', 1, 1990, N'Huế')
GO
INSERT [dbo].[CachDung] ([MaCachDung], [MoTaCD]) VALUES (N'CD0000', NULL)
INSERT [dbo].[CachDung] ([MaCachDung], [MoTaCD]) VALUES (N'CD0001', N'Ngày uống 2 lần, mỗi lần 1 viên(gói), trước ăn 1 giờ sáng, chiều')
INSERT [dbo].[CachDung] ([MaCachDung], [MoTaCD]) VALUES (N'CD0002', N'Ngày uống 2 lần, mỗi lần 1 viên(gói), sau ăn sáng, chiều')
INSERT [dbo].[CachDung] ([MaCachDung], [MoTaCD]) VALUES (N'CD0003', N'Ngày uống 3 lần, mỗi lần 1 viên(gói), trước ăn 1 giờ sáng, trưa, chiều')
INSERT [dbo].[CachDung] ([MaCachDung], [MoTaCD]) VALUES (N'CD0004', N'Ngày uống 3 lần, mỗi lần 1 viên(gói), sau ăn sáng, trưa, chiều ')
GO
INSERT [dbo].[ChiTietHD] ([MaCTHD], [SoLuongThuoc], [MaHoaDon], [MaThuoc]) VALUES (N'CTHD0001', 1, N'HD0001', N'Thuoc0000')
INSERT [dbo].[ChiTietHD] ([MaCTHD], [SoLuongThuoc], [MaHoaDon], [MaThuoc]) VALUES (N'CTHD0002', 30, N'HD0001', N'Thuoc0008')
INSERT [dbo].[ChiTietHD] ([MaCTHD], [SoLuongThuoc], [MaHoaDon], [MaThuoc]) VALUES (N'CTHD0003', 1, N'HD0002', N'Thuoc0000')
INSERT [dbo].[ChiTietHD] ([MaCTHD], [SoLuongThuoc], [MaHoaDon], [MaThuoc]) VALUES (N'CTHD0004', 30, N'HD0002', N'Thuoc0020')
INSERT [dbo].[ChiTietHD] ([MaCTHD], [SoLuongThuoc], [MaHoaDon], [MaThuoc]) VALUES (N'CTHD0005', 20, N'HD0002', N'Thuoc0022')
INSERT [dbo].[ChiTietHD] ([MaCTHD], [SoLuongThuoc], [MaHoaDon], [MaThuoc]) VALUES (N'CTHD0006', 1, N'HD0003', N'Thuoc0000')
INSERT [dbo].[ChiTietHD] ([MaCTHD], [SoLuongThuoc], [MaHoaDon], [MaThuoc]) VALUES (N'CTHD0007', 50, N'HD0003', N'Thuoc0007')
INSERT [dbo].[ChiTietHD] ([MaCTHD], [SoLuongThuoc], [MaHoaDon], [MaThuoc]) VALUES (N'CTHD0008', 1, N'HD0004', N'Thuoc0000')
INSERT [dbo].[ChiTietHD] ([MaCTHD], [SoLuongThuoc], [MaHoaDon], [MaThuoc]) VALUES (N'CTHD0009', 30, N'HD0004', N'Thuoc0010')
INSERT [dbo].[ChiTietHD] ([MaCTHD], [SoLuongThuoc], [MaHoaDon], [MaThuoc]) VALUES (N'CTHD0010', 1, N'HD0005', N'Thuoc0000')
INSERT [dbo].[ChiTietHD] ([MaCTHD], [SoLuongThuoc], [MaHoaDon], [MaThuoc]) VALUES (N'CTHD0011', 50, N'HD0005', N'Thuoc0010')
INSERT [dbo].[ChiTietHD] ([MaCTHD], [SoLuongThuoc], [MaHoaDon], [MaThuoc]) VALUES (N'CTHD0012', 20, N'HD0005', N'Thuoc0011')
INSERT [dbo].[ChiTietHD] ([MaCTHD], [SoLuongThuoc], [MaHoaDon], [MaThuoc]) VALUES (N'CTHD0013', 1, N'HD0006', N'Thuoc0000')
INSERT [dbo].[ChiTietHD] ([MaCTHD], [SoLuongThuoc], [MaHoaDon], [MaThuoc]) VALUES (N'CTHD0014', 50, N'HD0006', N'Thuoc0011')
GO
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayLapHD], [MaPhieuKham]) VALUES (N'HD0001', CAST(N'2019-12-24' AS Date), N'PK0001')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayLapHD], [MaPhieuKham]) VALUES (N'HD0002', CAST(N'2019-12-29' AS Date), N'PK0002')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayLapHD], [MaPhieuKham]) VALUES (N'HD0003', CAST(N'2019-12-29' AS Date), N'PK0003')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayLapHD], [MaPhieuKham]) VALUES (N'HD0004', CAST(N'2020-06-21' AS Date), N'PK0004')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayLapHD], [MaPhieuKham]) VALUES (N'HD0005', CAST(N'2020-06-22' AS Date), N'PK0005')
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayLapHD], [MaPhieuKham]) VALUES (N'HD0006', CAST(N'2020-06-01' AS Date), N'PK0006')
GO
INSERT [dbo].[PhieuKham] ([MaPhieuKham], [NgayKham], [TrieuChung], [MaBN], [MaBenh]) VALUES (N'PK0001', CAST(N'2019-12-24' AS Date), N'Ho, khó thở', N'BN0001', N'Benh0002')
INSERT [dbo].[PhieuKham] ([MaPhieuKham], [NgayKham], [TrieuChung], [MaBN], [MaBenh]) VALUES (N'PK0002', CAST(N'2019-12-29' AS Date), N'Sốt, nổi phát ban', N'BN0002', N'Benh0004')
INSERT [dbo].[PhieuKham] ([MaPhieuKham], [NgayKham], [TrieuChung], [MaBN], [MaBenh]) VALUES (N'PK0003', CAST(N'2019-12-29' AS Date), N'Tái khám', N'BN0001', N'Benh0000')
INSERT [dbo].[PhieuKham] ([MaPhieuKham], [NgayKham], [TrieuChung], [MaBN], [MaBenh]) VALUES (N'PK0004', CAST(N'2020-06-21' AS Date), N'Sốt, ho khan, mệt mỏi', N'BN0003', N'Benh0002')
INSERT [dbo].[PhieuKham] ([MaPhieuKham], [NgayKham], [TrieuChung], [MaBN], [MaBenh]) VALUES (N'PK0005', CAST(N'2020-06-22' AS Date), N'Tái khám', N'BN0003', N'Benh0000')
INSERT [dbo].[PhieuKham] ([MaPhieuKham], [NgayKham], [TrieuChung], [MaBN], [MaBenh]) VALUES (N'PK0006', CAST(N'2020-06-01' AS Date), N'Ho,sốt', N'BN0004', N'Benh0002')
GO
INSERT [dbo].[QuyDinh] ([MaQD], [TenQD], [NoiDung], [SoLuong]) VALUES (N'QD1', N'Thay đổi số lượng bênh nhân ngày tối đa', NULL, 10)
GO
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0000', N'Phí khám bệnh', NULL, N'lần', 30000.0000, N'Benh0001', N'CD0000')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0001', N'Alka-Seltzer', NULL, N'viên', 5000.0000, N'Benh0001', N'CD0001')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0002', N'Rabeprazole', NULL, N'viên', 2000.0000, N'Benh0001', N'CD0002')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0003', N'Metronidazole', NULL, N'viên', 1000.0000, N'Benh0001', N'CD0002')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc00031', N'Csadjas', NULL, N'viên', 5000.0000, NULL, N'CD0000')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0004', N'Almagate', NULL, N'gói', 3000.0000, N'Benh0001', N'CD0003')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0005', N'Grazyme', NULL, N'viên', 500.0000, N'Benh0001', N'CD0003')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0006', N'Mebeverin', NULL, N'viên', 1500.0000, N'Benh0001', N'CD0004')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0007', N'Remdesivir', NULL, N'viên', 10500.0000, N'Benh0002', N'CD0002')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0008', N'Favipiravir', NULL, N'viên', 15000.0000, N'Benh0002', N'CD0003')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0009', N'Tocilizumab', NULL, N'viên', 12000.0000, N'Benh0002', N'CD0003')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0010', N'Acalabrutinib', NULL, N'viên', 32000.0000, N'Benh0002', N'CD0004')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0011', N'Steroid', NULL, N'viên', 22000.0000, N'Benh0002', N'CD0003')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0012', N'chloroquine', NULL, N'viên', 52000.0000, N'Benh0002', N'CD0004')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0013', N'Liver detox', NULL, N'chai', 200000.0000, N'Benh0003', N'CD0004')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0014', N'Liver Tonic Capsule', NULL, N'chai', 100000.0000, N'Benh0003', N'CD0001')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0015', N'Hamomax', NULL, N'viên', 1000.0000, N'Benh0003', N'CD0001')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0016', N'An Mạch', NULL, N'viên', 2000.0000, N'Benh0003', N'CD0002')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0017', N'Naturenz', NULL, N'gói', 1500.0000, N'Benh0003', N'CD0001')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0018', N'Tonka', NULL, N'viên', 1500.0000, N'Benh0003', N'CD0003')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0019', N'Paracetamol', NULL, N'viên', 500.0000, N'Benh0004', N'CD0003')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0020', N'Aspirin', NULL, N'viên', 800.0000, N'Benh0004', N'CD0004')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0021', N'Ibuprofen', NULL, N'viên', 1800.0000, N'Benh0004', N'CD0002')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0022', N'Diclofenac', NULL, N'viên', 2800.0000, N'Benh0004', N'CD0001')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0023', N'Diclofenac', NULL, N'viên', 2800.0000, N'Benh0004', N'CD0003')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0024', N'Efferalgan', NULL, N'viên', 3800.0000, N'Benh0004', N'CD0004')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0025', N'Tylenol', NULL, N'viên', 800.0000, N'Benh0005', N'CD0004')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0026', N'Ultram', NULL, N'viên', 600.0000, N'Benh0005', N'CD0001')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0027', N'Motrin IB', NULL, N'viên', 1200.0000, N'Benh0005', N'CD0002')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0028', N'Plaquenil', NULL, N'viên', 1500.0000, N'Benh0005', N'CD0003')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0029', N'Enbrel', NULL, N'viên', 3000.0000, N'Benh0005', N'CD0003')
INSERT [dbo].[Thuoc] ([MaThuoc], [TenThuoc], [MoTaThuoc], [DonVi], [DonGia], [MaBenh], [MaCachDung]) VALUES (N'Thuoc0030', N'Prednisone Intensol', NULL, N'viên', 2200.0000, N'Benh0005', N'CD0002')
GO
ALTER TABLE [dbo].[ChiTietHD]  WITH CHECK ADD FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHD]  WITH CHECK ADD FOREIGN KEY([MaThuoc])
REFERENCES [dbo].[Thuoc] ([MaThuoc])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([MaPhieuKham])
REFERENCES [dbo].[PhieuKham] ([MaPhieuKham])
GO
ALTER TABLE [dbo].[PhieuKham]  WITH CHECK ADD FOREIGN KEY([MaBenh])
REFERENCES [dbo].[Benh] ([MaBenh])
GO
ALTER TABLE [dbo].[PhieuKham]  WITH CHECK ADD FOREIGN KEY([MaBN])
REFERENCES [dbo].[BenhNhan] ([MaBN])
GO
ALTER TABLE [dbo].[Thuoc]  WITH CHECK ADD FOREIGN KEY([MaBenh])
REFERENCES [dbo].[Benh] ([MaBenh])
GO
ALTER TABLE [dbo].[Thuoc]  WITH CHECK ADD FOREIGN KEY([MaCachDung])
REFERENCES [dbo].[CachDung] ([MaCachDung])
GO
USE [master]
GO
ALTER DATABASE [QuanLyPhongMachTu] SET  READ_WRITE 
GO
