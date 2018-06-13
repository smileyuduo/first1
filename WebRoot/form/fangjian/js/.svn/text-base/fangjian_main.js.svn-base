/******  操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function query_Fangjian(page){
	loadingDiv();
	var query_number = $("#query_number").val();
	var query_type = $("#query_type").val();
	var json = {
		"number" : query_number,
		"type" : query_type,
 		 "id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "fangjian_addPage.do",
		"jsonData" : null,
		"title" : "添加",
		"icon" : "plus",
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}

function addDataValidate(){
	var jsonObj={
		"methodName":"addData"
	};
	jsonValidate = jsonObj;
}

function getUpdateMainJson(id) {
	var update_number = $("#update_number").val();
	var update_type = $("#update_type").val();
	var update_price = $("#update_price").val();
	var update_photo = $("#imgUpload1").attr("src");
	var jsonObj = {
		"number" : update_number,
		"type" : update_type,
		"price" : update_price,
		"photo" : update_photo,
		"id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "fangjian_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"id" : id};
	var jsonAjax = {
		"url" : "fangjian_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "编辑",
		"icon" : "edit",
		"methodName" : "page_back"
	};
		getAjaxData(jsonAjax);
}

function editDataValidate(id){
	var jsonObj={
		"methodName":"editData",
		"id":id
		};
	jsonValidate = jsonObj;
}

function editData(jsonObj){
	var jsonAjax = {
		"url" : "fangjian_updateData.do",
		"jsonData" : getUpdateMainJson(jsonObj.id),
		"methodName" : "update_edit",
		"toID" :"tbodyData"
	};
	getAjaxData(jsonAjax);
}

function confirmDeleteDate(id,name){
	var jsonObj = {
		"id":id,
		"name":name,
		"title":"删除",
		"icon" : "exclamation-triangle",
		"color":"red",
		"info":'确认删除 <span class="red">'+name+'</span> ?',
		"methodName":"deleteMain"
	};
	openConfirmPage(jsonObj);
}

function deleteMain(jsonObj){
	var jsonObj = {
		"name" : jsonObj.name,
		"id" : jsonObj.id
	};
	var jsonAjax = {
		"url" : "fangjian_deleteData.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"methodName" : "update_delete",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}
/*
**
* 上传
* @param index
*/
function uploadImg(index){
	var jsonAjax = {
		'url':"otherFile_fileEntityUploadImg.do",
		'fileElementId':"uploadName"+index,
		'jsonData':{},
		'methodName':'uploadImg_back',
		'index':index
	}
	getAjaxUpdateData(jsonAjax);
}





/**
* 上传回调
* @param jsonObj
*/
function uploadImg_back(jsonObj){
	var fal = ajaxReceipt(jsonObj.data);
	if(fal) {
		$("#imgUpload"+jsonObj.index).attr("src",jsonObj.data);
		$("#imgUpload"+jsonObj.index).attr("isUpload","y");
	}
}