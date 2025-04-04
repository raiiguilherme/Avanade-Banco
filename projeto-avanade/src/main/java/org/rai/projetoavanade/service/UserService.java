package org.rai.projetoavanade.service;


import org.rai.projetoavanade.domain.Account;
import org.rai.projetoavanade.domain.Card;
import org.rai.projetoavanade.domain.User;
import org.rai.projetoavanade.exceptions.ex.BirthdayNotEnough;
import org.rai.projetoavanade.exceptions.ex.DataNotFound;
import org.rai.projetoavanade.producers.UserProducer;
import org.rai.projetoavanade.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(
                () -> new DataNotFound("User not found")
        );
    }

    public User create(User user){
        if (Period.between(user.getBirthday(), LocalDate.now()).getYears() < 18){
       throw new BirthdayNotEnough("you need more old that 18 years");
    }
        userProducer.pushMessageEmail(user);

        Card card = new Card();
        Account account = new Account();
        user.setAccount(account);
        user.setCard(card);
        return userRepository.save(user);
    }

    public void deleteUserById(Long id){
        var user = userRepository.findById(id).orElseThrow(
                () -> new DataNotFound("User not found")
        );
        userRepository.delete(user);
    }

    public User updateCustomer(Long id, User user){
        var userOld = userRepository.findById(id).orElseThrow(
                () -> new DataNotFound("User not found")
        );

        if (Period.between(user.getBirthday(), LocalDate.now()).getYears() < 18){
            throw new BirthdayNotEnough("you need more old that 18 years");
        }

        userOld.setCpf(user.getCpf());
        userOld.setGender(user.getGender());
        userOld.setName(user.getName());
        userOld.setEmail(user.getEmail());
        userOld.setBirthday(user.getBirthday());

        return userRepository.save(userOld);
    }


}
