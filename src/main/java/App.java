import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        int port;

        // This tells our app that if Heroku sets a port for us, we need to use that port.
        // Otherwise, if they do not, continue using port 4567.

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);

        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Hero> heroes = Hero.all();
            ArrayList<Squad> squads =Squad.all();
            model.put("heroes", heroes);
            model.put("squads",squads);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
//            Integer age = Integer.parseInt(request.params("age"));
            String strength = request.queryParams("strength");
            String weakness = request.queryParams("weakness");
            Hero newPost = new Hero(name,strength,weakness);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());



        get("/hero/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            List<Hero> hero = Hero.all();
            int idOfHeroToFind = Integer.parseInt(req.params(":id"));
            Hero foundHero = Hero.findById(idOfHeroToFind);
            model.put("hero", foundHero);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());


        get("/squads/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
//         int size = Integer.parseInt(request.params("size"));
            String cause = request.queryParams("cause");
            Squad newPost = new Squad(name,cause);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/squad/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToFind = Integer.parseInt(req.params(":id"));
            Squad foundHero = Squad.findById(idOfSquadToFind);
            model.put("squad", foundHero);
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());


       get("/squad/:id", (req, res) -> {
           Map<String, Object> model = new HashMap<>();
           int idOfSquadToFind = Integer.parseInt(req.params(":id"));
           Squad foundHero = Squad.findById(idOfSquadToFind);
           model.put("squad", foundHero);
           return new ModelAndView(model, "squad.hbs");
       }, new HandlebarsTemplateEngine());
       


    }
}
