
package ch.jmildner.k06fileio.u1navigation_in_filesystem;

import ch.jmildner.k06fileio.tools.FileTools;
import ch.jmildner.tools11.MyTools;
import java.io.File;
import java.io.IOException;

public class U10NavigationInFilesystem {

    public static void main(String[] args) throws IOException {

        MyTools.h1("U10NavigationInFilesystem");

        File dir1 = new File("temp1");
        File f11 = new File(dir1, "f11.txt");
        File f12 = new File(dir1, "f12.txt");

        File dir2 = new File("temp2");
        File f21 = new File(dir2, "f21.txt");
        File f22 = new File(dir2, "f22.txt");

        File dir9 = new File("temp9");

        MyTools.h2("makeDirectories - dir1, dir2, dir9");
        FileTools.makeDirectory(dir1);
        FileTools.makeDirectory(dir2);
        FileTools.makeDirectory(dir9);

        MyTools.h2("makeDirectories - dir1,dir2, dir9 - again");
        FileTools.makeDirectory(dir1);
        FileTools.makeDirectory(dir2);
        FileTools.makeDirectory(dir9);

        MyTools.h2("makeFiles - f11, f12, f21, f22");
        FileTools.makeFile(f11);
        FileTools.makeFile(f12);
        FileTools.makeFile(f21);
        FileTools.makeFile(f22);

        MyTools.h2("makeFiles - f11, f12, f21, f22 - again");
        FileTools.makeFile(f11);
        FileTools.makeFile(f12);
        FileTools.makeFile(f21);
        FileTools.makeFile(f22);

        MyTools.h2("showDirectories - dir1, dir2, dir9");
        FileTools.showDirectory(dir1);
        FileTools.showDirectory(dir2);
        FileTools.showDirectory(dir9);

        MyTools.h2("deleteDirectories - dir1, dir2, dir9 - should not work");
        FileTools.deleteDirectory(dir1);
        FileTools.deleteDirectory(dir2);
        FileTools.deleteDirectory(dir9);

        MyTools.h2("delete1 - f11, f12, dir1");
        FileTools.deleteFile(f11);
        FileTools.deleteFile(f12);
        FileTools.deleteDirectory(dir1);

        MyTools.h2("delete2 - f21, f22, dir2");
        FileTools.deleteFile(f21);
        FileTools.deleteFile(f22);
        FileTools.deleteDirectory(dir2);

        MyTools.h2("deleteDirectories - after delete");
        FileTools.deleteDirectory(dir1);
        FileTools.deleteDirectory(dir2);
        FileTools.deleteDirectory(dir9);

        MyTools.h2("showDirectories - after delete");
        FileTools.showDirectory(dir1);
        FileTools.showDirectory(dir2);
        FileTools.showDirectory(dir9);


        MyTools.h2("make and show 1 - dir1, f11, f12");
        FileTools.makeDirectory(dir1);
        FileTools.makeFile(f11);
        FileTools.makeFile(f12);
        FileTools.showDirectory(dir1);


        MyTools.h2("deleteDirectories 1");

        FileTools.deleteDirectory(dir1, false);
        FileTools.deleteDirectory(dir1, true);
        FileTools.deleteDirectory(dir1, true);
        FileTools.deleteDirectory(dir1, false);
    }

}
