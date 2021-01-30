
package testing_files;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;



public class testing_file {

  
    public static void main(String[] args)throws Exception {
       
        String uri = "https://api.rootnet.in/covid19-in/stats/latest";
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
            StringBuffer response = new StringBuffer();
            
            while((inputLine = br.readLine())!= null )
            {
                response.append(inputLine);
            }
            
            br.close();
            
           
           JSONObject myresponse = new JSONObject(response.toString());
           System.out.println("");
           System.out.println("");
           System.out.println("");
           
           System.out.println("-------------------------------------------------");
           System.out.println("Total Counts Till Date");
           System.out.println("-------------------------------------------------");
           
           JSONObject data = myresponse.getJSONObject("data");
           JSONObject summary = data.getJSONObject("summary");
           
           System.out.println("(Official)");
           System.out.println("");
           
           System.out.println("Total             : "+summary.get("total"));
           System.out.println("Confirmed Indian  : "+summary.get("confirmedCasesIndian"));
           System.out.println("Confirmed Foreign : "+summary.get("confirmedCasesForeign"));
           System.out.println("Total Discharged  : "+summary.get("discharged"));
           System.out.println("Total Deaths      : "+summary.get("deaths"));
           
           
           System.out.println("");
          
           System.out.println("(Un-Official)");
           System.out.println("");
           
           org.json.JSONArray ja = data.getJSONArray("unofficial-summary");
           JSONObject un_total = ja.getJSONObject(0);
           
           System.out.println("Total    : "+un_total.get("total"));
           System.out.println("Recovred : "+un_total.get("recovered"));
           System.out.println("Deaths   : "+un_total.get("deaths"));
           System.out.println("Active   : "+un_total.get("active"));
           
           System.out.println("-------------------------------------------------");
           System.out.println("State Wise Data");
           System.out.println("-------------------------------------------------");
           

            
    }
    
}
