package com.devsuperior.dsmovie.services;


import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO score){
        User user = userRepository.findByEmail(score.getEmail());
        if(user == null){
            user = new User();
            user.setEmail(score.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(score.getMovieId()).get();

        Score scoreAv = new Score();
        scoreAv.setMovie(movie);
        scoreAv.setUser(user);
        scoreAv.setValue(score.getScore());

        scoreAv = scoreRepository.saveAndFlush(scoreAv);

        double sum = 0.0;
        for(Score s : movie.getScores()){
            sum = sum + s.getValue();
        }        

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);
        MovieDTO movieDTO = new MovieDTO(movie);
        return movieDTO;

    }


    
    
}
