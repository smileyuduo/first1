package com.controllerAdmin.other.file;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.controllerAdmin.ControllerUtil;
import com.util.SysFinal;
import com.util.UtilStr;
import com.util.UtilTime;
import com.util.UtilValiDate;
/**
 * 文件管理类 2016年3月25日 14:54:53
 * @author 李飞
 *
 */
@Controller
public class FileController extends ControllerUtil{

	/****************************文件上传主要用于图片上传****************************************/
	/**
	 * 文件上传 上传成功 返回图片上传地址  上传失败 返回error
	 */
	@RequestMapping(value = "/otherFile_fileEntityUploadImg.do")
	public void fileEntityUploadImg(@RequestParam(value = "uploadName", required = false) MultipartFile file,HttpServletRequest req,HttpServletResponse resp) {
		try {
			String uploadName = file.getOriginalFilename();
			logger.info("准备上传文件"+uploadName);
			if (UtilValiDate.isEmpty(uploadName)) {
				if(!UtilValiDate.isImg(uploadName)){
					this.respBack("格式错误,请上传.gif.jpg.jpeg.png", resp);
					return ;
				}
				
				String newFileName = UtilTime.getTime(SysFinal.YYYYMMDDHHMMSSSSS)+System.currentTimeMillis()+uploadName.substring(uploadName.indexOf("."));
				String filePath =SysFinal.file_Img+UtilTime.getTime("yyyy-MM");
				File fileDir = new File(req.getSession().getServletContext().getRealPath(filePath));
				if(!fileDir.exists()){
					fileDir.mkdirs();
				}
				
				File savefile = new File(fileDir,newFileName);
				
				int width = UtilStr.getInt(req.getParameter("width"));
				int height = UtilStr.getInt(req.getParameter("height"));
				if(height==0 || width==0){
					file.transferTo(savefile); 
				}else{
					Thumbnails.of(file.getInputStream()).forceSize(height, width).toFile(savefile);  
				}
				this.respBack(req.getContextPath()+"/"+filePath+"/"+newFileName,resp);
			}else{
				this.respBack("error",resp);
				logger.info("准备上传文件是出现错误,请重新上传"+uploadName);
			}
		} catch (Exception e) {
			this.errorResp(e, resp);
		}
	}
	
	
	
	/****************************文件上传主要用于媒体上传****************************************/
	/**
	 * 文件上传 上传成功 返回图片上传地址  上传失败 返回error
	 */
	@RequestMapping(value = "/otherFile_fileEntityUploadMedia.do")
	public void fileEntityUploadMedia(@RequestParam(value = "uploadName", required = false) MultipartFile file,HttpServletRequest req,HttpServletResponse resp) {
		try {
			String uploadName = file.getOriginalFilename();
			logger.info("准备上传文件"+uploadName);
			if (UtilValiDate.isEmpty(uploadName)) {
				if(!UtilValiDate.isMedia(uploadName)){
					this.respBack("格式错误,请上传avi、MP4、flv、mov、wmv、3gp、swf、asf、mp3", resp);
					return ;
				}
				String newFileName = UtilTime.getTime(SysFinal.YYYYMMDDHHMMSSSSS)+System.currentTimeMillis()+uploadName.substring(uploadName.indexOf("."));
				String filePath =SysFinal.file_Video+UtilTime.getTime("yyyy-MM");
				File fileDir = new File(req.getSession().getServletContext().getRealPath(filePath));
				if(!fileDir.exists()){
					fileDir.mkdirs();
				}
				File savefile = new File(fileDir,newFileName);
				file.transferTo(savefile); 
				this.respBack(req.getContextPath()+"/"+filePath+"/"+newFileName,resp);
			}else{
				this.respBack("error",resp);
				logger.info("准备上传文件是出现错误"+uploadName);
			}
		} catch (Exception e) {
			this.errorResp(e, resp);
		}
	}
	
	
	/****************************文件上传主要用于文件上传****************************************/
	/**
	 * 文件上传 上传成功 返回图片上传地址  上传失败 返回error
	 */
	@RequestMapping(value = "/otherFile_fileEntityUploadFile.do")
	public void fileEntityUploadFile(@RequestParam(value = "uploadName", required = false) MultipartFile file,HttpServletRequest req,HttpServletResponse resp) {
		try {
			String uploadName = file.getOriginalFilename();
			logger.info("准备上传文件"+uploadName);
			if (UtilValiDate.isEmpty(uploadName)) {
				if(!UtilValiDate.isFile(uploadName)){
					this.respBack("格式错误,请上传txt、doc、dox", resp);
					return ;
				}
				String newFileName = UtilTime.getTime(SysFinal.YYYYMMDDHHMMSSSSS)+System.currentTimeMillis()+"("+uploadName+")"+uploadName.substring(uploadName.indexOf("."));
				String filePath =SysFinal.file_File+UtilTime.getTime("yyyy-MM");
				File fileDir = new File(req.getSession().getServletContext().getRealPath(filePath));
				if(!fileDir.exists()){
					fileDir.mkdirs();
				}
				File savefile = new File(fileDir,newFileName);
				file.transferTo(savefile); 
				this.respBack(req.getContextPath()+"/"+filePath+"/"+newFileName,resp);
			}else{
				this.respBack("error",resp);
				logger.info("准备上传文件是出现错误"+uploadName);
			}
		} catch (Exception e) {
			this.errorResp(e, resp);
		}
	}
	
	@RequestMapping(value = "/download.do")
	public void download(HttpServletRequest req,HttpServletResponse resp) {
		try {
			resp.setContentType("text/html;charset=utf-8");
			req.setCharacterEncoding("utf-8");
			String filePath = URLDecoder.decode(req.getParameter("filePath"),"utf-8");
			filePath = FileUtil.canReadFile(new File(filePath))?filePath:"D:\\apache-tomcat-6.0.29\\webapps"+filePath;
			File file = new File(filePath);
			resp.setHeader("Content-disposition", "attachment; filename=\""+file.getName());
			resp.addHeader("Content-Length",""+file.length());
			resp.setContentType("application/octet-steam;charset=UTF-8");
			File fileDir = new File("D:\\"+file.getName());
			if(!fileDir.exists()){
				fileDir.createNewFile();    
			}
			FileUtils.copyFile(file, fileDir);
			FileUtils.copyFile(fileDir, resp.getOutputStream());
			FileUtil.deleteContents(fileDir);
			
			
		} catch (Exception e) {
			this.errorResp(e, resp);
		}
	}
}
