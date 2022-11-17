package com.bitmattz.processor;

import com.bitmattz.dto.EmailDTO;
import com.bitmattz.models.Fii;
import com.bitmattz.models.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class FiiProcessor implements ItemProcessor<EmailDTO,EmailDTO> {



    @Override
    public EmailDTO process(EmailDTO emailDTO) throws Exception {
        Fii fii = emailDTO.getFii();
        User user = emailDTO.getUser();
        String message = "Olá "+user.getNome()+ "! \nOlhe o fundo imobiliário que separamos para você hoje: \nCódigo: " +fii.getCodigo()+ "\nTipo: " +fii.getSetor()+ "\nValor: "+fii.getPreco_atual()+ "\nDividendo: "+fii.getDividendo();
        final String toEmail = user.getEmail();
        emailDTO.setTo(toEmail);
        emailDTO.setMessage(message);
        return emailDTO;
    }
}
