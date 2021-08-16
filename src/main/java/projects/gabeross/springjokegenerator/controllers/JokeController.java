package projects.gabeross.springjokegenerator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.gabeross.springjokegenerator.services.JokeService;

@Controller
public class JokeController {

    // best practice: code to an interface for DI and let framework handle DI
    private final JokeService joke;

    // the Autowired annotation is not necessary -> Spring will do DI on its own for classes with a single
    // constructor
    @Autowired
    public JokeController(JokeService joke) {
        this.joke = joke;
    }

    // Addresses that will call this method
    // What this controller is doing is it is called by a request to this endpoint, and it
    // is returning the model we designate (which is just a mapping of data to a database ordinarily)
    // to the view we designate, which is in-turn generating the UI
    @RequestMapping({"/", ""})
    public String getJoke(Model model) {

        // this adds an attribute to the model (duh) with the attribute title "joke", attached
        // to the string returned by the getJoke() method
        model.addAttribute("joke", joke.getJoke());

        // this is the .html template we're linking this controller behavior to
        // I think when this endpoint is visited it will call this method which will
        // return the index .html template, filled with the data from the joke model
        return "index";
    }
}
