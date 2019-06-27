package cn.jbone.fs.common.utils;

public class FileUtils {
    public static String getSuffix(String fileName){
        if(fileName.indexOf(".") != -1){
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return "";
    }

    public static String getSuffixWithDot(String fileName){
        if(fileName.indexOf(".") != -1){
            return fileName.substring(fileName.lastIndexOf("."));
        }
        return "";
    }

    public static String getFileNameWithoutDomain(String fileUrl){

        if(fileUrl.startsWith("http://") || fileUrl.startsWith("https://")){
            return  fileUrl.substring(fileUrl.indexOf("/",8) + 1);
        }

        return fileUrl;
    }
}
