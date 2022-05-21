# Bài thực hành số 2 - Lập trình web

### Mô tả
	1. Trang index.html sẽ có 1 đường dẫn đến trang view product
	2. Trang products.html sẽ hiển thị ra tất cả các sản phẩm theo từng dòng và mỗi dòng đều có chức năng update hoặc delete
		2.1 Chức năng thêm mới
			- Khi bấm nút thêm mới thì sẽ gọi đến annotation getmapping để chuyển đến trang thêm mới
			- Tạo ra 1 form để điền đầy đủ thông tin các trường của lớp product(ngoại trừ id là tự tăng)
			- Ở form gọi đúng URL trong ProducControll để tiến hành thêm mới
			- Sau khi bấm nút thêm mới thì trang sẽ tự động điều hướng về trang products.html và dữ liệu vừa thêm sẽ được hiển thị ra
		2.2 Chức năng Update
			- Url phải thêm 1 thuộc tính là id để dịnh danh xem khi bấm sẽ là product nào
			- Sau đó viết 1 hàm update với annotation là getmapping và truyền id vào để lấy ra những thông tin chi tiết của sản phẩm và hiển thị lên form
			- Viết hàm update với annotation postmapping để thưc hiện quá trình cập nhật
		2.3 Chức năng delete
			- Url phải thêm 1 thuộc tính là id để dịnh danh xem khi bấm sẽ là product nào
			- Sau đó viết 1 hàm delete với annotation là getmapping và truyền id vào để lấy ra những thông tin chi tiết của sản phẩm và hiển thị lên form
			- Khi bấm vào nút delete thì sẽ hiển thị thông báo có xác nhận xóa không nếu đồng ý khi bấm sẽ xóa thành công và chuyển đến trang products.html còn nếu không đồng ý sẽ ở nguyên trang hiện tại

### Thành viên đóng góp
	1. Đỗ Công Ban làm phần thêm sản phẩm mới
	2. Nguyễn Phi Tân làm phần sửa sản phẩm
	3. Phan Hoàng Nguyên làm phần xóa sản phẩm
