package ua.fesvlast.tim;

import ua.fesvlast.tim.util.EnterData;
import ua.fesvlast.tim.util.Util;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	    System.out.println("This Application allow you download and save information from WEB sight.");
        EnterData enter =new EnterData();
        String url=enter.getUrlAddress();
        File file =enter.inputFilePath();

        Util util =new Util();
       char[]arr= util.getURLData(url);
        if(arr !=null){
            util.saveInfoFromURL(file, arr);
            System.out.println("Success.... ");
        }else{
            System.err.println("The application can't get this page, it is unavailable to download!");
        }
    }
}
