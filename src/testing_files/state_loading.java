
package testing_files;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;


public class state_loading{

    String store_state_name;

    public void state_names()
    {
        
         try{
             
             
                 
            StringBuffer response = null;
            
            String uri = "https://api.covid19india.org/data.json";
            URL obj = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Opera");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' Request to url : "+uri);
            System.out.println("Response Code : "+responseCode);
            System.out.println("-----------------------------------------------------");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            response = new StringBuffer();
            
             while((inputLine = br.readLine())!= null )
            {
                response.append(inputLine);
            }
            
            br.close();
          
            JSONObject myresponse = new JSONObject(response.toString());
            
            JSONArray ja = myresponse.getJSONArray("statewise");
            
            JSONObject state_name = (JSONObject) ja.get(0);
          
            String store_state_name = state_name.getString("deltaconfirmed");
            
            System.out.println("State Name : "+store_state_name);
             
      
}
      
   
   catch(Exception e)
   {
       e.printStackTrace();
   }
        
    }
    
    
   public static void main(String []args) 
   {
       
       state_loading sl = new state_loading();
       sl.state_names(); 
       
       
      
   }
}