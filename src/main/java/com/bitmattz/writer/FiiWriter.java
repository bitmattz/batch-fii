package com.bitmattz.writer;

import com.bitmattz.dto.EmailDTO;
import com.bitmattz.services.EmailSMTP;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FiiWriter implements ItemWriter<EmailDTO> {

    @Autowired
    private EmailSMTP emailSMTP;

    @Override
    public void write(List<? extends EmailDTO> emailList) throws Exception {
        for(EmailDTO email: emailList){
            emailSMTP.sendEmail(email.getTo(),"Recomendação diária de fundos imobiliários!", email.getMessage());
        }

    }
}
