package com.servicesAdmin.fangjian;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import com.dao.interfaceDAO.GYDAO;
import com.util.UtilValiDate;
import com.util.SysFinal;
import org.springframework.stereotype.Service;
import com.util.UtilSql;
import com.util.UtilStr;
/**
 *  service 实现类
 */ 
@Service("fangjianImp")
public class FangjianImp implements Fangjian {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.id,t.number,t.type,t.price,t.photo,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from fangjian t where 1=1");
		if (UtilValiDate.isEmpty(mapStr.get("id"))) {
			sql.append(" and t.id=:id ");
			mapSQLParameter.put("id", mapStr.get("id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("number"))) {
				sql.append(" and t.number like :number");
				mapSQLParameter.put("number", "%" + mapStr.get("number") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("type"))) {
				sql.append(" and t.type like :type");
				mapSQLParameter.put("type", "%" + mapStr.get("type") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("zt"))) {
				sql.append(" and t.zt = :zt");
				mapSQLParameter.put("zt", mapStr.get("zt"));
			}
		}
	}

	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		if (!UtilValiDate.isEmpty(mapStr.get(SysFinal.ISSORT_KEY))){ //由于从菜单进入没有带入参数，这里给入判断进行开启排序
			mapStr.put(SysFinal.ISSORT_KEY,"y");
		}
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter,mapStr);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
	}

	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		return this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
	}

	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("id", UtilSql.getTimeId());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("insert into fangjian");
		sql.append("( id, number,type,price,photo");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :id,:number,:type,:price,:photo");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("id", mapStr.get("id"));
		mapSQLParameter.put("number", mapStr.get("number"));
		mapSQLParameter.put("type", mapStr.get("type"));
		mapSQLParameter.put("price", mapStr.get("price"));
		mapSQLParameter.put("photo", mapStr.get("photo"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update fangjian set gxsj=:gxsj");
		sql.append(" ,number=:number,type=:type,price=:price,photo=:photo, bz=:bz ");
		sql.append(" where id=:id");
		mapStr.put(SysFinal.BZ_KEY, UtilStr.codeUTF_8(mapStr.get(SysFinal.BZ_KEY)));
		mapSQLParameter.put("number", mapStr.get("number"));
		mapSQLParameter.put("type", mapStr.get("type"));
		mapSQLParameter.put("price", mapStr.get("price"));
		mapSQLParameter.put("photo", mapStr.get("photo"));
		mapSQLParameter.put("bz", mapStr.get(SysFinal.BZ_KEY));
		mapSQLParameter.put("id", mapStr.get("id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}
	
	
	
	public Map<String, Object> updateData(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update fangjian set gxsj=:gxsj");
		sql.append(" ,zt=:zt ");
		sql.append(" where id=:id");
		mapSQLParameter.put("id", mapStr.get("id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		mapSQLParameter.put("zt", mapStr.get("zt"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		Map<String, Object> map = this.find_Map(mapStr);
		addLog(mapStr);
		return map;
	}
	
	public Map<String, Object> updateTuiFang(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update fangjian set gxsj=:gxsj");
		sql.append(" ,zt=:zt ");
		sql.append(" where id=:id");
		mapSQLParameter.put("id", mapStr.get("id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		mapSQLParameter.put("zt", "2");
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		Map<String, Object> map = this.find_Map(mapStr);
		UpdateLog(mapStr);
		return map;
	}
	
	
	public Map<String, Object> addLog(Map<String, String> mapStr) throws Exception{
		mapStr.put("lid", UtilSql.getTimeId());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("insert into log");
		sql.append("( id, user,room,start");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :id,:user,:room,:start");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("id", mapStr.get("lid"));
		mapSQLParameter.put("user", mapStr.get("zt"));
		mapSQLParameter.put("room", mapStr.get("id"));
		mapSQLParameter.put("start", UtilSql.getGXSJ());
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}
	
	public Map<String, Object> UpdateLog(Map<String, String> mapStr) throws Exception{
		
		
		
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select f.price*(timestampdiff(day,l.`start`,now())+1) as price from log l,fangjian f where l.room=f.id and f.id=:room");
		mapSQLParameter.put("room", mapStr.get("id"));
		Map<String, Object> map = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		String price = UtilStr.getStr(map.get("price"));
		
		sql.setLength(0);
		sql.append("update log t set gxsj=:gxsj");
		sql.append(" ,end=:end,price=:price ");
		sql.append(" where room=:room and user=:user and end is null");
		mapStr.put(SysFinal.BZ_KEY, UtilStr.codeUTF_8(mapStr.get(SysFinal.BZ_KEY)));
		mapSQLParameter.put("user", mapStr.get("zt"));
		mapSQLParameter.put("end", mapStr.get("gxsj"));
		mapSQLParameter.put("id", mapStr.get("id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		mapSQLParameter.put("price", price);
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from fangjian where id=:id");
		mapSQLParameter.put("id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
	}

	/************************系统生成方法完毕******************************/
}