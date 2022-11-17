package com.bitmattz.reader;

import com.bitmattz.dto.EmailDTO;
import com.bitmattz.models.Fii;
import com.bitmattz.models.User;
import com.bitmattz.repositories.FiiRepository;
import com.bitmattz.repositories.UserRepository;
import com.bitmattz.services.EmailSMTP;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class FiiReader implements ItemReader<EmailDTO> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FiiRepository fiiRepository;


    @Override
    public EmailDTO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        List<User> users = userRepository.findAll();
        String fiiCod = fiiRepository.findRandomFiis();
        //Fii fii = fiiRepository.findByCod(fiiCod);
        for(User user: users){

            EmailDTO emailDTO = new EmailDTO();
            //emailDTO.setFii(fii);
            emailDTO.setUser(user);
            return emailDTO;

        }
        return null;
    }
}
