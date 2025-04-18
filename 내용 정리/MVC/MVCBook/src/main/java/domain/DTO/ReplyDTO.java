package domain.DTO;

import java.time.LocalDateTime;

public class ReplyDTO {
	private int no;
	private String bookcode;
	private String username;
	private String content;
	private LocalDateTime createAt;
	
	public ReplyDTO() {}

	public ReplyDTO(int no, String bookcode, String username, String content, LocalDateTime createAt) {
		super();
		this.no = no;
		this.bookcode = bookcode;
		this.username = username;
		this.content = content;
		this.createAt = createAt;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBookcode() {
		return bookcode;
	}

	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	

}
