package lib;

public class Staff extends Person {
	protected String position;
	public Staff() {
		super();
		this.position = " ";
	}
	public Staff(String name,String email,String address,String phone,
			String position) {
		super(name,email,address,phone);
		this.position = position;
	}
	public void print_lib_information() {
		super.print_lib_information();
		System.out.println("직책: "+ position);
	}
	public String get_position() {
		return position;
	}
	public void set_position(String position) {
		this.position = position;
	}
}
