package com.servicesAdmin.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.util.MD5;
import com.util.UtilValiDate;

/**
 * 登录  login 2016年7月18日20:38:19
 * @author 李飞
 *
 */
@Service("loginServerImp")
public class LoginServerImp implements LoginServer{
	@Resource
	private GYDAO gyDAOimp;// dao操作类
	
	/**
	 * 用户登录
	 * @param mapStr
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	public Map<String, Object> login(Map<String,String> mapStr) throws Exception{
		Map<String, Object> mapObj = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.zh_id,t.zh_zhm,t.zh_zhmm,t.lrsj,t.lrzh,t.zt,t.bz from qx_zhb t");
		sql.append(" where t.zh_zhm=:zh_zhm and t.zh_zhmm=:zh_zhmm ");
		mapSQLParameter.put("zh_zhm", mapStr.get("zh_zhm"));
		mapSQLParameter.put("zh_zhmm", MD5.EncoderByMd5(mapStr.get("zh_zhmm")));
		Map<String, Object> mapLogin = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		if(mapLogin.size()!=0){
			mapObj.put("mapLogin", mapLogin);
			mapObj.put("gongNengJson", this.getGN(mapLogin));
		}else{
			sql.setLength(0);
			sql.append("select t.id,t.account,t.password,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
			sql.append(" from user t where 1=1 and t.account = :account and t.password=:password");
			mapSQLParameter.put("account", mapStr.get("zh_zhm"));
			mapSQLParameter.put("password", mapStr.get("zh_zhmm"));
			mapLogin = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
			if(mapLogin.size()>0){
				mapLogin.put("role", "user");
				mapObj.put("mapLogin", mapLogin);
				mapObj.put("gongNengJson", this.getGN2(mapLogin));
			}
		}
		return mapObj;
	}
	
	
	/**
	 * 根据功能分类ID加载出所有的功能
	 * @param mapLogin
	 * @return StringBuffer 
	 * @throws Exception
	 */
	public StringBuffer getGN(Map<String, Object> mapLogin)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//得到功能分类
		this.getGNFLSQL(mapLogin, sql, mapSQLParameter);
		List<Map<String,Object>> list_map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		StringBuffer sb = new StringBuffer();
		sb.append("{'data':[");
		for (Map<String, Object> map : list_map) {
			sb.append("{'id':'");
			sb.append(map.get("gnfl_id"));
			sb.append("','text':'");
			sb.append(map.get("gnfl_mc"));
			sb.append("','icon':'");
			sb.append(map.get("gnfl_icon"));
			sb.append("','menus':[");
			sql = sql.delete(0, sql.length());
			mapSQLParameter.clear();
			sql.append("select gnsb.gn_id,gnsb.gn_mc,gnsb.gn_dz,gnsb.gn_icon");
			sql.append(" from qx_js_zhb t,qx_js_gnsb jsgnsb,qx_gnsb gnsb");
			sql.append(" where gnsb.gnfl_id =:gnfl_id and t.zh_id=:zh_id");
			sql.append(" and t.js_id=jsgnsb.js_id and gnsb.gn_id=jsgnsb.gn_id");
			sql.append(" group by gnsb.gn_id,gnsb.gn_mc,gnsb.gn_dz order by gnsb.gn_mc asc");
			mapSQLParameter.put("gnfl_id", map.get("gnfl_id"));
			mapSQLParameter.put("zh_id", mapLogin.get("zh_id"));
			List<Map<String, Object>> listGongNeng = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
			for (Map<String, Object> mapGongNeng : listGongNeng) {
				sb.append("{'id':'");
				sb.append(mapGongNeng.get("gn_id"));
				sb.append("','parentID':'");
				sb.append(map.get("gnfl_id"));
				sb.append("','text':'");
				sb.append(mapGongNeng.get("gn_mc"));
				sb.append("','icon':'");
				sb.append(mapGongNeng.get("gn_icon"));
				sb.append("','url':'");
				sb.append(mapGongNeng.get("gn_dz"));
				sb.append("'},");
			}
			if(sb.toString().endsWith(",")){
				sb.deleteCharAt(sb.length()-1);
			}
			sb.append("]},");
		}
		if(sb.toString().endsWith(",")){
			sb.deleteCharAt(sb.length()-1);
		}
		sb.append("]}");
		return sb;
	}
	
	
	/**
	 * 根据功能分类ID加载出所有的功能
	 * @param mapLogin
	 * @return StringBuffer 
	 * @throws Exception
	 */
	public StringBuffer getGN2(Map<String, Object> mapLogin)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//得到功能分类
		this.getGNFLSQL2(mapLogin, sql, mapSQLParameter);
		List<Map<String,Object>> list_map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		StringBuffer sb = new StringBuffer();
		sb.append("{'data':[");
		for (Map<String, Object> map : list_map) {
			sb.append("{'id':'");
			sb.append(map.get("gnfl_id"));
			sb.append("','text':'");
			sb.append(map.get("gnfl_mc"));
			sb.append("','icon':'");
			sb.append(map.get("gnfl_icon"));
			sb.append("','menus':[");
			sql = sql.delete(0, sql.length());
			mapSQLParameter.clear();
			sql.append("select gnsb.gn_id,gnsb.gn_mc,gnsb.gn_dz,gnsb.gn_icon");
			sql.append(" from qx_js_zhb t,qx_js_gnsb jsgnsb,qx_gnsb gnsb");
			sql.append(" where gnsb.gnfl_id =:gnfl_id");
			sql.append(" and t.js_id=jsgnsb.js_id and gnsb.gn_id=jsgnsb.gn_id");
			sql.append(" group by gnsb.gn_id,gnsb.gn_mc,gnsb.gn_dz order by gnsb.gn_mc asc");
			mapSQLParameter.put("gnfl_id", map.get("gnfl_id"));
			List<Map<String, Object>> listGongNeng = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
			for (Map<String, Object> mapGongNeng : listGongNeng) {
				sb.append("{'id':'");
				sb.append(mapGongNeng.get("gn_id"));
				sb.append("','parentID':'");
				sb.append(map.get("gnfl_id"));
				sb.append("','text':'");
				sb.append(mapGongNeng.get("gn_mc"));
				sb.append("','icon':'");
				sb.append(mapGongNeng.get("gn_icon"));
				sb.append("','url':'");
				sb.append(mapGongNeng.get("gn_dz"));
				sb.append("'},");
			}
			if(sb.toString().endsWith(",")){
				sb.deleteCharAt(sb.length()-1);
			}
			sb.append("]},");
		}
		if(sb.toString().endsWith(",")){
			sb.deleteCharAt(sb.length()-1);
		}
		sb.append("]}");
		return sb;
	}
	
	/**
	 * SQL 得到所有功能
	 * @param mapLogin
	 * @param sql
	 * @param mapSQLParameter
	 * @throws Exception
	 */
	private void getGNFLSQL2(Map<String, Object> mapLogin,StringBuffer sql, Map<String, Object> mapSQLParameter)throws Exception {
		sql.append("select gnflb.gnfl_id,gnflb.gnfl_mc,gnflb.gnfl_icon");
		sql.append(" from qx_gnflb gnflb");
		sql.append(" where gnflb.gnfl_id= '20180327103709571'");
	}
	
	/**
	 * SQL 得到所有功能
	 * @param mapLogin
	 * @param sql
	 * @param mapSQLParameter
	 * @throws Exception
	 */
	private void getGNFLSQL(Map<String, Object> mapLogin,StringBuffer sql, Map<String, Object> mapSQLParameter)throws Exception {
		sql.append("select gnflb.gnfl_id,gnflb.gnfl_mc,gnflb.gnfl_icon");
		sql.append(" from qx_js_zhb t,qx_js_gnsb jsgngb,qx_gnsb gnsb,qx_gnflb gnflb");
		sql.append(" where t.zh_id=:zh_id");
		sql.append(" and t.js_Id=jsgngb.js_id and gnsb.gn_id=jsgngb.gn_id");
		sql.append(" and gnflb.gnfl_id=gnsb.gnfl_id and (gnsb.zt=2 or gnsb.zt=0 or gnsb.zt=3)");
		sql.append(" group by gnflb.gnfl_id,gnflb.gnfl_mc order by gnflb.gnfl_mc asc");
		mapSQLParameter.put("zh_id", mapLogin.get("zh_id"));
	}
}
