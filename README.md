# exoplanet-map
Using NASA's exoplanet archive API, pulls the currently known exoplanets and maps them relative to the Earth. 

#Current State
This project is in ALPHA so don't expect much.  Currently it pulls down all confirmed planets from the API within 25 PC or Earth.  

To see the map run
>mvn test

The galactic center is shown as up, at RA: 265.5 degrees.  

You can change the query by chaning the URL in ExoplanetFetcher.java

>http://exoplanetarchive.ipac.caltech.edu/cgi-bin/nstedAPI/nph-nstedAPI?table=exoplanets&where=st_dist<25&format=xml&select=pl_radj,pl_name,st_dist,ra,dec,pl_massj,pl_msinij&order=pl_radj

#Future Plans:
* Add scaling capablities
* Pan/Zoom
* User based query

