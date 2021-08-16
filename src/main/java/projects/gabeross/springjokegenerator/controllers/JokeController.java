package projects.gabeross.springjokegenerator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.gabeross.springjokegenerator.services.JokeService;
import projects.gabeross.springjokegenerator.services.JokeServiceImpl;

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

        // why are we returning "index" ?
        return "index";
    }
}
