package lib;

public class Staff extends Person { //staff extends from person class 
	protected String position; // position  
	public Staff() {
		super(); //super from person class
		this.position = " "; 
	}
	public Staff(String name,String email,String address,String phone,String position) {
		super(name,email,address,phone); // super from person class 
		this.position = position;
	}
	public void print_lib_information() {
		super.print_lib_information(); // super from person class ->print_lib_information 
		System.out.println("직책: "+ position);
	}
	public String get_position() { //get function
		return position;
	}
	public void set_position(String position) { //set function 
		this.position = position;
	}
}
