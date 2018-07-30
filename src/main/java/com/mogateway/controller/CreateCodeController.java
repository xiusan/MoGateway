package com.mogateway.controller;

import com.mogateway.util.createCode.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class CreateCodeController {

	private static Logger logger = Logger.getLogger(CreateCodeController.class);

	/**
	 * 代码生成映射到Html
	 * @return
	 */
	@RequestMapping(value = "/createcode")
	public String operatorInfoPage(){
		return "create_code";
	}

	/**
	 * 生成代码
	 */
	@RequestMapping(value = "/proCode")
	public void proCode(HttpServletResponse response) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		
		/* ============================================================================================= */
		String packageName = pd.getString("packageName");            //包名				========1
		String objectName = pd.getString("objectName");                //类名				========2
		String tabletop = pd.getString("tabletop");                    //表前缀				========3
		String objectRemark = pd.getString("objectRemark");                    //备注				========3
		tabletop = null == tabletop ? "" : tabletop.toUpperCase();        //表前缀转大写
		String zindext = pd.getString("zindex");                    //属性总数
		int zindex = 0;
		if (null != zindext && !"".equals(zindext)) {
			zindex = Integer.parseInt(zindext);
		}
		List<String[]> fieldList = new ArrayList<String[]>();    //属性集合			========4
		for (int i = 0; i < zindex; i++) {
			fieldList.add(pd.getString("field" + i).split(",fh,"));    //属性放到集合里面
		}
		//实体遍历
		List<String[]> entityList = new ArrayList<String[]>();
		for (int i = 0; i < fieldList.size(); i++) {
			String[] strings =  fieldList.get(i);
			String[] str =  new String[3];
			str[0]= getStr(strings[0].toString());
			entityList.add(str);
		}



		Map<String, Object> root = new HashMap<String, Object>();        //创建数据模型
		root.put("entityList", entityList);
		root.put("fieldList", fieldList);
		root.put("packageName", packageName);                        //包名
		root.put("objectName", objectName);                            //类名
		root.put("objectRemark", objectRemark);                            //备注
		root.put("objectNameLower", objectName.toLowerCase());        //类名(全小写)
		root.put("objectNameUpper", objectName.toUpperCase());        //类名(全大写)
		root.put("tabletop", tabletop);                                //表前缀
		root.put("nowDate", new Date());                            //当前日期

		DelAllFile.delFolder(PathUtil.getClasspath() + "admin/ftl"); //生成代码前,先清空之前生成的代码
		/* ============================================================================================= */
		logger.info("========开始生产代码========");
		String filePath = "admin/ftl/code/";                        //存放路径
		String ftlPath = "createCode";                                //ftl路径
		
		/*生成controller*/
		Freemarker.printFile("controllerTemplate.ftl", root, "controller/" + objectName + "Controller.java", filePath, ftlPath);

		/*生成service*/
		Freemarker.printFile("serviceTemplate.ftl", root, "service/"+ objectName +  "Service.java", filePath, ftlPath);

		/*生成mapper*/
		Freemarker.printFile("mapperTemplate.ftl", root, "mapper/"+ objectName +  "Mapper.java", filePath, ftlPath);

		/*生成Provider*/
		Freemarker.printFile("ProviderTemplate.ftl", root, "mapper/"+ objectName +  "Provider.java", filePath, ftlPath);

		/*生成HTML*/
		Freemarker.printFile("htmlTemplate.ftl", root, "html/"+ objectName +  ".html", filePath, ftlPath);

		/*生成index.xml  的菜单栏*/
		Freemarker.printFile("IndexTemplate.ftl", root, "html/"+ objectName +  "index.html", filePath, ftlPath);

		/*生成js*/
		Freemarker.printFile("jsTemplate.ftl", root, objectName+"/"+ objectName +  ".js", filePath, ftlPath);

		/*生成 *Operate.js*/
		Freemarker.printFile("jsOperateTemplate.ftl", root, objectName+"/"+ objectName +  "Operate.js", filePath, ftlPath);

		/*生成 实体*/
		Freemarker.printFile("EntityTemplate.ftl", root, "entity/"+ objectName +  ".java", filePath, ftlPath);

		/*生成 实体*/
		Freemarker.printFile("mysql_SQL_Template.ftl", root, "mysql/"+ objectName +  "mysql.txt", filePath, ftlPath);



		
		/*生成的全部代码压缩成zip文件*/
		FileZip.zip(PathUtil.getClasspath() + "admin/ftl/code", PathUtil.getClasspath() + "admin/ftl/code.zip");
		
		/*下载代码*/
		FileDownload.fileDownload(response, PathUtil.getClasspath() + "admin/ftl/code.zip", "code.zip");
		logger.info("========结束生产代码========");
	}

	/**
	 * 得到PageData
	 */
	public PageData getPageData() {
		return new PageData(this.getRequest());
	}

	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		return request;
	}

	public String getStr(String na) {
		String str = null;
		if(na.contains("_") == true){
			StringBuffer  sb = new StringBuffer();
			String[]  spStr = na.split("_");
			sb.append(spStr[0]);
			for (int i = 1; i < spStr.length; i++) {
				sb.append(spStr[i].substring(0,1).toUpperCase()+spStr[i].substring(1,spStr[i].length()).toLowerCase());
			}
			str = sb.toString();
		}else {
			str = na.toLowerCase();
		}
		return str;
	}
}