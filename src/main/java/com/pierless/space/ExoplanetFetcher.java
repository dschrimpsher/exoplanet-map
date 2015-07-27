package com.pierless.space;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.xml.Xml;
import com.google.api.client.xml.XmlNamespaceDictionary;
import com.google.api.client.xml.XmlObjectParser;
import com.pierless.space.data.ExoplanetCollection;
import com.pierless.space.data.TABLEDATA;
import com.pierless.space.data.TR;
import com.pierless.space.data.VOTABLE;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by dschrimpsher on 7/26/15.
 */
public class ExoplanetFetcher {

    static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    public static VOTABLE votable = null;

    private static void parseResponse(HttpResponse response) throws IOException, XmlPullParserException {
        String temp = response.parseAsString();
        System.out.println(temp);

        XmlPullParser parser = Xml.createParser();
        parser.setInput(new StringReader(temp));
        XmlNamespaceDictionary namespaceDictionary = new XmlNamespaceDictionary();


        votable = new VOTABLE();
        Xml.parseElement(parser, votable, namespaceDictionary, null);


//        System.out.println(feed.toString());

//        TABLEDATA tabledata = feed.getRESOURCE().getTABLE().getDATA().getTABLEDATA();
//        for (int i = 0; i < tabledata.getTR().length; i++) {
//            TR tr = tabledata.getTR(i);
//            for (int j = 0; j <  tr.getTD().length; j++) {
//                System.out.println(tr.getTD(j));
//            }
//        }

    }


    public static void run() throws IOException, XmlPullParserException {
        HttpRequestFactory requestFactory =
                HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
                    public void initialize(HttpRequest request) {
                        request.setParser(new XmlObjectParser(new XmlNamespaceDictionary().set("", "")));
                    }
                });

//        GenericUrl url = new GenericUrl("http://exoplanetarchive.ipac.caltech.edu/cgi-bin/nstedAPI/nph-nstedAPI?table=exoplanets&where=st_distformat=xml&select=pl_radj,pl_name,st_dist,ra,dec&order=pl_radj");
//        GenericUrl url = new GenericUrl("http://exoplanetarchive.ipac.caltech.edu/cgi-bin/nstedAPI/nph-nstedAPI?table=exoplanets&where=pl_radj%3E0%20and%20st_dist%3C25&format=xml&select=pl_radj,pl_name,st_dist,ra,dec,pl_massj,pl_msinij&order=pl_radj");

        GenericUrl url = new GenericUrl("http://exoplanetarchive.ipac.caltech.edu/cgi-bin/nstedAPI/nph-nstedAPI?table=exoplanets&where=st_dist%3C25&format=xml&select=pl_radj,pl_name,st_dist,ra,dec,pl_massj,pl_msinij&order=pl_radj");


        HttpRequest request = requestFactory.buildGetRequest(url);


        parseResponse(request.execute());
    }


//    public static void main(String[] args) {
//        try {
//            try {
//                run();
//                return;
//            } catch (HttpResponseException e) {
//                System.err.println(e.getMessage());
//            }
//        } catch (Throwable t) {
//            t.printStackTrace();
//        }
//        System.exit(1);
//    }


}
