import java.io.*;

public class CopyFiles{
    public static boolean copyFile(String src,String des){
        File file=new File(src);
        int ch;
        byte [] data=new byte[1024*2];
        if(file.isFile()){
            try {
                FileInputStream fin=new FileInputStream(src);
                String filename=file.getName().substring(0,file.getName().indexOf('.'));
                String extension=file.getName().substring(file.getName().indexOf('.'));

                FileOutputStream fout=new FileOutputStream(des+"/"+filename+"_copy"+extension);
                while ((ch=fin.read())!=-1){
                    fout.write((char)ch);
                }
                fin.close();
                fout.close();
                return true;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
      return false;
    }


    public static boolean copyDir(String src,String des){
        File file=new File(src);
        if(file.isFile()){
            copyFile(src,des);
            return true;
        }

        if(file.isDirectory()){
            File destinationDir=new File(des+"\\"+file.getName()+"_copy");
            if (!destinationDir.exists()) {
                destinationDir.mkdirs();
            }
            for(File f:file.listFiles()){
                if(f.isFile()){
                    copyFile(f.getAbsolutePath(),destinationDir.getAbsolutePath());
                }else {
                    copyDir(f.getAbsolutePath(), destinationDir.getAbsolutePath());
                }
            }
            return true;
        }
    return false;
    }


}