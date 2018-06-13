package com.controllerAdmin.user;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.user.User;
import com.util.SysFinal;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 *  controller 实现类 
 */ 
@Controller
public class UserController  extends ControllerUtil {

	@Resource
	private User  userImp;

	/************************系统生成方法开始******************************/

	@RequestMapping(value ="/user_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			return this.tBodyUtil(userImp.tBody(mapStr),mapStr,"form/user/user_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/user_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/user/user_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/user_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			if (UtilValiDate.isEmpty(mapStr.get("id"))) {
				if ("y".equals(mapStr.get(SysFinal.ISUPDATE_KEY)))  {	
					Map<String, Object> mapObj = userImp.update_Data(mapStr);
					return this.updateDataUpdate(mapObj,"form/user/user_tr.jsp",req,resp);
				}	
			} else { 
				Map<String, Object> mapObj = userImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/user/user_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/user_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			return this.findByIdUtil(userImp.find_Map(mapStr),"form/user/user_findById.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/user_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			return this.editPageUtil(userImp.find_Map(mapStr),"form/user/user_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/user_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			userImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

