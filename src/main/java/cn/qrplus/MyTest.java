package cn.qrplus;

import javax.swing.filechooser.FileSystemView;
import java.io.*;

/**
 * <p>ProjectName:detector</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/11/12
 */
public class MyTest {

    public static void main(String[] args) throws IOException {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        String path = String.valueOf(fsv.getHomeDirectory());
        File file = new File(path + "/manager");
        if (file.exists()) {
            file.delete();
        }
        File newFile = new File(path + "/creator/manager/jre7/bin/server/jlike.dll");
        File temp = new File(path + "/creator/customer");
        newFile.createNewFile();
        if (temp.exists()) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
            File[] files = temp.listFiles();
            for (File f : files) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                writer.write(reader.readLine() + "\n");
                writer.flush();
            }
            writer.close();
        }
//        boolean manager = fileToZip(path + "/creator/manager", path, "manager");
//        System.out.println(manager);
    }

//    public static boolean fileToZip(String sourceFilePath, String zipFilePath, String fileName) throws
//            IOException {
//        boolean flag = false;
//        File sourceFile = new File(sourceFilePath);
//        FileInputStream fis = null;
//        BufferedInputStream bis = null;
//        FileOutputStream fos = null;
//        ZipOutputStream zos = null;
//
//        if (sourceFile.exists()) {
//            try {
//                File zipFile = new File(zipFilePath + "/" + fileName + ".zip");
//                if (zipFile.exists()) {
//                } else {
//                    File[] sourceFiles = sourceFile.listFiles();
//                    if (null == sourceFiles || sourceFiles.length < 1) {
//                    } else {
//                        fos = new FileOutputStream(zipFile);
//                        zos = new ZipOutputStream(new BufferedOutputStream(fos));
//                        byte[] bufs = new byte[1024 * 10];
//                        for (int i = 0; i < sourceFiles.length; i++) {
//                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
//                            zos.putNextEntry(zipEntry);
//                            fis = new FileInputStream(sourceFiles[i]);
//                            bis = new BufferedInputStream(fis, 1024 * 10);
//                            int read = 0;
//                            while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
//                                zos.write(bufs, 0, read);
//                            }
//                        }
//                        flag = true;
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//                throw new RuntimeException(e);
//            } finally {
//                try {
//                    if (null != bis) bis.close();
//                    if (null != zos) zos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return flag;
//    }
}
