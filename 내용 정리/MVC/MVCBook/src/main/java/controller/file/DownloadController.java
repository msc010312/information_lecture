package controller.file;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SubController;
import domain.service.FileServiceImpl;

public class DownloadController implements SubController{

	private FileServiceImpl fileService;
	
	public DownloadController() throws Exception {
		fileService = FileServiceImpl.getInstance();
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {	
			// 파라미터
			
			// 유효성
			
			// 서비스
			boolean isUpload = fileService.download(req,resp);
			// 뷰
//			req.setAttribute("list", list);
//			req.getRequestDispatcher("/WEB-INF/view/file/download.jsp").forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
