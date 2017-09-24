package builder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ClassFileCreater implements AbstractFileCreater {

	public void createFloder(String name) {
		List<String> floders = CommonString.setFloder(name);
		for (String floder : floders) {
			File file = new File(floder);
			if(!file.exists()){
				file.mkdirs();
			}
		}
	}
	

	public void createFile(String name) {
		List<String> files = CommonString.setFlie(name);
		for (String file : files) {
			File javaFile = new File(file);
			try {
				if(!javaFile.exists()){
				javaFile.createNewFile();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
	}


	public void createModule(String name) {
		createFloder(name);
		createFile(name);
	}

}
