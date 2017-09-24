package builder;

import java.util.ArrayList;
import java.util.List;

public class CommonString {

	public static final String PREFIX = "src/com/wonders/";

	public static final String ACTION = "/action";

	public static final String DAO = "/dao";

	public static final String SERVICE = "/service";

	public static final String IMP = "/imp";

	public static final String BO = "/bo";

	public CommonString() {

	}

	public static List<String> setFloder(String name) {
		List<String> floder = new ArrayList<String>();
		String allName = CommonString.PREFIX + name;
		String actionName=allName+CommonString.ACTION;
		String daoName = allName + CommonString.DAO;
		String daoImpName = daoName + CommonString.IMP;
		String serviceName = allName + CommonString.SERVICE;
		String serviceImpName = serviceName + CommonString.IMP;
		String boName = allName + CommonString.BO;
		floder.add(actionName);
		floder.add(allName);
		floder.add(daoName);
		floder.add(daoImpName);
		floder.add(serviceName);
		floder.add(serviceImpName);
		floder.add(boName);
		return floder;
	}

	public static List<String> setFlie(String name) {
		List<String> files = new ArrayList<String>();
		String allName = CommonString.PREFIX + name;
		String className=name.substring(0, 1).toUpperCase()+name.substring(1);
		String action=allName+CommonString.ACTION+"/"+className+"Action.java";
		String daoName = allName + CommonString.DAO+"/"+className+"Dao.java";
		String daoImpName = allName + CommonString.DAO + CommonString.IMP+"/"+className+"DaoImp.java";
		String serviceName = allName + CommonString.SERVICE+"/"+className+"Service.java";
		String serviceImpName = allName + CommonString.SERVICE + CommonString.IMP+"/"+className+"ServiceImp.java";
		String boName = allName + CommonString.BO+"/"+className+".java";
		files.add(action);
		files.add(daoName);
		files.add(daoImpName);
		files.add(serviceName);
		files.add(serviceImpName);
		files.add(boName);
		return files;
	}
}
