package basic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;

public class Log {
	public static String filePath="log.txt";
	public static boolean isFirst=true;
	static FileWriter writer;
    public static void toNull(String x) {
        try (FileWriter fileWriter = new FileWriter(filePath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            //for (int i = 0; i < 10; i++) { // 假设我们要写入10行
                bufferedWriter.write(x); // 写入内容
                //bufferedWriter.newLine(); // 写入换行符
            //}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    public static void log(String x) {
    	// 获取堆栈追踪
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // 获取直接调用printMethodName方法的元素
        StackTraceElement callerElement = stackTrace[2];
        // 打印方法名
        System.out.println("time:["+getTime()+"] , method:["+callerElement.getMethodName()+"] , INFO:"+x);
    	write("time:["+getTime()+"] , method:["+callerElement.getMethodName()+"] , INFO:"+x);
    }
    public static void write(String x ) {
    	appendToFile(filePath, x);
    }
    public static void appendToFile(String filePath, String content) {
        try (FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(content);
            bufferedWriter.newLine(); // 写入一个新行
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @deprecated
     * @param sourceFile
     * @param targetDir
     * @throws IOException
     */
    public static void copyDirectory(String sourceFile, String targetDir) throws IOException {

        try {
            File fileToCopy = new File(sourceFile);
            File targetDirectory = new File(targetDir);

            // 检查目标目录是否存在，如果不存在则创建
            if (!targetDirectory.exists()) {
                targetDirectory.mkdirs();
            }

            // 使用Files类的copy方法拷贝文件
            Path sourcePath = Paths.get(fileToCopy.toURI());
            Path targetPath = Paths.get(targetDirectory.toURI());
            Files.copy(sourcePath, targetPath.resolve(sourcePath.getFileName()));

            System.out.println("文件拷贝成功！");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

