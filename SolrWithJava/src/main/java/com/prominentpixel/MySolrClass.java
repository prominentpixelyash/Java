package com.prominentpixel;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

public class MySolrClass {

    public static SolrClient getSolrClient(){
        String url="http://localhost:8983/solr/tvshows";
        SolrClient solr=new HttpSolrClient.Builder(url).build();
        return  solr;
    }

    public void indexingDocumentByField() throws SolrServerException, IOException {

        SolrClient solr=getSolrClient();
        SolrInputDocument doc=new SolrInputDocument();
        doc.addField("S.no.",504);
        doc.addField("Name of the show","The Kapil Sharma Show");
        doc.addField("Year of release",2015);
        doc.addField("No of seasons available",5);
        doc.addField("Language","Hindi");
        doc.addField("Genre","Comedy");
        doc.addField("IMDb rating",9.5);
        doc.addField("Age of viewers","12+");
        solr.add(doc);
        solr.commit();
        System.out.println("document indexing is done");
    }

    public void indexingOfObject() throws SolrServerException, IOException {
        SolrClient solr=getSolrClient();
        solr.addBean(new TvShow(506,"Dance+",2017,6,"Hindi","Dance",7.5,"5+"));
        solr.commit();
    }

    public void updatingDocument() throws SolrServerException, IOException {
        SolrClient solr=getSolrClient();
        UpdateRequest updateRequest=new UpdateRequest();
        updateRequest.setAction(UpdateRequest.ACTION.COMMIT,false,false);
        SolrInputDocument doc=new SolrInputDocument();
        doc.addField("id","47133bb9-66c1-4e02-a8f8-16bf65bc8534");
        doc.addField("S.no.",504);
        doc.addField("Name of the show","The Kapil Sharma Show");
        doc.addField("Year of release",2015);
        doc.addField("No of seasons available",5);
        doc.addField("Language","Hindi");
        doc.addField("Genre","Comedy");
        doc.addField("IMDb rating",8.8);
        doc.addField("Age of viewers","12+");
        updateRequest.add(doc);
        UpdateResponse response=updateRequest.process(solr);
        System.out.println("Document is updated");
    }

    public void deleteDocumentById() throws SolrServerException, IOException {
        SolrClient solr=getSolrClient();
        solr.deleteById("6074100f-7468-4d55-89b6-6851626cb72f");
        solr.commit();
        System.out.println("Document deleted");
    }

    public void deleteDocumentByQuery() throws SolrServerException, IOException {
        SolrClient solr=getSolrClient();
        solr.deleteByQuery("Language:Hindi AND IMDbRating:[8.0 TO 10.0]");
        System.out.println("Document Deleted");
    }

    public void getDocumentByQuery() throws SolrServerException, IOException {
        SolrClient solr=getSolrClient();
        SolrQuery query=new SolrQuery();
        query.setQuery("*:*");
        QueryResponse response=solr.query(query);
        System.out.println(response.getResults());
    }

    public void getDocumentByQueryWithField() throws SolrServerException, IOException {
        SolrClient solr=getSolrClient();
        SolrQuery query=new SolrQuery();
        query.setQuery("*:*");
        query.addField("Language");
        QueryResponse response=solr.query(query);
        System.out.println(response.getResults());
    }

    public static void main(String[] args) throws SolrServerException, IOException {

        MySolrClass mySolr=new MySolrClass();
        mySolr.indexingDocumentByField();
        mySolr.indexingOfObject();
        mySolr.updatingDocument();
        mySolr.deleteDocumentById();
        mySolr.deleteDocumentByQuery();
        mySolr.getDocumentByQuery();
        mySolr.getDocumentByQueryWithField();

    }

}
