package id.co.elevenia.legacy.mailer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.elevenia.legacy.mailer.domain.netpathy.AutomailUser;
import id.co.elevenia.legacy.mailer.dto.MailRequestDTO;
import id.co.elevenia.legacy.mailer.mapper.AutomailMapper;
import id.co.elevenia.legacy.mailer.repository.AutomailUserRepository;

@Service
public class AutomailService {

	@Autowired
	private AutomailMapper automailMapper;
	
	@Autowired
	private AutomailUserRepository automailUserRepository;
	
	public AutomailUser newMailRequest(MailRequestDTO dto) {
		AutomailUser automailUser = automailMapper.toAutomailUser(dto);
		automailUser = automailUserRepository.save(automailUser);
		automailUser.setParam(automailMapper.toAutomailParam(automailUser.getAutoCode(), dto.param)); 
		return automailUser;
	}
}
