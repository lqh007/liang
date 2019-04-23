package com.seven.common.utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class LoadPublicKeyByFile {
    public static String loadPublicKeyByFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String readLine = null;

            while ((readLine = br.readLine()) != null) {
                sb.append(readLine);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();

    }
}
