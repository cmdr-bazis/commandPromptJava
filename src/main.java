import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class main extends FileVisitor {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        FileVisitor path = new FileVisitor();

        while (!choice.equals("exit")){
            if (choice.startsWith("ls")){
                path.ls();
            }

            else if(choice.startsWith("cd")){
                if (choice.substring(3).equals("-")){
                    if (path.getPath().equals(path.getRootPath().toString())){
                        System.out.println("This is already root directory");
                    }
                    else {
                        path.setPreviousPath();
                    }
                }
                else if(choice.substring(3).equals("~")){
                    path.movePath(path.getRootPath().toString());
                }
                else{
                    Path newPath = Paths.get(path.getPath(), choice.substring(3));
                    if (newPath.toFile().isDirectory()){
                        path.movePath(newPath.toString());
                    }
                    else{
                        System.out.println("Not a directory");
                    }
                }
            }

            else if(choice.startsWith("pwd")){
                System.out.println(path.getPath());
            }

            else if(choice.startsWith("cat")){
                Path newFile = Paths.get(path.getPath(), choice.substring(4));
                if (newFile.toFile().isFile()){
                    path.readFile(Paths.get(path.getPath(), choice.substring(4)));
                }
                else {
                    System.out.println("Not a file");
                }
            }
            choice = input.nextLine();
        }
    }
}