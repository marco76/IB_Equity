package ch.genidea.greed.ib.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SendNotification {
    public void sendNotification(String application, String event, String description) {
           try {

                String data = URLEncoder.encode("apikey", "UTF-8") + "=" + URLEncoder.encode("d06c620aa68cc6722c24f71aa5543b502c8c82bf", "UTF-8");
                data += "&" + URLEncoder.encode("application", "UTF-8") + "=" + URLEncoder.encode(application, "UTF-8");
                data += "&" + URLEncoder.encode("event", "UTF-8") + "=" + URLEncoder.encode(event, "UTF-8");
                data += "&" + URLEncoder.encode("description", "UTF-8") + "=" + URLEncoder.encode(description, "UTF-8");


                String urlAdress = "https://api.prowlapp.com/publicapi/add";
                URL url = new URL(urlAdress);
                URLConnection urlConnection = url.openConnection();
                urlConnection.setDoOutput(true);

                OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
                wr.write(data);
                wr.flush();

                // Get the response
                BufferedReader rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = rd.readLine()) != null) {
                    System.out.println(line
                    );
                }
                wr.close();
                rd.close();


            } catch (Exception e) {
                e.printStackTrace();
            }


        //To change body of implemented methods use File | Settings | File Templates.
    }
}