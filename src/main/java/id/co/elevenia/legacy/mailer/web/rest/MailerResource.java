package id.co.elevenia.legacy.mailer.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import id.co.elevenia.legacy.mailer.dto.MailRequestDTO;
import id.co.elevenia.legacy.mailer.repository.AutomailUserRepository;
import id.co.elevenia.legacy.mailer.service.AutomailService;
import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping(value = "/api/mailer")
public class MailerResource {
	private final Logger log = LoggerFactory.getLogger(MailerResource.class);

	@Autowired
    private AutomailUserRepository automailUserRepository;
	
	@Autowired
	private AutomailService automailService;

    @PostMapping(value = "/send")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendMail(@RequestBody MailRequestDTO mailRequestDTO) {
		automailService.newMailRequest(mailRequestDTO);
    }
}
