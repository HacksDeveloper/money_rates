import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.io.*;


public class main {
    public static void main (String[] args) {
        Document page = null;
        ArrayList<String> Data = new ArrayList<>();
        for (long stop = System.nanoTime()+ TimeUnit.SECONDS.toNanos(30); stop>System.nanoTime();) {
            String url = "https://minfin.com.ua/ua/currency/usd/";
            try{
                page = Jsoup.connect(url).get();
            }
            catch (IOException e){
                System.out.println("Error to load data from: "+url);
            }
            String question = page.select(".mfm-posr").text();
            //System.out.println("Question: " + question);
            Elements answers = page.select(".mfm-posr");
                String url = "https://finance.liga.net/currency";
                try{
                    page = Jsoup.connect(url).get();
                }
                catch (IOException e){
                    System.out.println("Error to load data from: "+url);
                }
                //String question = page.select(".mfm-posr").text();
                //System.out.println("Question: " + question);
                Elements answers = page.select(".usd");
            for (Element answerer : answers) {
                //System.out.println("Answerer: " + answerer.text());
                String example=answerer.text();
                try (FileWriter writer = new FileWriter("Text.txt",true)) {
                    writer.write(example);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                /*if (answerer.text().equalsIgnoreCase(example))
                Data.add(answerer.text());*/
            }
        }
        for (int i = 0;i<Data.size();i++){
            System.out.println(Data.get(i));
        }


        //System.out.println(page);
    }



}
