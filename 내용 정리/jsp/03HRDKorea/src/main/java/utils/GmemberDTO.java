package utils;

public class GmemberDTO {
	private String regist_month;
	private String c_no;
	private String c_name;
	private String class_name;
	private String class_area;
	private Integer class_price;
	private String grade;
	
	public GmemberDTO (){}

	public GmemberDTO(String regist_month, String c_no, String c_name, String class_name, String class_area,
			Integer class_price, String grade) {
		super();
		this.regist_month = regist_month;
		this.c_no = c_no;
		this.c_name = c_name;
		this.class_name = class_name;
		this.class_area = class_area;
		this.class_price = class_price;
		this.grade = grade;
	}

	public String getRegist_month() {
		return regist_month;
	}

	public void setRegist_month(String regist_month) {
		this.regist_month = regist_month;
	}

	public String getC_no() {
		return c_no;
	}

	public void setC_no(String c_no) {
		this.c_no = c_no;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getClass_area() {
		return class_area;
	}

	public void setClass_area(String class_area) {
		this.class_area = class_area;
	}

	public Integer getClass_price() {
		return class_price;
	}

	public void setClass_price(Integer class_price) {
		this.class_price = class_price;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "GmemberDTO [regist_month=" + regist_month + ", c_no=" + c_no + ", c_name=" + c_name + ", class_name="
				+ class_name + ", class_area=" + class_area + ", class_price=" + class_price + ", grade=" + grade + "]";
	}
	
	
}
