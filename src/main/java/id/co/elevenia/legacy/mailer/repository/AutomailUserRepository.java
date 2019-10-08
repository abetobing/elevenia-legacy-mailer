package id.co.elevenia.legacy.mailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.elevenia.legacy.mailer.domain.netpathy.AutomailUser;

@Repository
public interface AutomailUserRepository extends JpaRepository<AutomailUser, Long> {

}
