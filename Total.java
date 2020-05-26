import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import org.json.JSONObject;
public class Total {

	public static void main(String[] args) throws IOException 
	{
		double[] d = new double[10000];
		JSONObject obj1  = new JSONObject();
		JSONObject obj2 = new JSONObject();
		File file = new File("C:\\Users\\Megha Dharshini\\Desktop\\Memory.txt");
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) 
        {
            String readLine;
            double temp;
            int line = 0;
            int i=0;
            double sum=0.0;
            double max = 0.0;
            while ((readLine = bf.readLine()) != null) 
            {
                if (line % 2 != 0) {
                	
                	String str=readLine;
                	str=str.replaceAll("[^0-9]","");
                    str=str.trim();
                    temp=Integer.parseInt(str);
                    d[i++]=temp/10000;
                }
                line++;
            }
            String str1;
            for(int j=0;j<938;j++)
            {
            	str1 = String.format("%d",j);
            	obj2.put(str1 + "s", d[j]);
            	if(max<d[j])
            		max=d[j];
            	sum=sum+d[j];
            }
           
            double average=sum/938;
            //System.out.println("AverageMemory(MB): " + average);
            //System.out.println("MaximumMemory(MB): " + max);
            DecimalFormat df = new DecimalFormat("#.###");
            df.setRoundingMode(RoundingMode.CEILING);
            obj1.put("AverageMemory(MB)", df.format(average));
            obj1.put("values: ", obj1);
            obj1.put("MaximumMemory(MB)", df.format(max));
            System.out.println(obj1);
         }
 }
}
