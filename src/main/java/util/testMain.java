package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class testMain {

	public static void main(String[] args) {
        try {
            File filename= new File("C:\\Users\\xym48\\Desktop\\st.log");
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);

            String line = "";
            String analyze = "";
            String result = "";
            List<String> resultList = new ArrayList<String>();
            while(true){
                line = br.readLine();
                if(line == null)
                    break;
                //line = Detect.Detect(line);
                analyze = Analyze.Analyze(line);
                if(line != null)
                    resultList.add(analyze);
            }
            result = StringListTools.ListToString(resultList, "\n");
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
