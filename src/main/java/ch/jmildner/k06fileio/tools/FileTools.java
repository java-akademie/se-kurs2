
package ch.jmildner.k06fileio.tools;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileTools {

    public static void deleteDirectory(File d, boolean deleteNotEmptyDirs) {
        System.out.printf("%n-delete dir[%s] deleteNotEmptyDirs=%b %n",
                d, deleteNotEmptyDirs);

        String[] dirList = d.list();
        if (dirList != null) {
            if (dirList.length == 0) {
                deleteDirectory(d);
                return;
            }
        } else {
            System.out.println("nothing to delete");
            return;
        }

        if (deleteNotEmptyDirs) {
            for (String fn : dirList) {
                File f = new File(d.toString() + "/" + fn);
                deleteFile(f);
            }
            deleteDirectory(d);
            return;
        }
        System.out.println("dir was not empty");
    }

    public static void showDirectory(File d) {
        String[] a = d.list();
        System.out.printf("%s %s %n",
                d, a == null ? "[not a directory]"
                        : a.length == 0 ? "[empty directory]"
                        : Arrays.toString(a));
    }

    public static void makeFile(File f) throws IOException {
        System.out.printf("file[%s] %s %n", f,
                f.createNewFile() ? "created" : "not created");
    }


    public static void makeDirectory(File d) {
        System.out.printf("dir[%s] %s %n", d,
                d.mkdir() ? "created" : "not created");
    }

    public static void deleteFile(File f) {
        System.out.printf("file[%s] %s %n", f,
                f.delete() ? "deleted" : "not deleted");
    }

    public static void deleteDirectory(File d) {
        System.out.printf("dir[%s] %s %n", d,
                d.delete() ? "deleted" : "not deleted");
    }

    public static void makeDirectory(String dirName) {
        File d = new File(dirName);
        System.out.printf("dir[%s] %s %n", d,
                d.mkdir() ? "created" : "not created");
    }

}
