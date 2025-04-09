package utils;

public class ClassDTO {
	private String regist_month;
	private String c_no;
	private String class_area;
	private Integer tuituon;
	private String teacher_code;
	public ClassDTO() {};
	public ClassDTO(String regist_month, String c_no, String class_area, Integer tuituon, String teacher_code) {
		super();
		this.regist_month = regist_month;
		this.c_no = c_no;
		this.class_area = class_area;
		this.tuituon = tuituon;
		this.teacher_code = teacher_code;
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
	public String getClass_area() {
		return class_area;
	}
	public void setClass_area(String class_area) {
		this.class_area = class_area;
	}
	public Integer getTuituon() {
		return tuituon;
	}
	public void setTuituon(Integer tuituon) {
		this.tuituon = tuituon;
	}
	public String getTeacher_code() {
		return teacher_code;
	}
	public void setTeacher_code(String teacher_code) {
		this.teacher_code = teacher_code;
	}
	@Override
	public String toString() {
		return "ClassDTO [regist_month=" + regist_month + ", c_no=" + c_no + ", class_area=" + class_area + ", tuituon="
				+ tuituon + ", teacher_code=" + teacher_code + "]";
	}
	
	
}
