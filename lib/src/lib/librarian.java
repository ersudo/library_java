package lib;

public class librarian extends Staff {
	protected String workplace;
	public librarian() {
		super();
		this.workplace = " ";
	}
	public librarian(String name,String email,String address,String phone,
			String position,String workplace) {
		super(name,email,address,phone,position);
		this.workplace =workplace;
	}
	public void set_work_place(String workplace) {
		this.workplace = workplace;
	}
	public String getWorkplace() {
		return this.workplace;
	}
	public void print_information() {
		super.print_lib_information();
		System.out.println("일하는 위치: "+ workplace);
	}
}
