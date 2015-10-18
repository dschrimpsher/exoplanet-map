package com.pierless.space.core;


import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;

import com.google.api.client.xml.Xml;
import com.google.api.client.xml.XmlNamespaceDictionary;
import com.google.api.client.xml.XmlObjectParser;
import com.pierless.space.data.VOTABLE;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by dschrimpsher on 7/26/15.
 *
 * Exoplanet Fectcher pulls currently know Exoplanet Data from NASA's public XML API and
 * parses it into a @SEE com.pierless.space.data.VOTABLE.
 */
public class ExoplanetFetcher {

    private HttpTransport httpTransport = new NetHttpTransport();
    private  VOTABLE votable = null;
    static final Logger logger = Logger.getLogger(ExoplanetFetcher.class);
    private  static final String NASA_EXOPLANET_URL = "http://exoplanetarchive.ipac.caltech.edu/cgi-bin/nstedAPI/nph-nstedAPI?table=exoplanets&where=st_dist%3C25&format=xml&select=pl_radj,pl_name,st_dist,ra,dec,pl_massj,pl_msinij&order=pl_radj";




    /**
     * Constructor
     */
    public ExoplanetFetcher() {
        httpTransport= new NetHttpTransport();
        votable = null;
    }


    /**
     * Parse the xmlString into a VOTABLE object.
     * @param xmlString reprsenting Exoplanet data from NASA.
     * @return  VOTABLE object that represents the xml dom.
     * @throws IOException
     * @throws XmlPullParserException
     */
    protected VOTABLE parseResponse(String xmlString) throws IOException, XmlPullParserException {
        logger.info(xmlString);

        XmlPullParser parser = Xml.createParser();
        parser.setInput(new StringReader(xmlString));
        XmlNamespaceDictionary namespaceDictionary = new XmlNamespaceDictionary();

        votable = new VOTABLE();
        Xml.parseElement(parser, votable, namespaceDictionary, null);
        return votable;
    }


    /**
     * PUll data from the NASA EXOPLANET API.
     * The have it parsed into a VOTABLE.
     */
    public VOTABLE execute() {
        try {
            HttpRequestFactory requestFactory =
                    httpTransport.createRequestFactory(new HttpRequestInitializer() {
                        public void initialize(HttpRequest request) {
                            request.setParser(new XmlObjectParser(new XmlNamespaceDictionary().set("", "")));
                        }
                    });
            GenericUrl url = new GenericUrl(NASA_EXOPLANET_URL);
            HttpRequest request = requestFactory.buildGetRequest(url);


            return parseResponse(request.execute().parseAsString());
        }
        catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        catch (XmlPullParserException e) {
            logger.error(e.getMessage(), e);
        }
        finally {
            //Should be empty
            return votable;
        }
    }


    protected HttpTransport getHttpTransport() {
        return httpTransport;
    }

    protected void setHttpTransport(HttpTransport httpTransport) {
        this.httpTransport = httpTransport;
    }

    public VOTABLE getVotable() {
        return votable;
    }

    public void setVotable(VOTABLE votable) {
        this.votable = votable;
    }
}
