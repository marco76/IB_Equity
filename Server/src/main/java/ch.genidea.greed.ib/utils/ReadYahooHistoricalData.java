package ch.genidea.greed.ib.utils;

import java.io.*;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: marco
 * Date: 4/29/12
 * Time: 10:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReadYahooHistoricalData {

    public static String[][] readAllSymbolsFromFile(String directory, String marketName){
        String array[][] = new String[10000][15];
        try{

           File file = new File(directory+marketName+".csv");
           FileReader fileReader = new FileReader(file);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           String strLine = "";
           int lineNumber = -1, tokenNumber = -1;
           // first line contains titles
            bufferedReader.readLine();
           //read comma separated file line by line
           while( (strLine = bufferedReader.readLine()) != null)
           {
               int a;
               lineNumber++;
               if (strLine.contains("ULTA"))
                   a=1;
               //break comma separated line using ","
                String[] newString = strLine.split("\",");
               for (int k = 0 ; k < newString.length; k++){

                   array[lineNumber][k] = newString[k].replace("\"", "").trim();

               }

               System.out.println(array[lineNumber].toString());

           }


       }
       catch(Exception e)
       {
           System.out.println("Exception while reading csv file: " + e);
       }
        return array;
    }

    public static String[][] readHistoricalDataFromFile(String directory, String equityTicker){
        String array[][] = new String[10000][10];
        try{

            File file = new File(directory+"/"+equityTicker.toUpperCase()+".txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String strLine = "";
            int lineNumber = -1;
            // first line contains titles
            bufferedReader.readLine();
            //read comma separated file line by line
            while( (strLine = bufferedReader.readLine()) != null)
            {
                int a;
                lineNumber++;
                //break comma separated line using ","
                String[] newString = strLine.split(",");
                for (int k = 0 ; k < newString.length; k++){
                    // 1: date in format 2012-04-25
                    if (k==0){
                        newString[k] = newString[k].replace("-","");
                    }
                    array[lineNumber][k] = newString[k].replace("\"","").trim();

                }

               // System.out.println(array[lineNumber].toString());

            }


        }
        catch(Exception e)
        {
            System.out.println("Exception while reading csv file: " + e);
        }
        return array;
    }


    public static void writeYahooHistoricalDataPageToFile(String ticker, String directory){
        BufferedWriter writer = null;
        try{
            new File(directory).mkdirs();
            File file = new File(directory+"/"+ticker+".txt");
            // Create file if it does not exist
            boolean success = file.createNewFile();


        FileWriter fileWriter = new FileWriter(file);
            URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s="+ticker+"&d=0&e=28&f=2015&g=d&a=3&b=12&c=1990&f=ana&ignore=.csv");
        writer = new BufferedWriter(fileWriter);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null){
            writer.write(inputLine);
            writer.newLine();
        }

            in.close();
        } catch (Exception e){e.printStackTrace();}
        finally{
            try{

            if (writer != null) {
                writer.flush();
                writer.close(); }
            } catch (IOException ex){
                 ex.printStackTrace();
                }

                }
        }
    }



