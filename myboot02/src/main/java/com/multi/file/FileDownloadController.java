package com.multi.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownloadController {
	//�뙆�씪 �떎�슫濡쒕뱶 �뤌�쑝濡� �씠�룞: upload �뤃�뜑 �븞�쓽 紐⑤뱺 �뙆�씪 紐⑸줉 異쒕젰
	@RequestMapping("/fileDownloadList")
	public ModelAndView fileDownloadList() {
		ModelAndView mv = new ModelAndView ();
		
		// c:\springWorkspace�쓽 upload �뤃�뜑�뿉 �엳�뒗 �쟾泥� �뙆�씪 紐⑸줉 媛��졇�삤湲�
		File path = new File("C:/springWorkspace/upload");
		String[] fileList = path.list()	;
		
		mv.addObject("fileList",fileList);
		mv.setViewName("upload/fileDownloadListView");
		return mv;
	}
	
	// �뙆�씪 �떎�슫濡쒕뱶 泥섎━
	@RequestMapping("/fileDownload/{file}")
	public void fileDownload(@PathVariable String file,
										HttpServletResponse response) throws IOException {
			
		File f = new File("C:/springWorkspace/upload" ,file);
		
		//file �떎�슫濡쒕뱶 �꽕�젙
		response.setContentType("application/download");
		response.setContentLength((int)f.length());
		response.setHeader("Content-Disposition", "attatchment;filename=\"" + file + "\"");
		
		//response 媛앹껜瑜� �넻�빐�꽌 �꽌踰꾨줈遺��꽣 �뙆�씪 �떎�슫濡쒕뱶
		OutputStream os = response.getOutputStream();
		
		//�뙆�씪 �엯�젰 媛앹껜 �깮�꽦
		FileInputStream fis = new FileInputStream(f);
		FileCopyUtils.copy(fis, os);
		
		fis.close();
		os.close();
				
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
}



