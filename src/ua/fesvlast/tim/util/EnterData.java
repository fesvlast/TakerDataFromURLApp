package ua.fesvlast.tim.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tymofii_Vlasov on 9/29/2014.
 */
public class EnterData {
    BufferedReader reader =null;

    public EnterData(){
        reader =new BufferedReader(new InputStreamReader(System.in));
    }

    public String getUrlAddress() throws IOException {
        System.out.println("Enter URL address(http://*****): ");
        String str =null;
        while (true){
            str =reader.readLine();
            System.out.println(str);
            if(str.equalsIgnoreCase("exit")) System.exit(0);
            if (validatorAddress(str)){
                break;
            }else{
                System.err.println("Invalid URL address!");
            }
        }
        System.out.println("OK");
        return str;
    }

    public File inputFilePath() throws IOException {
        File f = null;
        while (true) {
            System.out.println("Input the absolute folder's path for saving file: ");
            String str = reader.readLine();
            if (str.equalsIgnoreCase("exit"))  System.exit(0);

            if(validatorFilesPath(str)){
                     f = new File(str);
                     f.getParentFile().mkdirs();
                     f.createNewFile();
                    //System.out.println(f);
                    if (f.isFile()) {
                        break;
                    } else {
                        System.out.println("Wrong path for saving file");
                    }
            }else{
                System.err.println("Wrong path!");
            }
        }
        System.out.println("OK");
        return f;
    }

    public boolean validatorAddress(String str){
        Pattern pattern =Pattern.compile("((http)://)?(([a-z0-9\\-\\.]+)?[a-z0-9\\-]+(!?\\.[a-z]{2,4}))");
        Matcher matcher =pattern.matcher(str);
        return matcher.matches();
    }

    public boolean validatorFilesPath(String str){
        Pattern pattern =Pattern.compile("(\\w:((\\\\)|(\\/))+([A-z0-9_-]+((\\\\)|(\\/))+)+([A-z0-9_-]+.[A-z0-9]+))");
        Matcher matcher =pattern.matcher(str);
        return matcher.matches();
    }

}
