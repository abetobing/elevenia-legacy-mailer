package id.co.elevenia.legacy.mailer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import id.co.elevenia.legacy.mailer.domain.netpathy.AutomailParam;
import id.co.elevenia.legacy.mailer.domain.netpathy.AutomailUser;
import id.co.elevenia.legacy.mailer.dto.MailRequestDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AutomailMapper {
	
	default AutomailParam toAutomailParam(Long autocode, String[] param) {
		String paramStr = String.join(",", param);
		return new AutomailParam(autocode, paramStr);
	}
	
	@Mapping(source = "param", target = "param", ignore = true)
	AutomailUser toAutomailUser(MailRequestDTO dto);
}
