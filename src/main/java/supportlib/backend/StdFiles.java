package supportlib.backend;

import supportlib.Files;
import supportlib.files.Fi;
import supportlib.util.ArcRuntimeException;
import supportlib.util.OS;

import java.io.File;

public final class StdFiles implements Files {
    public static String externalPath = OS.userHome + File.separator;
    public static String localPath = new File("").getAbsolutePath() + File.separator;

    @Override
    public Fi get(String fileName, FileType type){
        return new StdFi(fileName, type);
    }

    @Override
    public String getExternalStoragePath(){
        return externalPath;
    }

    @Override
    public boolean isExternalStorageAvailable(){
        return true;
    }

    @Override
    public String getLocalStoragePath(){
        return localPath;
    }

    @Override
    public boolean isLocalStorageAvailable(){
        return true;
    }

    public static final class StdFi extends Fi{
        public StdFi(String fileName, FileType type){
            super(fileName, type);
        }

        public StdFi(File file, FileType type){
            super(file, type);
        }

        @Override
        public Fi child(String name){
            if(file.getPath().length() == 0) return new StdFi(new File(name), type);
            return new StdFi(new File(file, name), type);
        }

        @Override
        public Fi sibling(String name){
            if(file.getPath().length() == 0) throw new ArcRuntimeException("Cannot get the sibling of the root.");
            return new StdFi(new File(file.getParent(), name), type);
        }

        @Override
        public File file(){
            if(type == FileType.external) return new File(externalPath, file.getPath());
            if(type == FileType.local) return new File(localPath, file.getPath());
            return file;
        }
    }
}