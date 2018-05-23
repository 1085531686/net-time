package learn.test.man;

import java.io.File;
import java.net.URL;


public class ContextUtil {
	public static File getRootDri() {
        String rootDir="";
		URL url = ContextUtil.class.getClassLoader().getResource(
				"learn/test/man/ContextUtil.class");
		File f = new File(url.getFile());
		String Path = f.getAbsolutePath();
		System.out.println(Path);
		int endIndex = Path.indexOf("target");
		int startIndex = Path.indexOf("file:");
		if (startIndex == -1) {
			startIndex = 0;
		} else {
			startIndex = startIndex+6;
		}
		if (endIndex != -1) {
			rootDir=Path.substring(startIndex,endIndex);
		}else{
			endIndex=Path.lastIndexOf("bin");
			rootDir=Path.substring(startIndex,endIndex);
		}
		File root =new File(rootDir);
		return root;
	}
	
	
	public static File getConfigDir(String configdir){
		return new File(getRootDri(),configdir);
	}
}
