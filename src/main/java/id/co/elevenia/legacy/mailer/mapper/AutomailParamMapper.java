package id.co.elevenia.legacy.mailer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import id.co.elevenia.legacy.mailer.domain.netpathy.AutomailParam;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AutomailParamMapper {
	
	AutomailParam toAutomailParam(String[] param);
}
