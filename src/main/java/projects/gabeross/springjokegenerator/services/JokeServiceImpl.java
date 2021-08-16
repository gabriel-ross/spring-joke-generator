package projects.gabeross.springjokegenerator.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes jokeRepo;

    // ordinarily we'd let spring take care of injecting this in the constructor arg, which would
    // allow compatibility with other joke repositories, but we're just hard-coding this one in
    // for convenience
    public JokeServiceImpl() {
        this.jokeRepo = new ChuckNorrisQuotes();
    }

    @Override
    public String getJoke() {
        return jokeRepo.getRandomQuote();
    }
}
