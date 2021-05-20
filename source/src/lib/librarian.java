package lib;

public class librarian extends Staff {
	protected String work_place;
	public librarian() {
		super();
		this.work_place = " ";
	}
	public librarian(String name,String email,String address,String phone,
			String position,String work_place) {
		super(name,email,address,phone,position);
		this.work_place =work_place;
	}
	public void set_work_place(String work_place) {
		this.work_place = work_place;
	}
	public void print_information() {
		super.print_lib_information();
		System.out.println("일하는 위치: "+ work_place);
	}
}
