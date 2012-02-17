import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class CopyFiles {
	
	private static final String SRC_PATH = "/home/shardul/Env/Apache-Maven/Local_Maven_Repository";
	private static final String DEST_PATH = "/home/shardul/Env/JARs";
	
	private static void findFiles(File[] files, List<File> resultFilesList) {
		for (File file : files) {
			if (file.isDirectory()) {
				findFiles(file.listFiles(), resultFilesList);
			} else {
				resultFilesList.add(file);
			}
		}
	}
	

	private static boolean isJarFile(String fileName) {
		int dotLastIndex = fileName.lastIndexOf(".");
		if (dotLastIndex != -1) {
			String extension = fileName.substring(dotLastIndex + 1);
			return "jar".equals(extension);
		}
		
		return false;
	}
	
	private static InputStream getFileInputStream(File file) {
		InputStream is = null;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file : " + file.getAbsolutePath() + ".Cause : " + e.getMessage());
		} 
		return is;
	}
	
	private static OutputStream getFileOutputStream(File file) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file : " + file.getAbsolutePath() + ".Cause : " + e.getMessage());
		} 
		
		return os;
	}
	
	private static boolean copy(File srcFile, String destDir) {
		
		InputStream fis = getFileInputStream(srcFile);
		
		String outputFilePath =  destDir + "/" + srcFile.getName();
		OutputStream fos = getFileOutputStream(new File(outputFilePath));
		int i = -1;
		
		boolean flag = false;
		try {
			
			while ((i = fis.read()) != -1) {
				fos.write(i);
			}
			flag = true;
		} catch (IOException e) {
			System.out.println("IOException occured while copying the file : "
					+ srcFile.getAbsolutePath() + ".Cause : " + e.getMessage());
			flag = false;
		} finally {
			closeStream(fos);
			closeStream(fis);
		}
		
		return flag;
	}
	
	private static void closeStream(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				System.out.println("IOException occured while closing the stream : " + e.getMessage());
			}	
		}
	}
	
	public static void main(String[] args) {
		File dir = new File(SRC_PATH);
		
		List<File> resultFilesList = new ArrayList<File>();
		findFiles(dir.listFiles(), resultFilesList);
		
		System.out.println("Total Files found " + resultFilesList.size() );
		
		List<File> jarFilesList = new ArrayList<File>();
		for (File file : resultFilesList) {
			if(isJarFile(file.getName())) {
				jarFilesList.add(file);	
			}
		}
		
		System.out.println("Total JAR Files found " + jarFilesList.size() );
		
		System.out.println("Copying files...");
		int copiedFilesCount = 0;
		for (File file : jarFilesList) {
			if (copy(file, DEST_PATH)) {
				copiedFilesCount++;
			}
		}
		System.out.println("Copied");
		System.out.println("Copied JAR Files to [" + DEST_PATH + "] Count:" + copiedFilesCount );
		
	}
}
