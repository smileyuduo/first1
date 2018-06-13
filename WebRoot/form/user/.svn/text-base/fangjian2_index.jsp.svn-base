<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@include file="/form_util/page/root.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="${root}/form/main/assets/css/bootstrap.css" />
<link rel="stylesheet" href="${root}/form/main/assets/css/font-awesome.css" />
<link rel="stylesheet" href="${root}/form/main/assets/css/ace-fonts.css" />
<link rel="stylesheet" href="${root}/form/main/assets/css/ace.css" />
<link rel="stylesheet" href="${root}/form_util/util/util_css/myPage.css" />
</head>
<body class="no-skin">
<!-- 返回回来参数 -->
<%@include file="/form_util/page/hidden.jsp"%>
<div class="main-container box" id="main-container">
	<div class="page-content">
		<div class="row">
			<div class="widget-box">
				<div class="widget-header">
					<h4 class="widget-title">
						我的住房
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="fangjian2_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									
									<label>
										门牌号
									</label>
									<input type="text" id="query_number" placeholder="门牌号" value="${map.number}">
									
									<label>
										类型
									</label>
									<input type="text" id="query_type" placeholder="类型" value="${map.type}">
									<button type="submit" onclick="query_Fangjian(0)" class="btn btn-sm btn-success">
										查询
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	<div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline no-footer"> 
		<table id="sample-table-1" class="table  table-bordered dataTable"> 
			<thead>
				<tr>
					<th width="50px">
						序号
					</th>
<th field="number"  onclick="querySort(this,'query_Fangjian')">
						门牌号
					</th>
					<th field="type"  onclick="querySort(this,'query_Fangjian')">
						类型
					</th>
					<th field="price"  onclick="querySort(this,'query_Fangjian')">
						日价格
					</th>
					<th field="photo"  onclick="querySort(this,'query_Fangjian')">
						图片展示
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'query_Fangjian')">
						更新时间
					</th><th field="bz"  onclick="querySort(this,'query_Fangjian')">
						备注
					</th>
					<th width="110">
						操作
					</th>
				</tr>
			</thead>
			<tbody id="tbodyData">
				<c:if test="${empty listMap}">
					<tr align="center">
						<td colspan="44">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="map">
					<tr id="tr${map.id}"  isOpen="n">
						<td index="tdIndex">
							${i.index+1}
						</td>
					<td>
							${map.number}
						</td>
						<td>
							${map.type}
						</td>
						<td>
							${map.price}
						</td>
						<td>
							<img src="${map.photo}" width="50" height="50"/>
						</td>
						<td>
							${map.gxsj}
						</td>
						<td>
							${map.bz}
						</td>
						<td>
							<div class="hidden-sm hidden-xs btn-group">
								<button class="btn btn-xs btn-info" onclick="tuifang('${map.id}')" title="退房">退房</button>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="query_Fangjian" />
<c:set var="pageSelectNum" value="selectPageMain" />
<%@include file="/form_util/page/page.jsp"%>

<script src="${root}/form_util/util/sys_js/jquery.js"></script>
<script src="${root}/form_util/util/util_js/ajaxUtil.js"></script>
<script src="${root}/form_util/util/util_js/alertDivUtil.js"></script>
<script src="${root}/form_util/util/util_js/bodyUtil.js"></script>
<script src="${root}/form_util/util/util_js/validateUtil.js"></script>
<script src="${root}/form_util/util/util_js/jsonUtil.js"></script>
<script src="${root}/form_util/util/util_js/publicJsonUtil.js"></script>
<script src="${root}/form_util/util/util_js/findByIdUtil.js"></script>
<script src="${root}/form_util/util/util_js/strUtil.js"></script>
<script src="${root}/form_util/date/WdatePicker.js"></script>
<script src="${root}/form/main/assets/js/bootstrap-tab.js"></script>
<script src="${root}/form_util/util/sys_js/ajaxfileupload.js"></script>
<script src="${root}/form_util/util/util_js/nodeUtil.js"></script>
<script src="${root}/form/fangjian/js/fangjian_main.js"></script>
<script type="text/javascript">

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "user_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}
	function tuifang(id){
		var jsonObj = {
			"id":id
				}
		var jsonTemp = publicFieldsnJSON(jsonObj);
		var jsonAjax = {
			"url" : "tuifang.do",
			"jsonData" : {"mapStr":jsonToStr(jsonTemp)},
			"methodName" : "query_Fangjian(0)",
			"toID" : "tbodyData"
		};
		getAjaxData(jsonAjax);
		}
</script>
</body>
</html>