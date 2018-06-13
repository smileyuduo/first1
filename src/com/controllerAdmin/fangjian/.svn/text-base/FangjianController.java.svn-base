package com.controllerAdmin.fangjian;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.fangjian.Fangjian;
import com.util.SysFinal;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 *  controller 实现类 
 */ 
@Controller
public class FangjianController  extends ControllerUtil {

	@Resource
	private Fangjian  fangjianImp;

	/************************系统生成方法开始******************************/

	@RequestMapping(value ="/fangjian_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			mapStr.put("zt", "");
			return this.tBodyUtil(fangjianImp.tBody(mapStr),mapStr,"form/fangjian/fangjian_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	@RequestMapping(value ="/fangjian2_index.do")
	public String index2(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			mapStr.put("zt",this.getUserId(req, resp));
			return this.tBodyUtil(fangjianImp.tBody(mapStr),mapStr,"form/user/fangjian2_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/fangjian3_index.do")
	public String index3(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			mapStr.put("zt","2");
			return this.tBodyUtil(fangjianImp.tBody(mapStr),mapStr,"form/user/fangjian_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	@RequestMapping(value ="/ruzhu.do")
	public String ruzhu(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			mapStr.put("zt",this.getUserId(req, resp));
			Map<String, Object> mapObj = fangjianImp.updateData(mapStr);
			return this.updateDataUpdate(mapObj,"form/fangjian/fangjian_tr.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	@RequestMapping(value ="/tuifang.do")
	public String tuifang(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			mapStr.put("zt",this.getUserId(req, resp));
			Map<String, Object> mapObj = fangjianImp.updateTuiFang(mapStr);
			return this.updateDataUpdate(mapObj,"form/fangjian/fangjian_tr.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	
	@RequestMapping(value ="/fangjian_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/fangjian/fangjian_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/fangjian_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			if (UtilValiDate.isEmpty(mapStr.get("id"))) {
				if ("y".equals(mapStr.get(SysFinal.ISUPDATE_KEY)))  {	
					Map<String, Object> mapObj = fangjianImp.update_Data(mapStr);
					return this.updateDataUpdate(mapObj,"form/fangjian/fangjian_tr.jsp",req,resp);
				}	
			} else { 
				Map<String, Object> mapObj = fangjianImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/fangjian/fangjian_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/fangjian_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			return this.findByIdUtil(fangjianImp.find_Map(mapStr),"form/fangjian/fangjian_findById.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/fangjian_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			return this.editPageUtil(fangjianImp.find_Map(mapStr),"form/fangjian/fangjian_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	@RequestMapping(value ="/fangjian_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			fangjianImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

