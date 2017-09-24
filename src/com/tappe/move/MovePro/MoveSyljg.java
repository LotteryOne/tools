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
		// /������
		String yyyymmdd = new java.text.SimpleDateFormat("yyyyMMdd")
				.format(new Date());// ϵͳ��ǰ������
		String createFileRoute = "C:/Log/" + yyyymmdd + "/syljg/";//// �ļ�����·��
		String workSpaceRoute = "C:/SOFT/file/work9/syljg";// ��Ŀ����·��
		Map showMap = new HashMap();

		// ��SVN�ύ���ֳ�·����ȡ��ӿ���̨ճ������б����ļ��ĸ�ʽת��
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int i = 1;
		String oriRoute;
		String first="C:/SOFT/file/work9";
		while ((oriRoute = reader.readLine()) != null) {
			String sourceRoute = first+oriRoute;
			String destinationRoute = "";
			// sourceȡ��java build path
			
			String source1 = first+"/syljg/src/main/java";
//			String source6 = "C:/SOFT/file/WORK/Work1/mzzhyw/src/resource";

			String output = first+"/syljg/webapp/WEB-INF/classes";// ����·��·��
//			sourceRoute = sourceRoute.replace(source6, output);
			sourceRoute = sourceRoute.replace(source1, output);
			sourceRoute = sourceRoute.replace(".java", ".class");
			System.out.println("�����ļ�·��=" + sourceRoute);
			destinationRoute = createFileRoute
					+ sourceRoute.replace(workSpaceRoute, "");
			destinationRoute = destinationRoute.replace("syljg/webapp/WEB-INF/",
					"syljg.war/WEB-INF/");// ת����websphere��·��ģʽ
			destinationRoute = destinationRoute.replace(
					"syljg/webapp/WEB-INF/jsp/", "syljg.war/WEB-INF/jsp/");
			destinationRoute = destinationRoute.replace("syljg/webapp/js/",
					"syljg.webapp/js/");
			destinationRoute = destinationRoute.replace("syljg/webapp/",
					"syljg.war/");
			System.out.println("Ŀ��·��=" + destinationRoute);

			// �ļ�����
			File fileSource = new File(sourceRoute);
			File fileDestination = new File(destinationRoute);
			FileUtils.copyFile(fileSource, fileDestination);

			System.out.println("�ļ��������");
			i++;

			// ������������ճ�����ļ����¼�¼��
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
