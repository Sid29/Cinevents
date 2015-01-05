package com.example.sustrac.cinevents;

import android.app.IntentService;
import android.content.Intent;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
/*
 * Classe pour la recupération des données depuis l'api
 */
public class DLTask extends IntentService{

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public DLTask() {
        super("DLTask");
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        String dataString = workIntent.getDataString();
        String retour; //string à retourné
        try {
           retour = downloadUrl("http://api.allocine.fr/rest/v3/movielist?partner=QUNXZWItQWxsb0Npbuk&count=25&filter=nowshowing&page=1&order=datedesc&format=json");
        } catch (IOException e) {
           retour =  "Unable to retrieve web page. Url may be invalid";
        }
    }


    private String downloadUrl(String myurl) throws IOException {
        InputStream is = null;
        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int response = conn.getResponseCode();
            is = conn.getInputStream();

            //convert the InputStream into a string
            String contentAsString = readIt(is, 500);

            return contentAsString;
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;

        reader = new InputStreamReader(stream, "UTF-8");

        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }


}