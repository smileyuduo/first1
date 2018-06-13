package com.controllerAdmin.log;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.log.Log;
import com.util.SysFinal;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 *  controller 实现类 
 */ 
@Controller
public class LogController  extends ControllerUtil {

	@Resource
	private Log  logImp;

	/************************系统生成方法开始******************************/

	@RequestMapping(value ="/log_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			return this.tBodyUtil(logImp.tBody(mapStr),mapStr,"form/log/log_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	@RequestMapping(value ="/log2_index.do")
	public String index2(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			mapStr.put("user", getUserId(req, resp));
			return this.tBodyUtil(logImp.tBody(mapStr),mapStr,"form/log/log2_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/log_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/log/log_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/log_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			if (UtilValiDate.isEmpty(mapStr.get("id"))) {
				if ("y".equals(mapStr.get(SysFinal.ISUPDATE_KEY)))  {	
					Map<String, Object> mapObj = logImp.update_Data(mapStr);
					return this.updateDataUpdate(mapObj,"form/log/log_tr.jsp",req,resp);
				}	
			} else { 
				Map<String, Object> mapObj = logImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/log/log_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/log_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			return this.findByIdUtil(logImp.find_Map(mapStr),"form/log/log_findById.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/log_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			return this.editPageUtil(logImp.find_Map(mapStr),"form/log/log_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/log_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			logImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

