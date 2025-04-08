package utils;

public class VoteDTO {
	private String v_jumin;
	private String v_name;
	private String m_num;
	private String v_time;
	private String v_area;
	private String v_confirm;
	public VoteDTO() {}
	public VoteDTO(String v_jumin, String v_name, String m_num, String v_time, String v_area, String v_confirm) {
		super();
		this.v_jumin = v_jumin;
		this.v_name = v_name;
		this.m_num = m_num;
		this.v_time = v_time;
		this.v_area = v_area;
		this.v_confirm = v_confirm;
	}
	public String getV_jumin() {
		return v_jumin;
	}
	public void setV_jumin(String v_jumin) {
		this.v_jumin = v_jumin;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getM_num() {
		return m_num;
	}
	public void setM_num(String m_num) {
		this.m_num = m_num;
	}
	public String getV_time() {
		return v_time;
	}
	public void setV_time(String v_time) {
		this.v_time = v_time;
	}
	public String getV_area() {
		return v_area;
	}
	public void setV_area(String v_area) {
		this.v_area = v_area;
	}
	public String getV_confirm() {
		return v_confirm;
	}
	public void setV_confirm(String v_confirm) {
		this.v_confirm = v_confirm;
	}
	@Override
	public String toString() {
		return "VoteDTO [v_jumin=" + v_jumin + ", v_name=" + v_name + ", m_num=" + m_num + ", v_time=" + v_time
				+ ", v_area=" + v_area + ", v_confirm=" + v_confirm + "]";
	}
	
	
}
