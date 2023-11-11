package com.xml_project_be.xml_project.file.dir;

import java.io.File;

public class CheckMKDir {
    public static void check_dir_exist(File file) {
        if (!file.exists()) file.mkdirs();
    }
}