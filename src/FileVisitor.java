import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.util.List;

public class FileVisitor{
    Path dir = Paths.get("C:\\Users\\bazis-\\Documents\\archivesForJavaCmdHomework");
    public Path getRootPath(){
        return Paths.get("C:\\Users\\bazis-\\Documents\\archivesForJavaCmdHomework");
    }
    public void ls() {
        File dirList = new File(dir.toString());
        if (dirList.isDirectory()){
            for (File item : dirList.listFiles()){
                if (item.isDirectory()){
                    System.out.println(item.getName() + " <folder>");
                }
                else{
                    System.out.println(item.getName() + " <file>");
                }
            }
        }
    }
    public void movePath(String Path){
        dir = Paths.get(Path);
    }
    public void setPreviousPath(){
        dir = Paths.get(dir.getParent().toString());
    }
    public String getPath(){
        return dir.toString();
    }
    public void readFile(Path file) throws IOException {
        List<String> lines = Files.readAllLines(file);
        for (String s : lines){
            System.out.println(s);
        }
    }
}
