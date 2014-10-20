package ua.fesvlast.tim.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Tymofii_Vlasov on 9/29/2014.
 */
public class Util {

    public char[] getURLData(String str) throws IOException {
        URL theURL =new URL(str);
        URLConnection conn =theURL.openConnection();

        int contentLen =conn.getContentLength();
        //System.out.println("Content length: "+contentLen);
        int c;
        char[] listChars=null;
        if(contentLen!=0){
            //System.out.println("Content: ");
           // System.out.println(conn.getContentType());
            InputStream stream =conn.getInputStream();
            BufferedInputStream reader =new BufferedInputStream(stream);
            listChars=new char[contentLen];
            int counter=0;
            while (((c=reader.read())) !=-1){
                listChars[counter]=(char)c;
                counter++;
            }
            stream.close();
            reader.close();
        }else{
            System.out.println("Sorry, no content!");
        }
        return listChars;
    }

    public boolean saveInfoFromURL(File f, char[] arr) {
        boolean status=true;
        FileWriter writer = null;
        BufferedWriter bw=null;
        try {
            writer = new FileWriter(f);
            bw =new BufferedWriter(writer);
            bw.write(arr);
        } catch (IOException e) {
          System.err.println("Error occured! The information wasn't written into the file!");
           status=false;
        }finally {
            try {
                bw.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return status;

    }
}
