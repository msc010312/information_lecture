package Ch38.Controller;

import java.util.HashMap;
import java.util.Map;

import Ch38.Domain.Dto.BookDto;

public class BookController implements SubController {
	Map<String, Object> res;
	@Override
	public Map<String, Object> excute(Map<String, Object> params) {
		 res = new HashMap();
		// 1.추가(C) 2.조회(R) 3.수정(U) 4.삭제(D)
		Integer serviceNum = (Integer) params.get("serviceNum");
		if (serviceNum == null) {
			res.put("status", false);
			res.put("status", "유효하지않은 서비스 요청");
			return res;
		}
		switch (serviceNum) {
		case 1:
			System.out.println("[sc] 도서추가 요청확인");
			String bookCode = (params.get("bookCode")!=null)?(String)params.get("bookCode"):null;
			String bookName = (params.get("bookName")!=null)?(String)params.get("bookName"):null;
			String publisher = (params.get("publisher")!=null)?(String)params.get("publisher"):null;
			String isbn = (params.get("isbn")!=null)?(String)params.get("isbn"):null;
			BookDto bookdto = new BookDto(bookCode,bookName,publisher,isbn);
			boolean isValid = isValid(bookdto);
			if(!isValid) {
				res.put("status", false);
				return res;
			}
			System.out.println("도서 추가 유효성 검증 : " + isValid);
			break;
		case 2:
			System.out.println("[sc] 도서조회 요청확인");
			break;
		case 3:
			System.out.println("[sc] 도서정보수정 요청확인");
			break;
		case 4:
			System.out.println("[sc] 도서삭제 요청확인");
			break;
		default:
			System.out.println("[sc] 잘못된 서비스번호 요청");
		}
		return res;
	}
	private boolean isValid(BookDto bookdto) {
		if(bookdto.getBookCode() == null || bookdto.getBookCode().length()!=8) {
			res.put("error", "bookcode는 8글자만 가능합니다");
			System.out.println("[invalid] bookcode는 8글자만 가능합니다");
			return false;
		}
		if(bookdto.getBookName().length()>256) {
			res.put("error", "bookname은 255자를 넘길 수 없습니다");
			System.out.println("[invalid] bookname은 255자를 넘길 수 없습니다");
			return false;
		}
		return true;
	}
}
