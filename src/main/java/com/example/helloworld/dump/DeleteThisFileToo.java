package com.example.helloworld.dump;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DeleteThisFileToo {


}


class Article {
    String name;
    int numComments;

    Article(String name, int numComments) {
        this.name = name;
        this.numComments = numComments;
    }
}
class Solution {

    public static List<String> topArticles(int limit) {
        List<Article> articles = new ArrayList<>();
        int pageNumber = 1;
        int totalPages = Integer.MAX_VALUE; // Initial high value

        while (pageNumber <= totalPages) {
            try {
                String url = "https://jsonmock.hackerrank.com/api/articles?page=" + pageNumber;
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONParser parser = new JSONParser();
                JSONObject jsonResponse = (JSONObject) parser.parse(response.toString());
                totalPages = Integer.parseInt(jsonResponse.get("total_pages").toString());
                JSONArray data = (JSONArray) jsonResponse.get("data");

                for (Object obj : data) {
                    JSONObject article = (JSONObject) obj;
                    String title = (String) article.getOrDefault("title", null);
                    String storyTitle = (String) article.getOrDefault("story_title", null);

                    int numComments = 0;
                    if(article.containsKey("num_comments")){
                        if(article.get("num_comments") != null ){
                            numComments = Integer.parseInt(article.get("num_comments").toString());
                        }
                    }

                    String articleName = title != null ? title : storyTitle;
                    if (articleName != null) {
                        articles.add(new Article(articleName, numComments));
                    }
                }

                pageNumber++;
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }

        // Sort articles by numComments (descending) and then by name (descending alphabetically)
        articles.sort((a1, a2) -> {
            if (a1.numComments != a2.numComments) {
                return Integer.compare(a2.numComments, a1.numComments);
            }
            return a2.name.compareTo(a1.name);
        });

        // Get the top `limit` articles
        List<String> topArticles = new ArrayList<>();
        for (int i = 0; i < Math.min(limit, articles.size()); i++) {
            topArticles.add(articles.get(i).name);
        }

        return topArticles;
    }

    public static void main(String[] args) {
        int limit = 2; // Example limit
        List<String> result = topArticles(limit);
        for (String article : result) {
            System.out.println(article);
        }
    }
}
