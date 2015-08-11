package sample;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.text.GapContent;

import org.json.JSONObject;

public class Bet {

    public void doLogin(String username, String password) throws Exception{

        String USER_AGENT = "Mozilla/5.0";

        String url = "https://api.primedice.com/api/login";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        // Header Request
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "username=" + username + "&password=" + password;

        // Send Parameters
        con.setDoOutput(true); //Request body, not needed in GET
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();


        //print result
        System.out.println(response.toString());

        JSONObject loginJsonResp = new JSONObject(response.toString());
        accessToken = loginJsonResp.getString("access_token");
        System.out.println(accessToken);
    }

}
