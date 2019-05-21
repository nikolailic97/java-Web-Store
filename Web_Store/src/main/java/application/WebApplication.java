package application;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import models.Product;
import org.apache.log4j.BasicConfigurator;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

public class WebApplication {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        staticFileLocation("/public");
        FreeMarkerEngine freemarker = new FreeMarkerEngine();
        Configuration config = new Configuration();
        URL putanja = WebApplication.class.getResource("/templates");
        try {
        config.setDirectoryForTemplateLoading(
            new File(putanja.getPath())    
        );
        } catch(Exception ex) {
            System.err.println(ex);
        }
        freemarker.setConfiguration(config);
        
        ArrayList<Product> proizvodi = new ArrayList();
        proizvodi.add(new Product(1,"Balans Jogurt 1L","Imlek",96.99,"Milk products", "balans_jogurt.jpg"));
        proizvodi.add(new Product(2,"Coko Krem","Imlek",64.99,"Milk products", "coko_krem.jpg"));
        proizvodi.add(new Product(3,"Kiselo mleko 2,8%","Mlekara Subotica",32.99,"Milk products", "kiselo_mleko.jpg"));
        proizvodi.add(new Product(4,"Heljda Brasno","Danubius",89.99,"Floor products", "heljda_brasno.jpg"));
        proizvodi.add(new Product(5,"Psenicno Brasno","Danubius",79.99,"Floor products", "psenicno_brasno.jpg"));
        proizvodi.add(new Product(6,"Jaja","Shop'n'go",112.49,"Egg products","jaja.jpg"));
        proizvodi.add(new Product(7,"Kafa Grand De luxe 200g","Grand",264.99,"Coffee","kafa_grand.jpg"));
        proizvodi.add(new Product(8,"Belo Vino Aleksic Kardas 0,75L","Aleksic",949.99,"Vines","aleksic_beloVino.jpg"));
        proizvodi.add(new Product(9,"Vocni sok Fruvita crveni grejp 750ml","Fruvita",124.99,"Drinks", "fruvita_grejp.jpg"));
        proizvodi.add(new Product(10,"Sladoled Quattro Light 520g", "Frikom", 347.99,"Ice cream","sladoled_quattro.jpg"));
        proizvodi.add(new Product(11,"Cokolada Milka Oreo 300g", "Milka", 269.99,"Sweets","cokolada_milka300g.jpg"));
        get("/",(request, response) -> {
            Product p = new Product(10,"Sladoled Quattro Light 520g", "Frikom", 347.99,"Ice cream","sladoled_quattro.jpg");
            HashMap<String, Object> data = new HashMap<>();
            data.put("proizvod",p);
            data.put("proizvodi", proizvodi);
            return new ModelAndView(data, "home.ftl");
        }, freemarker);
        
        get("/proizvodi/:id",(request, response) -> {
            int id = Integer.parseInt(request.params("id"));
            Product p = null;
            for(Product proizvod : proizvodi) {
                if(proizvod.getID() == id) {
                    p = proizvod;
                    break;
                }
            }
            
            HashMap<String, Object> data = new HashMap<>();
            data.put("proizvod", p);
            return new ModelAndView(data, "product.ftl");
        }, freemarker);
        
        // /proizvodi/10/100
        // prikazati sve proizvode čija je cena između 10 i 100
        get("/proizvodi/:min/:max", (request, response) -> {
            double min = Double.parseDouble(request.params(":min"));
            double max = Double.parseDouble(request.params(":max"));
            ArrayList<Product> filtrirani = new ArrayList<>();
            
            for(Product p : proizvodi) {
                if(p.getPrice() >= min && p.getPrice() <= max)
                {
                    filtrirani.add(p);
                }
            }
            HashMap<String, Object> data = new HashMap<>();
            data.put("proizvodi", filtrirani);
            return new ModelAndView(data, "proizvodi.ftl");
        }, freemarker);
        
        // /search?category=Milk Products
        get("/search", (request, response) -> {
            String category = request.queryParams("category");
            ArrayList<Product> filtrirani = new ArrayList<>();
            
            for(Product p : proizvodi) {
                if(p.getCategory().equals(category))
                {
                    filtrirani.add(p);
                }
            }
            HashMap<String, Object> data = new HashMap<>();
            data.put("proizvodi", filtrirani);
            return new ModelAndView(data, "proizvodi.ftl");
        }, freemarker);
        
        get("/contact",(request, response) -> {
            HashMap<String, Object> data = new HashMap<>();
            return new ModelAndView(data, "contact.ftl");
        }, freemarker);
    }
}
