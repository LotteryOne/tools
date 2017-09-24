package com.tappe.move.MovePro;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;

public class MoveSyljg extends TestCase {

	public void setUp() {
		// super.setUp();
	}

	public void testVal() throws Exception {
		// /配置区
		String yyyymmdd = new java.text.SimpleDateFormat("yyyyMMdd")
				.format(new Date());// 系统当前年月日
		String createFileRoute = "C:/Log/" + yyyymmdd + "/syljg/";//// 文件生成路径
		String workSpaceRoute = "C:/SOFT/file/work9/syljg";// 项目所在路径
		Map showMap = new HashMap();

		// 将SVN提交的现成路径获取后从控制台粘贴后进行编译文件的格式转换
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int i = 1;
		String oriRoute;
		String first="C:/SOFT/file/work9";
		while ((oriRoute = reader.readLine()) != null) {
			String sourceRoute = first+oriRoute;
			String destinationRoute = "";
			// source取自java build path
			
			String source1 = first+"/syljg/src/main/java";
//			String source6 = "C:/SOFT/file/WORK/Work1/mzzhyw/src/resource";

			String output = first+"/syljg/webapp/WEB-INF/classes";// 编译路径路径
//			sourceRoute = sourceRoute.replace(source6, output);
			sourceRoute = sourceRoute.replace(source1, output);
			sourceRoute = sourceRoute.replace(".java", ".class");
			System.out.println("编译文件路径=" + sourceRoute);
			destinationRoute = createFileRoute
					+ sourceRoute.replace(workSpaceRoute, "");
			destinationRoute = destinationRoute.replace("syljg/webapp/WEB-INF/",
					"syljg.war/WEB-INF/");// 转换成websphere的路径模式
			destinationRoute = destinationRoute.replace(
					"syljg/webapp/WEB-INF/jsp/", "syljg.war/WEB-INF/jsp/");
			destinationRoute = destinationRoute.replace("syljg/webapp/js/",
					"syljg.webapp/js/");
			destinationRoute = destinationRoute.replace("syljg/webapp/",
					"syljg.war/");
			System.out.println("目的路径=" + destinationRoute);

			// 文件搬运
			File fileSource = new File(sourceRoute);
			File fileDestination = new File(destinationRoute);
			FileUtils.copyFile(fileSource, fileDestination);

			System.out.println("文件搬运完成");
			i++;

			// 以下内容用于粘贴到文件更新记录中
			String filePath = sourceRoute.replace(workSpaceRoute, "");
			filePath = filePath.replace("syljg/webapp/WEB-INF/",
					"syljg.war/WEB-INF/");
			filePath = filePath.replace("syljg/webapp/jsp/", "syljg.war/jsp/");
			filePath = filePath.replace("syljg/webapp/js/", "syljg.war/js/");
			filePath = filePath.replace("syljg/webapp/", "syljg.war/");
			String fileName = filePath.substring(filePath.lastIndexOf("/") + 1,
					filePath.length());
			showMap.put(filePath, fileName);
			System.out.println(fileName + "	" + filePath);
		}

	}

}
