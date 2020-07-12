create database QuanLyPhongMachTu
go
use QuanLyPhongMachTu
go
create table BenhNhan(
	MaBN varchar(10) primary key,
	HoTen nvarchar(30),
	GioiTinh bit,
	NamSinh int,
	DiaChi nvarchar(50)
)
go
create table Benh(
	MaBenh varchar(10) primary key,
	LoaiBenh nvarchar(50),
	MoTaBenh nvarchar(100),
)
go
create table Thuoc(
	MaThuoc varchar(10) primary key,
	TenThuoc nvarchar(50),
	MoTaThuoc nvarchar(100),
	DonVi nvarchar(30),
	DonGia money,
	MaBenh varchar(10),
	MaCachDung varchar(10),
)
go
create table PhieuKham(
	MaPhieuKham varchar(10) primary key,
	NgayKham date,
	TrieuChung nvarchar(100),
	MaBN varchar(10),
	MaBenh varchar(10),

)
go
create table HoaDon(
	MaHoaDon varchar(10) primary key,
	NgayLapHD date,
	MaPhieuKham varchar(10)
)
go
create table ChiTietHD(
	MaCTHD varchar(10) primary key,
	SoLuongThuoc int,
	MaHoaDon varchar(10),
	MaThuoc varchar(10),

)
go
create table CachDung(
	MaCachDung varchar(10) primary key,
	MoTaCD nvarchar(100)
)
go
create table QuyDinh(
	MaQD varchar(10),
	TenQD nvarchar(100),
	NoiDung nvarchar(100),
	SoLuong int
)
go
alter table Thuoc add foreign key(MaBenh) references Benh(MaBenh)
go
alter table Thuoc add foreign key(MaCachDung) references CachDung(MaCachDung)
go
alter table PhieuKham add foreign key(MaBN) references BenhNhan(MaBN)
go
alter table PhieuKham add foreign key(MaBenh) references Benh(MaBenh)
go
alter table HoaDon add foreign key(MaPhieuKham) references PhieuKham(MaPhieuKham)
go
alter table ChiTietHD add foreign key(MaHoaDon) references HoaDon(MaHoaDon)
go
alter table ChiTietHD add foreign key(MaThuoc) references Thuoc(MaThuoc)
