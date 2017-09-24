package com.tappe.move.MovePro;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import junit.framework.TestCase;

public class MoveDbWeb extends TestCase {
	protected void setUp() throws Exception {
	}

	public void testVal() throws Exception {
		String yyyymmdd = new java.text.SimpleDateFormat("yyyyMMdd")
				.format(new Date());// 系统当前年月日

		// 工程名必须和项目目录同名 否则报错

		String project = "/lxbt"; // 工程名
		String createFilePath = "C:/Log"; // 保存路径
		String workSpacePath = "C:/SOFT/file/WORK/Work1/lxbt"; // 工程所在目录
		String webRoot = "WebRoot"; // webRoot

		String createFileRoute = createFilePath + "/" + yyyymmdd + project
				+ "/";
		String workSpaceRoute = workSpacePath;
		Map showMap = new HashMap();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int i = 1;
		String oriRoute;
		String first = workSpaceRoute.replace(project, "");
		String pro = project.replace("/", "");
		while ((oriRoute = reader.readLine()) != null) {
			String sourceRoute = first + oriRoute;
			String destinationRoute = "";

			String source1 = workSpaceRoute + "/src/java";
			String source2 = workSpaceRoute + "/src/resource";

			String output = workSpaceRoute + "/" + webRoot + "/WEB-INF/classes";// 编译路径路径

			sourceRoute = sourceRoute.replace(source1, output);
			sourceRoute = sourceRoute.replace(source2, output);
			
			
			sourceRoute = sourceRoute.replace(".java", ".class");
			System.out.println("编译文件路径=" + sourceRoute);
			destinationRoute = createFileRoute
					+ sourceRoute.replace(workSpaceRoute, "");
			destinationRoute = destinationRoute.replace(pro + "/" + webRoot
					+ "/WEB-INF/", pro + ".war/WEB-INF/");// 转换成websphere的路径模式
			destinationRoute = destinationRoute.replace(pro + "/" + webRoot
					+ "/WEB-INF/jsp/", pro + ".war/WEB-INF/jsp/");
			destinationRoute = destinationRoute.replace(pro + "/" + webRoot
					+ "/js/", pro + "." + webRoot + "/js/");
			destinationRoute = destinationRoute.replace(pro + "/" + webRoot
					+ "/", pro + ".war/");
			System.out.println("目的路径=" + destinationRoute);

			// 文件搬运
			File fileSource = new File(sourceRoute);
			File fileDestination = new File(destinationRoute);
			FileUtils.copyFile(fileSource, fileDestination);

			System.out.println("文件搬运完成");
			i++;

			// 以下内容用于粘贴到文件更新记录中
			String filePath = sourceRoute.replace(workSpaceRoute, "");
			filePath = filePath.replace(pro + "/" + webRoot + "/WEB-INF/", pro
					+ ".war/WEB-INF/");
			filePath = filePath.replace(pro + "/" + webRoot + "/jsp/", pro
					+ ".war/jsp/");
			filePath = filePath.replace(pro + "/" + webRoot + "/js/", pro
					+ ".war/js/");
			filePath = filePath.replace(pro + "/" + webRoot + "/", pro
					+ ".war/");
			String fileName = filePath.substring(filePath.lastIndexOf("/") + 1,
					filePath.length());
			showMap.put(filePath, fileName);
			System.out.println(fileName + "	" + filePath);
		}

	}
}
