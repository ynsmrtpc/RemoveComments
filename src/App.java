import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class App {

    private static String readLine(File file) {
        String fileText = "";
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String str;
            while((str = br.readLine()) != null) {
                fileText = fileText + replace(str) + "";
            } 
            br.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileText;
    }

    private static String replace(String str) {
        if(str.startsWith("//")){
            return "";
        } else if (str.contains("//")) {
            if (str.contains("\"")) {
                int last = str.lastIndexOf("\"");
                int lastComment = str.lastIndexOf("//");
                if (lastComment > last) {
                    str = str.substring(0, lastComment);
                } else {
                    int index = str.lastIndexOf("//");
                    str = str.substring(0, index);
                }
            }
        } 
        return str;
    }


    public static void main(String[] args) throws Exception {
        String directory = System.getProperty("user.dir");
        String fileName = "CommentlessCourse.java";
        String absolutePath = directory + File.separator + fileName;

        File f = new File("./Course.java");
        String fileS = readLine(f);
        fileS = fileS.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)", "");

        try (FileWriter fileWriter = new FileWriter(absolutePath)) {
            fileWriter.write(fileS);
        }  
                System.out.println(fileS);
    }
}