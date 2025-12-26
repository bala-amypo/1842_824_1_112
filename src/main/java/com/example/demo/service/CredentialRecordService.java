import com.example.demo.entity.CredentialRecord;
import java.time.LocalDateTime;
import java.util.List;

public interface CredentialRecordService {
    CredentialRecord createCredential(CredentialRecord record);
    CredentialRecord updateCredential(Long id, CredentialRecord updated);
    List<CredentialRecord> getAllCredentials();
    List<CredentialRecord> getCredentialsByHolder(Long holderId);
    CredentialRecord getCredentialByCode(String code);
    List<CredentialRecord> findByExpiryDateBefore(LocalDateTime date); 
    List<CredentialRecord> findByStatusUsingHql(String status);
    List<CredentialRecord> searchByIssuerAndType(String issuer, String type);
}
